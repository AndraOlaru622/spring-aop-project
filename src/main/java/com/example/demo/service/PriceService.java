package com.example.demo.service;

import com.example.demo.model.Price;
import com.example.demo.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PriceService {
    @Autowired
    private PriceRepository priceRepository;


    public List<Price> getPrices() {
        return priceRepository.getPrices();
    }

    public List<Price> addPrice(Price p) {
        return priceRepository.addPrice(p);
    }

    public List<Price> deletePriceById(int id) {
        return priceRepository.deletePriceById(id);
    }
}
