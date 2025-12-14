import org.adrianegl.Address;
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
}
