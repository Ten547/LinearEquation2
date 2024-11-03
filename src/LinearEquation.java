public class LinearEquation {
    private int x1, y1, x2, y2;
    private boolean isVertical;

    public LinearEquation(int x1, int y1, int x2, int y2) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.isVertical = (x1 == x2);
    }

    public boolean isVertical() {
        return isVertical;
    }

    public double distance() {
        double dist = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        return roundedToHundredth(dist);
    }

    public double slope() {
        if (isVertical) {
            return Double.NaN;
        }
        return roundedToHundredth((double) (y2 - y1) / (x2 - x1));
    }

    public double yIntercept() {
        if (isVertical) {
            return Double.NaN;
        }
        return roundedToHundredth(y1 - (slope() * x1));
    }

    public String equation() {
        if (isVertical) {
            return "x = " + x1;
        }
        if (y1 == y2) {
            return "y = " + y1;
        }

        int diffY = y2 - y1;
        int diffX = x2 - x1;
        String slope = diffY + "/" + diffX;
        double intercept = yIntercept();

        if (intercept == 0) {
            return "y = " + slope + "x";
        } else if (intercept > 0) {
            return "y = " + slope + "x + " + intercept;
        } else {
            return "y = " + slope + "x - " + Math.abs(intercept);
        }
    }

    public String coordinateForX(double xValue) {
        if (isVertical) {
            return "undefined";
        }
        double yValue = slope() * xValue + yIntercept();
        return "(" + roundedToHundredth(xValue) + ", " + roundedToHundredth(yValue) + ")";
    }

    public String lineInfo() {
        if (isVertical) {
            return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                    "The equation of the line between these points is: x = " + x1 + "\n" +
                    "The distance between these points is " + distance();
        }
        return "The two points are: (" + x1 + ", " + y1 + ") and (" + x2 + ", " + y2 + ")\n" +
                "The equation of the line between these points is: " + equation() + "\n" +
                "The y-intercept of this line is: " + yIntercept() + "\n" +
                "The slope of this line is: " + slope() + "\n" +
                "The distance between these points is " + distance();
    }

    private double roundedToHundredth(double toRound) {
        return Math.round(toRound * 100.0) / 100.0;
    }
}
