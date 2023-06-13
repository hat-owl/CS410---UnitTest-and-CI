import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.annotation.processing.SupportedAnnotationTypes;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.fail;

public class CILabTest {

    private CILabInterface myString;

    @BeforeEach
    public void setUp() {
        myString = new CILab();
    }

    @AfterEach
    public void tearDown() {
        myString = null;
    }

    // exception testing
    @Test
    public void detectCapitalUseTest1() {
       myString.setString("-! _");
       assertThrows(IllegalArgumentException.class, myString.detectCapitalUse());

        myString.setString("app-! _");
        assertThrows(IllegalArgumentException.class, myString.detectCapitalUse());

        myString.setString("apple-");
        assertThrows(IllegalArgumentException.class, myString.detectCapitalUse());
    }

    // blank string test
    @Test
    public void detectCapitalUseTest2() {
        // blank string should return true
        myString.setString("");
        assertFalse(myString.detectCapitalUse());
    }

    // one-character word test
    @Test
    public void detectCapitalUseTest3() {
        // lowercase and uppercase both should return true
        myString.setString("a");
        assertTrue(myString.detectCapitalUse());

        myString.setString("A");
        assertTrue(myString.detectCapitalUse());
    }

    // multi-character testing of correct capital words
    @Test
    public void detectCapitalUseTest4() {
        myString.setString("bus");
        assertTrue(myString.detectCapitalUse());

        myString.setString("BUS");
        assertTrue(myString.detectCapitalUse());

        myString.setString("Bus");
        assertTrue(myString.detectCapitalUse());
    }

    // multi-character testing to confirm incorrect capitalization is rejected properly
    @Test
    public void detectCapitalUseTest5() {
        // not all lowercase
        myString.setString("buS");
        assertFalse(myString.detectCapitalUse());

        myString.setString("bUS");
        assertFalse(myString.detectCapitalUse());

        // not all capitals
        myString.setString("BUs");
        assertFalse(myString.detectCapitalUse());

        // not just first capital
        myString.setString("BuS");
        assertFalse(myString.detectCapitalUse());

        // longer word and mixed case
        myString.setString("buSseS");
        assertFalse(myString.detectCapitalUse());
    }
}
