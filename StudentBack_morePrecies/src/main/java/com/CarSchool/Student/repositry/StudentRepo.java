package com.CarSchool.Student.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CarSchool.Student.model.StudentInfo;


@Repository
public interface StudentRepo extends JpaRepository<StudentInfo, Long>{

}
