/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import com.mycompany.tasksbeforecupcake.Image;
import com.mycompany.tasksbeforecupcake.Ingredience;
import com.mycompany.tasksbeforecupcake.Rating;
import com.mycompany.tasksbeforecupcake.Recipe;
import com.mycompany.tasksbeforecupcake.User;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rasmus2
 */
public class DataAccessObject {
    
    public List<Recipe> retrieveAllRecipe() throws Exception {
        DBConnector conn = new DBConnector();
        String query = "SELECT * FROM testbeforecupcakes.recipe;";

        Connection connection = conn.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int idRecipe = 0;
        String rname = "";
        String instructions = "";
        List<Recipe> reca = new ArrayList();

        while (rs.next()) {
            idRecipe = rs.getInt("idRecipe");
            rname = rs.getString("name");
            instructions = rs.getString("instructions");
            reca.add(new Recipe(idRecipe,rname,instructions));
        }
        return reca;
    }
    
    public Recipe retrieveRecipe(String name) throws Exception {
        DBConnector conn = new DBConnector();
        String query = "SELECT * FROM recipe WHERE name = '" + name + "';";

        Connection connection = conn.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int idRecipe = 0;
        String rname = "";
        String instructions = "";
        Recipe rec = null;

        while (rs.next()) {
            idRecipe = rs.getInt("idRecipe");
            rname = rs.getString("name");
            instructions = rs.getString("instructions");
            rec = new Recipe(idRecipe,rname,instructions);
        }
        return rec;
    }
    
    public Image retrieveImage(String name) throws Exception {
        DBConnector conn = new DBConnector();
        String query = "SELECT image.* FROM testbeforecupcakes.recipe, testbeforecupcakes.recipe_has_images, testbeforecupcakes.image WHERE recipe.idRecipe = recipe_has_images.recipe_id AND recipe_has_images.image_id = image.idImage AND recipe.name = '" + name + "';";

        Connection connection = conn.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int idImage = 0;
        String image_path = "";
        Image im = null;

        while (rs.next()) {
            idImage = rs.getInt("idImage");
            image_path = rs.getString("image_path");
            im = new Image(idImage,image_path);
        }
        return im;
    }
    
    public User retrieveUser(String name) throws Exception {
        DBConnector conn = new DBConnector();
        String query = "SELECT user.* FROM testbeforecupcakes.recipe, testbeforecupcakes.user_has_recipe, testbeforecupcakes.user WHERE recipe.idRecipe = user_has_recipe.recipe_id AND user_has_recipe.user_id = user.idUser AND recipe.name = '" + name + "';";

        Connection connection = conn.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int idUser = 0;
        String uname = "";
        String password = "";
        User us = null;

        while (rs.next()) {
            idUser = rs.getInt("idUser");
            uname = rs.getString("name");
            password = rs.getString("password");
            us = new User(idUser,uname,password);
        }
        return us;
    }
    
    public List<Ingredience> retrieveIngredience(String name) throws Exception {
        DBConnector conn = new DBConnector();
        String query = "SELECT ingredience.* FROM testbeforecupcakes.recipe, testbeforecupcakes.recipe_has_ingredience, testbeforecupcakes.ingredience WHERE recipe.idRecipe = recipe_has_ingredience.recipe_id AND recipe_has_ingredience.ingredience_id = ingredience.idingredience AND recipe.name = '" + name + "';";

        Connection connection = conn.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int idingredience = 0;
        String inname = "";
        List<Ingredience> in = new ArrayList();

        while (rs.next()) {
            idingredience = rs.getInt("idingredience");
            inname = rs.getString("name");
            in.add(new Ingredience(idingredience,inname));
        }
        return in;
    }
    
    public List<Rating> retrieveReview(String name) throws Exception {
        DBConnector conn = new DBConnector();
        String query = "SELECT rating.* FROM testbeforecupcakes.recipe, testbeforecupcakes.recipe_has_rating, testbeforecupcakes.rating WHERE recipe.idRecipe = recipe_has_rating.recipe_id AND recipe_has_rating.rating_id = rating.idRating AND recipe.name = '" + name + "';";

        Connection connection = conn.getConnection();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        
        int idRating = 0;
        int value = 0;
        String decription = "";
        List<Rating> re = new ArrayList();

        while (rs.next()) {
            idRating = rs.getInt("idRating");
            value = rs.getInt("value");
            decription = rs.getString("decription");
            re.add(new Rating(idRating,value,decription));
        }
        return re;
    }
    
    public static void main(String[] args) throws Exception {
        DataAccessObject t = new DataAccessObject();
        Recipe r = t.retrieveRecipe("bananapie");
        System.out.println(r.toString());
    }
}
