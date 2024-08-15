package com.example.auto_numberrs.converters;

import com.example.auto_numberrs.model.InputNumberModel;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {NumberConverter.class, InputNumberModel.class})
public class NumberConverterTest {
    @Autowired
    private NumberConverter converter;

    //todo: переименовать на нормальное название теста
    @Test
    public void test1() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(10);
        InputNumberModel model = converter.getModel();
        assertEquals("ААУ", alphabetFromSequence);
    }

    @Test
    public void test2() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(12);
        InputNumberModel model = converter.getModel();
        assertEquals("АВА", alphabetFromSequence);
    }

    @Test
    public void test3() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(0);
        InputNumberModel model = converter.getModel();
        assertEquals("ААА", alphabetFromSequence);
    }

    @Test
    public void test4() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(1);
        InputNumberModel model = converter.getModel();
        assertEquals("ААВ", alphabetFromSequence);
    }

    @Test
    public void test5() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(11);
        InputNumberModel model = converter.getModel();
        assertEquals("ААХ", alphabetFromSequence);
    }

    @Test
    public void test6() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(24);
        InputNumberModel model = converter.getModel();
        assertEquals("АЕА", alphabetFromSequence);
    }

    @Test
    public void test7() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(144);
        InputNumberModel model = converter.getModel();
        assertEquals("ВАА", alphabetFromSequence);
    }

    @Test
    public void test8() {
        String alphabetFromSequence = converter.getAlphabetFromSequence(1727);
        InputNumberModel model = converter.getModel();
        assertEquals("ХХХ", alphabetFromSequence);
    }

}
