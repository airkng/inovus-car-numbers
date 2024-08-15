package com.example.auto_numberrs.service.impl;

import com.example.auto_numberrs.converters.NumberConverter;
import com.example.auto_numberrs.model.CarNumber;
import com.example.auto_numberrs.model.NumberPart;
import com.example.auto_numberrs.repository.NumberRepository;
import com.example.auto_numberrs.service.NumberService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(prefix = "service", name = "type", havingValue = "simple")
@RequiredArgsConstructor
public class SimpleNumberService implements NumberService {
    private final RandomGenerator generator;
    private final NumberRepository repository;
    private final NumberConverter converter;
    @Override
    public String getRandomNumber() {
        //Integer[] integers = generator.generateValues();
        Integer[] randoms = generator.generateValues(NumberPart.NUMERIC, NumberPart.ALPHABET);
        String alphabetFromSequence = converter.getAlphabetFromSequence(randoms[1]);
        Integer numericFromSequence = converter.getNumericFromSequence(randoms[0]);
        CarNumber carNumber = converter.convertToCarNumber(numericFromSequence, alphabetFromSequence);
        synchronized (repository){
            while (repository.contains(carNumber)) {
                carNumber = repository.getNext();
            }
            repository.updateNextAndAddToUsedList(carNumber);
            return carNumber.toString();
        }

    }

    @Override
    public String getNextNumber() {
        CarNumber next = repository.getNext();
        synchronized (repository) {
            while (repository.contains(next)) {
                next = repository.getNext();
            }
            repository.updateNextAndAddToUsedList(next);
        }
        return next.toString();
    }
}
