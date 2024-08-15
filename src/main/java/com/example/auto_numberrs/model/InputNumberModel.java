package com.example.auto_numberrs.model;

import lombok.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Component
public class InputNumberModel {
    @Getter(AccessLevel.NONE)
    private String alphabet = "[А, Е, Т, О, Р, Н, У, К, Х, С, В, М]";
    @Getter(AccessLevel.NONE)
    private String number = "[0,1,2,3,4,5,6,7,8,9]";
    private String[] alphabets;
    private String[] numbers;
    private Integer alphabetPossibleVariations;
    private Integer numberPossibleVariations;

    {
        alphabets = Arrays.stream(
                alphabet
                        .replaceAll("\\[", "")
                        .replaceAll("\\]", "")
                        .replaceAll("\\s+", "")
                        .split(",")
        ).sorted(String::compareToIgnoreCase)
                .toArray(String[]::new);
        numbers = number.replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("\\s+", "")
                .split(",");
        alphabetPossibleVariations = Integer.valueOf((int)Math.pow(alphabets.length, 3));
        numberPossibleVariations = Integer.valueOf((int)Math.pow(numbers.length, 3));
    }
}
