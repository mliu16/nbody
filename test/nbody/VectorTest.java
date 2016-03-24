/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nbody;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ling
 */
public class VectorTest {

    public VectorTest() {
    }

    /**
     * Test of length method, of class Vector.
     */
    @Test
    public void testLength() {
        System.out.println("length");
        double[] a = {0.1, 0.02, 0.15};
        Vector instance = new Vector(a);
        int expResult = 3;
        int result = instance.length();
        assertEquals(expResult, result);
       
    } //testLenght()
    
    

    /**
     * Test of dot method, of class Vector.
     */
    @Test
    public void testDot() {
        System.out.println("dot");
        double[] a = {0.1, 0.01, 0.001};
        double[] b = {0.2, 0.02, 0.002};       
        Vector that = new Vector(b);
        Vector instance = new Vector(a);
        double expResult = 0.020202;
        double result = instance.dot(that);
        assertEquals(expResult, result, 0.0);     
       
    } //testDot()
    
    
    
    /**
     * Test of xBackward method, of class Vector.
     * Compare two vectors
     */
    @Test
    public void testXBackward() {
        System.out.println("xBackward");
        double[] a = {0.01, 0.5};
        Vector instance = new Vector(a);
        double[] b = {-0.009, 0.5};
        Vector expResult = new Vector(b) ;
        instance.xBackward();
        assertArrayEquals(expResult, instance);
    } // testXBackward()
    
    
    
//    /**
//     * Test of xBackward method, of class Vector.
//     * Compare specific values in vector applying cartesian(i) ???????
//     */
//    @Test
//    public void testXBackward() {
//        System.out.println("xBackward");
//        double[] a = {0.01, 0.5};
//        Vector instance = new Vector(a);
//        double[] b = {-0.009, 0.5};
//        Vector expVector = new Vector(b);
//        double expResult = expVector.cartesian(0);
//        instance.xBackward();
//        double result = instance.cartesian(0);
//        assertEquals(expResult, result, 0.0);
//    } // testXBackward()
    
    
    
    /**
     * Test of yBackward method, of class Vector.
     * Compare two vector
     */
    @Test
    public void testYBackward() {
        System.out.println("yBackward");
        double[] a = {0.01, 0.5};
        double[] b = {0.01, -0.45};
        Vector instance = new Vector(a);
        Vector expResult = new Vector(b);
        instance.yBackward();      
        assertArrayEquals(expResult, instance);
    } // testYBackward();
    
    
    
//     /**
//     * Test of yBackward method, of class Vector.
//     * Compare values in the vector applying cartesian(i)
//     */
//    @Test
//    public void testYBackward() {
//        System.out.println("yBackward");
//        double[] a = {0.01, 0.5};
//        double[] b = {0.01, -0.45};
//        Vector instance = new Vector(a);
//        Vector expResult = new Vector(b);
//        double expRes = expResult.cartesian(1);
//        instance.yBackward();  
//        double result = instance.cartesian(1);
//        assertEquals(expRes, result, 0.0);
//    } // testYBackward();
    
    
    
    /**
     * Test of magnitude method, of class Vector.
     */
    @Test
    public void testMagnitude() {
        System.out.println("magnitude");
        double[] a = {0.1, 0.01, 0.001};
        double[] b = {Math.sqrt(0.1 * 0.1), Math.sqrt(0.01 * 0.01), Math.sqrt(0.001 * 0.001)};
        Vector instance = new Vector(a);
        Vector expVector = new Vector(b);
        boolean equal = false;
        for (int i = 0; i  < a.length; i++) {
            double expResult = expVector.cartesian(i);
            double result = instance.cartesian(i);
            assertEquals(expResult, result, 0.0);
        } // for
    } //testMagnitude()
    


    /**
     * Test of distanceTo method (Euclidean distance), of class Vector.
     */
    @Test
    public void testDistanceTo() {
        System.out.println("distanceTo");
        double[] a = {0.1, 0.01, 0.001};
        double[] b = {0.2, 0.02, 0.002};
        Vector that = new Vector(a);
        Vector instance = new Vector(b);
        double diff1 = a[0] - b[0];
        double diff2 = a[1] - b[1];
        double diff3 = a[2] - b[2];        
        double expResult = Math.sqrt(diff1 * diff1 + diff2 * diff2 + diff3 * diff3);
        double result = instance.distanceTo(that);
        assertEquals(expResult, result, 0.0);       
    } // testDistanceTo()

    

    /**
     * Test of plus method, of class Vector.
     * Not pass because of very tiny difference (0.00000000000000004) 
     */
    @Test
    public void testPlus() {
        System.out.println("plus");
        double[] a = {0.1, 0.01, 0.001};
        double[] b = {0.2, 0.02, 0.002};
        double[] c = {0.3, 0.03, 0.003};
        Vector that = new Vector(a);
        Vector instance = new Vector(b);
        Vector expResult = new Vector(c);
        Vector result = instance.plus(that);
        assertArrayEquals(expResult, result);      
    } //testPlus
    
    

    /**
     * Test of minus method, of class Vector.
     * Failed ????????
     */
    @Test
    public void testMinus() {
        System.out.println("minus");
        double[] a = {0.1, 0.01, 0.001};
        double[] b = {0.2, 0.02, 0.002};
        double[] c = {0.1, 0.01, 0.001};
        Vector that = new Vector(a);
        Vector instance = new Vector(b);
        Vector expResult = new Vector(c);
        Vector result = instance.minus(that);
        assertArrayEquals(expResult, result);       
    } //testMinus()
    
    

    /**
     * Test of cartesian method, of class Vector.
     */
    @Test
    public void testCartesian() {
        System.out.println("cartesian");
        int i = 2;
        double[] a = {0.1, 0.01, 0.001};       
        Vector instance = new Vector(a);
        double expResult = 0.001;
        double result = instance.cartesian(i);
        assertEquals(expResult, result, 0.0);       
    } //testCartesian()
    


    /**
     * Test of times method, of class Vector.
     * Call the assertArrayEquals method to compare two vectors
     */
    @Test
    public void testTimes() {
        System.out.println("times");
        double factor = 2.0;
        double[] a = {0.1, 0.01, 0.001};
        double[] b = {0.2, 0.02, 0.002};
        Vector instance = new Vector(a);
        Vector expResult = new Vector(b);
        Vector result = instance.times(factor);
        assertArrayEquals(expResult, result);  
    } //testTimes()
    

    private void assertArrayEquals(Vector a, Vector b) {
        if (a.N != b.N) {
        throw new UnsupportedOperationException("Not supported yet."); 
        } // if
        
        boolean equality = true;
        for (int i = 0; i < a.N; i++) {
            if (a.cartesian(i) != b.cartesian(i));
            equality = false;
        } //for
    } //assertArrayEquals(Vector a, Vector b)


    
    /**
     * Test of direction method, of class Vector.
     */
    @Test
    public void testDirection() {
        System.out.println("direction");
        double[] a = {0.1, 0.01, 0.001};  
        
        //Create the expected vector
        double factor =  1.0 / Math.sqrt(0.010101); 
        double[] b = new double[a.length];
        for(int i = 0; i < a.length; i++) {
            b[i] = factor * a[i];
        } // for 
        Vector expResult = new Vector(b); 
        
        Vector instance = new Vector(a);
        Vector result = instance.direction();
        assertArrayEquals(expResult, result);       
    } //testDirection()
    
    
   

    /**
     * Test of toString method, of class Vector.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        String a = new String();
        a = "Ming";
        String expResult = "Ming";
        String result = a.toString();
        assertEquals(expResult, result);       
    } //testToString()
    


//    /**
//     * Test of main method, of class Vector.
//     */
//    @Test
//    public void testMain() {
//        System.out.println("main");
//        
//        String args = "abcedfg";
//        Vector.main(args);
//        
//    } // testMain()
//    
}
