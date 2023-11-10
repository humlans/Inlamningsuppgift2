package handelsakademin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class CropManager {

    ArrayList <Crop> cropList;
    Scanner scanner = new Scanner(System.in);
    String input = "";

    public void cropMenu(ArrayList<Crop> cropList){
        this.cropList =  cropList;

        do {
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
                    System.out.println("Please press enter");
                    scanner.nextLine();
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
            String cropDescription = crop.getDescription();
            System.out.println(cropDescription);
        }
        System.out.println("\nPress enter to return to Crop Menu...");
        scanner.nextLine();
    }

    private void addCrops() {
    }

    private void removeCrops() {
    }

}
