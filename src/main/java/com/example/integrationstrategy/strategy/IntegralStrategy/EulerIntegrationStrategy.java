package com.example.integrationstrategy.strategy.IntegralStrategy;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.integrationstrategy.enums.IntegralType;
import com.example.integrationstrategy.model.IntegrateRes;
import com.example.integrationstrategy.util.EvaluateStringFormula;

@Service
public class EulerIntegrationStrategy implements IntegralStrategy {
  public IntegralType getIntegralType() {
    return IntegralType.euler;
  }

  public IntegrateRes execute(String formula, double[] range, double interval, double y0) {
    ArrayList<Double> yPrime = new ArrayList<Double>();
    ArrayList<Double> y = new ArrayList<Double>();

    double yn = y0;
    for (double x = range[0]; x <= range[1]; x += interval) {
      double yPrimeN = EvaluateStringFormula.fx(formula, x);
      yPrime.add(yPrimeN);
      if (x > range[0]) {
        yn += interval * yPrimeN;
      }
      y.add(yn);
    }

    IntegrateRes res = new IntegrateRes();
    res.setYPrime(yPrime);
    res.setY(y);
    return res;
  }
}
