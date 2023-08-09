package com.springboot.employeeapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.employeeapplication.entity.HelloModel;

@Repository
public interface HelloRepository extends JpaRepository<HelloModel, Integer> {

}
