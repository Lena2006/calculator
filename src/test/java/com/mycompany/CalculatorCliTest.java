/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.Reader;
import java.io.StringReader;
import java.util.concurrent.TimeUnit;
import java.util.function.DoubleConsumer;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;
import org.junit.rules.Timeout;
import org.mockito.Mockito;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;



public class CalculatorCliTest {
private  Calkulator calculatorMock;
private CalculatorCli calculatorCli;

@Rule
public TestRule timeout = new Timeout(1, TimeUnit.MINUTES);

    @Before
    public  void setUp()  {
        calculatorMock = Mockito.mock(Calkulator.class);
        calculatorCli = new CalculatorCli(calculatorMock);
        
    }

    @Test
    public void emptyExpressionsMustBeSkipped() {
      calculatorCli.runInteractiveSession(new StringReader (";\n;  ;;;\t\n;"));
      Mockito.verifyZeroInteractions(calculatorMock);
    }
    @Test
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated() {
       calculatorCli.runInteractiveSession(new StringReader ("1;2;3;"));
       
       verify(calculatorMock).calculate("1");
       verify(calculatorMock).calculate("2");
       verify(calculatorMock).calculate("3");
       verifyNoMoreInteractions(calculatorMock);
    }

    
    @Test 
    public void eachExpressionSeparatedBySemicolonMustBeEvaluated_2() {
        when(calculatorMock.calculate("1")).thenReturn(1d);
        when(calculatorMock.calculate("2")).thenReturn(2d);
        when(calculatorMock.calculate("3")).thenReturn(3d);
        
        calculatorCli.runInteractiveSession(new StringReader("1;2;3;"));
            verify(calculatorMock).calculate("1");
            verify(calculatorMock).calculate("2");
            verify(calculatorMock).calculate("3");
           verifyNoMoreInteractions(calculatorMock);
           
            
    }
  
}
