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
public class BodyTest {
    
    public BodyTest() {
    }

    /**
     * Test of move method, of class Body.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        double[] a = {2.0, 2.0};
        double[] b = {0.0, 0.0};
        double[] c = {0.0, 0.0};
        Vector f = new Vector(a);
        Vector r = new Vector(b); 
        Vector v = new Vector(c);
        double dt = 0.01;
        double[] d = {0.02, 0.02};
        double[] e = {0.0002, 0.0002};
        Vector expR = new Vector(e);
        Vector expV = new Vector(d);
        Body expBody = new Body(expR, expV, 1.0, 10);
        Body instance = new Body(r, v, 1.0, 2);
        instance.move(f, dt);
        assertArrayEquals(expR, r);
        assertArrayEquals(expV, v);
    } // testMove

     
    
    
    /**
     * Test of forceFrom method, of class Body.
     */
    @Test
    public void testForceFrom() {
        System.out.println("forceFrom");
        double G = 6.67e-11;
        double[] a = {0.0, 0.0};
        double[] aa = {1.0, 1.0};
        Vector r = new Vector(a);
        Vector v = new Vector(aa);
        Body b = new Body(r, v, 1.0, 10);
        
        double[] c = {0.5, 0.5};
        double[] cc = {1.5, 1.5};
        Vector inR = new Vector(c);
        Vector inV = new Vector(cc);
        Body instance = new Body(inR, inV, 1.5, 10);
        Vector result = instance.forceFrom(b);
        
        double[] delta = {-0.5, -0.5};
        Vector expDelta = new Vector(delta);
        double expDist = Math.sqrt(((-0.5)*(-0.5)) + ((-0.5)*(0.5)));
        double expF = G * 1.0 * 1.5 / (expDist * expDist) ;
        double firstFactor = 1.0/expDist;
        double secondFactor = expF;
        double[] d = {-0.5*firstFactor*secondFactor, -0.5*firstFactor*secondFactor};
        Vector expResult = new Vector(d);
        
        assertArrayEquals(expResult, result);       
    } //testForceForm()
    
    

//    /**
//     * Test of draw method, of class Body.
//     * ?????: I do not how to test this one? compare what?
//     */
//    @Test
//    public void testDraw() {
//        System.out.println("draw");
//        
//        Body instance = null;
//        instance.draw();
//        
//    }
    
    

    /**
     * Test of bouncing method, of class Body.
     */
    @Test
    public void testBouncing() {
        System.out.println("bouncing");
        double boundary = 1.0;
        double[] a = {1.1, 0.2};
        double[] b = {1.0, 1.0};
        Vector r = new Vector(a);
        Vector v = new Vector(b);
        
        double[] er = {1.1 * -0.9, 0.2};
        double[] ev = {-1.0, 1.0};
        Vector expR = new Vector(er);
        Vector expV = new Vector(ev);
        Body expBody = new Body(expR, expV, 1.0, 10);
        Body instance = new Body(r, v, 1.0, 10);
        instance.bouncing(boundary);               
        assertArrayEquals(expR, r);
        assertArrayEquals(expV, v);
    } //testBouncing  
    
    
    
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
   
}
