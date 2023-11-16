package handelsakademin.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CropManager {

    private ArrayList <Crop> cropList;
    private Scanner scanner = new Scanner(System.in);
    private String input = "";

    public void cropMenu(ArrayList<Crop> cropList){
        this.cropList =  cropList;

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
                    System.out.println("You will now be directed back to the main menu.");
                    break;

                default:
                    System.out.println("Write a valid number.");
                    break;

            }

        } while (!input.equals("4"));
    }

    private void viewCrops() {
        System.out.println("These are your crops:");
        for(Crop crop: cropList){
            System.out.println(crop.getDescription());
        }
    }

    private void addCrops() {
        viewCrops();
        System.out.println("Write an existing crop id to increase the quantity or write 0 to add a new crop.");
        System.out.println("If you want to go back to the Crop menu write quit instead.");
        input = scanner.nextLine();
        if(!input.equalsIgnoreCase("quit")) {
            int chosenId;
            // Should probably add a while-loop so that they can write a number and not just move forward in the method...
            // Try to reduce the amount of bird-wings within bird-wings
            try {
                chosenId = Integer.parseInt(input);
                if (chosenId == 0){
                    System.out.println("What is the name of the new crop?");
                    String name = scanner.nextLine();
                    System.out.println("What is the crop type of the new crop?");
                    String cropType = scanner.nextLine();
                    System.out.println("What is the quantity of this crop?");
                    int quantity = Integer.parseInt(scanner.nextLine());
                    cropList.add(new Crop(name, cropType, quantity));
                    System.out.println("You have successfully added the following crop:");
                    System.out.println(cropList.get(cropList.size()-1).getDescription());
                }
                else if(chosenId > 0) {
                    for(int i = 0; i <= cropList.size(); i++){
                        int tempId = cropList.get(i).getId();
                        if (tempId == chosenId){
                            System.out.println("How many crops would you like to add?");
                            input = scanner.nextLine();
                            int quantity = Integer.parseInt(input);
                            cropList.get(i).addCrop(quantity);
                            System.out.println("Successfully added " + quantity + " pieces to crop id " + chosenId);
                        }
                    }
                }
            }
            catch (Exception e) {
                System.out.println("Please write a valid number");
            }
        }
    }

    private void removeCrops() {
        viewCrops();
        System.out.println("Which crop would you like to remove? Write the id:");
        input = scanner.nextLine();
        try{
            int idToRemove = Integer.parseInt(input);
            for(int i = 0; i <= cropList.size(); i++){
                if(idToRemove == cropList.get(i).getId()){
                    System.out.println("The following crop has been removed:");
                    System.out.println(cropList.get(i).getDescription());
                    cropList.remove(i);
                    break;
                }
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
