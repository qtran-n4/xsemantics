/*******************************************************************************
 * Copyright (c) 2013-2017 Lorenzo Bettini.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *   Lorenzo Bettini - Initial contribution and API
 *******************************************************************************/

package org.eclipse.xsemantics.example.fj.typesystem.fj.rules;

import it.xtypes.runtime.*;

public class TMethodCallTypeRule extends FJTypeSystemRule {

	protected Variable<org.eclipse.xsemantics.example.fj.fj.MethodCall> var_m = new Variable<org.eclipse.xsemantics.example.fj.fj.MethodCall>(
			createEClassifierType(basicPackage.getMethodCall()));

	protected Variable<org.eclipse.xsemantics.example.fj.fj.Type> right_var;

	protected TypingJudgmentEnvironment env_G = new TypingJudgmentEnvironment();

	public TMethodCallTypeRule() {
		this("TMethodCall", "|-", ":");
	}

	public TMethodCallTypeRule(String ruleName, String typeJudgmentSymbol,
			String typeStatementRelation) {
		super(ruleName, typeJudgmentSymbol, typeStatementRelation);
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.MethodCall> getLeft() {
		return var_m;
	}

	@Override
	public Variable<org.eclipse.xsemantics.example.fj.fj.Type> getRight() {
		if (right_var == null)
			right_var = new Variable<org.eclipse.xsemantics.example.fj.fj.Type>(
					createEClassifierType(basicPackage.getType()), null);
		return right_var;
	}

	@Override
	public TypingJudgmentEnvironment getEnvironment() {
		return env_G;
	}

	@Override
	public void setEnvironment(TypingJudgmentEnvironment environment) {
		if (environment != null)
			env_G = environment;
	}

	@Override
	public RuntimeRule newInstance() {
		return new TMethodCallTypeRule("TMethodCall", "|-", ":");
	}

	@Override
	public void applyImpl() throws RuleFailedException {

		applySubtypeRule(env_G, var_m.getValue().getArgs(), var_m.getValue()
				.getMethod().getParams());

		getRight().setValue(var_m.getValue().getMethod().getType());

	}

	@Override
	protected String failMessage() {
		return "cannot type";
	}

}
