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
/* Generated By:JJTree: Do not edit this line. ASTTemplate.java */

package org.eclipse.birt.core.template;

public class ASTTemplate extends SimpleNode {
	public ASTTemplate(int id) {
		super(id);
	}

	public ASTTemplate(Parser p, int id) {
		super(p, id);
	}

	/** Accept the visitor. **/
	@Override
	public Object jjtAccept(ParserVisitor visitor, Object data) {
		return visitor.visit(this, data);
	}
}
