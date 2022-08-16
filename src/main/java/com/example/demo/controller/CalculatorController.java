package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Calculator;
import com.example.demo.service.CalculatorService;

@RestController
@RequestMapping("/api")
public class CalculatorController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping("/calculator")
    private ResponseEntity<List<Calculator>> getAllCalculations()  {
		
		try {
			List<Calculator> list = calculatorService.findAll();
			
			if (list.isEmpty() || list.size() == 0) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<>(list, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
    }

    @PostMapping("/calculator")
    private ResponseEntity<Calculator> saveCalculation(@RequestBody Calculator calculation) {
    	
    	//TODO: NEED VALIDATION ON FIELD SYMBOL!!!!!
    	
    	try {
    		calculatorService.saveOrUpdate(calculation);
    		return new ResponseEntity<>(calculation, HttpStatus.OK);
    	} catch (Exception e) {
    		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    	}

    }
}
