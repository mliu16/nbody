
package nbody;

import edu.princeton.cs.StdDraw;
import java.awt.Color;


public class Stars {
    
    private double x;
    private double y;
    private double r;
    
    public Stars(double x, double y, double r){
        this.x = x;
        this.y = y;
        this.r = r;
    } //Stars
    
     public void draw() {       
        x = Math.random() * 2 - 2;
        y = Math.random() * 2 - 2;
        r = 0.001 * Math.random() * 0.004;        
        StdDraw.setPenColor(Color.WHITE);  
        StdDraw.filledCircle(x, y, r);  

    } // draw()
    
}
