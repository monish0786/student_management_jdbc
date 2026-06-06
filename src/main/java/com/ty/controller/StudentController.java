package com.ty.controller;

import com.ty.dao.StudentDao;
import com.ty.dto.Student;

public class StudentController {

	StudentDao dao=new StudentDao();
	public void saveStudent(Student student) {
	String phone=String.valueOf(student.getPhone());
	if(phone.length()!=10) {
		System.out.println("Number must be atleast of 10 digits !!!!");
		return;
	}
	dao.saveStudent(student);
	
	}
	
	public void findStudentById(int id) {
		dao.findStudentById(id);
	}
	
	public void findAllStudent() {
		dao.findAllStudents();
	}
	
	public void updateStudent(Student student) {
		dao.updateStudent(student);
	}
	
	public void deleteStudent(int id) {
		dao.deleteStudent(id);
	}
	
	public void searchStudentByName(String name) {
		dao.searchStudentByName(name);
	}
}
