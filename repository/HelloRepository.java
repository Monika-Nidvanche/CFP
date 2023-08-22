package com.springboot.employeeapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.employeeapplication.entity.HelloModel;

@Repository
public interface HelloRepository extends JpaRepository<HelloModel, Integer> {

	@Query(value="select * from hello_model where name=:name",nativeQuery = true)
	HelloModel findByName(String name);

	@Query(value="select * from hello_model,emp_department where employee_id=did and department=:dept", 
			nativeQuery = true)
	List<HelloModel> findAllByDepartment(String dept);

}
