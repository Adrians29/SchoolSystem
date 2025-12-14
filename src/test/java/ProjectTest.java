import org.adrianegl.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
    @DisplayName("testDepartmentIdAutoIncrement():")
    void testDepartmentIdAutoIncrement() {
        Department department1 = new Department("Math");
        Department department2 = new Department("Science");
        assertNotEquals(department1, department2);
    }

    //Student Test

    @Test
    @DisplayName("testRegisterAndDropCourse():")
    void testRegisterAndDropCourse1() {
        Department department = new Department("Physics");
        Course course = new Course("Mechanics", 3, department);
        Student student = new Student("Carlos Rodriguez", Student.Gender.MALE, null, department);

        assertTrue(student.registerCourse(course));
        assertTrue(student.dropCourse(course));
    }

    @Test
    @DisplayName("testRegisterAndDropCourse():")
    void testRegisterAndDropCourse2() {
        Department department = new Department("Life Science");
        Course course = new Course("Biology", 2, department);
        Student student = new Student("Maria", Student.Gender.FEMALE, null, department);

        assertTrue(student.registerCourse(course));
        assertTrue(student.dropCourse(course));
    }

    //Assignment Test

    @Test
    @DisplayName("calcAssignmentAvg():")
    void testCalcAssignmentAvg1() {
        Assignment assignment = new Assignment("Quiz", 100);
        assignment.getScores().addAll(List.of(80, 90, 85));

        assertEquals(85, assignment.calcAssignmentAvg());
    }

    @Test
    @DisplayName("testGenerateRandomScore")
    void testGenerateRandomScore() {
        Assignment assignment = new Assignment("Quiz", 30);
        assignment.getScores().add(null);
        assignment.getScores().add(null);

        assignment.generateRandomScore();

        assertNotNull(assignment.getScores().get(0));
        assertNotNull(assignment.getScores().get(1));
    }
}
