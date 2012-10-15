package com.srhub.formula.core;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.srhub.formula.api.Predicate;

public class Predicates {

	/** The LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(Terms.class);

	/** The PATTERN. */
	private final static Pattern PATTERN = Pattern.compile("#?[a-z\\.]*");

	private static final String TRUE = "true";
	private static final String FALSE = "false";
	private static final String OCTOTHORPE = "#";

	private static final Predicate ALWAYS_TRUE = new ConstantPredicate(true);
	private static final Predicate ALWAYS_FALSE = new ConstantPredicate(false);

	/**
	 * Gets the variables.
	 * 
	 * @param s
	 *            the s
	 * @return the variables
	 */
	public static Set<String> extractVariables(final String term) {

		final Matcher matcher = PATTERN.matcher(term);

		LOGGER.trace("Matching \"{}\"", term);

		final Set<String> modifiers = new HashSet<>();
		while (matcher.find()) {
			final String match = matcher.group();

			// TODO why does the regex find empty strings?
			// TODO regex to ignore true, false
			if (match.length() > 0) {
				if (!(match.equals(TRUE) || match.equals(FALSE) || match
						.startsWith(OCTOTHORPE))) {
					LOGGER.trace("Found match \"{}\"", match);
					modifiers.add(match);
				}
			}
		}

		return modifiers;
	}

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
		return ALWAYS_TRUE;
	}

	public static Predicate alwaysFalse() {
		return ALWAYS_FALSE;
	}
}
