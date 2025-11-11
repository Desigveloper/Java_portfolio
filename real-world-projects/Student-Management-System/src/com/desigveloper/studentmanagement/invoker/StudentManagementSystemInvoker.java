package com.desigveloper.studentmanagement.invoker;

import com.desigveloper.studentmanagement.model.Student;
import com.desigveloper.studentmanagement.services.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManagementSystemInvoker {
    private static Scanner scanner = new Scanner(System.in);
    private static StudentService studentService = new StudentService();
    private static LecturerService lecturerService = new LecturerService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();
    private static SampleDataService sampleDataService = new SampleDataService();

    public static void main(String[] args) {
        System.out.println("=== Student System Management System ===");
        showMenu()
    }

    public static void showMenu() {
        while (true) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Student Management");
            System.out.println("2. Lecturer Management");
            System.out.println("3. Course Management");
            System.out.println("4. Enrollment Management");
            System.out.println("5. Generate Sample Data");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> showStudentMenu();
                case 2 -> showLecturerMenu();
                case 3 -> showCourseMenu();
                case 4 -> showEnrollmenttMenu();
                case 5 -> {
                    sampleDataService.generateSampleData();
                    System.out.println("Data sample generated successfully");
                }
                case 0 -> {
                    System.out.print("Do you really want to exit (y/n): ");
                    String exit = scanner.next();

                    if (exit.equalsIgnoreCase("y") || exit.equalsIgnoreCase("yes")) {
                        System.out.println("Goodbye");
                        return;
                    }
                }
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void showStudentMenu() {
        while (true) {
            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. Register Student");
            System.out.println("2. View Student");
            System.out.println("3. View All Students");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Find Student By Major");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> registerStudent();
                case 2 -> viewStudent();
                case 3 -> viewAllStudents();
                case 4 -> updateStudent();
                case 5 -> deleteStudent();
                case 6 -> findStudentByMajor();
                case 0 -> {return;}
                default -> System.out.println("Invalid Option!");
            }
        }
    }

    private static void registerStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.next();

        System.out.print("Enter student name: ");
        String name = scanner.next();

        System.out.print("Enter student birth date in yyyy/mm/dd: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        System.out.print("Enter student email: ");
        String email = scanner.next();
        System.out.print("Enter student major: ");
        String major = scanner.next();

        Student student = Student.builder(studentId, name, LocalDate.of(year, month, day))
                .withEmail(email).withMajor(major).withStudentGPA("Nil")
                .withEnrolledCourse("Active").build();

        boolean success = studentService.registerStudent(student);
        if (success) {
            System.out.println("Student registered successfully");
        } else {
            System.out.printf("Student ID: %s already exists\n", studentId);
        }
    }

    private static void viewStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        studentService.getStudent(id).ifPresentOrElse(
                student -> System.out.println("Student: " + student),
                () -> System.out.println("Student not found")
        );
    }

    private static void viewAllStudents() {
        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No student found!");
        } else {
            System.out.println("List of all registered Student");
            students.forEach(System.out::println);
        }
    }

    private static void updateStudent() {

    }
}
