package com.example.auto_numberrs.controllers;

import com.example.auto_numberrs.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/number")
@RequiredArgsConstructor
public class NumberController {
    private final NumberService numberService;

    @GetMapping("/random")
    public String random() {
        return numberService.getRandomNumber();
    }

    @GetMapping("/next")
    public String next() {
        return numberService.getNextNumber();
    }
}
