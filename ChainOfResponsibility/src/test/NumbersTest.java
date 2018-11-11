package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import chainPattern.*;

class NumbersTest {

	@Test
	void test() {
		Numbers request = new Numbers(4, 2, "add");
		Numbers request2 = new Numbers(4, 2, "subtract");
		Numbers request3 = new Numbers(4, 2, "multiply");
		Numbers request4 = new Numbers(4, 2, "divide");
		AddNumbers addNumbers = new AddNumbers();
		SubtractNumbers subNumbers = new SubtractNumbers();
		MultiplyNumbers multiplyNumbers = new MultiplyNumbers();
		DivideNumbers divideNumbers = new DivideNumbers();
		addNumbers.setNextChain(subNumbers);
		subNumbers.setNextChain(multiplyNumbers);
		multiplyNumbers.setNextChain(divideNumbers);
		assertEquals(6, addNumbers.calculate(request), "4 + 2 = 6");
		assertEquals(2, addNumbers.calculate(request2), "4 - 2 = 2");
		assertEquals(8, addNumbers.calculate(request3), "4 * 2 = 8");
		assertEquals(2, addNumbers.calculate(request4), "4 / 2 = 2");
	}
}