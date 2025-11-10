package com.desigveloper.studentmanagement.dao.inmemory;

import com.desigveloper.studentmanagement.model.Course;
import com.desigveloper.studentmanagement.model.Enrollment;
import com.desigveloper.studentmanagement.model.Lecturer;
import com.desigveloper.studentmanagement.model.Student;

import java.time.LocalDate;

public class SampleDataGenerator {
    public void generateSampleData() {
        // DAO instance
        MemoryStudentDaoImp studentDao = new MemoryStudentDaoImp();
        MemoryLecturerDaoImp lecturerDao = new MemoryLecturerDaoImp();
        MemoryCourseDaoImp courseDao = new MemoryCourseDaoImp();
        MemoryEnrollmentDaoImp enrollmentDao = new MemoryEnrollmentDaoImp();


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

        studentDao.addStudent(johnDoe);
        studentDao.addStudent(janeSmith);
        studentDao.addStudent(bobJohnson);

        // Add sample lecturers
        Lecturer aliceBrown = Lecturer.builder("T001", "Dr. Alice Brown", "alice.brown@university.edu")
                .withDepartment("Computer Science")
                .build();

        Lecturer charlieWilson = Lecturer.builder("T002", "Prof. Charlie Wilson", "charlie.wilson@university.edu")
                .withDepartment("Mathematics")
                .build();

        Lecturer lilianPhilips = Lecturer.builder("T003", "Dr. Lilian Philips", "lilian.philips@university.edu")
                .withDepartment("Physics")
                .build();

        lecturerDao.addLecturer(aliceBrown);
        lecturerDao.addLecturer(charlieWilson);
        lecturerDao.addLecturer(lilianPhilips);

        // Sample courses
        Course programmingIntro = Course.builder("C001", "Introduction to programming", 3)
                .withCapacity(200)
                .withLecturerId("T001")
                .withPrerequisite("Aggregate 6-25")
                .build();

        Course calculusI = Course.builder("C002", "Calculus I", 2)
                .withCapacity(120)
                .withLecturerId("T002")
                .withPrerequisite("Mathematics")
                .build();

        Course dataStructure = Course.builder("C003", "Data Structure", 3)
                .withCapacity(200)
                .withLecturerId("T001")
                .withPrerequisite("Aggregate 6-25")
                .build();

        Course physicIntro = Course.builder("C004", "Introduction to Physics", 3)
                .withCapacity(150)
                .withLecturerId("T003")
                .withPrerequisite("General Science")
                .build();

        courseDao.addCourse(programmingIntro);
        courseDao.addCourse(calculusI);
        courseDao.addCourse(dataStructure);
        courseDao.addCourse(physicIntro);


        // Sample enrollments
        Enrollment e1S001 = Enrollment.builder("E001", "S001", "C001")
                .withEnrollmentDate("Fall 2024")
                .withGrade("Not graded")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment e2S001 = Enrollment.builder("E002", "S001", "C003")
                .withEnrollmentDate("Fall 2024")
                .withGrade("Not graded")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment e3S002 = Enrollment.builder("E003", "S002", "C002")
                .withEnrollmentDate("Fall 2024")
                .withGrade("Not graded")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment e4S003 = Enrollment.builder("E004", "S003", "C001")
                .withEnrollmentDate("Fall 2024")
                .withGrade("Not graded")
                .withSemester(1)
                .withStatus("Active")
                .build();

        Enrollment e5S002 = Enrollment.builder("E005", "S002", "C004")
                .withEnrollmentDate("Fall 2024")
                .withGrade("Not graded")
                .withSemester(1)
                .withStatus("Active")
                .build();

        enrollmentDao.addEnrollment(e1S001);
        enrollmentDao.addEnrollment(e2S001);
        enrollmentDao.addEnrollment(e3S002);
        enrollmentDao.addEnrollment(e4S003);
        enrollmentDao.addEnrollment(e5S002);
    }
}
