package com.desigveloper.invoker;

import com.desigveloper.service.CalculatorService;

public class Main {
    public static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        service.invokeCalculator();
    }
}