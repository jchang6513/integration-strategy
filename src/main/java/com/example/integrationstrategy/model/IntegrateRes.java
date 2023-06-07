package com.example.integrationstrategy.model;

import java.util.ArrayList;

import lombok.Data;

@Data
public class IntegrateRes {
  ArrayList<Double> yPrime = new ArrayList<>();
  ArrayList<Double> y = new ArrayList<>();
}
