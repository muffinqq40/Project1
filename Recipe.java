/*
 * Keep track of a recipe - human details as well as
 * ingredients and the steps necessary to create
 */

package drs;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Dave
 */
public class Recipe {
    private String title;
    private String description;
    private ArrayList<Ingredient> ingredients;
    private ArrayList<String> steps;
   
    
    /*
     * create an empty recipe
     */
    public Recipe() {
        ingredients = new ArrayList<>();
        steps = new ArrayList<>();
    }
    
    /*
     * create a recipe from a scanner
     */
    public Recipe(Scanner sc) {
        this();
        // read in the recipe. The words "Recipe-title: have already been read
        
        title = sc.nextLine().trim();
        sc.next();
        description = sc.nextLine().trim();
        String tag = sc.next();
        while (tag.equals(":Ingredient-name:")) {
            Ingredient i = new Ingredient(sc);
            ingredients.add(i);
            tag = sc.next();
        }
        
        while (tag.equals(":Step:")) {
            String s = sc.nextLine().trim();
            steps.add(s);
            tag = sc.next();
        }
        
        // I'm pretty sure tag is :END-OF-RECIPE:
        sc.nextLine();
        
    }

    String getTitle() {
        return title;
    }

    /*
     * return a copy of the ingredients so that ther is no
     * messing around.
     */
    ArrayList<Ingredient> getIngredients() {
        return new ArrayList<>(ingredients);
    }
    
        public String toString() {
        String ret = title + "\n" + description + "\n" + "Ingredients:\n";
        
        for (Ingredient i : ingredients) {
            ret += i + "\n";
        }
        ret += "Steps\n";
        int n = 1;
        for (String s : steps) {
            ret += n + ": " + s + "\n";
            n++;
        }
        return ret;
    }
    


    /// from netbeans
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.title);
        hash = 29 * hash + Objects.hashCode(this.description);
        hash = 29 * hash + Objects.hashCode(this.ingredients);
        hash = 29 * hash + Objects.hashCode(this.steps);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Recipe other = (Recipe) obj;
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.ingredients, other.ingredients)) {
            return false;
        }
        if (!Objects.equals(this.steps, other.steps)) {
            return false;
        }
        return true;
    }
    
    
}
