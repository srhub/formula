package com.srhub.formula.core;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Set;

import org.junit.Test;

public class ExpressionFunctionTest {

	@Test
	public void testGetVariables() {
		final ExpressionFunction function = new ExpressionFunction(
				"10 -essence");

		final Set<String> variables = function.getVariables();

		assertTrue(variables.size() == 1);
		assertEquals("essence", variables.iterator().next());
	}

}
