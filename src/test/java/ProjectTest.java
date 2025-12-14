import org.adrianegl.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.Util;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProjectTest {

    //Address Test

    @Test
    @DisplayName("isPostalCodeValid: A1B2C3 -> true")
    void testValidPostalCode1() {
        assertTrue(Address.isPostalCodeValid("A1B2C3"));
    }

    @Test
    @DisplayName("isPostalCodeValid: 1A2B3F -> false")
    void testInvalidPostalCode1() {
        assertFalse(Address.isPostalCodeValid("1A2B3F"));
    }

    @Test
    @DisplayName("isPostalCodeValid: a1b2e3 -> true")
    void testValidPostalCode2() {
        assertTrue(Address.isPostalCodeValid("a1b2e3"));
    }

    //Department Test

    @Test
    @DisplayName("isDepartmentNameValid: Computer Science -> true")
    void testValidDepartmentName1() {
        assertTrue(Department.isDepartmentNameValid("Computer Science"));
    }

    @Test
    @DisplayName("isDepartmentNameValid: Business -> true")
    void testValidDepartmentName2() {
        assertTrue(Department.isDepartmentNameValid("Business"));
    }

    @Test
    @DisplayName("isDepartmentNameValid: 123Cooking -> false")
    void testInvalidDepartmentName() {
        assertFalse(Department.isDepartmentNameValid("123Cooking"));
    }

    @Test
    @DisplayName("testDepartmentIdAutoIncrement(): nextId++")
    void testDepartmentIdAutoIncrement() {
        Department department1 = new Department("Math");
        Department department2 = new Department("Science");
        assertNotEquals(department1, department2);
    }

    //Student Test

    @Test
    @DisplayName("testRegisterCourse(): newCourse -> register")
    void testRegisterCourse1() {
        Department department = new Department("Physics");
        Course course = new Course("Mechanics", 3, department);
        Student student = new Student("Carlos Rodriguez", Student.Gender.MALE, null, department);

        assertTrue(student.registerCourse(course));
        assertTrue(student.dropCourse(course));
    }

    @Test
    @DisplayName("testRegisterAndDropCourse(): newCourse -> register -> drop")
    void testRegisterAndDropCourse1() {
        Department department = new Department("Life Science");
        Course course = new Course("Biology", 2, department);
        Student student = new Student("Maria", Student.Gender.FEMALE, null, department);

        assertTrue(student.registerCourse(course));
        assertTrue(student.dropCourse(course));
    }

    //Assignment Test

    @Test
    @DisplayName("calcAssignmentAvg(): 80, 90, 95 -> 85")
    void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Quiz", 100);
        assignment.getScores().addAll(List.of(80, 90, 85));

        assertEquals(85, assignment.calcAssignmentAvg());
    }

    @Test
    @DisplayName("testGenerateRandomScore: null -> notNull")
    void testGenerateRandomScore() {
        Assignment assignment = new Assignment("Quiz", 30);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        assignment.generateRandomScore();

        assertNotNull(assignment.getScores().get(0));
        assertNotNull(assignment.getScores().get(1));
    }

    //Course Test

    @Test
    @DisplayName("testAssignmentWeightValidation: 30, 70 -> true")
    void testAssignmentWeightValidation1() {
        Department department = new Department("Science");
        Course course = new Course("Chemistry", 2, department);

        course.addAssignment("Quiz", 30);
        course.addAssignment("Exam", 70);

        assertTrue(course.isAssignmentWeightValid());
    }

    @Test
    @DisplayName("testAssignmentWeightValidation: 5, 70 -> false")
    void testAssignmentWeightValidation2() {
        Department department = new Department("Science");
        Course course = new Course("Chemistry", 2, department);

        course.addAssignment("Assignment", 5);
        course.addAssignment("Exam", 70);

        assertFalse(course.isAssignmentWeightValid());
    }

    @Test
    @DisplayName("testCourseStudentRegistration: newStudent -> true, sameStudent -> false")
    void testCourseStudentRegistration() {
        Department department = new Department("Math");
        Course course = new Course("Calculus", 4, department);
        Student student = new Student("Oscar Perez", Student.Gender.MALE, null, department);

        assertTrue(course.registerStudent(student));
        assertFalse(course.registerStudent(student));
    }

    @Test
    @DisplayName("testGenerateScoresAndFinalAverage")
    void testGenerateScoresAndFinalAverage() {
        Department department = new Department("Business");
        Course course = new Course("Economics in Business", 4, department);

        Student student1 = new Student("Zakriya Adress", Student.Gender.MALE, null, department);
        Student student2 = new Student("Juan Pablo Escobar", Student.Gender.MALE, null, department);

        course.registerStudent(student1);
        course.registerStudent(student2);

        course.addAssignment("Quiz", 40);
        course.addAssignment("Exam", 60);

        course.generateScores();

        assertEquals(2, course.getFinalScores().size());
        assertNotNull(course.getFinalScores().get(0));
        assertNotNull(course.getFinalScores().get(1));
    }

    //Util Test

    @Test
    @DisplayName("toTitleCase:    diScrete MaTH -> Discrete Math")
    void testUtilTitleCase1() {
        assertEquals("Discrete Math", Util.toTitleCase("   diScrete MaTH"));
    }

    @Test
    @DisplayName("toTitleCase: mechanics -> Mechanics")
    void testUtilTitleCase2() {
        assertEquals("Mechanics", Util.toTitleCase("mechanics"));
    }

    @Test
    @DisplayName("toTitleCase: Biology -> Biology")
    void testUtilTitleCase3() {
        assertEquals("Biology", Util.toTitleCase("Biology"));
    }
}
