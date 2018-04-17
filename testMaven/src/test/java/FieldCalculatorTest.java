import org.junit.*;

import static org.junit.Assert.*;

public class FieldCalculatorTest {
    static FieldCalculator kalkulator1;
    @BeforeClass
    public static void myTestSetUp() {
        kalkulator1 = new FieldCalculator();
    }

    @Before
    public void start() {

        System.out.println("Poczatek testu");

    }


    @After
    public void test(){
        System.out.println("Koniec testu");
    }

    @AfterClass
    public static void end(){
        System.out.println("Wsyzstkie testy pomyslnie");
    }

    @Test
    public void calculateSquare1() {
        double t1 = kalkulator1.calculateSquare(4);
        assertEquals(16, t1, 0);

    }

    @Test
    public void calculateSquare2() {
        double t1 = kalkulator1.calculateSquare(0);
        assertEquals(0, t1, 0);
    }

    @Test
    public void calculateSquare3() {
        double t1 = kalkulator1.calculateSquare(1);
        assertEquals(1, t1, 0);
    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateCircle1(){
        double t1 = kalkulator1.calculateCircle(-1);


    }

    @Test (expected = IllegalArgumentException.class)
    public void calculateCircle2(){
        double t1 = kalkulator1.calculateCircle(0);

    }





    @Test
    public void calculateTriangle() {
        double t1 = kalkulator1.calculateTriangle(4,2);
        assertEquals(4, t1, 0);

    }

    @Test
    public void calculateRectangle() {
        double t1 = kalkulator1.calculateRectangle(10,2);
        assertEquals(20, t1, 0);

    }


}