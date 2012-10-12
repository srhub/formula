package com.srhub.formula.core;

import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.Sets;
import com.google.common.collect.Sets.SetView;
import com.platzhaltr.calcr.core.Calcr;
import com.srhub.formula.api.Function;

/**
 * The Class ExpressionFunction.
 */
public class ExpressionFunction implements Function {

	/** The LOGGER. */
	private final static Logger LOGGER = LoggerFactory
			.getLogger(ExpressionFunction.class);

	/** The expression. */
	protected final String expression;

	/**
	 * Instantiates a new expression expression.
	 * 
	 * @param expression
	 *            the expression
	 */
	public ExpressionFunction(final String expression) {
		this.expression = expression;
	}

	/**
	 * Gets the expression.
	 * 
	 * @return the expression
	 */
	public String getExpression() {
		return expression;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.srhub.sr3.core.task.Function#evaluate(java.util.Map)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public int evaluate(final Map<String, ? extends Object> variables)
			throws EvaluationException {

		LOGGER.trace("Evaluating {} with {}", expression, variables);

		final SetView<String> difference = Sets.difference(getVariables(),
				variables.keySet());

		if (!difference.isEmpty()) {
			throw new EvaluationException("Missing variables",
					difference.immutableCopy());
		}

		return (int) Calcr.parse(expression, (Map<String, Number>) variables);
	}

	@Override
	public Set<String> getVariables() {
		return Terms.extractVariables(expression);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((expression == null) ? 0 : expression.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final ExpressionFunction other = (ExpressionFunction) obj;
		if (expression == null) {
			if (other.expression != null) {
				return false;
			}
		} else if (!expression.equals(other.expression)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "ExpressionFunction [expression=" + expression + "]";
	}

}
