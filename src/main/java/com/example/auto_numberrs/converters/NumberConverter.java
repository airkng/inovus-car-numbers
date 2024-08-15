package com.example.auto_numberrs.converters;

import com.example.auto_numberrs.model.CarNumber;
import com.example.auto_numberrs.model.InputNumberModel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NumberConverter {
    @Getter // для теста
    private final InputNumberModel model;
    public CarNumber convertToCarNumber(Integer number, String alphabet) {
        return CarNumber.builder()
                .numeric(number)
                .alphabet(alphabet)
                .build();
    }

    public String getAlphabetFromSequence(Integer sequenceNum) {
        //todo: думаю, можно реализовать через рекурсию
        //получение третьего символа последовательности
        int charCount = model.getAlphabets().length; //Количество букв в алфавите
        int thirdCharNum = (int) Math.floor(sequenceNum / Math.pow(charCount, 2));
        String thirdChar = model.getAlphabets()[thirdCharNum];

        int secValue = sequenceNum - (thirdCharNum == 0 ? 0 : (thirdCharNum * (int) Math.pow(charCount, 2) ));
        int secCharNum = (int) Math.floor(secValue / Math.pow(charCount, 1));
        String secondChar = model.getAlphabets()[secCharNum];
        int firstValue = secValue - (secCharNum == 0 ? 0 : (secCharNum * (int) Math.pow(charCount, 1) ));
        String firstChar = model.getAlphabets()[firstValue];
        return thirdChar + secondChar + firstChar;
    }

    //вот так вот просто, а вы что думали
    public Integer getNumericFromSequence(Integer random) {
        return random;
    }

    //порядковый номер / алфавит ^ 2 округленная в меньшую сторону - буква 3 цифры
    //порядковый номер / алфавит - буква 2 цифры
    //порядковый номер / алфавит - буква 2 цифры



}
