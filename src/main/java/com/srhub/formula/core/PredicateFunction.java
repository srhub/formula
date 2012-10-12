package com.srhub.formula.core;

import com.srhub.formula.api.Function;
import com.srhub.formula.api.Predicate;

/**
 * The Class PredicateFunction.
 * 
 * @author Oliver Schrenk <oliver.schrenk@gmail.com>
 */
public class PredicateFunction {

	private final Predicate predicate;

	private final Function function;

	public PredicateFunction(final Predicate predicate, final Function function) {
		super();
		this.predicate = predicate;
		this.function = function;
	}

	public Predicate getPredicate() {
		return predicate;
	}

	public Function getFunction() {
		return function;
	}

}
