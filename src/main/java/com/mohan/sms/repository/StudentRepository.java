package com.mohan.sms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mohan.sms.entity.Student;

public interface StudentRepository extends JpaRepository <Student,Long>{

}
