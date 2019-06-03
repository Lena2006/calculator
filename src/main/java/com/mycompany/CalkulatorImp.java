/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Класс занимается вычислениями и передает полученное значение
 *
 * @author Елена
 */
public class CalkulatorImp implements Calkulator {

    /**
     * Метод вычисляет полученное значение
     *
     * @param expression тип строка,используется для вычислений
     * @return тип строка ,возвращает вычсления
     */
    @Override
    public double calculate(String expression) {
//        return 0;
        //throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.

//        return Double.parseDouble(expression);
        ScriptEngine scriptEngine = new ScriptEngineManager().getEngineByName("nashorn");
        try {
            defineMathFunctions(scriptEngine);
            return ((Number) scriptEngine.eval(expression)).doubleValue();
        } catch (ScriptException e) {
            throw new IllegalArgumentException("Failed to evaluate expression", e);

        }
    }

    /**
     * Вычисление математических фунлций
     *
     * @param scriptEngine <code>ScriptEngine</code> is the fundamental
     * interface whose methods must be fully functional in every implementation
     * of this specification.
     * <br><br>
     * These methods provide basic scripting functionality. Applications written
     * to this simple interface are expected to work with minimal modifications
     * in every implementation. It includes methods that execute scripts, and
     * ones that set and get values.
     * <br><br>
     * The values are key/value pairs of two types. The first type of pairs
     * consists of those whose keys are reserved and defined in this
     * specification or by individual implementations. The values in the pairs
     * with reserved keys have specified meanings.
     * <br><br>
     * The other type of pairs consists of those that create Java language
     * Bindings, the values are usually represented in scripts by the
     * corresponding keys or by decorated forms of them.
     * @throws ScriptException The generic <code>Exception</code> class for the
     * Scripting APIs. Checked exception types thrown by underlying scripting
     * implementations must be wrapped in instances of
     * <code>ScriptException</code>. The class has members to store line and
     * column numbers and filenames if this information is available.
     */
    private static void defineMathFunctions(ScriptEngine scriptEngine) throws ScriptException {
        for (String function : new String[]{"sin", "cos", "sqrt"}) {
            scriptEngine.eval("function " + function + "(x) { return Java.type('java.lang.Math')." + function + "(x); }");
        }
    }
}
