package com.srhub.formula.core;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Function;
import com.srhub.formula.api.Predicate;

/**
 * The Class PredicateFunction.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class PredicateFunction implements Function {

	private final Predicate predicate;

	private final Function function;

	private final int defaultResult;

	public PredicateFunction(final Predicate predicate,
			final Function function, final int defaultResult) {
		super();
		this.predicate = predicate;
		this.function = function;
		this.defaultResult = defaultResult;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public Function getFunction() {
		return function;
	}

	public int getDefaultResult() {
		return defaultResult;
	}

	@Override
	public Set<String> getVariables() {

		final Set<String> variables = new HashSet<>();

		variables.addAll(predicate.getVariables());
		variables.addAll(function.getVariables());

		return variables;
	}

	@Override
	public int evaluate(final Map<String, ? extends Object> variables)
			throws EvaluationException {

		if (!predicate.applies(variables)) {
			return defaultResult;
		}

		return function.evaluate(variables);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + defaultResult;
		result = prime * result
				+ ((function == null) ? 0 : function.hashCode());
		result = prime * result
				+ ((predicate == null) ? 0 : predicate.hashCode());
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
		final PredicateFunction other = (PredicateFunction) obj;
		if (defaultResult != other.defaultResult) {
			return false;
		}
		if (function == null) {
			if (other.function != null) {
				return false;
			}
		} else if (!function.equals(other.function)) {
			return false;
		}
		if (predicate == null) {
			if (other.predicate != null) {
				return false;
			}
		} else if (!predicate.equals(other.predicate)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "PredicateFunction [predicate=" + predicate + ", function="
				+ function + ", defaultResult=" + defaultResult + "]";
	}

}
