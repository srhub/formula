package com.srhub.formula.core;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Predicate;

public class ConstantPredicate implements Predicate {

	private final boolean constant;

	protected ConstantPredicate(final boolean constant) {
		this.constant = constant;
	}

	@Override
	public Set<String> getVariables() {
		return Collections.emptySet();
	}

	@Override
	public boolean applies(final Map<String, ? extends Object> variables)
			throws EvaluationException {
		return constant;
	}

}
