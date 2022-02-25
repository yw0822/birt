/*******************************************************************************
 * Copyright (c) 2021 Contributors to the Eclipse Foundation
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * https://www.eclipse.org/legal/epl-2.0/.
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *   See git history
 *******************************************************************************/
/* Generated By:JavaCC: Do not edit this line. PropertyParser.java */
package org.eclipse.birt.report.model.css.property;

import java.io.StringReader;
import java.util.LinkedHashMap;

import org.w3c.css.sac.CSSException;

/**
 * Parses the compound properties of CSS defined, such as background, font,
 * border, border-width and so on.
 *
 * @version $Revision: 1.2 $ $Date: 2007/02/01 10:15:08 $
 */

public class PropertyParser implements PropertyParserConstants {
	/**
	 * Stores the CSS2.0 properties.
	 */

	private LinkedHashMap cssProperties;

	public PropertyParser(String input) {
		this(new StringReader(input));
	}

	/**
	 * Adds the property value
	 */

	private void setValue(StringBuffer value, char operator, Token n, int token) throws ParseException {
		if (n != null) {
			if (n.kind == PropertyParserConstants.IDENT) {
				value.append(convertIdent(operator + n.image));
			} else {
				value.append(operator + n.image);
			}
		}
	}

	/**
	 * Returns the cssProperties.
	 *
	 */

	public LinkedHashMap getCssProperties() {
		return cssProperties;
	}

	/**
	 * @exception ParseException exception during the parse
	 */
	final public char unaryOperator() throws ParseException {
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case MINUS:
			jj_consume_token(MINUS); {
			if (true) {
				return '-';
			}
		}
			break;
		case PLUS:
			jj_consume_token(PLUS); {
			if (true) {
				return '+';
			}
		}
			break;
		default:
			jj_la1[0] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		throw new Error("Missing return statement in function");
	}

	final public Token size() throws ParseException {
		Token n;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case ABSOLUTE_SIZE:
			n = jj_consume_token(ABSOLUTE_SIZE); {
			if (true) {
				return n;
			}
		}
			break;
		case RELATIVE_SIZE:
			n = jj_consume_token(RELATIVE_SIZE); {
			if (true) {
				return n;
			}
		}
			break;
		case PERCENTAGE:
			n = jj_consume_token(PERCENTAGE); {
			if (true) {
				return n;
			}
		}
			break;
		case LENGTH:
			n = jj_consume_token(LENGTH); {
			if (true) {
				return n;
			}
		}
			break;
		case BORDER_WIDTH:
			n = jj_consume_token(BORDER_WIDTH); {
			if (true) {
				return n;
			}
		}
			break;
		default:
			jj_la1[1] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		throw new Error("Missing return statement in function");
	}

	/**
	 * Deals with the shorthand property font.
	 */
	final public void parseFont() throws ParseException {
		Token n;
		String fontFamily = "";
		cssProperties = new LinkedHashMap();
		try {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case FONT_VAL:
				n = jj_consume_token(FONT_VAL);
				cssProperties.put("font", n.image);
				cssProperties.put("font-weight", "");
				cssProperties.put("font-style", "");
				break;
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case NORMAL:
			case FONT_STYLE:
			case FONT_VARIANT:
			case FONT_WEIGHT:
			case BORDER_WIDTH:
				String fontStyle = null;
				String fontVariant = null;
				String fontWeight = null;
				label_1: while (true) {
					switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
					case NORMAL:
					case FONT_STYLE:
					case FONT_VARIANT:
					case FONT_WEIGHT:
						;
						break;
					default:
						jj_la1[2] = jj_gen;
						break label_1;
					}
					switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
					case FONT_STYLE:
						n = jj_consume_token(FONT_STYLE);
						fontStyle = n.image;
						break;
					case FONT_VARIANT:
						n = jj_consume_token(FONT_VARIANT);
						fontVariant = n.image;
						break;
					case FONT_WEIGHT:
						n = jj_consume_token(FONT_WEIGHT);
						fontWeight = n.image;
						break;
					case NORMAL:
						n = jj_consume_token(NORMAL);
						if (fontStyle == null) {
							fontStyle = n.image;
						}
						if (fontVariant == null) {
							fontVariant = n.image;
						}
						if (fontWeight == null) {
							fontWeight = n.image;
						}
						break;
					default:
						jj_la1[3] = jj_gen;
						jj_consume_token(-1);
						throw new ParseException();
					}
				}
				cssProperties.put("font-style", fontStyle);
				cssProperties.put("font-variant", fontVariant);
				cssProperties.put("font-weight", fontWeight);
				n = size();
				if (n != null) {
					cssProperties.put("font-size", n.image);
				}
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case DIV:
					jj_consume_token(DIV);
					n = size();
					if (n != null) {
						cssProperties.put("line-height", n.image);
					}
					break;
				default:
					jj_la1[4] = jj_gen;
					;
				}
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case IDENT:
					n = jj_consume_token(IDENT);
					if (n != null) {
						fontFamily += n.image;
					}
					break;
				case STRING:
					n = jj_consume_token(STRING);
					if (n != null) {
						fontFamily += n.image;
					}
					break;
				default:
					jj_la1[5] = jj_gen;
					jj_consume_token(-1);
					throw new ParseException();
				}
				label_2: while (true) {
					switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
					case COMMA:
						;
						break;
					default:
						jj_la1[6] = jj_gen;
						break label_2;
					}
					n = jj_consume_token(COMMA);
					fontFamily += ",";
					switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
					case IDENT:
						n = jj_consume_token(IDENT);
						if (n != null) {
							fontFamily += n.image;
						}
						break;
					case STRING:
						n = jj_consume_token(STRING);
						if (n != null) {
							fontFamily += n.image;
						}
						break;
					default:
						jj_la1[7] = jj_gen;
						jj_consume_token(-1);
						throw new ParseException();
					}
				}
				cssProperties.put("font-family", fontFamily);
				break;
			default:
				jj_la1[8] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
		} catch (Exception ex) {
			System.out.println("The parse for the input font is failed!");
			{
				if (true) {
					throw new CSSException("The input font is invalid for the CSS2 grammar.");
				}
			}
		}
	}

	/**
	 * Deals with the shorthand property background
	 *
	 */
	final public void parseBackground() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		try {
			label_3: while (true) {
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case COLOR:
					n = jj_consume_token(COLOR);
					if (n != null) {
						cssProperties.put("background-color", n.image);
					}
					break;
				case URL:
					n = jj_consume_token(URL);
					if (n != null) {
						cssProperties.put("background-image", n.image);
					}
					break;
				case BACKGROUND_REPEAT:
					n = jj_consume_token(BACKGROUND_REPEAT);
					if (n != null) {
						cssProperties.put("background-repeat", n.image);
					}
					break;
				case BACKGROUND_ATTACHMENT:
					n = jj_consume_token(BACKGROUND_ATTACHMENT);
					if (n != null) {
						cssProperties.put("background-attachment", n.image);
					}
					break;
				case PERCENTAGE:
				case LENGTH:
				case ABSOLUTE_SIZE:
				case RELATIVE_SIZE:
				case BACKGROUND_POSITION:
				case BORDER_WIDTH:
					n = background_position();
					if (n != null) {
						if (cssProperties.get("background-position") == null) {
							cssProperties.put("background-position", n.image);
						} else {
							cssProperties.put("background-position",
									(String) cssProperties.get("background-position") + " " + n.image);
						}
					}
					break;
				default:
					jj_la1[9] = jj_gen;
					jj_consume_token(-1);
					throw new ParseException();
				}
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case URL:
				case PERCENTAGE:
				case LENGTH:
				case ABSOLUTE_SIZE:
				case RELATIVE_SIZE:
				case COLOR:
				case BACKGROUND_REPEAT:
				case BACKGROUND_ATTACHMENT:
				case BACKGROUND_POSITION:
				case BORDER_WIDTH:
					;
					break;
				default:
					jj_la1[10] = jj_gen;
					break label_3;
				}
			}
		} catch (Exception ex) {
			System.out.println("The parse for the input background is failed!");
			{
				if (true) {
					throw new CSSException("The input background is invalid for the CSS2 grammar.");
				}
			}
		}
	}

	final public void parseBorder() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		label_4: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				cssProperties.put("border-top-width", n.image);
				cssProperties.put("border-right-width", n.image);
				cssProperties.put("border-bottom-width", n.image);
				cssProperties.put("border-left-width", n.image);
				break;
			case BORDER_STYLE:
				n = jj_consume_token(BORDER_STYLE);
				cssProperties.put("border-top-style", n.image);
				cssProperties.put("border-right-style", n.image);
				cssProperties.put("border-bottom-style", n.image);
				cssProperties.put("border-left-style", n.image);
				break;
			case COLOR:
				n = jj_consume_token(COLOR);
				cssProperties.put("border-top-color", n.image);
				cssProperties.put("border-right-color", n.image);
				cssProperties.put("border-bottom-color", n.image);
				cssProperties.put("border-left-color", n.image);
				break;
			default:
				jj_la1[11] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case COLOR:
			case BORDER_STYLE:
			case BORDER_WIDTH:
				;
				break;
			default:
				jj_la1[12] = jj_gen;
				break label_4;
			}
		}
	}

	final public void parseBorderWidth() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		n = size();
		cssProperties.put("border-top-width", n.image);
		cssProperties.put("border-right-width", n.image);
		cssProperties.put("border-bottom-width", n.image);
		cssProperties.put("border-left-width", n.image);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case PERCENTAGE:
		case LENGTH:
		case ABSOLUTE_SIZE:
		case RELATIVE_SIZE:
		case BORDER_WIDTH:
			n = size();
			cssProperties.put("border-right-width", n.image);
			cssProperties.put("border-left-width", n.image);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				cssProperties.put("border-bottom-width", n.image);
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case PERCENTAGE:
				case LENGTH:
				case ABSOLUTE_SIZE:
				case RELATIVE_SIZE:
				case BORDER_WIDTH:
					n = size();
					cssProperties.put("border-left-width", n.image);
					break;
				default:
					jj_la1[13] = jj_gen;
					;
				}
				break;
			default:
				jj_la1[14] = jj_gen;
				;
			}
			break;
		default:
			jj_la1[15] = jj_gen;
			;
		}
	}

	final public void parseBorderStyle() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		n = jj_consume_token(BORDER_STYLE);
		cssProperties.put("border-top-style", n.image);
		cssProperties.put("border-right-style", n.image);
		cssProperties.put("border-bottom-style", n.image);
		cssProperties.put("border-left-style", n.image);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case BORDER_STYLE:
			n = jj_consume_token(BORDER_STYLE);
			cssProperties.put("border-right-style", n.image);
			cssProperties.put("border-left-style", n.image);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case BORDER_STYLE:
				n = jj_consume_token(BORDER_STYLE);
				cssProperties.put("border-bottom-style", n.image);
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case BORDER_STYLE:
					n = jj_consume_token(BORDER_STYLE);
					cssProperties.put("border-left-style", n.image);
					break;
				default:
					jj_la1[16] = jj_gen;
					;
				}
				break;
			default:
				jj_la1[17] = jj_gen;
				;
			}
			break;
		default:
			jj_la1[18] = jj_gen;
			;
		}
	}

	final public void parseBorderColor() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		n = jj_consume_token(COLOR);
		cssProperties.put("border-top-color", n.image);
		cssProperties.put("border-right-color", n.image);
		cssProperties.put("border-bottom-color", n.image);
		cssProperties.put("border-left-color", n.image);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case COLOR:
			n = jj_consume_token(COLOR);
			cssProperties.put("border-right-color", n.image);
			cssProperties.put("border-left-color", n.image);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case COLOR:
				n = jj_consume_token(COLOR);
				cssProperties.put("border-bottom-color", n.image);
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case COLOR:
					n = jj_consume_token(COLOR);
					cssProperties.put("border-left-color", n.image);
					break;
				default:
					jj_la1[19] = jj_gen;
					;
				}
				break;
			default:
				jj_la1[20] = jj_gen;
				;
			}
			break;
		default:
			jj_la1[21] = jj_gen;
			;
		}
	}

	final public void parseBorderTop() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		label_5: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				cssProperties.put("border-top-width", n.image);
				break;
			case BORDER_STYLE:
				n = jj_consume_token(BORDER_STYLE);
				cssProperties.put("border-top-style", n.image);
				break;
			case COLOR:
				n = jj_consume_token(COLOR);
				cssProperties.put("border-top-color", n.image);
				break;
			default:
				jj_la1[22] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case COLOR:
			case BORDER_STYLE:
			case BORDER_WIDTH:
				;
				break;
			default:
				jj_la1[23] = jj_gen;
				break label_5;
			}
		}
	}

	final public void parseBorderRight() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		label_6: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				cssProperties.put("border-right-width", n.image);
				break;
			case BORDER_STYLE:
				n = jj_consume_token(BORDER_STYLE);
				cssProperties.put("border-right-style", n.image);
				break;
			case COLOR:
				n = jj_consume_token(COLOR);
				cssProperties.put("border-right-color", n.image);
				break;
			default:
				jj_la1[24] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case COLOR:
			case BORDER_STYLE:
			case BORDER_WIDTH:
				;
				break;
			default:
				jj_la1[25] = jj_gen;
				break label_6;
			}
		}
	}

	final public void parseBorderBottom() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		label_7: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				cssProperties.put("border-bottom-width", n.image);
				break;
			case BORDER_STYLE:
				n = jj_consume_token(BORDER_STYLE);
				cssProperties.put("border-bottom-style", n.image);
				break;
			case COLOR:
				n = jj_consume_token(COLOR);
				cssProperties.put("border-bottom-color", n.image);
				break;
			default:
				jj_la1[26] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case COLOR:
			case BORDER_STYLE:
			case BORDER_WIDTH:
				;
				break;
			default:
				jj_la1[27] = jj_gen;
				break label_7;
			}
		}
	}

	final public void parseBorderLeft() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		label_8: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				cssProperties.put("border-left-width", n.image);
				break;
			case BORDER_STYLE:
				n = jj_consume_token(BORDER_STYLE);
				cssProperties.put("border-left-style", n.image);
				break;
			case COLOR:
				n = jj_consume_token(COLOR);
				cssProperties.put("border-left-color", n.image);
				break;
			default:
				jj_la1[28] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case COLOR:
			case BORDER_STYLE:
			case BORDER_WIDTH:
				;
				break;
			default:
				jj_la1[29] = jj_gen;
				break label_8;
			}
		}
	}

	final public Token getMarginWidth() throws ParseException {
		Token n;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case LENGTH:
			n = jj_consume_token(LENGTH); {
			if (true) {
				return n;
			}
		}
			break;
		case PERCENTAGE:
			n = jj_consume_token(PERCENTAGE); {
			if (true) {
				return n;
			}
		}
			break;
		case AUTO:
			n = jj_consume_token(AUTO); {
			if (true) {
				return n;
			}
		}
			break;
		default:
			jj_la1[30] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		throw new Error("Missing return statement in function");
	}

	final public void parseMargin() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		n = getMarginWidth();
		cssProperties.put("margin-top", n.image);
		cssProperties.put("margin-right", n.image);
		cssProperties.put("margin-bottom", n.image);
		cssProperties.put("margin-left", n.image);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case PERCENTAGE:
		case LENGTH:
		case AUTO:
			n = getMarginWidth();
			cssProperties.put("margin-right", n.image);
			cssProperties.put("margin-left", n.image);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
			case AUTO:
				n = getMarginWidth();
				cssProperties.put("margin-bottom", n.image);
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case PERCENTAGE:
				case LENGTH:
				case AUTO:
					n = getMarginWidth();
					cssProperties.put("margin-left", n.image);
					break;
				default:
					jj_la1[31] = jj_gen;
					;
				}
				break;
			default:
				jj_la1[32] = jj_gen;
				;
			}
			break;
		default:
			jj_la1[33] = jj_gen;
			;
		}
	}

	final public Token getPaddingWidth() throws ParseException {
		Token n;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case LENGTH:
			n = jj_consume_token(LENGTH); {
			if (true) {
				return n;
			}
		}
			break;
		case PERCENTAGE:
			n = jj_consume_token(PERCENTAGE); {
			if (true) {
				return n;
			}
		}
			break;
		default:
			jj_la1[34] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		throw new Error("Missing return statement in function");
	}

	final public void parsePadding() throws ParseException {
		Token n;
		cssProperties = new LinkedHashMap();
		n = getPaddingWidth();
		cssProperties.put("padding-top", n.image);
		cssProperties.put("padding-right", n.image);
		cssProperties.put("padding-bottom", n.image);
		cssProperties.put("padding-left", n.image);
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case PERCENTAGE:
		case LENGTH:
			n = getPaddingWidth();
			cssProperties.put("padding-right", n.image);
			cssProperties.put("padding-left", n.image);
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PERCENTAGE:
			case LENGTH:
				n = getPaddingWidth();
				cssProperties.put("padding-bottom", n.image);
				switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
				case PERCENTAGE:
				case LENGTH:
					n = getPaddingWidth();
					cssProperties.put("padding-left", n.image);
					break;
				default:
					jj_la1[35] = jj_gen;
					;
				}
				break;
			default:
				jj_la1[36] = jj_gen;
				;
			}
			break;
		default:
			jj_la1[37] = jj_gen;
			;
		}
	}

	/**
	 * Returns the background-position token.
	 *
	 * @exception ParseException exception during the parsing
	 */
	final public Token background_position() throws ParseException {
		Token n;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case BACKGROUND_POSITION:
			n = jj_consume_token(BACKGROUND_POSITION); {
			if (true) {
				return n;
			}
		}
			break;
		case PERCENTAGE:
		case LENGTH:
		case ABSOLUTE_SIZE:
		case RELATIVE_SIZE:
		case BORDER_WIDTH:
			n = size(); {
			if (true) {
				return n;
			}
		}
			break;
		default:
			jj_la1[38] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		throw new Error("Missing return statement in function");
	}

	/**
	 * @exception ParseException exception during the parsing
	 */
	final public StringBuffer expr() throws ParseException {
		StringBuffer value = new StringBuffer();
		term(value);
		label_9: while (true) {
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PLUS:
			case MINUS:
			case COMMA:
			case DIV:
			case STRING:
			case NUMBER:
			case URL:
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case COLOR:
			case NORMAL:
			case AUTO:
			case FONT_VAL:
			case FONT_STYLE:
			case FONT_VARIANT:
			case FONT_WEIGHT:
			case BACKGROUND_REPEAT:
			case BACKGROUND_ATTACHMENT:
			case BACKGROUND_POSITION:
			case BORDER_STYLE:
			case BORDER_WIDTH:
			case IDENT:
			case DIMEN:
			case HASH:
			case UNICODERANGE:
			case FUNCTION:
				;
				break;
			default:
				jj_la1[39] = jj_gen;
				break label_9;
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case COMMA:
			case DIV:
				operator(value);
				break;
			default:
				jj_la1[40] = jj_gen;
				;
			}
			term(value);
		}
		{
			if (true) {
				return value;
			}
		}
		throw new Error("Missing return statement in function");
	}

	/**
	 * @exception ParseException exception during the parsing
	 */
	final public void operator(StringBuffer value) throws ParseException {
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case DIV:
			jj_consume_token(DIV);
			if (value.toString().length() > 0) {
				value.append("/");
			}
			break;
		case COMMA:
			jj_consume_token(COMMA);
			if (value.toString().length() > 0) {
				value.append(",");
			}
			break;
		default:
			jj_la1[41] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
	}

	/**
	 * @exception ParseException exception during the parsing
	 */
	final public void term(StringBuffer value) throws ParseException {
		Token n;
		char operator = ' ';
		String func;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case PLUS:
		case MINUS:
		case NUMBER:
		case PERCENTAGE:
		case LENGTH:
		case ABSOLUTE_SIZE:
		case RELATIVE_SIZE:
		case COLOR:
		case NORMAL:
		case AUTO:
		case FONT_VAL:
		case FONT_STYLE:
		case FONT_VARIANT:
		case FONT_WEIGHT:
		case BACKGROUND_REPEAT:
		case BACKGROUND_ATTACHMENT:
		case BACKGROUND_POSITION:
		case BORDER_STYLE:
		case BORDER_WIDTH:
		case DIMEN:
		case FUNCTION:
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case PLUS:
			case MINUS:
				operator = unaryOperator();
				break;
			default:
				jj_la1[42] = jj_gen;
				;
			}
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case NUMBER:
				n = jj_consume_token(NUMBER);
				setValue(value, operator, n, NUMBER);
				break;
			case PERCENTAGE:
			case LENGTH:
			case ABSOLUTE_SIZE:
			case RELATIVE_SIZE:
			case BORDER_WIDTH:
				n = size();
				setValue(value, operator, n, LENGTH);
				break;
			case COLOR:
				n = jj_consume_token(COLOR);
				setValue(value, operator, n, COLOR);
				break;
			case DIMEN:
				n = jj_consume_token(DIMEN);
				System.out.println("Unknown dimension:" + n.image);
				break;
			case FUNCTION:
				func = function();
				value.append(func);
				break;
			case NORMAL:
			case AUTO:
			case FONT_VAL:
			case FONT_STYLE:
			case FONT_VARIANT:
			case FONT_WEIGHT:
			case BACKGROUND_REPEAT:
			case BACKGROUND_ATTACHMENT:
			case BACKGROUND_POSITION:
			case BORDER_STYLE:
				n = getFromShorthand();
				setValue(value, operator, n, NORMAL);
				break;
			default:
				jj_la1[43] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			break;
		case STRING:
		case URL:
		case IDENT:
		case HASH:
		case UNICODERANGE:
			switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
			case STRING:
				n = jj_consume_token(STRING);
				setValue(value, operator, n, STRING);
				break;
			case IDENT:
				n = jj_consume_token(IDENT);
				setValue(value, operator, n, IDENT);
				break;
			case HASH:
				hexcolor(value);
				break;
			case URL:
				n = jj_consume_token(URL);
				setValue(value, operator, n, URL);
				break;
			case UNICODERANGE:
				n = jj_consume_token(UNICODERANGE);
				setValue(value, operator, n, UNICODERANGE);
				break;
			default:
				jj_la1[44] = jj_gen;
				jj_consume_token(-1);
				throw new ParseException();
			}
			break;
		default:
			jj_la1[45] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
	}

	/**
	 * Returns the the same token as those in shorthand properties.
	 **/
	final public Token getFromShorthand() throws ParseException {
		Token n;
		switch ((jj_ntk == -1) ? jj_ntk() : jj_ntk) {
		case FONT_VAL:
			n = jj_consume_token(FONT_VAL); {
			if (true) {
				return n;
			}
		}
			break;
		case FONT_STYLE:
			n = jj_consume_token(FONT_STYLE); {
			if (true) {
				return n;
			}
		}
			break;
		case FONT_VARIANT:
			n = jj_consume_token(FONT_VARIANT); {
			if (true) {
				return n;
			}
		}
			break;
		case FONT_WEIGHT:
			n = jj_consume_token(FONT_WEIGHT); {
			if (true) {
				return n;
			}
		}
			break;
		case BACKGROUND_REPEAT:
			n = jj_consume_token(BACKGROUND_REPEAT); {
			if (true) {
				return n;
			}
		}
			break;
		case BACKGROUND_ATTACHMENT:
			n = jj_consume_token(BACKGROUND_ATTACHMENT); {
			if (true) {
				return n;
			}
		}
			break;
		case BACKGROUND_POSITION:
			n = jj_consume_token(BACKGROUND_POSITION); {
			if (true) {
				return n;
			}
		}
			break;
		case AUTO:
			n = jj_consume_token(AUTO); {
			if (true) {
				return n;
			}
		}
			break;
		case NORMAL:
			n = jj_consume_token(NORMAL); {
			if (true) {
				return n;
			}
		}
			break;
		case BORDER_STYLE:
			n = jj_consume_token(BORDER_STYLE); {
			if (true) {
				return n;
			}
		}
			break;
		default:
			jj_la1[46] = jj_gen;
			jj_consume_token(-1);
			throw new ParseException();
		}
		throw new Error("Missing return statement in function");
	}

	/**
	 * @exception ParseException exception during the parsing
	 */
	final public String function() throws ParseException {
		StringBuffer exp;
		Token n = jj_consume_token(FUNCTION);
		exp = expr();
		jj_consume_token(LPARAN);
		{
			if (true) {
				return n.image + exp.toString() + ")";
			}
		}
		throw new Error("Missing return statement in function");
	}

	/**
	 * @exception ParseException exception during the parsing
	 */
	final public void hexcolor(StringBuffer value) throws ParseException {
		Token n;
		n = jj_consume_token(HASH);
		setValue(value, ' ', n, HASH);
	}

	/**
	 *
	 * @param s
	 * @param start
	 * @param len
	 * @return @throws ParseException
	 */
	String convertStringIndex(String s, int start, int len) throws ParseException, ParseException {
		StringBuilder buf = new StringBuilder(len);
		int index = start;

		while (index < len) {
			char c = s.charAt(index);
			if (c == '\\') {
				if (++index < len) {
					c = s.charAt(index);
					switch (c) {
					case '0':
					case '1':
					case '2':
					case '3':
					case '4':
					case '5':
					case '6':
					case '7':
					case '8':
					case '9':
					case 'a':
					case 'b':
					case 'c':
					case 'd':
					case 'e':
					case 'f':
					case 'A':
					case 'B':
					case 'C':
					case 'D':
					case 'E':
					case 'F':
						int numValue = Character.digit(c, 16);
						int count = 0;
						int p = 16;

						while (index + 1 < len && count < 6) {
							c = s.charAt(index + 1);

							if (Character.digit(c, 16) != -1) {
								numValue = (numValue * 16) + Character.digit(c, 16);
								p *= 16;
								index++;
							} else {
								if (c == ' ') {
									// skip the latest white space
									index++;
								}
								break;
							}
						}

						buf.append((char) numValue);
						break;
					case '\n':
					case '\f':
						break;
					case '\r':
						if (index + 1 < len) {
							if (s.charAt(index + 1) == '\n') {
								index++;
							}
						}
						break;
					default:
						buf.append(c);
					}
				} else {
					throw new ParseException("invalid string");
				}
			} else {
				buf.append(c);
			}
			index++;
		}

		return buf.toString();
	}

	/**
	 *
	 * @param s
	 * @return
	 * @throws ParseException
	 */
	String convertIdent(String s) throws ParseException, ParseException {
		return convertStringIndex(s, 0, s.length());
	}

	public PropertyParserTokenManager token_source;
	SimpleCharStream jj_input_stream;
	public Token token, jj_nt;
	private int jj_ntk;
	private int jj_gen;
	final private int[] jj_la1 = new int[47];
	static private int[] jj_la1_0;
	static private int[] jj_la1_1;
	static private int[] jj_la1_2;
	static {
		jj_la1_0();
		jj_la1_1();
		jj_la1_2();
	}

	private static void jj_la1_0() {
		jj_la1_0 = new int[] { 0xc000, 0x0, 0x0, 0x0, 0x80000, 0x0, 0x10000, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
				0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
				0x0, 0x0, 0x0, 0x9c000, 0x90000, 0x90000, 0xc000, 0x0, 0x0, 0xc000, 0x0, };
	}

	private static void jj_la1_1() {
		jj_la1_1 = new int[] { 0x0, 0x1001e00, 0xe4000, 0xe4000, 0x0, 0x2000020, 0x0, 0x2000020, 0x10f5e00, 0x1703f00,
				0x1703f00, 0x1803e00, 0x1803e00, 0x1001e00, 0x1001e00, 0x1001e00, 0x800000, 0x800000, 0x800000, 0x2000,
				0x2000, 0x2000, 0x1803e00, 0x1803e00, 0x1803e00, 0x1803e00, 0x1803e00, 0x1803e00, 0x1803e00, 0x1803e00,
				0x8600, 0x8600, 0x8600, 0x8600, 0x600, 0x600, 0x600, 0x600, 0x1401e00, 0xfffff60, 0x0, 0x0, 0x0,
				0x5fffe40, 0xa000120, 0xfffff60, 0xffc000, };
	}

	private static void jj_la1_2() {
		jj_la1_2 = new int[] { 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
				0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0, 0x0,
				0x60, 0x0, 0x0, 0x0, 0x40, 0x20, 0x60, 0x0, };
	}

	public PropertyParser(java.io.InputStream stream) {
		jj_input_stream = new SimpleCharStream(stream, 1, 1);
		token_source = new PropertyParserTokenManager(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 47; i++) {
			jj_la1[i] = -1;
		}
	}

	public void ReInit(java.io.InputStream stream) {
		jj_input_stream.ReInit(stream, 1, 1);
		token_source.ReInit(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 47; i++) {
			jj_la1[i] = -1;
		}
	}

	public PropertyParser(java.io.Reader stream) {
		jj_input_stream = new SimpleCharStream(stream, 1, 1);
		token_source = new PropertyParserTokenManager(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 47; i++) {
			jj_la1[i] = -1;
		}
	}

	public void ReInit(java.io.Reader stream) {
		jj_input_stream.ReInit(stream, 1, 1);
		token_source.ReInit(jj_input_stream);
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 47; i++) {
			jj_la1[i] = -1;
		}
	}

	public PropertyParser(PropertyParserTokenManager tm) {
		token_source = tm;
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 47; i++) {
			jj_la1[i] = -1;
		}
	}

	public void ReInit(PropertyParserTokenManager tm) {
		token_source = tm;
		token = new Token();
		jj_ntk = -1;
		jj_gen = 0;
		for (int i = 0; i < 47; i++) {
			jj_la1[i] = -1;
		}
	}

	final private Token jj_consume_token(int kind) throws ParseException {
		Token oldToken;
		if ((oldToken = token).next != null) {
			token = token.next;
		} else {
			token = token.next = token_source.getNextToken();
		}
		jj_ntk = -1;
		if (token.kind == kind) {
			jj_gen++;
			return token;
		}
		token = oldToken;
		jj_kind = kind;
		throw generateParseException();
	}

	final public Token getNextToken() {
		if (token.next != null) {
			token = token.next;
		} else {
			token = token.next = token_source.getNextToken();
		}
		jj_ntk = -1;
		jj_gen++;
		return token;
	}

	final public Token getToken(int index) {
		Token t = token;
		for (int i = 0; i < index; i++) {
			if (t.next != null) {
				t = t.next;
			} else {
				t = t.next = token_source.getNextToken();
			}
		}
		return t;
	}

	final private int jj_ntk() {
		jj_nt = token.next;
		if (jj_nt == null) {
			return (jj_ntk = (token.next = token_source.getNextToken()).kind);
		} else {
			return (jj_ntk = jj_nt.kind);
		}
	}

	private java.util.Vector jj_expentries = new java.util.Vector();
	private int[] jj_expentry;
	private int jj_kind = -1;

	public ParseException generateParseException() {
		jj_expentries.removeAllElements();
		boolean[] la1tokens = new boolean[72];
		for (int i = 0; i < 72; i++) {
			la1tokens[i] = false;
		}
		if (jj_kind >= 0) {
			la1tokens[jj_kind] = true;
			jj_kind = -1;
		}
		for (int i = 0; i < 47; i++) {
			if (jj_la1[i] == jj_gen) {
				for (int j = 0; j < 32; j++) {
					if ((jj_la1_0[i] & (1 << j)) != 0) {
						la1tokens[j] = true;
					}
					if ((jj_la1_1[i] & (1 << j)) != 0) {
						la1tokens[32 + j] = true;
					}
					if ((jj_la1_2[i] & (1 << j)) != 0) {
						la1tokens[64 + j] = true;
					}
				}
			}
		}
		for (int i = 0; i < 72; i++) {
			if (la1tokens[i]) {
				jj_expentry = new int[1];
				jj_expentry[0] = i;
				jj_expentries.addElement(jj_expentry);
			}
		}
		int[][] exptokseq = new int[jj_expentries.size()][];
		for (int i = 0; i < jj_expentries.size(); i++) {
			exptokseq[i] = (int[]) jj_expentries.elementAt(i);
		}
		return new ParseException(token, exptokseq, tokenImage);
	}

	final public void enable_tracing() {
	}

	final public void disable_tracing() {
	}

}
