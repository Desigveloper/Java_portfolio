package com.desigveloper.studentmanagement.invoker;

/*
    Created By: Desigveloper
    Date created: October 2025
    Date modified: 23/10/2025
    Description: This program displays Student, Lecturer and Course information on the screen
*/

import com.desigveloper.studentmanagement.model.Course;
import com.desigveloper.studentmanagement.model.Enrollment;
import com.desigveloper.studentmanagement.model.Lecturer;
import com.desigveloper.studentmanagement.model.Student;
import com.desigveloper.studentmanagement.services.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class StudentManagementSystemApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final LecturerService lecturerService = new LecturerService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();
    private static final SampleDataService sampleDataService = new SampleDataService();

    public static void main(String[] args) {
        System.out.println("=== Student System Management System ===");
        showMenu();
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
                case 4 -> showEnrollmentMenu();
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

    // ========= STUDENT MENU METHODS ===========
    private static void showStudentMenu() {
        // Implementation for Student Menu
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
        String studentId = scanner.nextLine();

        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter student birth date in yyyy/mm/dd: ");
        int year = scanner.nextInt();
        int month = scanner.nextInt();
        int day = scanner.nextInt();

        System.out.print("Enter student email: ");
        String email = scanner.nextLine();
        System.out.print("Enter student major: ");
        String major = scanner.nextLine();

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
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        Optional<Student> existing = studentService.getStudent(id);
        if (existing.isEmpty()) {
            System.out.println("Student not found");
        } else {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();
            System.out.print("Enter new email: ");
            String email = scanner.nextLine();
            System.out.print("Enter new major: ");
            String major = scanner.nextLine();

            Student student = existing.get();
            boolean success = studentService.updateStudent(student, name, email, major);

            if (success) {
                System.out.println("Student updated successfully");
            } else {
                System.out.println("Failed to update student");
            }
        }
    }

    private static void deleteStudent() {
        System.out.print("Enter student ID: ");
        String id = scanner.nextLine();

        boolean success = studentService.deleteStudent(id);
        if (success) {
            System.out.println("Student deleted successfully");
        } else {
            System.out.println("Student not found");
        }
    }

    private static void findStudentByMajor() {
        System.out.print("Enter major: ");
        String major = scanner.nextLine();

        List<Student> students = studentService.getAllStudents();

        if (students.isEmpty()) {
            System.out.printf("No student found in %s major\n", major);
        } else {
            System.out.printf("List of student in %s major:\n", major);
            students.forEach(System.out::println);
        }
    }

    // ========= LECTURER MENU METHODS ===========
    private static void showLecturerMenu() {
        // Implementation for Lecturer Menu
        while (true) {
            System.out.println("\n--- LECTURER MENU ---");
            System.out.println("1. Add Lecturer");
            System.out.println("2. View Lecturer");
            System.out.println("3. View All Lecturers");
            System.out.println("4. Update Lecturer");
            System.out.println("5. Delete Lecturer");
            System.out.println("6. Find Lecturer By Department");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> addLecturer();
                case 2 -> viewLecturer();
                case 3 -> viewAllLecturers();
                case 4 -> updateLecturer();
                case 5 -> deleteLecturer();
                case 6 -> findLecturerByDepartment();
                case 0 -> {return;}
                default -> System.out.println("Invalid option");
            }
        }
    }

    private static void addLecturer() {
        System.out.print("Enter lecture ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        Lecturer lecturer = Lecturer.builder(id, name, email).withDepartment(department).build();

        boolean success = lecturerService.addLecturer(lecturer);


        if (success) {
            System.out.println("Lecturer registered successfully!");
        } else {
            System.out.printf("Lectured ID: %s already exists", id);
        }
    }

    private static void viewLecturer() {
        System.out.print("Enter lecturer ID: ");
        String id = scanner.nextLine();

        lecturerService.getLecturer(id).ifPresentOrElse(
                lecturer -> System.out.println("Lecturer: " + lecturer),
                () -> System.out.println("Lecturer ID not found")
        );
    }

    private static void viewAllLecturers() {
        List<Lecturer> lecturers = lecturerService.getAllLecturers();

        if (lecturers.isEmpty()) {
            System.out.println("No lecturer found");
        } else {
            System.out.println("List of assigned lecturers");
            lecturers.forEach(System.out::println);
        }
    }

    private static void updateLecturer() {
        System.out.print("Enter lecturer ID: ");
        String id = scanner.nextLine();

        Optional<Lecturer> existing = lecturerService.getLecturer(id);

        if (existing.isEmpty()) {
            System.out.printf("Lecturer with ID: %s not found", id);
        } else {
            System.out.print("Enter new name: ");
            String name = scanner.nextLine();

            System.out.print("Enter new email: ");
            String email = scanner.nextLine();

            System.out.print("Enter new department: ");
            String department = scanner.nextLine();

            Lecturer update = Lecturer.builder(existing.get().getId(), name, email)
                    .withDepartment(department).build();
            boolean success = lecturerService.updateLecturer(update);

            if (success) {
                System.out.println("Lecturer details updated successfully");
            } else {
                System.out.println("Failed to update lecturer");
            }
        }
    }

    private static void deleteLecturer() {
        System.out.print("Enter lecturer ID: ");
        String id = scanner.nextLine();

        boolean success = lecturerService.deleteLecturer(id);

        if (success)
            System.out.println("Lecturer with ID: %s removed successfully.");
    }

    private static void findLecturerByDepartment() {
        System.out.print("Enter department: ");
        String department = scanner.nextLine();

        List<Lecturer> lecturers = lecturerService.getLecturerByDepartment(department);

        if (lecturers.isEmpty()) {
            System.out.printf("No lecturers found in this %s department\n", department);
        } else {
            System.out.printf("List of lecturers in %s department.\n", department);
            lecturers.forEach(System.out::println);
        }
    }

    // ========= COURSE MENU METHODS ===========
    private static void showCourseMenu() {
        // Implementation for Lecturer Menu
        while (true) {
            System.out.println("\n--- COURSE MENU ---");
            System.out.println("1. Add Course");
            System.out.println("2. View Course");
            System.out.println("3. View All Courses");
            System.out.println("4. Update Course");
            System.out.println("5. Delete Course");
            System.out.println("6. Find Lecturer By Lecturer ID");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> createCourse();
                case 2 -> viewCourse();
                case 3 -> viewAllCourses();
                case 4 -> updateCourse();
                case 5 -> deleteCourse();
                case 6 -> findLecturerByLecturerId();
                case 0 -> {return;}
                default -> System.out.println("Invalid option");
            }
        }
    }
    private static void createCourse() {
        // Implementation for adding a course
        System.out.print("Enter course code: ");
        String courseCode = scanner.nextLine();

        System.out.print("Enter course title: ");
        String title = scanner.nextLine();

        System.out.println("Enter course credit: ");
        int credit = scanner.nextInt();

        System.out.println("Enter course capacity: ");
        int capacity = scanner.nextInt();

        System.out.println("Enter lecturer ID: ");
        String lecturerId = scanner.nextLine();

        System.out.print("Enter prerequisite: ");
        String prerequisite = scanner.nextLine();

        Course course = Course.builder(courseCode, title, credit)
                .withCapacity(capacity)
                .withLecturerId(lecturerId)
                .withPrerequisite(prerequisite)
                .build();

        boolean success = courseService.addCourse(course);

        if (success) {
            System.out.println("Course added successfully!");
        } else {
            System.out.printf("Course with code: %s already exists\n", courseCode);
        }
    }

    private static void viewCourse() {
        System.out.print("Enter course code:");
        String code = scanner.nextLine();

        courseService.getCourse(code).ifPresentOrElse(
                course -> System.out.println("Course: " + course),
                () -> System.out.println("Course not found")
        );
    }

    private static void viewAllCourses() {
        List<Course> courses = courseService.getAllCourses();

        if (courses.isEmpty()) {
            System.out.println("No courses found");
        } else {
            System.out.println("List of all available courses:");
            courses.forEach(System.out::println);
        }
    }

    private static void updateCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();

        Optional<Course> existing = courseService.getCourse(code);

        if (existing.isEmpty())  {
            System.out.println("Course not found");
        } else {
            System.out.print("Enter new title: ");
            String title = scanner.nextLine();

            System.out.print("Enter new credit: ");
            int credit = scanner.nextInt();

            System.out.print("Enter new capacity: ");
            int capacity = scanner.nextInt();

            Course updatedCourse = Course.builder(code, title, credit)
                    .withCapacity(capacity)
                    .withLecturerId(existing.get().getLecturerId())
                    .withPrerequisite(existing.get().checkPrerequisite())
                    .build();

            boolean success = courseService.updateCourse(updatedCourse);

            if (success) {
                System.out.println("Course updated successfully");
            } else {
                System.out.println("Failed to update course");
            }
        }
    }

    private static void deleteCourse() {
        System.out.print("Enter course code: ");
        String code = scanner.nextLine();

        Optional<Course> existing = courseService.getCourse(code);

        if (existing.isEmpty()) {
            System.out.println("Course not found");
            System.exit(0);
        }

        courseService.deleteCourse(existing.get());
        System.out.println("Course deleted successfully");
    }

    private static void findLecturerByLecturerId() {
        System.out.print("Enter lecturer ID: ");
        String lecturerId = scanner.nextLine();

        List<Course> courses = courseService.getCourseByLecturerId(lecturerId);

        if (courses.isEmpty()) {
            System.out.printf("No courses found for lecturer ID: %s\n", lecturerId);
        } else {
            System.out.printf("List of courses for lecturer ID: %s\n", lecturerId);
            courses.forEach(System.out::println);
        }


    }

    // ========= ENROLLMENT MENU METHODS ===========
    private static void showEnrollmentMenu() {
        // Implementation for Student Menu
        while (true) {
            System.out.println("\n--- ENROLLMENT MANAGEMENT ---");
            System.out.println("1. Enroll Student in Course");
            System.out.println("2. View Enrollment");
            System.out.println("3. View All Enrollments");
            System.out.println("4. Update Enrollment Grade");
            System.out.println("5. Drop Enrollment");
            System.out.println("6. View Enrollment By Student");
            System.out.println("7. View Enrollment By Course");
            System.out.println("8. View Enrollment By Semester");
            System.out.println("9. View Enrollment By Student and Course");
            System.out.println("0. Back to Main Menu");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> enrollStudent();
                case 2 -> viewEnrollment();
                case 3 -> viewAllEnrollments();
                case 4 -> updateEnrollmentGrade();
                case 5 -> dropEnrollment();
                case 6 -> findEnrollmentByStudent();
                case 7 -> findEnrollmentByCourse();
                case 8 -> findEnrollmentBySemester();
                case 9 -> findEnrollmentByStudentAndCourse();
                case 0 -> {return;}
                default -> System.out.println("Invalid Option!");
            }
        }
    }

    private static void enrollStudent() {
        System.out.print("Enter enrollment ID: ");
        String id = scanner.nextLine();

        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        System.out.print("Enter student grade: ");
        String grade = scanner.nextLine();

        System.out.print("Enter current semester: ");
        int semester = scanner.nextInt();

        // Verify if student exists
        if (studentService.getStudent(studentId).isEmpty()) {
            System.out.printf("Error: Student ID: %s not found!.\n", studentId);
            System.exit(0);
        }

        // Verify if course exists
        if (courseService.getCourse(courseId).isEmpty()) {
            System.out.printf("Error: Course ID %s not found!.\n", courseId);
            System.exit(0);
        }

        String status = "Active";
        String date = LocalDate.now().toString();

        Enrollment enrollment = Enrollment.builder(id, studentId, courseId).withSemester(semester)
                .withEnrollmentDate(date).withStatus(status).build();

        enrollment.setGrade(grade);

        boolean success = enrollmentService.addEnrollment(enrollment);

        if (success) {
            System.out.printf("Student with ID: %S enrolled successfully\n", studentId);
        }
    }

    private static void viewEnrollment() {
        System.out.print("Enter enrollment ID: ");
        String id = scanner.nextLine();

        enrollmentService.getEnrollment(id).ifPresentOrElse(
                enrollment -> System.out.println("Enrollment: " + enrollment),
                () -> System.out.printf("Enrollment ID: %s not found!\n", id )
        );
    }

    private static void viewAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();

        if (enrollments.isEmpty()) {
            System.out.println("No enrollment found!");
        } else {
            enrollments.forEach(System.out::println);
        }
    }

    private static void updateEnrollmentGrade() {
        System.out.print("Enter enrollment ID: ");
        String id =scanner.nextLine();

        Optional<Enrollment> existing = enrollmentService.getEnrollment(id);

        if (existing.isEmpty()) {
            System.out.printf("Enrollment ID: %s\n", id);
        } else {
            System.out.print("Enter new grade: ");
            String grade = scanner.nextLine();

            Enrollment update = existing.get();

            boolean success = update.setGrade(grade);

            if (success) {
                System.out.printf("Enrollment ID: %s updated successfully!\n", update.getId());
            }

        }
    }

    private static void dropEnrollment() {
        System.out.print("Enter enrollment ID: ");
        String id = scanner.nextLine();

        boolean success = enrollmentService.dropEnrollment(id);

        if (success) {
            System.out.printf("Enrollment ID: %s dropped successfully.", id);
        } else {
            System.out.print("Error: Enrollment couldn't be dropped");
        }
    }

    private static void findEnrollmentByStudent() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        // Verify if student exist
        if (studentService.getStudent(studentId).isEmpty()) {
            System.out.printf("Student ID: %s not found!\n", studentId);
            System.exit(0);
        }

        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();

        if (enrollments.isEmpty()) {
            System.out.printf("No enrollment found for student ID: %s!\n", studentId);
        } else {
            System.out.printf("Enrollments for student ID: %s\n", studentId);
            enrollments.forEach(System.out::println);
        }
    }

    private static void findEnrollmentByCourse() {
        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        List<Enrollment> enrollments = enrollmentService.getEnrollmentByCourseId(courseId);

        if (enrollments.isEmpty()) {
            System.out.printf("No enrollment found for course ID: %s!\n", courseId);
        } else {
            System.out.printf("Enrollments for course ID: %s\n", courseId);
            enrollments.forEach(System.out::println);
        }
    }

    private static void findEnrollmentBySemester() {
        System.out.print("Enter semester ie. 1 or 2: ");
        int semester = scanner.nextInt();
        scanner.nextLine(); // consume newline

        List<Enrollment> enrollments = enrollmentService.getEnrollmentBySemester(semester);
        if(enrollments.isEmpty()) {
            System.out.printf("No enrollments for semester: %d\n", semester);
        } else {
            System.out.printf("Enrollments for semester %d:\n", semester);
            enrollments.forEach(System.out::println);
        }
    }

    private static void findEnrollmentByStudentAndCourse() {
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        System.out.print("Enter course ID: ");
        String courseId = scanner.nextLine();

        Optional<Enrollment> existing = enrollmentService.getEnrollmentByStudentAndCourse(studentId, courseId);

        existing.ifPresentOrElse(
                enrollment -> System.out.println("Enrollment: " + enrollment),
                () -> System.out.printf("No enrollment found with Student ID: %s and Course ID: %s\n", studentId, courseId)
        );
    }
}