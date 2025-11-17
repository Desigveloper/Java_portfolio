package com.desigveloper.invoker;

import com.desigveloper.service.CalculatorService;

class Main {
    static void main(String[] args) {
        CalculatorService service = new CalculatorService();
        service.invokeCalculator();
    }
}