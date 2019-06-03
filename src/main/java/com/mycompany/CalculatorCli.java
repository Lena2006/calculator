/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.function.DoubleConsumer;
import java.util.stream.Stream;

/**
 * Является клиентским классом для вызова calculatorImp
 *
 * @author Елена
 */
public class CalculatorCli {

    private final Calkulator calculator;

    public CalculatorCli(Calkulator calculator) {
        this.calculator = calculator;
    }
/**
 * Запускает интерактивную сессию
 * Считывает вводимые с консоли данные
 * @param reader 
 * имеет тип Reader
 */
    public void runInteractiveSession(Reader reader) {
        runInteractiveSession(reader, System.out::println);
       // runInteractuveSession(reader, System.out::println);
     //   runInteractiveSession(reader);

    }
/**
 * Запускает интерактивную сессию
 * Работает со Stream
 * Раскладывает строчку разделенные точкой с запятой
 *  @param reader 
 * Abstract class for reading character streams.  The only methods that a
 * subclass must implement are read(char[], int, int) and close().  Most
 * subclasses, however, will override some of the methods defined here in order
 * to provide higher efficiency, additional functionality, or both.
 * @param resultConsumer 
 * Represents an operation that accepts a single {@code double}-valued argument and
 * returns no result.  This is the primitive type specialization of
 * {@link Consumer} for {@code double}.  Unlike most other functional interfaces,
 * {@code DoubleConsumer} is expected to operate via side-effects.
 * 
 */
    public void runInteractiveSession(Reader reader, DoubleConsumer resultConsumer) {
        new BufferedReader(reader).lines()
                .flatMap(s -> Stream.of(s.split(";")))
              .filter(s -> !s.trim().isEmpty())
                .mapToDouble(calculator::calculate)
                .forEach(resultConsumer);
    }

    public static void main(String[] args) throws Exception {
        CalculatorCli calculatorCli = new CalculatorCli(new CalkulatorImp());
        try (Reader reader = new InputStreamReader(System.in)) {
            calculatorCli.runInteractiveSession(reader);

        }

    }

}
