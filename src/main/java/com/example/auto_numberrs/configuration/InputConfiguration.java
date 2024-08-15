package com.example.auto_numberrs.configuration;

import com.example.auto_numberrs.model.InputNumberModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class InputConfiguration {
    @Value("${input-data.model.alphabet}")
    private String alphabet;
    @Value("${input-data.model.numbers}")
    private String numbers;

    //@Bean todo: беда с кодировкой. Хотелось подргружать значения из .properties файла, но тогда нужно переформатировать его в UTF-8
    // ввести доп настройку spring.messages=utf-8 и запускать через cmd
    //запуск через Idea с параметром -Dfile.encoding не помогло
    public InputNumberModel getInputModel() {
        return null;
    }

}
