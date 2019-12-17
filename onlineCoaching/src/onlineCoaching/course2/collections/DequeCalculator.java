package onlineCoaching.course2.collections;

import static java.lang.Integer.parseInt;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;

import org.junit.Test;

public class DequeCalculator {
	public int evaluate(final String input) {
		final Deque<String> stack = new ArrayDeque<>();
		final String[] tokens = input.split(" ");
		for(String token : tokens) {
			stack.add(token);
		}
		
		while(stack.size()>1) {
			final int left = parseInt(stack.pop());
			final String operator = stack.pop();
			final int right = parseInt(stack.pop());
			
			int result = 0;
			switch(operator) {
				case "+":
					result = left + right;
					break;
				case "-":
					result = left - right;
					break;
			}
			stack.push(String.valueOf(result));
		}
		return parseInt(stack.pop());
	}
	
	public static void main(String[] args) {
		CalculatorTest c = new CalculatorTest();
		c.shouldComplexStatements();
		c.shouldEvaluateConstants();
		c.shouldSupportAdding();
		c.shouldSupportSubtraction();
	}

}

class CalculatorTest{
	private DequeCalculator calculator = new DequeCalculator();
	
	@Test
	public void shouldEvaluateConstants() {
		int result = calculator.evaluate("1");
		assertEquals(1, result);
	}
	
	@Test
	public void shouldSupportAdding() {
		int result = calculator.evaluate("1 + 2");
		assertEquals(3, result);
	}
	
	@Test
	public void shouldSupportSubtraction() {
		int result = calculator.evaluate("1 - 2");
		assertEquals(-1, result);
	}
	
	@Test
	public void shouldComplexStatements() {
		int result = calculator.evaluate("1 - 3 + 2 + 4");
		assertEquals(4, result);
	}
}













