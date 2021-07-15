package Sem08.V1;

import junit.framework.TestCase;
public class TestNode extends  TestCase{

    public void testValue() {
        Node n = new Node(5);
        assertEquals(5.0, n.evaluate());
        assertEquals("(5.0)", n.toString());
    }


    public void testplus() {
        Node n = new Node('+', 5, 7);
        assertEquals(12.0, n.evaluate());
        assertEquals("((5.0)+(7.0))", n.toString());
    }


    public void testminus() {
        Node n = new Node('-', 5, 7);
        assertEquals(-2.0, n.evaluate());
        assertEquals("((5.0)-(7.0))", n.toString());
    }


    public void testmultiply() {
        Node n = new Node('*', 5, 7);
        assertEquals(35.0, n.evaluate());
        assertEquals("((5.0)*(7.0))", n.toString());
    }


    public void testdivide() {
        Node n = new Node('/', 5, 7);
        assertEquals(5.0 / 7, n.evaluate());
        assertEquals("((5.0)/(7.0))", n.toString());
    }

    public void testcomplex() {
        Node n = new Node(
                '*',
                new Node('+', 5, 7),
                new Node('-', 1, 2));
        assertEquals(-12.0, n.evaluate());
        assertEquals("(((5.0)+(7.0))*((1.0)-(2.0)))", n.toString());
    }
}
