package com.srhub.formula.core;

import java.util.Map;
import java.util.Set;

import com.platzhaltr.predicatr.core.Predicatr;
import com.srhub.formula.api.Predicate;

public class ExpressionPredicate implements Predicate {

	private final String condition;

	public ExpressionPredicate(final String condition) {
		super();
		this.condition = condition;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean applies(final Map<String, ? extends Object> variables)
			throws EvaluationException {
		return Predicatr.parse(condition, (Map<String, Object>) variables);
	}

	@Override
	public Set<String> getVariables() {
		return Terms.extractVariables(condition);
	}

}
