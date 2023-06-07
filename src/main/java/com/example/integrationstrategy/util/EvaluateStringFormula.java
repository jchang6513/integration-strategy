package com.example.integrationstrategy.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class EvaluateStringFormula {
  public static double fx(String formula, double x) {
    return EvaluateStringFormula.evaluateFormula(formula.replaceAll("x", Double.toString(x)));
  }

  public static double evaluateFormula(String formula) {
    ScriptEngine graalEngine = new ScriptEngineManager().getEngineByName("graal.js");

    try {
      Object evaluationResult = graalEngine.eval(formula);
      if (evaluationResult instanceof Number) {
          return ((Number) evaluationResult).doubleValue();
      }
    } catch (ScriptException e) {
      e.printStackTrace();
    }

    return Double.NaN;
  }
}

