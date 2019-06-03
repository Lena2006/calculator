/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

/**
 *Интерфейс предназначен для установки методов по умолчанию
 * классы, реализующие данный интерфейс должны  реализовывать данные методы
 * @author Елена
 */
public interface Calkulator {
    /**
     * Метод calculete должен принимать на выход данные для вычисления
     * @param expression
     * Параметр expression имеет тип Строка.
     * @return 
     * в клаасах, зуфлизующих данный интерфейс возвращаемое значение 
     * является результатом вычисления
     */
    public double calculate(String expression);
    
    
    
}
