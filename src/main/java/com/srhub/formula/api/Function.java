package com.srhub.formula.api;

import java.util.Map;

import com.srhub.formula.core.EvaluationException;

public interface Function extends Term {

	int evaluate(Map<String, ? extends Object> variables)
			throws EvaluationException;

}
