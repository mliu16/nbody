package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;

public class Star {

    private final double x;
    private final double y;
    private final double r;

    public Star(double x, double y, double r) {
        this.x = x;
        this.y = y;
        this.r = r;
    } //Stars

    public void draw() {
        int a = (int) (65 + Math.random()*190);
        Color color = new Color(a, a, a);
        StdDraw.setPenColor(color);
        StdDraw.setPenRadius(r);
        StdDraw.point(x, y);

    } // draw()   

} // Stars
