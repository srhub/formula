package com.srhub.formula.core;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Terms {

	/** The LOGGER. */
	private final static Logger LOGGER = LoggerFactory.getLogger(Terms.class);

	/** The PATTERN. */
	private final static Pattern PATTERN = Pattern.compile("[a-z\\.]*");

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
			if (match.length() > 0) {
				LOGGER.trace("Found match \"{}\"", match);
				modifiers.add(match);
			}
		}

		return modifiers;
	}

}
