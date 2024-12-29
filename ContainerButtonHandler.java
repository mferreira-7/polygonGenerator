//FERRE62305
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;

class ContainerButtonHandler implements ActionListener {
    ContainerFrame theApp;   // Reference to ContainerFrame object

    // ButtonHandler constructor
    ContainerButtonHandler(ContainerFrame app ) {
        theApp = app;
    }

    public void clearTextFields(){ //method to clear all text fields
        theApp.Color_Field.setText("");
        theApp.Number_Of_Sides_Field.setText("");
        theApp.Starting_Angle_Field.setText("");
        theApp.Radius_Field.setText("");
        theApp.Polygon_ID_Field.setText("");
    }

    public void actionPerformed(ActionEvent e) {

        if( e.getSource()==theApp.addButton) {
            try {parseInt(theApp.Polygon_ID_Field.getText());} //validate that input can be parsed to an int
            catch (Exception D) {System.out.println("Polygon was not added, PolygonID must be an integer");}
            if (parseInt(theApp.Polygon_ID_Field.getText()) > 99999 && parseInt(theApp.Polygon_ID_Field.getText()) < 10000000 ) { //validate that input is 6 digits
                boolean unique = true;
                for (RegPolygon x:theApp.polygonList) {
                    if (x.pId == parseInt(theApp.Polygon_ID_Field.getText())) {
                        unique = false;
                    }
                }
                if (unique) { //validate that input is unique
                    int validID = parseInt(theApp.Polygon_ID_Field.getText());
                    try {parseInt(theApp.Number_Of_Sides_Field.getText());} //validate that input can be parsed to an int
                    catch (Exception NOS) {
                        System.out.println("Polygon was not added, number of sides must be an integer");
                    }
                    if (!(parseInt(theApp.Number_Of_Sides_Field.getText()) > 2)){ //validate that input can create a valid closed shape
                        System.out.println("Polygon was not added, number of sides must be 3+");
                    } else {
                        int validNOS = parseInt(theApp.Number_Of_Sides_Field.getText());
                        try {parseDouble(theApp.Starting_Angle_Field.getText());} //validate that input can be parsed to a double
                        catch (Exception SA) {System.out.println("Polygon was not added, starting angle must be an integer or a double");}
                        if (parseDouble(theApp.Starting_Angle_Field.getText()) > 0){ //validate that input is valid shape angle
                            double validSA = parseDouble(theApp.Starting_Angle_Field.getText());
                            try {parseDouble(theApp.Radius_Field.getText());} //validate that input can be parsed to a double
                            catch (Exception R) {System.out.println("Polygon was not added, radius must be an integer or a double");}
                            if (parseDouble(theApp.Radius_Field.getText()) > 0){ //validate that input is a valid shape radius
                                double validR = parseDouble(theApp.Radius_Field.getText());
                                if (MyColor.getColor(theApp.Color_Field.getText()) == null){
                                    System.out.println("Polygon was not added, color must be valid"); //validate that input can be mapped to a valid color
                                } else {
                                    Color validC = MyColor.getColor(theApp.Color_Field.getText());
                                    MyColor.color = null;
                                    theApp.polygonList.add(new RegPolygon(validNOS, validSA, validR, validID, validC)); //create polygon object using validate inputs
                                    System.out.println("Polygon " + validID + " was added");
                                    clearTextFields();
                                }
                            } else {
                                System.out.println("Polygon was not added, radius cannot be zero");
                            }
                        } else {
                            System.out.println("Polygon was not added, starting angle cannot be zero");
                        }
                    }

                } else {
                    System.out.println("Polygon was not added, PolygonID must be unique");
                }
            } else {
                System.out.println("Polygon was not added, PolygonID must be a valid six digit integer");
            }

        }

        if( e.getSource()==theApp.displayButton) { //display button implementation
            System.out.println();
            System.out.println("UNSORTED LIST OF POLYGONS:");
            for (RegPolygon x: theApp.polygonList) { //iterate through polygon list, print each object's string representation
                System.out.println(x.toString());
            }
            clearTextFields();
        }

        if( e.getSource()==theApp.searchButton) { //search button implementation
            boolean found = false;
            for (RegPolygon x: theApp.polygonList) {
                if (x.pId == parseInt(theApp.Polygon_ID_Field.getText())){ //iterate and find the polygon that's id matches the field value
                    theApp.drawSelection = x.pId;
                    System.out.println();
                    System.out.println("Polygon " + x.pId + " was drawn");
                    clearTextFields();
                    found = true;
                    break;
                }
            }
            if (!found) { //if id match is not found
                System.out.println();
                System.out.println("Polygon was not drawn, PolygonID not found");
            }
        }

        if( e.getSource()==theApp.sortButton) { //sort button implementation
            System.out.println();
            System.out.println("SORTED LIST OF POLYGONS:");
            Collections.sort(theApp.polygonList, RegPolygon::compareTo);
            for (RegPolygon x: theApp.polygonList) { //iterate through sorted list, printing each item
                System.out.println(x.toString());
            }
            clearTextFields();
        }

        theApp.repaint();

    }

}

