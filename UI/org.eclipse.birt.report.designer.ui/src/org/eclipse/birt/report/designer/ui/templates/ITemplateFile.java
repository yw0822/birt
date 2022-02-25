/*******************************************************************************
 * Copyright (c) 2007 Actuate Corporation.
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

package org.eclipse.birt.report.designer.ui.templates;

import org.eclipse.birt.report.model.api.ReportDesignHandle;

/**
 * ITemplateFile
 */
public interface ITemplateFile extends ITemplateEntry {

	/**
	 * Gets the Template
	 *
	 * @return
	 */
	ReportDesignHandle getReportHandle();
}
