package com.example.integrationstrategy.strategy.IntegralStrategy;

import org.springframework.stereotype.Service;

import com.example.integrationstrategy.enums.IntegralType;
import com.example.integrationstrategy.model.IntegrateRes;

@Service
public interface IntegralStrategy {
  public IntegralType getIntegralType();

  public IntegrateRes execute(String formula, double[] range, double interval, double y0);
}
