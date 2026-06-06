package com.ty.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.dto.Student;
import com.ty.util.DBconnection;

public class StudentDao {

	public void saveStudent(Student student) {
		
	Connection con=	DBconnection.getConnection();
	String sql="INSERT INTO student(name,email,phone,course) values (?,?,?,?)";
	try {
		PreparedStatement ps=con.prepareStatement(sql);
		ps.setString(1, student.getName());
		ps.setString(2, student.getEmail());
		ps.setLong(3, student.getPhone());
		ps.setString(4, student.getCourse());
		int res=ps.executeUpdate();	
		if(res>0) {
			System.out.println("Student Inserted Successfully");
		}
		else {
			System.out.println("Insertion Fail");
		}		
	} 
	catch (SQLException e) {
		
		e.printStackTrace();
		}	
	}
//------------------------------------------------------------
	public void findAllStudents() {
		try {
		Connection con=DBconnection.getConnection();
		String sql="SELECT * FROM student";
	
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("Id : "+rs.getInt("id"));
				System.out.println("Name : "+rs.getString("name"));
				System.out.println("Email : "+rs.getString("email"));
				System.out.println("Phone : "+rs.getLong("phone"));
				System.out.println("Course : "+rs.getString("course"));
				System.out.println("----------------------------------");
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
//-----------------------------------------------------------------------
	public void findStudentById(int id) {
		try {
		Connection con=DBconnection.getConnection();
		String sql="SELECT * FROM student WHERE id=?";
	    PreparedStatement ps=con.prepareStatement(sql);
	    ps.setInt(1, id);
	    
	    ResultSet rs=ps.executeQuery();
	    if(rs.next()) {
			System.out.println("Id : "+rs.getInt("id"));
			System.out.println("Name : "+rs.getString("name"));
			System.out.println("Email : "+rs.getString("email"));
			System.out.println("Phone : "+rs.getLong("phone"));
			System.out.println("Course : "+rs.getString("course"));
		}
	    else {
	    	System.out.println("Student not found");
	      }			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
//-------------------------------------------------------------------
	public void updateStudent(Student student) {
		
		Connection con=DBconnection.getConnection();
		String sql="UPDATE student set name=?, email=?,phone=?,course=? where id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,student.getName());
			ps.setString(2,student.getEmail());
			ps.setLong(3,student.getPhone());
			ps.setString(4,student.getCourse());
			ps.setInt(5,student.getId());
			int res=ps.executeUpdate();
			
			if(res>0) {
				System.out.println("Student upated successfully");
			}
			else {
				System.out.println("Student not found");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
//------------------------------------------------------------------------
	public void deleteStudent(int id) {
		
		Connection con=DBconnection.getConnection();
		String sql="delete from student where id=?";
	try {
			PreparedStatement ps=con.prepareStatement(sql);	
			ps.setInt(1, id);
			int res=ps.executeUpdate();
			if(res>0) {
				System.out.println("Student deleted");
			}
			else {
				System.out.println("Student not found");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
//------------------------------------------------------------------------
	
	public void searchStudentByName(String name) {
		try {
		Connection con=DBconnection.getConnection();
		String sql="select * from student where name=?";
			PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs=ps.executeQuery();
		
		while(rs.next()) {
			System.out.println("---------------------");
			System.out.println("Id : " + rs.getInt("id"));
			System.out.println("Name : " + rs.getString("name"));
			System.out.println("Email : " + rs.getString("email"));
			System.out.println("Phone : " + rs.getLong("phone"));
			System.out.println("Course : " + rs.getString("course"));
		}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	
}
