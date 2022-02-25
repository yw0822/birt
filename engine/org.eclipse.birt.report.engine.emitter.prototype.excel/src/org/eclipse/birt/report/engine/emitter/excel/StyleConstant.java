/*******************************************************************************
 * Copyright (c) 2004, 2008Actuate Corporation.
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

package org.eclipse.birt.report.engine.emitter.excel;

import java.awt.Color;

public interface StyleConstant {

	int COUNT = 36;

	int FONT_FAMILY_PROP = 0;
	int FONT_SIZE_PROP = 1;
	int FONT_STYLE_PROP = 2;
	int FONT_WEIGHT_PROP = 3;

	int TEXT_LINE_THROUGH_PROP = 4;
	int TEXT_UNDERLINE_PROP = 5;

	int BACKGROUND_COLOR_PROP = 6;
	int COLOR_PROP = 7;

	int H_ALIGN_PROP = 8;
	int V_ALIGN_PROP = 9;

	int BORDER_BOTTOM_COLOR_PROP = 10;
	int BORDER_BOTTOM_STYLE_PROP = 11;
	int BORDER_BOTTOM_WIDTH_PROP = 12;

	int BORDER_TOP_COLOR_PROP = 13;
	int BORDER_TOP_STYLE_PROP = 14;
	int BORDER_TOP_WIDTH_PROP = 15;

	int BORDER_LEFT_COLOR_PROP = 16;
	int BORDER_LEFT_STYLE_PROP = 17;
	int BORDER_LEFT_WIDTH_PROP = 18;

	int BORDER_RIGHT_COLOR_PROP = 19;
	int BORDER_RIGHT_STYLE_PROP = 20;
	int BORDER_RIGHT_WIDTH_PROP = 21;

	int DATE_FORMAT_PROP = 22;
	int NUMBER_FORMAT_PROP = 23;
	int STRING_FORMAT_PROP = 24;
	int DATA_TYPE_PROP = 25;
	int TEXT_TRANSFORM = 26;
	int TEXT_INDENT = 27;

	int DIRECTION_PROP = 28;

	int WHITE_SPACE = 29;

	int BORDER_DIAGONAL_COLOR_PROP = 30;
	int BORDER_DIAGONAL_STYLE_PROP = 31;
	int BORDER_DIAGONAL_WIDTH_PROP = 32;

	int BORDER_ANTIDIAGONAL_COLOR_PROP = 33;
	int BORDER_ANTIDIAGONAL_STYLE_PROP = 34;
	int BORDER_ANTIDIAGONAL_WIDTH_PROP = 35;

	String NULL = "NULL";

	Color HYPERLINK_COLOR = Color.blue;
}
