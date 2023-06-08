package com.example.integrationstrategy.strategy.IntegralStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrationstrategy.entity.IntegralEntity;
import com.example.integrationstrategy.enums.IntegralType;

@Service
public class IntegralStrategyContext {
  private final Map<IntegralType, IntegralStrategy> strategies;

  @Autowired
  public IntegralStrategyContext(Set<IntegralStrategy> strategySet) {
    this.strategies = new HashMap<IntegralType, IntegralStrategy>();

    strategySet.forEach(
      strategy -> this.strategies.put(strategy.getIntegralType(), strategy)
    );
  }

  public IntegralEntity executeStrategy(IntegralType type, String formula, double[] range, double interval, double y0) {
    IntegralStrategy strategy = strategies.get(type);

    return strategy.execute(formula, range, interval, y0);
  }
}
