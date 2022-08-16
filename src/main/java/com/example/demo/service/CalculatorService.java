package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repository.ICalculatorRepo;
import com.example.demo.entity.Calculator;

@Service
public class CalculatorService {

	@Autowired
    ICalculatorRepo calculatorRepository;

    public List<Calculator> findAll() {
        return calculatorRepository.findAll();
    }

    public Calculator getCalculationById(int id) {
        return calculatorRepository.findById((long) id).get();
    }

    public void saveOrUpdate(Calculator calculation) {
    	calculatorRepository.save(calculation);
    }

    public void delete(int id) {
    	calculatorRepository.deleteById((long) id);
    }
    
}
