package com.example.auto_numberrs.service.impl;

import com.example.auto_numberrs.model.NumberPart;
import com.example.auto_numberrs.model.NumberRange;
import com.example.auto_numberrs.service.Generatable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
@RequiredArgsConstructor
public class RandomGenerator implements Generatable {
    private final NumberRange carNumberRanges;
    private final Random rndGen = new Random();

    @Override
    public Integer[] generateValues() {
        int randomNum = generateNumber();
        int randomAlphabet = generateAlphabet();
        return new Integer[]{randomNum, randomAlphabet};
    }

    @Override
    public Integer[] generateValues(NumberPart... parts) {
        Integer[] result = new Integer[parts.length];
        for (int i = 0; i < parts.length; i++) {
            switch (parts[i]) {
                case NUMERIC:
                    result[i] = generateNumber();
                    break;
                case ALPHABET:
                    result[i] = generateAlphabet();
                    break;
                default: throw new IllegalArgumentException("Неверное значение части номерного знака");
            }
        }
        return result;
    }

    private int generateAlphabet() {
        return rndGen.nextInt(carNumberRanges.getAlphabetRange());
    }

    private int generateNumber() {
        return rndGen.nextInt(carNumberRanges.getNumberRange());
    }
}
