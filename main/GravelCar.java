package main;

public class GravelCar extends RallyCar {
    private double suspensionTravel;
    public GravelCar(String make, String model, int horsepower, double suspensionTravel) {
        super(make, model, horsepower);
        this.suspensionTravel = suspensionTravel;
    }
    
    public double getSuspensionTravel() {
        return suspensionTravel;
    }

    @Override
    public double calculatePerformance() {
        double performance = suspensionTravel * 0.90;
        return Double.parseDouble(String.format("%.1f", performance));
    }
}


