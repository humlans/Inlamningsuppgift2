package handelsakademin.oop;

import java.util.ArrayList;

public class Animal extends Entity{
    private String species;
    private ArrayList<String> acceptableCropTypes = new ArrayList<>();
    private static int nextId = 1;

    //The constructor of the crop and animal is very similar except that the animal also takes an arraylist.
    public Animal (String name, String species, ArrayList<String> acceptableCropTypes) {
        super(name);
        id = nextId;
        nextId ++;
        this.species = species;
        this.acceptableCropTypes = acceptableCropTypes;
    }

    // Because of animals that are saved in the files there is another constructor that also takes the id.
    public Animal(int id, String name, String species, ArrayList<String> acceptableCropTypes){
        super(name);
        this.id = id;
        this.species = species;
        this.acceptableCropTypes = acceptableCropTypes;
    }

    @Override
    public String getDescription(){
        return ("Id: " + getId() + ", Name: " + name + ", Species: " + species + ", Diet: " + getAcceptableCropTypesCSV(", "));
    }

    // The feed function checks if the animal has the crop in their diet
    // and then if there were enough amount of the chosen crop.
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

    // This will return a string made from the acceptableCropTypes list
    // separated by a string chosen from the place where it is called through the delimiter variable.
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

    // Returns a string separated by ',' and '@'
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
