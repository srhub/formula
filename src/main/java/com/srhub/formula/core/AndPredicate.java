package com.srhub.formula.core;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Predicate;

public class AndPredicate implements Predicate {

	private final Predicate[] predicates;

	protected AndPredicate(final Predicate[] predicates) {
		this.predicates = predicates;

	}

	@Override
	public boolean applies(final Map<String, ? extends Object> variables)
			throws EvaluationException {

		for (final Predicate predicate : predicates) {
			final Boolean evaluate = predicate.applies(variables);

			// return on first false
			if (!evaluate) {
				return false;
			}
		}

		return true;

	}

	@Override
	public Set<String> getVariables() {

		final Set<String> variables = new HashSet<>();

		for (final Predicate predicate : predicates) {
			variables.addAll(predicate.getVariables());
		}

		return variables;
	}

	@Override
	public int hashCode() {
		// prime 17 to differentiate between AndPredicate and OrPredicate
		final int prime = 17;
		int result = 1;
		result = prime * result + Arrays.hashCode(predicates);
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final AndPredicate other = (AndPredicate) obj;
		if (!Arrays.equals(predicates, other.predicates)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "AndPredicate [predicates=" + predicates + "]";
	}

}
