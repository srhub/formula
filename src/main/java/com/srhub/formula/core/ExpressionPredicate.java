package com.srhub.formula.core;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.platzhaltr.predicatr.core.Predicatr;
import com.srhub.formula.api.Predicate;

public class ExpressionPredicate implements Predicate {

	/** The LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(ExpressionPredicate.class);

	private final String condition;

	public ExpressionPredicate(final String condition) {
		super();
		this.condition = condition;
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean applies(final Map<String, ? extends Object> variables)
			throws EvaluationException {

		LOGGER.trace("Evaluating {} with {}", condition, variables);

		final SetView<String> difference = Sets.difference(getVariables(),
				variables.keySet());

		if (!difference.isEmpty()) {
			throw new EvaluationException("Missing variables",
					difference.immutableCopy());
		}

		return Predicatr.parse(condition, (Map<String, Object>) variables);
	}

	@Override
	public Set<String> getVariables() {
		return Predicates.extractVariables(condition);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((condition == null) ? 0 : condition.hashCode());
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
		final ExpressionPredicate other = (ExpressionPredicate) obj;
		if (condition == null) {
			if (other.condition != null) {
				return false;
			}
		} else if (!condition.equals(other.condition)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ExpressionPredicate [condition=" + condition + "]";
	}

}
