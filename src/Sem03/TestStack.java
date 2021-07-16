package Sem03;
import junit.framework.TestCase;
import java.util.ArrayList;
import java.util.Arrays;


public class TestStack extends TestCase {

    MyStack<String> ms;

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        ms = new MyStack<>();
    }

    public void testSizeEmpty(){
        assertEquals(0, ms.size());
    }

    public void testsizeOneElement(){
        ms.add("one");
        assertEquals(1, ms.size());
    }


    public void testsizeManyElement(){
        for (int i = 0; i <= 100; i++)
            ms.add("one" + i);
        assertEquals(101, ms.size());
    }


    public void testpushOne(){
        String elem = "Element";
        ms.add(elem);
        String actualElem = ms.pop();
        assertEquals(elem, actualElem);
    }


    public void testAddAll(){
        ms.addAll(new ArrayList<String>(Arrays.asList("1", "2", "3")));
        assertEquals(3, ms.size());
        assertEquals("3", ms.pop());
    }
}