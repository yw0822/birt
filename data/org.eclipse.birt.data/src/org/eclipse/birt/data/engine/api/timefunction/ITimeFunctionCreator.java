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
package org.eclipse.birt.data.engine.api.timefunction;

public interface ITimeFunctionCreator {
	IPeriodsFunction createPeriodsToDateFunction(String levelType, boolean isCurrent);

	IPeriodsFunction createTrailingFunction(String levelType, int Offset);

	IParallelPeriod createParallelPeriodFunction(String levelType, int Offset);
}
