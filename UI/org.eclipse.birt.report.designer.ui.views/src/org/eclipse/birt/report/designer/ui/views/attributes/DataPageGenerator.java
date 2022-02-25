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

package org.eclipse.birt.report.designer.ui.views.attributes;

/**
 * Instances of ColumnPageGenerator take change of creating attribute page
 * correspond to TableColumn element.
 */
public class DataPageGenerator extends BasePageGenerator {

	@Override
	protected void createTabItems() {
		createTabItem(BINDINGTITLE, ATTRIBUTESTITLE);
		createTabItem(MAPTITLE, BINDINGTITLE);
		createTabItem(HIGHLIGHTSTITLE, MAPTITLE);
	}
}
