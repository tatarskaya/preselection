package task2_3.chef.ingredients;

import task2_3.chef.exceptions.NegativeCaloricityException;

public abstract class Ingredient {

    private String name;
    private String color;
    private String countryProducing;
    private double caloricity;

    Ingredient (String name, String color, String countryProducing, double caloricity) throws NegativeCaloricityException {
        if (name.isEmpty()) {
            throw new IllegalArgumentException("Name is empty");
        } else if (color.isEmpty()) {
            throw new IllegalArgumentException("Color is empty");
        } else if (countryProducing.isEmpty()) {
            throw new IllegalArgumentException("Country is empty");
        } else {
            this.name = name;
            this.color = color;
            this.countryProducing = countryProducing;
        }
        if (caloricity < 0) {
            throw new NegativeCaloricityException();
        } else {
            this.caloricity = caloricity;
        }
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getCountryProducing() {
        return countryProducing;
    }

    public double getCaloricity() {
        return caloricity;
    }
}
