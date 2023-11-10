package handelsakademin.oop;

import java.util.ArrayList;

public class Animal extends Entity{
    private String species;
    private ArrayList<String> acceptableCropTypes = new ArrayList<>();
    private static int nextId = 1;

    //Constructor
    public Animal (String name, String species, ArrayList<String> acceptableCropTypes) {
        super(name);
        id = nextId;
        nextId ++;
        this.species = species;
        this.acceptableCropTypes = acceptableCropTypes;
    }

    @Override
    public String getDescription(){
        String[] acceptableCropTypesList = new String[acceptableCropTypes.size()];
        return ("Id: " + getId() + ", Name: " + name + ", Species: " + species + ", Diet: " + getAcceptableCropTypesCSV(", "));
    }

    // Don't know if it works or not but maybe?
    private String getAcceptableCropTypesCSV(String delimiter){
        String string = "";
        for(int i = 0; i < acceptableCropTypes.size(); i++){
            string += acceptableCropTypes.get(i);
            if(i < acceptableCropTypes.size() -1){
                string += delimiter;
            }

        }
        return string;
    }

    // How do I get make a list into a string to write it out?
    public String getCSV(){
        return id + "," + name + "," + species + "," + getAcceptableCropTypesCSV("@");
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
