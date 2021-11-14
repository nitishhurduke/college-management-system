package com.braindatawire.collegemanagement.serviceImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.braindatawire.collegemanagement.model.Batch;
import com.braindatawire.collegemanagement.model.Course;
import com.braindatawire.collegemanagement.model.Faculty;
import com.braindatawire.collegemanagement.model.Student;
import com.braindatawire.collegemanagement.service.Cjc;

public class Karvenagar implements Cjc {

	List<Course> cList = new ArrayList<>();
	List<Faculty> fList = new ArrayList<>();
	List<Batch> bList = new ArrayList<>();
	List<Student> sList = new ArrayList<>();

	Scanner sc = new Scanner(System.in);

	int countC = 0;
	int countF = 0;
	int countB = 0;
	int countS = 0;

	@Override
	public void addCourse() {
		System.out.println("  *ADD new Course*");

		Course course = new Course();

		System.out.print("Enter Course ID : ");
		course.setCid(sc.nextInt());
		System.out.print("Enter Course Name : ");
		course.setCname(sc.next());
		System.out.println("Choose Type of Course : ");
		System.out.println(" 1.FullDay");
		System.out.println(" 2.Regular");
		int input = sc.nextInt();
		switch (input) {
		case 1:
			course.setcType("FD");
			break;
		case 2:
			course.setcType("R");
			break;
		}
		System.out.println("Course Type '" + course.getcType() + "' Selected");
		System.out.println("Choose Mode of Course: ");
		System.out.println(" 1.Online");
		System.out.println(" 2.Offline");
		int input1 = sc.nextInt();
		switch (input1) {
		case 1:
			course.setcMode("Online");
			break;
		case 2:
			course.setcMode("Offline");
			break;
		}
		System.out.println("Course Mode '" + course.getcMode() + "' Selected");
		System.out.println("Enter Course fees: ");
		course.setcFees(sc.nextDouble());

		cList.add(course);
		System.out.println("New Course '" + course.getCname() + "' added Successfully...");

		countC++;
	}

	@Override
	public void viewCourse() {
		if (countC > 0) {
			Iterator<Course> itr = cList.iterator();
			System.out.println("  *ALL Courses*");
			System.out.println("Id Name  Type  Mode  Fees");
			while (itr.hasNext()) {
				Course course = itr.next();
				System.out.println(course.getCid() + "  " + course.getCname() + "   " + course.getcType() + "  "
						+ course.getcMode() + "  " + course.getcFees());
			}
		} else {
			System.out.println("No Courses to show..");
		}
	}

	@Override
	public void addFaculty() {
		if (countC > 0) {
			Faculty faculty = new Faculty();
			System.out.println("  *Add Faculty*");
			System.out.print("Enter Facutly ID : ");
			faculty.setFid(sc.nextInt());
			System.out.print("Enter Faculty Name : ");
			faculty.setFname(sc.next());
			System.out.println(" *Courses List*");
			System.out.println("\nId Course");
			for (Course c : cList) {
				System.out.println(c.getCid() + "  " + c.getCname() + "(" + c.getcType() + "," + c.getcMode() + ")");
			}
			System.out.print("Enter a Course ID to assign Faculty to it : ");
			int input = sc.nextInt();

			Iterator<Course> itr = cList.iterator();
			while (itr.hasNext()) {
				Course course = itr.next();
				if (input == course.getCid()) {
					faculty.setCourse(course);
					System.out.println("New Faculty '" + faculty.getFname() + "' added and assigned to '"
							+ course.getCname() + "' Course Successfully..");
					fList.add(faculty);
					countF++;
				} else {
//					System.out.println("Invalid Course ID...");
				}
			}

		} else {
			System.out.println("You must add Course first...");
		}

	}

	@Override
	public void viewFaculty() {
		if (countF > 0) {
			System.out.println("  *ALL Faculties*");
			Iterator<Faculty> itr = fList.iterator();
			System.out.println("Id  Name    Course");
			while (itr.hasNext()) {
				Faculty faculty = itr.next();
				System.out.println(faculty.getFid() + "  " + faculty.getFname() + "  " + faculty.getCourse().getCname()
						+ "(" + faculty.getCourse().getcType() + "," + faculty.getCourse().getcMode() + ")");
			}

		} else {
			System.out.println("No Faculty to show..");
		}
	}

	@Override
	public void addBatch() {
		if (countF > 0) {
			System.out.println("  *Add Batch*");
			Batch batch = new Batch();
			System.out.print("Enter Batch ID : ");
			batch.setBid(sc.nextInt());
			System.out.print("Enter Batch Name : ");
			batch.setBname(sc.next());
			System.out.print("Enter a Faculty ID to assign to this batch : ");
			int input = sc.nextInt();

			Iterator<Faculty> itr = fList.iterator();
			while (itr.hasNext()) {
				Faculty faculty = itr.next();
				if (input == faculty.getFid()) {
					batch.setFaculty(faculty);
					System.out.println("New Batch '" + batch.getBname() + "'(" + batch.getBid()
							+ ") added and Faculty '" + faculty.getFname() + "' assigned to it Successfully...");
					bList.add(batch);
					countB++;
				} else {
//					System.out.println("Invalid Faculty ID...");
				}
			}
		} else {
			System.out.println("You must add Faculty first...");
		}
	}

	@Override
	public void viewBatch() {
		if (countB > 0) {
			System.out.println("  *ALL Batches*");
			Iterator<Batch> itr = bList.iterator();
			System.out.println("Id  Name  Faculty   Course ");
			while (itr.hasNext()) {
				Batch batch = itr.next();
				System.out.println(batch.getBid() + " " + batch.getBname() + " " + batch.getFaculty().getFname()

						+ " " + batch.getFaculty().getCourse().getCname() + "("
						+ batch.getFaculty().getCourse().getcType() + "," + batch.getFaculty().getCourse().getcMode()
						+ ")");
			}
		} else {
			System.out.println("No Batch to show..");
		}
	}

	@Override
	public void addStudent() {
		if (countB > 0) {
			System.out.println("  *Add Student*");
			Student student = new Student();
			System.out.print("Enter Student ID : ");
			student.setSid(sc.nextInt());
			System.out.print("Enter Student Name : ");
			student.setSname(sc.next());
			System.out.print("Enter a Batch ID to add this Student in : ");
			int input = sc.nextInt();

			Iterator<Batch> itr = bList.iterator();
			while (itr.hasNext()) {
				Batch batch = itr.next();
				if (input == batch.getBid()) {
					student.setBatch(batch);

					student.setFees(student.getBatch().getFaculty().getCourse().getcFees());
					System.out.print(
							"First Installmetnt(Atleast 5000) of total course fees " + student.getFees() + " : ");
					student.setFeespaid(sc.nextDouble());
					sList.add(student);
					System.out.println("New Student '" + student.getSname() + "' added in batch '" + batch.getBname()
							+ "' Successfully...");
					countS++;
				} else {
//					System.out.println("Invalid Batch ID...");
				}
			}
		} else {
			System.out.println("You must add Batch first...");
		}
	}

	@Override
	public void viewStudent() {
		if (countS > 0) {
			System.out.println("  *ALL Students*");
			Iterator<Student> itr = sList.iterator();
			System.out.println("Id Name Batch Faculty Course TotalFees BalFees");
			while (itr.hasNext()) {
				Student student = itr.next();
				System.out.println(student.getSid() + " " + student.getSname() + " " + student.getBatch().getBname()
						+ " " + student.getBatch().getFaculty().getFname() + " "
						+ student.getBatch().getFaculty().getCourse().getCname() + "   " + student.getFees() + "  "
						+ student.getFeesbal());
			}
		} else {
			System.out.println("No Students to show...");
		}
	}

	public void payFees() {
		System.out.println("Enter Student Id: ");
		int input = sc.nextInt();

		for (Student s : sList) {
			if (input == s.getSid()) {
				System.out.println("*Student Details*");
				System.out.println("Student ID: " + s.getSid());
				System.out.println("Student Name: " + s.getSname());
				System.out.println("Student Batch: " + s.getBatch().getBname());
				System.out.println("Student Course: " + s.getBatch().getFaculty().getCourse().getCname() + "("
						+ s.getBatch().getFaculty().getCourse().getcType() + ","
						+ s.getBatch().getFaculty().getCourse().getcMode() + ")");
				System.out.println("Total Course Fees: " + s.getFees());
				System.out.println("Total Fees Paid : " + s.getFeespaid());
				System.out.println("Total Fees Balance: " + s.getFeesbal());
				System.out.print("\nEnter Amount to pay: ");
				s.payFees(sc.nextDouble());
				System.out.println("Fees Paid Successfully...");
				System.out.println("New Fees Balance: " + s.getFeesbal());

			}
		}
	}
}
