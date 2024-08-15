package com.example.auto_numberrs.repository.impl;

import com.example.auto_numberrs.exceptions.NumbersEndException;
import com.example.auto_numberrs.model.CarNumber;
import com.example.auto_numberrs.repository.NumberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.Set;

@Repository
@Slf4j
public class SimpleNumberRepositoryImpl implements NumberRepository {
    private static final Integer ALL_NUMBERS_USED_VALUE = Integer.MAX_VALUE / 10;
    private Set<CarNumber> usedNumbers = new HashSet<>();
    private CarNumber last;

    @Override
    public CarNumber getNext() {
        log.info("Получение следующего значения");
        if (last == null) {
            last = CarNumber.builder()
                    .alphabet("ААА")
                    .numeric(0)
                    .build();
            usedNumbers.add(last);
            //todo: почему здесь он не возвращает значение а идет вообще куда не должен идти
            return last;
        } else {
        return getNextNum(0);
        }
    }

    private CarNumber getNextNum(int count) {
        log.info("Рекурсия получения следуюшего значения: {}", count);
        Integer numeric = last.getNumeric();
        String alphabet = last.getAlphabet();
        if (numeric.equals(999)) {
            numeric = 0;
            alphabet = getNextAlphabetSymbol();
        } else {
            ++numeric;
        }
        CarNumber possibleLastCarNumber = CarNumber.builder()
                .numeric(numeric)
                .alphabet(alphabet)
                .build();
        if (usedNumbers.contains(possibleLastCarNumber)) {
            if (count > ALL_NUMBERS_USED_VALUE) {
                throw new NumbersEndException("А все. Вот и сказочки конец");
            }
            count = ++count;
            return getNextNum(count);
        }
        last = possibleLastCarNumber;
        return last;
    }

    private String getNextAlphabetSymbol() {
        //todo; дописать логику получения
        return "null";
    }

    @Override
    public boolean contains(CarNumber carNumber) {
        return usedNumbers.contains(carNumber);
    }

    @Override
    public void updateNextAndAddToUsedList(CarNumber next) {
        last = next;
        usedNumbers.add(last);
    }
}
