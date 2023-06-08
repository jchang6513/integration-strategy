package com.example.integrationstrategy.strategy.IntegralStrategy;

import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.integrationstrategy.entity.IntegralEntity;
import com.example.integrationstrategy.enums.IntegralType;
import com.example.integrationstrategy.util.EvaluateStringFormula;

@Service
public class EulerIntegrationStrategy implements IntegralStrategy {
  public IntegralType getIntegralType() {
    return IntegralType.euler;
  }

  public IntegralEntity execute(String formula, double[] range, double interval, double y0) {
    ArrayList<Double> yp = new ArrayList<Double>();
    ArrayList<Double> y = new ArrayList<Double>();
    ArrayList<Double> x = new ArrayList<Double>();

    double yn = y0;
    for (double xi = range[0]; xi <= range[1]; xi += interval) {
      double yPrimeN = EvaluateStringFormula.fx(formula, xi);
      x.add(xi);
      yp.add(yPrimeN);

      if (xi > range[0]) yn += interval * yPrimeN;
      y.add(yn);
    }

    IntegralEntity res = new IntegralEntity();
    res.setYp(yp);
    res.setY(y);
    res.setX(x);
    return res;
  }
}
