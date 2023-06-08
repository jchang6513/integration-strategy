package com.example.integrationstrategy.strategy.IntegralStrategy;

import org.springframework.stereotype.Service;

import com.example.integrationstrategy.entity.IntegralEntity;
import com.example.integrationstrategy.enums.IntegralType;

@Service
public interface IntegralStrategy {
  public IntegralType getIntegralType();

  public IntegralEntity execute(String formula, double[] range, double interval, double y0);
}
