package myutils;

import java.util.Date;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author usuario
 */
public class MyUtilsTest {

    public MyUtilsTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
    }

    /**
     * Test of inverteix method, of class MyUtils.
     */
    @org.junit.jupiter.api.Test
    public void testInverteix() {
        System.out.println("inverteix");

        // pos 0 una palabra, pos 2 conjunto de palabras, pos 3 espacio, pos 4 intro nada
        String[] cadenas = {"hola", "hola que tal", " ", ""};
        String[] expResult = {"aloh", "lat euq aloh", " ", ""};

        for (int i = 0; i < expResult.length; i++) {
            String result = MyUtils.inverteix(cadenas[i]);

            assertEquals(expResult[i], result);
        }

        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of edat method, of class MyUtils.
     */
    @org.junit.jupiter.api.Test
    public void testEdat() {
        final Date ACTUAL = new Date();

        System.out.println("edat");
        int[][] valores = {{1, 7, 2002}, {1, 1, 2002}, {40, 2, 2002},
        {ACTUAL.getDate(), ACTUAL.getMonth() + 1, 2002},
        {ACTUAL.getDate(), ACTUAL.getMonth() + 1 , ACTUAL.getYear() + 1900},
        {ACTUAL.getDate() + 1, ACTUAL.getMonth() + 1 , ACTUAL.getYear() + 1900}
        ,{1,1,ACTUAL.getYear() + 1900 - 150}, {1,1,ACTUAL.getYear() + 1900 - 151}};

        int[] expResult = {20, 21, -2, 21, 0, -2, 150, -1};

        for (int i = 0; i < expResult.length; i++) {
            int result = MyUtils.edat(valores[i]);

            assertEquals(expResult[i], result);
        }

    }

    /**
     * Test of factorial method, of class MyUtils.
     */
    @org.junit.jupiter.api.Test
    public void testFactorial() {
        System.out.println("factorial");
        int[] numero = {0, 1, 5, -1};
        int[] expResult = {1, 1, 120, -1};

        for (int i = 0; i < expResult.length; i++) {

            int result = MyUtils.factorial(numero[i]);
            assertEquals(expResult[i], result);

        }

    }

}
