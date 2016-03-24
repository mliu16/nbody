package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;
import java.util.LinkedList;

/**
 * ****************************************************************************
 * Compilation: javac Body.java Execution: java Body Dependencies: Vector.java
 * StdDraw.java
 *
 * Implementation of a 2D Body with a position, velocity and mass.
 *
 *
 *****************************************************************************
 */
public class Body {

    private Vector r;      // position
    private Vector v;      // velocity
    private final double mass;   // mass
    private final int capture;
    private final LinkedList<Vector> pastPositions;

    //Constructor
    public Body(Vector r, Vector v, double mass, int capture) {
        this.r = r;
        this.v = v;
        this.mass = mass;
        //this.capturenew = new double[capture][2];
        this.capture = capture;
        this.pastPositions = new LinkedList<>();
    } // Body( Vector, Vector, double )

    //make bodies move and tails follow
    public void move(Vector f, double dt) {
        Vector a = f.times(1 / mass);
        v = v.plus(a.times(dt));
        r = r.plus(v.times(dt));
        update(r);

    } // move( Vector, double )

    //Update for adding tails
    private void update(Vector r) {
        // Fill pastPositions if empty
        if (pastPositions.isEmpty()) {
            for (int i = 0; i < this.capture; i++) {
                pastPositions.add(r);
            }
        }
        // Insert new position, then remove oldest one
        pastPositions.add(0, r);
        if (pastPositions.size() > this.capture) {
            pastPositions.removeLast();
        }

    } // update()

    //Fore based on gravity
    public Vector forceFrom(Body b) {
        Body a = this;
        double G = 6.67e-11;
        Vector delta = b.r.minus(a.r);
        double dist = delta.magnitude();
        double F = (G * a.mass * b.mass) / (dist * dist);
        return delta.direction().times(F);
    } // forceFrom( Body )

    //Draw bodies
    public void draw() {
        StdDraw.setPenRadius(0.025);
        int red = (int) Math.round(Math.random() * 255);
        int green = (int) Math.round(Math.random() * 255);
        int blue = (int) Math.round(Math.random() * 255);
        Color color = new Color(red, green, blue);
        StdDraw.setPenColor(color);
        StdDraw.point(r.cartesian(0), r.cartesian(1));
        StdDraw.setPenRadius(.002);

        //Draw tails
        for (int i = 0; i < pastPositions.size() - 1; i++) {
            Vector p1 = pastPositions.get(i);
            Vector p2 = pastPositions.get(i + 1);
            StdDraw.setPenRadius(0.02 * (this.capture - i)/this.capture);
            StdDraw.line(p1.cartesian(0), p1.cartesian(1), p2.cartesian(0), p2.cartesian(1));
        } //for

    } // draw()

    //Change move direction by calling x and y Backward methods in Vector
    public void bouncing(double boundary) {
        double x = r.cartesian(0);
        double y = r.cartesian(1);
        if (x >= boundary) {
            v.xBackward();
        } //if
        if (x <= -boundary) {
            v.xBackward();
        } //if
        if (y >= boundary) {
            v.yBackward();
        } //if
        if (y <= -boundary) {
            v.yBackward();
        } //if 
    } //bouncing
} // Body
