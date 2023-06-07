package com.example.integrationstrategy.model;

import com.example.integrationstrategy.enums.IntegralType;

import lombok.Data;

@Data
public class IntegrateReq {
  IntegralType type;

  String formula;

  double interval;

  double[] range = new double[2];

  double y0;
}
