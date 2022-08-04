package com.agungtsp.githubuserfavorite;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
  Calculator calculator;

  @Test
  void testMultiply() {
    calculator = new Calculator();
    Assert.assertEquals(20, calculator.multiply(4,5));
    Assert.assertEquals(40, calculator.multiply(10,4));
  }

  @Test
  void testMultiplyThousand() {
    calculator = new Calculator();
    Assert.assertEquals(2000, calculator.multiply(10,200));
  }

  @Test
  void testDivide() {
    calculator = new Calculator();
    Assert.assertEquals(10, calculator.divide(100,10));
  }
}
