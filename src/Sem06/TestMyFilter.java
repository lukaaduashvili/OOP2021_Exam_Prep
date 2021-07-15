package Sem06;

import junit.framework.TestCase;


public class TestMyFilter extends TestCase {

    private Filter filter;

    public void setUp() {
        filter = new MyFilter();
    }

    public void testempty() {
        assertEquals(0, filter.size());
    }

    public void testadd() {
        for(int i = 0; i < 10; i++) {
            assertFalse(filter.isPresent(i));
            filter.add(i);
            assertTrue(filter.isPresent(i));
            assertEquals(i+1, filter.size());
        }
    }


    public void testaddTwice() {
        filter.add(5);
        assertEquals(filter.size(), 1);
        filter.add(5);
        assertEquals(filter.size(), 1);
    }


    public void testremoveTest() {
        for(int i = 0; i < 10; i++) {
            filter.add(i);
            assertTrue(filter.isPresent(i));
        }

        for(int i = 0; i < 10; i++) {
            filter.remove(i);
            assertFalse(filter.isPresent(i));
        }
    }
}
