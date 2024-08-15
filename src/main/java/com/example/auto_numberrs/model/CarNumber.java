package com.example.auto_numberrs.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
public class CarNumber {
    private static final String TAT_CODE = "116 RUS";
    private Integer numeric;
    private String alphabet;

    @Override
    public String toString() {
        String cosmeticNum = "";
        if (numeric < 10) {
            cosmeticNum = "00";
        } else if (numeric < 100) {
            cosmeticNum = "0";
        }
        return alphabet.substring(0, 2) + cosmeticNum + numeric.toString() + alphabet.substring(2) + " " + TAT_CODE;
    }
}
