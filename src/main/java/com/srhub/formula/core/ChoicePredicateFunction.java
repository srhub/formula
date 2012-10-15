package com.srhub.formula.core;

import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Function;
import com.srhub.formula.api.Predicate;

public class ChoicePredicateFunction implements Function {

	private final Map<Predicate, Function> map;
	private final int defaultResult;

	public ChoicePredicateFunction(final Map<Predicate, Function> map,
			final int defaultResult) {
		this.map = map;
		this.defaultResult = defaultResult;
	}

	@Override
	public int evaluate(final Map<String, ? extends Object> variables)
			throws EvaluationException {
		// TODO is iteration order important for this?
		final Set<Predicate> predicates = map.keySet();
		for (final Predicate predicate : predicates) {
			if (predicate.applies(variables)) {
				return map.get(predicate).evaluate(variables);
			}
		}

		return defaultResult;
	}

	@Override
	public Set<String> getVariables() {
		// TODO Auto-generated method stub
		return null;
	}
}
