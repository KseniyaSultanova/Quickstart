package Lesson4Test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class TriangleTest {
private static Logger logger = LoggerFactory.getLogger(TriangleTest.class);


@BeforeAll
static void beforeAll(){
    logger.info("Info");
}

    @Test
    public void isTriangleTest(){
        double result = AreaTriangle(3,4,5);
        Assertions.assertEquals(6.00, result);

    }


    public double AreaTriangle (double a, double b, double c) {
        double p = (a + b + c) / 2;
        double AreaTriangle = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return AreaTriangle;
    }

}
