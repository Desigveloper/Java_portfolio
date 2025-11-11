package com.desigveloper.studentmanagement.services;


import com.desigveloper.studentmanagement.model.Course;
import com.desigveloper.studentmanagement.model.Enrollment;
import com.desigveloper.studentmanagement.model.Lecturer;
import com.desigveloper.studentmanagement.model.Student;

import java.time.LocalDate;

public class SampleDataService {
    private final StudentService studentService;
    private final LecturerService lecturerService;
    private final CourseService courseService;
    private final EnrollmentService enrollmentService;

    public SampleDataService() {
        this.studentService = new StudentService();
        this.lecturerService = new LecturerService();
        this.courseService = new CourseService();
        this.enrollmentService = new EnrollmentService();
    }

    public void generateSampleData() {
        // Sample students
        Student johnDoe = Student.builder("S001", "John Doe", LocalDate.of(1996, 5, 17))
                        .withEmail("john.doe@university.edu")
                        .withMajor("Computer Science")
                        .withEnrolledCourse("True")
                        .withStudentGPA("nil")
                        .build();

        Student janeSmith = Student.builder("S002", "Jane Smith", LocalDate.of(2004, 3, 4))
                .withEmail("jane.smith@university.edu")
                .withMajor("Mathematics")
                .withEnrolledCourse("True")
                .withStudentGPA("nil")
                .build();

        Student bobJohnson = Student.builder("S003", "Bob Johnson", LocalDate.of(2001, 10, 23))
                .withEmail("bob.johnson@university.edu")
                .withMajor("Physics")
                .withEnrolledCourse("True")
                .withStudentGPA("nil")
                .build();

        studentService.registerStudent(johnDoe);
        studentService.registerStudent(janeSmith);
        studentService.registerStudent(bobJohnson);

        // Add sample lecturers
        Lecturer aliceBrown = Lecturer.builder("L001", "Dr. Alice Brown", "alice.brown@university.edu")
                .withDepartment("Computer Science")
                .build();

        Lecturer charlieWilson = Lecturer.builder("L002", "Prof. Charlie Wilson", "charlie.wilson@university.edu")
                .withDepartment("Mathematics")
                .build();

        Lecturer lilianPhilips = Lecturer.builder("L003", "Dr. Lilian Philips", "lilian.philips@university.edu")
                .withDepartment("Physics")
                .build();

        lecturerService.addLecturer(aliceBrown);
        lecturerService.addLecturer(charlieWilson);
        lecturerService.addLecturer(lilianPhilips);

        // Sample courses
        Course programmingIntro = Course.builder("CS101", "Introduction to programming", 3)
                .withCapacity(200)
                .withLecturerId("L001")
                .withPrerequisite("Aggregate 6-25")
                .build();

        Course calculusI = Course.builder("MATH201", "Calculus I", 2)
                .withCapacity(120)
                .withLecturerId("L002")
                .withPrerequisite("Mathematics")
                .build();

        Course dataStructure = Course.builder("CS202", "Data Structure", 3)
                .withCapacity(200)
                .withLecturerId("L001")
                .withPrerequisite("Aggregate 6-25")
                .build();

        Course physicIntro = Course.builder("PHYS102", "Introduction to Physics", 3)
                .withCapacity(150)
                .withLecturerId("L003")
                .withPrerequisite("General Science")
                .build();

        courseService.addCourse(programmingIntro);
        courseService.addCourse(calculusI);
        courseService.addCourse(dataStructure);
        courseService.addCourse(physicIntro);


        // Sample enrollments
        Enrollment csStudent1 = Enrollment.builder("E001", "S001", "CS101")
                .withEnrollmentDate("Fall 2024")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment csStudent2 = Enrollment.builder("E002", "S001", "CS202")
                .withEnrollmentDate("Fall 2024")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment mathStudent1 = Enrollment.builder("E003", "S002", "MATH201")
                .withEnrollmentDate("Fall 2024")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment physicsStudent1 = Enrollment.builder("E004", "S003", "PHYS102")
                .withEnrollmentDate("Fall 2024")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment physicsStudent2 = Enrollment.builder("E005", "S002", "PHYS102")
                .withEnrollmentDate("Fall 2024")
                .withSemester(1)
                .withStatus("Active")
                .build();

        enrollmentService.addEnrollment(csStudent1);
        enrollmentService.addEnrollment(csStudent2);
        enrollmentService.addEnrollment(mathStudent1);
        enrollmentService.addEnrollment(physicsStudent1);
        enrollmentService.addEnrollment(physicsStudent2);


        // Add grades
        enrollmentService.updateEnrollmentGrade("S001", "A");
        enrollmentService.updateEnrollmentGrade("S003", "B+");
        enrollmentService.updateEnrollmentGrade("S002", "B");
    }

    // Clear all data
    public void clearAllData() {
        // In real applications, there will be bulk delete methods
        // For now, we will require individual deletes
        System.out.println("Data clearing would be implemented with bult delete operations");
    }
}
