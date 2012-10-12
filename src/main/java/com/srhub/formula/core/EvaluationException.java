package com.srhub.formula.core;

import java.util.Set;

public class EvaluationException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Set<String> missingKeys;

	public EvaluationException(final String message,
			final Set<String> missingKeys) {
		super(message);
		this.missingKeys = missingKeys;
	}

	public Set<String> getMissingKeys() {
		return missingKeys;
	}

}
