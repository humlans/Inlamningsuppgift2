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

    public void feed(Crop crop){
        boolean acceptedCropType = false;
        for(int i = 0; i < acceptableCropTypes.size(); i++){
            if(acceptableCropTypes.get(i).equals(crop.getCropType())){
                acceptedCropType = true;
                boolean successfulFeed = crop.takeCrop(1);
                if(successfulFeed){
                    System.out.println("You have successfully fed " + crop.getName() + " to your animal.");
                }
                else {
                    System.out.println("The feeding was unsuccessful because the quantity of the crop was too low.");
                }
                break;
            }
        }
        if(!acceptedCropType){
            System.out.println("The feeding was unsuccessful because the animal doesn't have that crop type in it's diet.");
        }
    }

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
