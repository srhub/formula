package com.srhub.formula.core;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Predicate;

public class ConstantPredicate implements Predicate {

	private static final Set<String> EMPTY_SET = Collections.emptySet();

	private final boolean constant;

	protected ConstantPredicate(final boolean constant) {
		this.constant = constant;
	}

	@Override
	public Set<String> getVariables() {
		return EMPTY_SET;
	}

	@Override
	public boolean applies(final Map<String, ? extends Object> variables)
			throws EvaluationException {
		return constant;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (constant ? 1231 : 1237);
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
		final ConstantPredicate other = (ConstantPredicate) obj;
		if (constant != other.constant) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ConstantPredicate [constant=" + constant + "]";
	}

}
