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
            
            StdDraw.setPenColor(Color.WHITE);
            StdDraw.setPenRadius(r);
            StdDraw.point(x, y);
            
    } // draw()   

} // Stars
