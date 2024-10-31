import java.util.Scanner;

public class LinearEquationLogic {
    private Scanner scanner;




    public LinearEquationLogic() {
        scanner = new Scanner(System.in);
    }




    public void start() {
        boolean repeat = true;
        System.out.println("Welcome to the Linear Equation Calculator!");




        while (repeat) {
            System.out.println("Please enter two coordinate points in the format (x, y):");




            String firstPoint = getCoordinatePoint("First");
            int[] firstCoordinates = parseCoordinates(firstPoint);
            int x1 = firstCoordinates[0];
            int y1 = firstCoordinates[1];




            String secondPoint = getCoordinatePoint("Second");
            int[] secondCoordinates = parseCoordinates(secondPoint);
            int x2 = secondCoordinates[0];
            int y2 = secondCoordinates[1];




            LinearEquation equation = new LinearEquation(x1, y1, x2, y2);




            if (equation.isVertical()) {
                System.out.println("The line is vertical with equation x = " + x1);
            } else {
                System.out.println(equation.lineInfo());




                System.out.println("Enter an x value to solve for the corresponding y:");
                double xValue = scanner.nextDouble();
                double yValue = Double.parseDouble(equation.coordinateForX(xValue));
                System.out.println("The point on the line is: (" + xValue + ", " + yValue + ")");
            }




            System.out.println("Do you want to enter another pair of coordinates? (yes/no)");
            repeat = scanner.next().equalsIgnoreCase("yes");
        }



        System.out.println("Goodbye!");
    }




    private String getCoordinatePoint(String pointOrder) {
        System.out.println("Enter the " + pointOrder + " point:");
        return scanner.nextLine();
    }




    private int[] parseCoordinates(String coordinate) {
        coordinate = coordinate.replace("(", "").replace(")", "");
        String[] values = coordinate.split(", ");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        return new int[]{x, y};
    }
}
