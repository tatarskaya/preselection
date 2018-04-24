package task4.db;

import org.apache.derby.jdbc.EmbeddedDriver;
import task4.Ingredient;
import task4.IngredientDataSource;
import task4.exceptions.EmptyResultSet;
import task4.exceptions.WrongIngredientName;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class IngredientDB implements IngredientDataSource {
    private String url = "jdbc:derby:my_db;create=true;user=me;password=mine";

    private void createDB() {
        try {
            DriverManager.registerDriver(new EmbeddedDriver());
            Connection connection = DriverManager.getConnection(url);
            Statement statement = connection.createStatement();
            try {
                statement.executeQuery("SELECT * FROM ingredients");
            }
            catch (SQLSyntaxErrorException ex) {
                statement.executeUpdate("CREATE TABLE ingredients ( ID int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), NAME varchar(255) NOT NULL, COLOR varchar(255) NOT NULL, COUNTRY varchar(255) NOT NULL, CALORICITY double NOT NULL )");
                statement.addBatch("INSERT INTO ingredients (NAME, COLOR, COUNTRY, CALORICITY) VALUES ('Cucumber', 'Green', 'Belarus', 15)");
                statement.addBatch("INSERT INTO ingredients (NAME, COLOR, COUNTRY, CALORICITY) VALUES ('Paprika', 'Yellow', 'Spain', 30)");
                statement.addBatch("INSERT INTO ingredients (NAME, COLOR, COUNTRY, CALORICITY) VALUES ('Tomato', 'Red', 'Italy', 20)");
                statement.executeBatch();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Ingredient> getIngredients(List<Class> ingredientsName) {
        String sql = "SELECT * FROM ingredients WHERE name=?";
        List <Ingredient> ingredients = new ArrayList<>();

        createDB();
        try {
            DriverManager.registerDriver(new EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try (
                Connection connection = DriverManager.getConnection(url);
                PreparedStatement statement = connection.prepareStatement(sql);
        )   {
            for (Class className : ingredientsName) {
                ingredients.add(ingredientInitialization(className, statement));
            }
            printSaladIngredients(ingredients);
        } catch (SQLException | EmptyResultSet | WrongIngredientName ex) {
            ex.printStackTrace();
        }
        return ingredients;
    }

    private void printSaladIngredients(List<Ingredient> salad) {
        for (Ingredient ingredient : salad) {
            System.out.println(ingredient.getName());
            System.out.println("Color: " + ingredient.getColor());
            System.out.println("Country: " + ingredient.getCountryProducing());
            System.out.println("Caloricity: " + ingredient.getCaloricity());
            System.out.println("-----------------------------------");
        }
    }

    private <T extends Ingredient> T ingredientInitialization (Class<T> className, PreparedStatement statement) throws SQLException, EmptyResultSet, WrongIngredientName {
        try {
            Ingredient obj = className.newInstance();
            ResultSet ingredientSet = getResultSet(className.getSimpleName(), statement);
            return setIngredientDetails(ingredientSet, obj);
        } catch (InstantiationException | IllegalAccessException e) {
            throw new WrongIngredientName(className.getSimpleName(), e);
        }
    }

    private <T extends Ingredient> T setIngredientDetails(ResultSet ingredientSet, Ingredient ingredient) throws SQLException {
        ingredient.setName(ingredientSet.getString(2));
        ingredient.setColor(ingredientSet.getString(3));
        ingredient.setCountryProducing(ingredientSet.getString(4));
        ingredient.setCaloricity(ingredientSet.getDouble(5));
        return (T)ingredient;
    }

    private ResultSet getResultSet(String ingredientName, PreparedStatement statement) throws SQLException {
        statement.setString(1, ingredientName);
        ResultSet ingredient = statement.executeQuery();
        ingredient.next();
        return ingredient;
    }
}
