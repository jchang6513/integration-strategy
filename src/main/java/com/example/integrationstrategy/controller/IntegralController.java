package com.example.integrationstrategy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.integrationstrategy.entity.IntegralEntity;
import com.example.integrationstrategy.model.IntegrateReq;
import com.example.integrationstrategy.model.IntegrateRes;
import com.example.integrationstrategy.strategy.IntegralStrategy.IntegralStrategyContext;

@RestController
public class IntegralController {

	@Autowired
	private IntegralStrategyContext strategyContext;

  @PostMapping("/integral")
	@ResponseBody
	public IntegrateRes postIntegral(@RequestBody IntegrateReq requestBody) {
		IntegralEntity result = strategyContext.executeStrategy(
			requestBody.getType(),
			requestBody.getFormula(),
			requestBody.getRange(),
			requestBody.getInterval(),
			requestBody.getY0()
		);

		IntegrateRes res = new IntegrateRes();
		res.setX(result.getX());
		res.setYPrime(result.getYp());
		res.setY(result.getY());
		return res;
	}
}
