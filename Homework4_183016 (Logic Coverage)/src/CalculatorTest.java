import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator;
    @BeforeEach
    public void setUp(){
        calculator=new Calculator();
    }

    public static Collection<Object[]> provider1(){
        return Arrays.asList(new Object[][]{
                {7,5,8,5,15,2400}, //6th row from the truth table for predicate: T,F,T,F
                {39,5,10,6,18,2021}, //11th row from the truth table for predicate: F,T,F,T
                {100,5,10,8,18,2300}, //13th row from the truth table for predicate: F,F,T,T
                {100,5,10,8,18,2800}, //14th row from the truth table for predicate: F,F,T,F
                {100,5,10,8,18,2028} //15th row from the truth table for predicate: F,F,F,T

        });
    }

    @ParameterizedTest
    @MethodSource("provider1")
    public void PTests(int expected, int month1, int day1, int month2, int day2, int year){
        assertEquals(expected,Calculator.cal(month1,day1,month2,day2,year));

    }



}