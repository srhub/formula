package com.srhub.formula.core;

import static org.junit.Assert.assertEquals;

import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Sets;

public class PredicatesTest {

	@Test
	public void testExistence() {
		final String term = "true & com.foo#bar?";
		final Set<String> actualVariables = Predicates.extractVariables(term);
		final Set<String> expectedVariables = Sets.newHashSet("com.foo");

		assertEquals(expectedVariables, actualVariables);
	}
}
