/**
 * Name: Sahil Gathe
 * ID: A16840774
 * Email: sgathe@ucsd.edu
 * Sources used:Tutors, Zybooks, and Lecture Slides
 * 
 * This file implents the Senctuary object. This object repersents a Senctuary and has hold the data values. 
 * The amount of animals and the type of animals.
 */

import java.util.HashMap;
import java.util.Set;

import org.hamcrest.core.AllOf;

/**
 * This class implments the Santuary object which repersents a animal sanctyary and keeps track
 * of the animals within said sanctuary
 */
public class Sanctuary {
    
    HashMap<String, Integer> sanctuary;
    int maxAnimals;
    int maxSpecies;

    /**
     * Santuary constructor
     * @param maxAnimals
     * @param maxSpecies
     */
    public Sanctuary(int maxAnimals, int maxSpecies) {
        if(maxAnimals < 0 || maxSpecies < 0){
            throw new IllegalArgumentException("Sencatuary Constructor");
        }
        else{
            sanctuary = new HashMap<String, Integer>();
            this.maxAnimals = maxAnimals;
            this.maxSpecies = maxSpecies;
        }
    }

    /**
     * @param species
     * @return the number of species that are in the santuary
     */
    public int getNum(String species) {
        if(sanctuary.containsKey(species)){
            if(sanctuary.get(species) == null){
                throw new IllegalArgumentException("Species valuse null in getNum");
            }
            else{
                return sanctuary.get(species);
            }
        }
        else{
            return 0;
        }
    }
    
    /**
     * @return the total number of animals in a santuary Hashset
     */
    public int getTotalAnimals() {
        int total = 0;
        for(String i: sanctuary.keySet()){
            total += sanctuary.get(i);
        }
        return total;
    }
    
    /**
     * @return total number of spcies(keys) in the santury Hashset
     */
    public int getTotalSpecies() {
        return sanctuary.size();
    }

    /**
     * Added the given species(key) with the value of num to the santury hashset
     * @param species
     * @param num
     * @return the number of animals that are not rescued.
     *         the value differnce between the max and the amount added.
     */
    public int rescue(String species, int num){
        if(num <= 0 || species == null){
            throw new IllegalArgumentException("Number of rescue is less then 1 or spices is null");
        }
        else{
            if(getTotalAnimals() + num <= maxAnimals){
                if(sanctuary.containsKey(species)){
                    sanctuary.put(species, sanctuary.get(species) + num);
                }
                else{
                    sanctuary.put(species, num);
                }
                return 0;
            }
            else{
                int notRescued = (this.getTotalAnimals() + num) - maxAnimals;
                sanctuary.put(species, maxAnimals);
                return notRescued;
            }
        }
    }

    /**
     * changes the value of the species(key) to the given value num
     * @param species
     * @param num
     */
    public void release(String species, int num) {
        if(!sanctuary.containsKey(species) || num <= 0 || num > sanctuary.get(species) || species == null){
            throw new IllegalArgumentException("Release has a illegal argumant");
        }
        else if(sanctuary.get(species) - num != 0 ){
            sanctuary.replace(species, sanctuary.get(species) - num);
        }
        else{
            sanctuary.remove(species);
        }
    }
}
