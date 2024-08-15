package com.example.auto_numberrs.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Component
public class NumberRange {
    @Autowired
    public NumberRange(InputNumberModel model) {
        this.numberRange = model.getNumberPossibleVariations();
        this.alphabetRange = model.getAlphabetPossibleVariations();
    }

    private Integer numberRange;
    private Integer alphabetRange;
}
