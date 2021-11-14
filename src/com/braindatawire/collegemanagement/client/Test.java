package com.braindatawire.collegemanagement.client;

import java.util.Scanner;

import com.braindatawire.collegemanagement.serviceImpl.Karvenagar;

public class Test {

	public static void main(String[] args) {
		Karvenagar karve = new Karvenagar();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("-----------------------");
			System.out.println("	*Main Menu*");
			System.out.println(" 1.Add Course");
			System.out.println(" 2.View Courses");
			System.out.println(" 3.Add Faculty");
			System.out.println(" 4.View Faculties");
			System.out.println(" 5.Add Batch");
			System.out.println(" 6.View Batches");
			System.out.println(" 7.Add Student");
			System.out.println(" 8.View Students");
			System.out.println(" 9.Pay Fees ");
			System.out.print("Choose frome above operations : ");
			int input = sc.nextInt();
			System.out.println("-----------------------");
			switch (input) {
			case 1:
				karve.addCourse();
				break;

			case 2:
				karve.viewCourse();
				break;
			case 3:
				karve.addFaculty();
				break;
			case 4:
				karve.viewFaculty();
				break;
			case 5:
				karve.addBatch();
				break;
			case 6:
				karve.viewBatch();
				break;
			case 7:
				karve.addStudent();
				break;
			case 8:
				karve.viewStudent();
				break;
			case 9: 
				karve.payFees();
				break;
			default:
				System.out.println("Thank you....");
				System.exit(0);
				break;

			}
		}

	}
}
