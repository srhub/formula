package com.srhub.formula.core;

import java.util.List;

import com.srhub.formula.api.Predicate;

public class Predicates {

	private static final Predicate TRUE = new ConstantPredicate(true);
	private static final Predicate FALSE = new ConstantPredicate(false);

	public static Predicate and(final List<Predicate> predicates) {
		return and(predicates.toArray(new Predicate[predicates.size()]));
	}

	public static Predicate and(final Predicate... predicates) {
		if (predicates.length == 0) {
			return null;
		} else if (predicates.length == 1) {
			return predicates[0];
		}

		return new AndPredicate(predicates);

	}

	public static Predicate or(final Predicate... predicates) {
		if (predicates.length == 0) {
			return null;
		} else if (predicates.length == 1) {
			return predicates[0];
		}

		return new OrPredicate(predicates);
	}

	public static Predicate alwaysTrue() {
		return TRUE;
	}

	public static Predicate alwaysFalse() {
		return FALSE;
	}
}
