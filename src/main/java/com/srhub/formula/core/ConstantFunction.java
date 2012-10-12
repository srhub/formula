package com.srhub.formula.core;

import java.util.Collections;
import java.util.Map;
import java.util.Set;

import com.srhub.formula.api.Function;

public class ConstantFunction implements Function {

	private final int value;

	public ConstantFunction(final int value) {
		super();
		this.value = value;
	}

	public float getValue() {
		return value;
	}

	@Override
	public int evaluate(final Map<String, ?> variables) {
		return value;
	}

	@Override
	public Set<String> getVariables() {
		return Collections.<String> emptySet();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
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
		final ConstantFunction other = (ConstantFunction) obj;
		if (value != other.value) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ConstantFunction [value=" + value + "]";
	}

}
