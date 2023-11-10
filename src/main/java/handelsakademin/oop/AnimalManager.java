package handelsakademin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {

    ArrayList <Animal> animalList;
    ArrayList <Crop> cropList;
    Scanner scanner = new Scanner(System.in);

    // There is a lis that I haven't added yet, look it over
    public void animalMenu(ArrayList<Animal> animalList, ArrayList <Crop> cropList){

        this.animalList = animalList;
        this.cropList = cropList;
        String input = "";

        do {
            System.out.println("1. View animals");
            System.out.println("2. Add animal");
            System.out.println("3. Remove animal");
            System.out.println("4. Feed animal");
            System.out.println("5. Return to main menu");
            System.out.println("Choose what you want to do:");
            input = scanner.nextLine();

            switch(input){
                case "1":
                    viewAnimals();
                    break;
                case "2":
                    addAnimal();
                    break;
                case "3":
                    removeAnimal();
                    break;
                case "4":
                    feedAnimal();
                    break;
                case "5":
                    System.out.println("You will be directed to the main menu.");
                    System.out.println("Please press enter to proceed");
                    scanner.nextLine();
                    break;
                default:
                    System.out.println("Write a valid number.");
                    break;
            }

        } while (!input.equals("5"));
    }


    // The viewAnimals is Done!!
    // Just have to dubble check if I have to remove the press enter to return to Animal Menu
    // Because I might have to use it when I add and remove animals as well...
    private void viewAnimals() {
        System.out.println("These are your animals:");
        for(Animal animal : animalList){
            String animalDescription = animal.getDescription();
            System.out.println(animalDescription);
        }
        System.out.println("\nPress enter to return to Animal Menu...");
        scanner.nextLine();
    }

    private void addAnimal() {
        System.out.println("Which species is your animal?");
        System.out.println("What is the name of the animal?");
        System.out.println("What does the animal eat?"); // In order to choose what it eats the crop list should be displayed.
    }
    private void removeAnimal() {
    }

    private void feedAnimal(){

    }


    // Fix so that it displays all the elements in an arraylist through a for each loop

}
