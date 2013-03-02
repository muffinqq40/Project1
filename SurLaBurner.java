/*
 * Here is my take on Project 1. 
 * 
 * I've also included the test routines.
 * 
 * This main class reads in the file and has a short interaction with the
 * chef.
 * 
 * Please feel free to use this as a basis for the other projects this year that
 * will be based upon this project. (Also feel free to use your own!)
 */
package drs;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dave
 */
public class SurLaBurner {
    
    public static void main(String[] args)  throws Exception {
        Scanner sc = new Scanner(new File("recipes.txt"));
        RecipeBox rb = new RecipeBox(sc);
        
        ArrayList<String> titles = rb.getTitles();
        for (String s : titles)  {
            System.out.println(s);
        }
        
        
        System.out.println("What do you want to make?");
        Scanner kb = new Scanner(System.in);
        String choice = kb.nextLine().trim();
        Recipe r = rb.getRecipeWithTitle(choice);
        System.out.println(r);
        
    }
    
}
