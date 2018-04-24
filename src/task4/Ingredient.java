package task4;

public abstract class Ingredient {

    private String name;
    private String color;
    private String countryProducing;
    private double caloricity;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCountryProducing() {
        return countryProducing;
    }

    public void setCountryProducing(String countryProducing) {
        this.countryProducing = countryProducing;
    }

    public double getCaloricity() {
        return caloricity;
    }

    public void setCaloricity(double caloricity) {
        this.caloricity = caloricity;
    }
}
