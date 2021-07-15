package Sem03;

import junit.framework.TestCase;

public class TestMath extends TestCase {
    Math math = new Math();

    public void testSumPos() {
        assertEquals(math.add(1, 2), 1+2);
        assertEquals(math.add(3, 5), 3+5);
    }

    public void testAddZero(){
        assertEquals(9, math.add(9 , 0));
        assertEquals(9, math.add(0 , 9));
    }


    public void testAbsPositiveNumber(){
        assertEquals(5, math.abs(5));
    }


    public void testAbsZero(){
        assertEquals(0, math.abs(0));
    }

    public void testAbsNegativeNumber(){
        assertEquals(19, math.abs(-19));
    }
}
