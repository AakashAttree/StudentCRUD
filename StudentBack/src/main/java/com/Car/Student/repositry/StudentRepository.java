package com.Car.Student.repositry;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Car.Student.model.StudentInfo;


@Repository
public interface StudentRepository extends CrudRepository<StudentInfo, Integer> {

}
