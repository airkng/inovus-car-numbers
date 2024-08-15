package com.example.auto_numberrs.service;

import com.example.auto_numberrs.model.NumberPart;

public interface Generatable {
    Integer[] generateValues();
    Integer[] generateValues(NumberPart...parts);
}
