package com.example.integrationstrategy.strategy.IntegralStrategy;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.integrationstrategy.enums.IntegralType;
import com.example.integrationstrategy.model.IntegrateReq;
import com.example.integrationstrategy.model.IntegrateRes;

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

  public IntegrateRes executeStrategy(IntegrateReq req) {
    IntegralStrategy strategy = strategies.get(req.getType());

    return strategy.execute(req.getFormula(), req.getRange(), req.getInterval(), req.getY0());
  }
}
