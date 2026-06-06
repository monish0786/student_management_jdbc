package com.ty.view;

import java.util.Scanner;

import com.ty.controller.StudentController;
import com.ty.dto.Student;

public class MainView {

	public void start() {
		Scanner sc=new Scanner(System.in);
		StudentController scont=new StudentController();
		while(true) {
			System.out.println("\n===== STUDENT MENU =====");
			System.out.println("1. Insert Student");
			System.out.println("2. Find Student By Id");
			System.out.println("3. View All Students");
			System.out.println("4. Update Student");
			System.out.println("5. Delete Student");
			System.out.println("6. Search Student By Name");
			System.out.println("7. Exit");

			System.out.println("Enter choice");
			int choice=sc.nextInt();
			sc.nextLine();
			switch(choice){
			
			case 1: 
				Student stu=new Student();
				System.out.println("Enter Name");
				stu.setName(sc.nextLine());
				
				System.out.println("Enter Email");
				stu.setEmail(sc.nextLine());
				
				System.out.println("Enter Phone");
				stu.setPhone(sc.nextLong());
				sc.nextLine();
				
				System.out.println("Enter Course");
				stu.setCourse(sc.nextLine());
				
				scont.saveStudent(stu);
				break;
				
			case 2:
				System.out.println("Enter id");
				int id=sc.nextInt();
				scont.findStudentById(id);
				break;
			
			case 3:
				scont.findAllStudent();
				break;
				
			case 4:
				Student updateStudent=new Student();
				System.out.println("Enter id:");
				updateStudent.setId(sc.nextInt());
				System.out.println("Enter name:");
				updateStudent.setName(sc.next());
				System.out.println("Enter email:");
				updateStudent.setEmail(sc.next());
				System.out.println("Enter phone:");
				updateStudent.setPhone(sc.nextLong());
				System.out.println("Enter course:");
				updateStudent.setCourse(sc.next());
				scont.updateStudent(updateStudent);
				break;
			
			case 5:
				System.out.println("Enter id");
				int deleteId=sc.nextInt();
				scont.deleteStudent(deleteId);
				break;
				
			case 6:
				System.out.println("Enter name");
				String name=sc.nextLine();
				scont.searchStudentByName(name);
				break;
				
			case 7 :
				try {
				System.out.println("Exiting..");
				for(int i=1;i<=7;i++) {
						Thread.sleep(500);
						System.out.print(" . ");	
				     }
				System.out.println("\nThank you");
				System.exit(0);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					break;
				
		        
		       default:
		    	   System.out.println("Invalid choice");
		   }
		}
	}
}
