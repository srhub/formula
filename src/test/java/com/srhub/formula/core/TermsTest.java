package com.srhub.formula.core;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class TermsTest {

	@Test
	public void testExtractVariables() {
		final String term = "10 - variable";

		final Set<String> actualVariables = Terms.extractVariables(term);
		final Set<String> expectedVariables = Sets.newHashSet("variable");

		assertEquals(expectedVariables, actualVariables);
	}

}
