/*******************************************************************************
 * Copyright (c) 2004 Actuate Corporation.
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

package org.eclipse.birt.report.designer.internal.ui.editors.schematic.editparts;

import org.eclipse.birt.report.designer.internal.ui.editors.schematic.editparts.AbstractModelEventProcessor.IModelEventFactory;

/**
 * Optimize the event dispatch.Mark the event start and end.
 */
//Now use the cross tab.
public interface IAdvanceModelEventFactory extends IModelEventFactory {
	/**
	 * Event start
	 */
	void eventDispathStart();

	/**
	 * Event end
	 */
	void eventDispathEnd();
}
