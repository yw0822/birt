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

package org.eclipse.birt.report.engine.api;

/**
 * Defines render options for PDF emitter.
 */
public interface IPDFRenderOption extends IRenderOption {
	/**
	 * @deprecated Scale the content to fit into the page, when the content exceeds
	 *             page size. This property has been deprecated, please set
	 *             PAGE_OVERFLOW = FIT_TO_PAGE_SIZE instead.
	 */
	@Deprecated
	String FIT_TO_PAGE = "pdfRenderOption.fitToPage";

	/**
	 * @deprecated The flag to indicate whether PDF layout use auto page break or
	 *             not. if it is set to true, then auto page break will not take
	 *             effect. This property has been deprecated, please set
	 *             PAGE_OVERFLOW = OUTPUT_TO_MULTIPLE_PAGES instead.
	 */
	@Deprecated
	String PAGEBREAK_PAGINATION_ONLY = "pdfRenderOption.pagebreakPaginationOnly";

	/**
	 * Properties to control how to output the content if the content exceeds the
	 * page-size. CLIP_CONTENT: clip the content FIT_TO_PAGE_SIZE: scale the content
	 * to fit into the page OUTPUT_TO_MULTIPLE_PAGES: divided the content into
	 * multiple pages ENLARGE_PAGE_SIZE: enlarge the page size to contain all the
	 * content.
	 */
	String PAGE_OVERFLOW = "pdfRenderOption.pageOverflow";

	// disabled on ui
	int CLIP_CONTENT = 1;
	// "Fit to whole page" on ui
	int FIT_TO_PAGE_SIZE = 2;
	// "Auto" on ui
	int OUTPUT_TO_MULTIPLE_PAGES = 4;
	// "Actual size" on ui
	int ENLARGE_PAGE_SIZE = 8;

	/**
	 * define the PDF page count limit, it should be an Integer object
	 */
	String PDF_PAGE_LIMIT = "pdfRenderOption.pageLimit";

	/**
	 * If it is set to false, all the text should be displayed into one line, the
	 * text which can not be displayed in the line will be clipped.
	 */
	String PDF_TEXT_WRAPPING = "pdfRenderOption.textWrapping";

	/**
	 * If it is set to false, no word break is used. The word longer than the line
	 * width will be clipped at the line boundary.
	 */
	String PDF_WORDBREAK = "pdfRenderOption.wordBreak";

	/**
	 * If it is set to false, we needn't check if the character exists in the
	 * selected font.
	 */
	String PDF_FONT_SUBSTITUTION = "pdfRenderOption.fontSubstitution";

	/**
	 * If it is set to false, no BIDI processing is used.
	 */
	String PDF_BIDI_PROCESSING = "pdfRenderOption.bidiProcessing";

	/**
	 * The customer defined DPI setting for image display.
	 */
	String DPI = IRenderOption.RENDER_DPI;

	/**
	 * The layout uses the page number from the report document. If it is false, use
	 * the page number generated by layout engine.
	 */
	String RESERVE_DOCUMENT_PAGE_NUMBERS = "pdfRenderOption.reserveDocumentPageNumbers";

	/**
	 * The option to let PDF emitter choose to "render all pages" or "render page by
	 * page". It is false by default, corresponding to "render all pages".
	 */
	String REPAGINATE_FOR_PDF = "pdfRenderOption.repaginateForPDF";

	/**
	 * @deprecated define the font directory used by PDF.
	 */
	@Deprecated
	String FONT_DIRECTORY = "pdfRenderOption.fontDirectory";

	/**
	 * @deprecated should the true-type font be embedded into the generated PDF
	 *             file.
	 */
	@Deprecated
	String IS_EMBEDDED_FONT = "pdfRenderOption.embeddedFonts";

	/**
	 * The option to disable flash animation. Set this option to true for PDF
	 * printing.
	 */
	String DISABLE_FLASH_ANIMATION = "pdfRenderOption.disableFlashAnimation";

	/**
	 * The option to disable print.
	 */
	String DISABLE_PRINT = "pdfRenderOption.disablePrint";

	/**
	 * @deprecated
	 * @param isEmbededFont
	 */
	@Deprecated
	void setEmbededFont(boolean isEmbededFont);

	/**
	 * @deprecated
	 * @return if font is embedded
	 */
	@Deprecated
	boolean isEmbededFont();

	/**
	 * @deprecated
	 * @return the user-defined font directory
	 */
	@Deprecated
	String getFontDirectory();

	/**
	 * @deprecated
	 * @param fontDirectory the user-defined font directory
	 */
	@Deprecated
	void setFontDirectory(String fontDirectory);
}
