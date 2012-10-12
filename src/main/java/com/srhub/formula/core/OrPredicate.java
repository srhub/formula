package com.srhub.formula.core;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Predicate;

public class OrPredicate implements Predicate {

	private final Predicate[] predicates;

	protected OrPredicate(final Predicate[] predicates) {
		this.predicates = predicates;

	}

	@Override
	public boolean applies(final Map<String, ? extends Object> variables)
			throws EvaluationException {

		for (final Predicate predicate : predicates) {
			final Boolean evaluate = predicate.applies(variables);

			// return on first true
			if (evaluate) {
				return true;
			}
		}

		return false;

	}

	@Override
	public Set<String> getVariables() {

		final Set<String> variables = new HashSet<>();

		for (final Predicate predicate : predicates) {
			variables.addAll(predicate.getVariables());
		}

		return variables;
	}

}
