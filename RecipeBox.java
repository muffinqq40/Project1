/*
 * A recipe box has a list of recipies in it and knows how to 
 * thumb through them for some answers.
 */
package drs;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dave
 */
public class RecipeBox {
    
    private ArrayList<Recipe> recipes;
    
    /*
     * an empty recipe box - so sad
     */
    public RecipeBox() {
        recipes = new ArrayList();
    }
    
    /*
     * read in from a scanner
     */
    public RecipeBox(Scanner sc) {
        this();
        String key;
        key = sc.next();
        while (key.equals(":Recipe-title:")) {
            Recipe r = new Recipe(sc);
            addRecipe(r);
            key = sc.next();
        }
    }
            
    /*
     * adding a new recipe
     */
       
    public void addRecipe(Recipe aRecipe) {
        recipes.add(aRecipe);
    }
    
    public String toString() {
        String ret = "Recipe Box\n";
        for (Object o : recipes) {
            Recipe r = (Recipe) o;
            ret += r + "\n";
        }
        return ret;
    }

    /*
     * someday, this may populate a drop down menu or
     * a combo box
     */
    ArrayList<String> getTitles() {
        ArrayList<String> titles = new ArrayList<>();
        for (Recipe r : recipes) {
            titles.add(r.getTitle());
        }
        return titles;
    }

    /*
     * find a particular title. Later on, we should add methods that get
     * certain cusines, weight loss, etc.
     */
    Recipe getRecipeWithTitle(String choice) {
        for(Recipe r : recipes) {
            if (r.getTitle().equals(choice)) return r;
        }
        return null;
    }
    
}
