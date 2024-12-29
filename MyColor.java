//FERRE62305
import java.awt.Color;

public class MyColor {

    public static Color color;
    public static String color2;

    public MyColor(){ //constructor to initialise null variables
        color = null;
        color2 = null;
    }

    static Color getColor(String col) {

        switch (col.toLowerCase()) { //switch statement to map string argument to Color Object
            case "black" -> color = Color.BLACK;
            case "blue" -> color = Color.BLUE;
            case "cyan" -> color = Color.CYAN;
            case "dark gray" -> color = Color.DARK_GRAY;
            case "gray" -> color = Color.GRAY;
            case "green" -> color = Color.GREEN;
            case "yellow" -> color = Color.YELLOW;
            case "light gray" -> color = Color.LIGHT_GRAY;
            case "magenta" -> color = Color.MAGENTA;
            case "orange" -> color = Color.ORANGE;
            case "pink" -> color = Color.PINK;
            case "red" -> color = Color.RED;
            case "white" -> color = Color.WHITE;
        }

        return color;
    }

    static String getColor(Color col2) { //if statement to map Color object argument to string

        if (col2.equals(Color.BLACK)) {
            color2 = "black";
        } else if (col2.equals(Color.BLUE)) {
            color2 = "blue";
        } else if (col2.equals(Color.CYAN)) {
            color2 = "cyan";
        } else if (col2.equals(Color.DARK_GRAY)) {
            color2 = "dark gray";
        } else if (col2.equals(Color.GRAY)) {
            color2 = "gray";
        } else if (col2.equals(Color.GREEN)) {
            color2 = "green";
        } else if (col2.equals(Color.YELLOW)) {
            color2 = "yellow";
        } else if (col2.equals(Color.LIGHT_GRAY)) {
            color2 = "light gray";
        } else if (col2.equals(Color.MAGENTA)) {
            color2 = "magenta";
        } else if (col2.equals(Color.ORANGE)) {
            color2 = "orange";
        } else if (col2.equals(Color.PINK)) {
            color2 = "pink";
        } else if (col2.equals(Color.RED)) {
            color2 = "red";
        } else if (col2.equals(Color.WHITE)) {
            color2 = "white";
        }

        return color2;
    }

}

