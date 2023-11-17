package handelsakademin.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CropManager {

    private ArrayList <Crop> cropList;

    // In the constructor of the cropManager we check if there is anything in the cropList
    // and if it is empty some crops will be created.
    public CropManager(ArrayList<Crop> cropList) {
        this.cropList = cropList;
        if(cropList.isEmpty()){
            cropList.add(new Crop("Corn", "Vegetable", 50));
            cropList.add(new Crop("Pear", "Fruit", 68));
            cropList.add(new Crop("Pumpkin seed", "Seed", 200));
            cropList.add(new Crop("Spinach", "Vegetable", 13));
            cropList.add(new Crop("Sunflower seed", "Seed", 450));
            cropList.add(new Crop("Broccoli", "Vegetable", 10));
            cropList.add(new Crop("Salad", "Leaf", 4));
            cropList.add(new Crop("Grapes", "Fruit", 149));
            cropList.add(new Crop("Banana", "Fruit", 53));
            cropList.add(new Crop("Leaf", "Eucalyptus", 26));
        }
    }

    // The cropMenu contains all the other methods and will direct the user to them depending on what they write.
    public void cropMenu(){
        Scanner scanner = new Scanner(System.in);
        String input = "";

        do {
            System.out.println("CROP MENU");
            System.out.println("1. View crops");
            System.out.println("2. Add crops");
            System.out.println("3. Remove crops");
            System.out.println("4. Return to main menu");
            System.out.println("Choose what you want to do:");
            input = scanner.nextLine();

            switch (input){
                case "1" :
                    viewCrops();
                    break;

                case "2":
                    addCrops();
                    break;

                case "3":
                    removeCrops();
                    break;

                case "4":
                    break;

                default:
                    System.out.println("Write a valid number.");
                    break;

            }

        } while (!input.equals("4"));
    }

    // Will write out all the crops.
    private void viewCrops() {
        System.out.println("These are your crops:");
        for(Crop crop: cropList){
            System.out.println(crop.getDescription());
        }
    }

    //addCrops will either give the user the choice to write an existing crops id to increase the quantity
    // or the user can add a completely new crop by writing zero.
    private void addCrops() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        viewCrops();

        System.out.println("Write an existing crop id to increase the quantity or write 0 to add a new crop.");
        System.out.println("If you want to go back to the Crop menu write quit instead.");
        input = scanner.nextLine();
        if(!input.equalsIgnoreCase("quit")) {
            int chosenId = -1;
            try {
                chosenId = Integer.parseInt(input);
            }
            catch (Exception e) {
                System.out.println("Please write a number");
            }

            if (chosenId == 0){
                System.out.println("What is the name of the new crop?");
                String name = scanner.nextLine();

                System.out.println("What is the crop type of the new crop?");
                String cropType = scanner.nextLine();

                System.out.println("What is the quantity of this crop?");
                int quantity = -1;
                try {
                    quantity = Integer.parseInt(scanner.nextLine());
                }
                catch (Exception e){
                    System.out.println("Please write a number");
                }

                if(!name.isEmpty() && !cropType.isEmpty() && quantity >= 0) {
                    cropList.add(new Crop(name, cropType, quantity));
                    System.out.println("You have successfully added the following crop:");
                    System.out.println(cropList.get(cropList.size() - 1).getDescription());
                }
                else{
                    System.out.println("Could not add a new crop because of missing information.");
                    System.out.println("Try again.");
                }
            }
            else if(chosenId > 0) {
                boolean foundCrop = false;
                for(int i = 0; i < cropList.size(); i++){
                    int tempId = cropList.get(i).getId();
                    if (tempId == chosenId){
                        System.out.println("How many crops would you like to add?");
                        input = scanner.nextLine();
                        int quantity = -1;
                        try {
                            quantity = Integer.parseInt(input);
                        }
                        catch (Exception e){
                            System.out.println("Please write a number");
                        }

                        if(quantity > 0) {
                            cropList.get(i).addCrop(quantity);
                        }
                        foundCrop = true;
                    }
                }

                if(!foundCrop){
                    System.out.println("There is no crop with that id.");
                }

            }
        }
    }

    // removeCrop will remove a crop from the cropList by using a chosen id.
    private void removeCrops() {
        Scanner scanner = new Scanner(System.in);
        String input = "";

        viewCrops();
        System.out.println("Which crop would you like to remove? Write the id:");
        input = scanner.nextLine();
        try{
            boolean foundCrop = false;
            int idToRemove = Integer.parseInt(input);
            for(int i = 0; i < cropList.size(); i++){
                if(idToRemove == cropList.get(i).getId()){
                    System.out.println("The following crop has been removed:");
                    System.out.println(cropList.get(i).getDescription());
                    cropList.remove(i);
                    foundCrop = true;
                    break;
                }
            }
            if(!foundCrop){
                System.out.println("There is no crop with that id.");
            }
        }
        catch (Exception e){
            System.out.println("Please write a valid id to remove a crop.");
        }
    }

    public ArrayList<Crop> getCrops(){
        return cropList;
    }

}
