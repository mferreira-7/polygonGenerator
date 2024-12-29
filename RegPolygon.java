//FERRE62305
import java.awt.*;

public class RegPolygon implements Comparable<RegPolygon>{

    Color pColor; // Colour of the polygon, set to a Colour object, default set to black
    int pId = 000000;           // Polygon ID should be a six digit non-negative integer
    int pSides;                 // Number of sides of the polygon, should be non-negative value
    double pStarting_angle;     // starting angle
    double pRadius;             // radius of polygon

    int polyCenX;       // x value of centre point (pixel) of polygon when drawn on the panel
    int polyCenY;       // y value of centre point (pixel of polygon when drawn on the panel
    double [] pointsX;  // int array containing x values of each vertex (corner point) of the polygon
    double [] pointsY;  // int array containing y values of each vertex (corner point) of the polygon

    public RegPolygon(int p_sides, double st_angle, double rad, int p_id, Color color) {

        this.pSides = p_sides;              // user defined number of sides should be non-negative
        this.pStarting_angle = st_angle;    // user defined starting angle
        this.pRadius = rad;                 // user defined radius
        this.pId = p_id;                    // user defined polygon ID
        this.pColor = color;                // user defined polygon color
        pointsX = new double[pSides];       // list of doubles to store the x value of each corner point
        pointsY = new double[pSides];       // list of doubles to store the y value of each corner point

    }

    private Polygon getPolygonPoints(Dimension dim) {

        polyCenX = dim.width / 2;                      // x value of centre point of the polygon
        polyCenY = dim.height / 2;                     // y value of centre point of the polygon
        double angleIncrement = 2 * Math.PI / pSides;  // increment of each angle
        Polygon p = new Polygon();                     // Polygon to be drawn

        // Compute coordinates for n-sided regular polygon of given radius and start angle
        for (int i = 0; i < pSides; i++) {
            pointsX[i] = polyCenX + pRadius * Math.cos(pStarting_angle);
            pointsY[i] = polyCenY + pRadius * Math.sin(pStarting_angle);
            p.addPoint((int) pointsX[i], (int) pointsY[i]);
            pStarting_angle = pStarting_angle + angleIncrement;
        }

        return p;

    }


    //method to set the colour of the Polygon to be drawn
    public void drawPolygon(Graphics2D g, Dimension d) {
        g.setColor(pColor);
        g.drawPolygon(getPolygonPoints(d));
    }


    // gets a stored ID
    public int getID() {
        return pId;
    }


    @Override
    // method used for comparing PolygonContainer objects based on stored ids
    public int compareTo(RegPolygon o) {
        if (pId == o.pId){return 0;}
        else if (pId > o.pId){return 1;}
        else {return -1;}
    }


    // outputs a string representation of the PolygonContainer object
    public String toString() {return "A "+MyColor.getColor(pColor)+" polygon with "+pSides+" sides, a starting angle of "+pStarting_angle+", a radius of "+pRadius+" and it's ID is "+pId;}
}
