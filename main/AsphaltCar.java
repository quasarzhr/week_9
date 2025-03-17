package main;

public class AsphaltCar extends RallyCar {
    private double downforce;
    public AsphaltCar(String make, String model, int horsepower, double downforce) {
        super(make, model, horsepower);
        this.downforce = downforce;
    }
    
    public double getDownforce() {
        return downforce;
    }

    @Override
    public double calculatePerformance() {
        double performance = downforce * 0.90;
        return Double.parseDouble(String.format("%.1f", performance));
    }
}

