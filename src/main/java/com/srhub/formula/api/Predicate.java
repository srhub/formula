package com.srhub.formula.api;

import java.util.Map;

import com.srhub.formula.core.EvaluationException;

public interface Predicate extends Term {

	boolean applies(Map<String, ? extends Object> variables)
			throws EvaluationException;

}
