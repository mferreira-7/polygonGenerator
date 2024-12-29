//FERRE62305
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Dimension;

public class ContainerPanel extends JPanel{

    ContainerFrame conFrame;

    public ContainerPanel(ContainerFrame cf) {
        conFrame = cf;   // reference to ContainerFrame object
    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        Graphics2D comp = (Graphics2D)g;
        Dimension size = getSize();

        for (RegPolygon x: conFrame.polygonList) { //find the Polygon in the array that's id matches the id
            if(conFrame.drawSelection == x.pId) { //of the selected polygon to be drawn
                x.drawPolygon(comp, size);
            }
        }

    }

}
