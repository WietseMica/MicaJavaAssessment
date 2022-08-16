package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Calculator;

@Repository
public interface ICalculatorRepo extends JpaRepository<Calculator, Long> {

}
