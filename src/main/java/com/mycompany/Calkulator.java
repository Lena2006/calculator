/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

/**
 *��������� ������������ ��� ��������� ������� �� ���������
 * ������, ����������� ������ ��������� ������  ������������� ������ ������
 * @author �����
 */
public interface Calkulator {
    /**
     * ����� calculete ������ ��������� �� ����� ������ ��� ����������
     * @param expression
     * �������� expression ����� ��� ������.
     * @return 
     * � �������, ����������� ������ ��������� ������������ �������� 
     * �������� ����������� ����������
     */
    public double calculate(String expression);
    
    
    
}
