import org.adrianegl.Address;
import org.adrianegl.Department;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
     @DisplayName("testDepartmentIdAutoIncrement(): D01 -> D02")
     void testDepartmentIdAutoIncrement() {
        Department department1 = new Department("Chemistry");
        Department department2 = new Department("Discrete Math");
        assertEquals("D01", department1.getDepartmentId());
        assertEquals("D02", department2.getDepartmentId());
    }


 }
