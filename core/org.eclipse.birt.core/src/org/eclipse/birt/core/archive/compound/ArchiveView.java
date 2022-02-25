/*******************************************************************************
 * Copyright (c) 2007, 2009 Actuate Corporation.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *******************************************************************************/

package org.eclipse.birt.core.archive.compound;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

import org.eclipse.birt.core.archive.RAOutputStream;

public class ArchiveView implements IArchiveFile {

	private boolean sharedArchive = false;
	private IArchiveFile view = null;
	private IArchiveFile archive = null;
	private HashSet<ViewEntry> openedEntries = new HashSet<>();

	public ArchiveView(IArchiveFile view, IArchiveFile archive, boolean sharedArchive) {
		this.view = view;
		this.archive = archive;
		this.sharedArchive = sharedArchive;
	}

	public ArchiveView(String viewName, String archiveName, String viewMode) throws IOException {
		this.view = new ArchiveFile(viewName, viewMode);
		this.archive = new ArchiveFile(archiveName, "r");
		sharedArchive = false;
	}

	public ArchiveView(String viewName, IArchiveFile archive, String viewMode) throws IOException {
		this.view = new ArchiveFile(viewName, viewMode);
		this.archive = archive;
		this.sharedArchive = true;
	}

	@Override
	synchronized public void close() throws IOException {
		try {
			for (ViewEntry entry : openedEntries) {
				entry.doClose();
			}
			openedEntries.clear();
		} finally {
			try {
				if (!sharedArchive) {
					archive.close();
				}
			} finally {
				view.close();
			}
		}
	}

	@Override
	synchronized public boolean exists(String name) {
		if (view.exists(name) || archive.exists(name)) {
			return true;
		}
		return false;
	}

	@Override
	synchronized public ArchiveEntry openEntry(String name) throws IOException {
		if (view.exists(name)) {
			ArchiveEntry entry = view.openEntry(name);
			return new ViewEntry(this, name, entry);
		}
		if (archive.exists(name)) {
			ArchiveEntry entry = archive.openEntry(name);
			return new ViewEntry(this, name, entry);
		}
		throw new FileNotFoundException(name);
	}

	@Override
	synchronized public List<String> listEntries(String namePattern) {
		List<String> viewList = view.listEntries(namePattern);
		List<String> archiveList = archive.listEntries(namePattern);

		if (archiveList.isEmpty()) {
			return viewList;
		}

		LinkedHashSet<String> entries = new LinkedHashSet<>(viewList);
		entries.addAll(archiveList);
		return new ArrayList<>(entries);
	}

	@Override
	public synchronized Object lockEntry(String entry) throws IOException {
		if (view.exists(entry)) {
			return view.lockEntry(entry);
		}
		if (archive.exists(entry)) {
			return archive.lockEntry(entry);
		}
		return view.lockEntry(entry);
	}

	@Override
	public void refresh() throws IOException {
		// archive.refresh( ); donot need to refresh archive, because archive in
		// ONLY in r mode
		view.refresh();
	}

	@Override
	public String getSystemId() {
		return view.getSystemId();
	}

	@Override
	public String getDependId() {
		return archive.getSystemId();
	}

	synchronized protected void openEntry(ViewEntry entry) {
		openedEntries.add(entry);
	}

	synchronized protected void closeEntry(ViewEntry entry) {
		openedEntries.remove(entry);
	}

	static class ViewEntry extends ArchiveEntryAdapter {

		protected ArchiveView view;
		protected boolean writable;

		ViewEntry(ArchiveView view, String name, ArchiveEntry entry) {
			super(name, entry);
			writable = false;
			this.view = view;
			view.openEntry(this);
		}

		@Override
		public void close() throws IOException {
			view.closeEntry(this);
			doClose();
		}

		private void doClose() throws IOException {
			super.close();
		}

		@Override
		protected void setOutputStream(RAOutputStream output) {
			this.output = output;
		}

		@Override
		public void flush() throws IOException {
			if (output != null) {
				output.flush();
			}
			entry.flush();
		}

		@Override
		public void write(long pos, byte[] b, int off, int len) throws IOException {
			ensureWritable();
			entry.write(pos, b, off, len);
		}

		protected void ensureWritable() throws IOException {
			if (!writable) {
				ArchiveEntry viewEntry = view.createEntry(entry.getName());
				try {
					copyEntry(entry, viewEntry);
				} finally {
					entry.close();
				}
				entry = viewEntry;
				writable = true;
			}
		}

		private void copyEntry(ArchiveEntry src, ArchiveEntry tgt) throws IOException {
			byte[] b = new byte[4096];
			long length = src.getLength();
			long pos = 0;
			while (pos < length) {
				int size = src.read(pos, b, 0, 4096);
				tgt.write(pos, b, 0, size);
				pos += size;
			}
		}
	}

	@Override
	public ArchiveEntry createEntry(String name) throws IOException {
		return view.createEntry(name);
	}

	@Override
	synchronized public void flush() throws IOException {
		// first flush all the ext2 files
		for (ViewEntry entry : openedEntries) {
			entry.flush();
		}
		view.flush();
	}

	@Override
	public void save() throws IOException {
		view.save();
	}

	@Override
	public String getName() {
		return view.getName();
	}

	@Override
	public long getUsedCache() {
		return view.getUsedCache();
	}

	@Override
	public boolean removeEntry(String name) throws IOException {
		return view.removeEntry(name);
	}

	@Override
	public void setCacheSize(long cacheSize) {
		view.setCacheSize(cacheSize);
	}

	@Override
	synchronized public void unlockEntry(Object locker) throws IOException {
		try {
			view.unlockEntry(locker);
		} catch (FileNotFoundException ex) {
			archive.unlockEntry(locker);
		}
	}

	public IArchiveFile getArchive() {
		return this.archive;
	}

	public IArchiveFile getView() {
		return this.view;
	}

	@Override
	public long getLength() {
		return view == null ? 0 : view.getLength();
	}
}
