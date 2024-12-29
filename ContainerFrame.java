//FERRE62305
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ContainerFrame extends JFrame{

    ArrayList<RegPolygon> polygonList; //Arraylist parameterized to hold only RegPolygon objects

    JButton displayButton; //Buttons
    JButton addButton;
    JButton searchButton;
    JButton sortButton;

    JTextField Number_Of_Sides_Field; //Text Fields
    JTextField Starting_Angle_Field;
    JTextField Radius_Field;
    JTextField Color_Field;
    JTextField Polygon_ID_Field;

    JLabel Number_Of_Sides_Label; //Labels
    JLabel Starting_Angle_Label;
    JLabel Radius_Label;
    JLabel Color_Label;
    JLabel Polygon_ID_Label;

    int drawSelection = 0;   // Selection variable to determine which Polygon is selected to be drawn

    public void createComponents() {

        polygonList = new ArrayList<>();

        ContainerButtonHandler cbHandler = new ContainerButtonHandler(this);

        displayButton = new JButton("Display");
        addButton = new JButton("Add");
        searchButton = new JButton("Search");
        sortButton = new JButton("Sort");

        Number_Of_Sides_Field = new JTextField(5);
        Starting_Angle_Field = new JTextField(5);
        Radius_Field = new JTextField(5);
        Color_Field = new JTextField(5);
        Polygon_ID_Field = new JTextField(5);

        Number_Of_Sides_Label = new JLabel("No. Sides:");
        Starting_Angle_Label = new JLabel("Starting Angle:");
        Radius_Label = new JLabel("Radius:");
        Color_Label = new JLabel("Color:");
        Polygon_ID_Label = new JLabel("PolygonID:");

        displayButton.addActionListener(cbHandler); //individual action listeners for buttons
        addButton.addActionListener(cbHandler);
        searchButton.addActionListener(cbHandler);
        sortButton.addActionListener(cbHandler);

        JPanel inputPanel = new JPanel(); //panels
        JPanel drawPanel = new ContainerPanel(this);
        JPanel buttPanel = new JPanel();

        inputPanel.add(Number_Of_Sides_Label); //panel components added
        inputPanel.add(Number_Of_Sides_Field);

        inputPanel.add(Starting_Angle_Label);
        inputPanel.add(Starting_Angle_Field);

        inputPanel.add(Radius_Label);
        inputPanel.add(Radius_Field);

        inputPanel.add(Color_Label);
        inputPanel.add(Color_Field);

        inputPanel.add(Polygon_ID_Label);
        inputPanel.add(Polygon_ID_Field);

        buttPanel.add(addButton);
        buttPanel.add(displayButton);
        buttPanel.add(searchButton);
        buttPanel.add(sortButton);

        add(inputPanel, BorderLayout.NORTH); //panels implicitly added to frame
        add(drawPanel, BorderLayout.CENTER);
        add(buttPanel, BorderLayout.SOUTH);

        inputPanel.setBackground(Color.LIGHT_GRAY); //GUI design
        drawPanel.setBackground(Color.GRAY);
        buttPanel.setBackground(Color.LIGHT_GRAY);

        setSize(750, 500);
        setVisible(true);
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	// Close action.
    }

    public static void main(String[] args) {

        ContainerFrame cFrame = new ContainerFrame();
        cFrame.createComponents();
    }

}
