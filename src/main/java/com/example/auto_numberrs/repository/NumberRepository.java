package com.example.auto_numberrs.repository;

import com.example.auto_numberrs.model.CarNumber;

public interface NumberRepository {
    CarNumber getNext();

    boolean contains(CarNumber carNumber);

    void updateNextAndAddToUsedList(CarNumber next);

}
