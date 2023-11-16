package handelsakademin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {

    ArrayList <Animal> animalList;

    Scanner scanner = new Scanner(System.in);

    // There is a lis that I haven't added yet, look it over
    public void animalMenu(ArrayList<Animal> animalList, ArrayList <Crop> cropList){

        this.animalList = animalList;
        String input = "";

        do {
            System.out.println("ANIMAL MENU");
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
                    feedAnimal(cropList);
                    break;
                case "5":
                    System.out.println("You will be directed to the main menu.");
                    break;
                default:
                    System.out.println("Write a valid number.");
                    break;
            }

        } while (!input.equals("5"));
    }


    // The viewAnimals is Done!!
    // Just have to double-check if I have to remove the press enter to return to Animal Menu
    // Because I might have to use it when I add and remove animals as well...
    private void viewAnimals() {
        System.out.println("These are your animals:");
        for(Animal animal : animalList){
            System.out.println(animal.getDescription());
        }
    }

    private void addAnimal() {
        ArrayList <String> acceptableCropTypes = new ArrayList<>();
        viewAnimals();
        System.out.println("What is the name of the new animal?");
        String name = scanner.nextLine();
        System.out.println("What is the species of the new animal?");
        String species = scanner.nextLine();
        System.out.println("What does this animal eat?");
        System.out.println("Write a crop type to add to " + name + "'s diet");
        System.out.println("If you don't want to add any more crops types write quit.");
        System.out.println("Crop type:");
        String input = scanner.nextLine();
        while(!input.equalsIgnoreCase("quit")){
            acceptableCropTypes.add(input);
            System.out.println(input + " is added to " + name + "'s diet.");
            System.out.println("Write another crop type to add to the diet or write quit to stop.");
            input = scanner.nextLine();
        }
        animalList.add(new Animal(name, species, acceptableCropTypes));
        System.out.println("You have successfully added the following animal:");
        System.out.println(animalList.get(animalList.size()-1).getDescription());

    }


    private void removeAnimal() {
        viewAnimals();
        System.out.println("Which animal would you like to remove? Write the id:");
        try{
            int idToRemove = Integer.parseInt(scanner.nextLine());
            for(int i = 0; i <= animalList.size(); i++){
                if(idToRemove == animalList.get(i).getId()){
                    System.out.println("The following animal has been removed:");
                    System.out.println(animalList.get(i).getDescription());
                    animalList.remove(i);
                    break;
                }
            }
        }
        catch (Exception e){
            System.out.println("Please write a valid id to remove an animal.");
        }
    }

    private void feedAnimal(ArrayList<Crop> cropList){
        viewAnimals();
        System.out.println("Which animal would you like to feed?");
        System.out.println("Write their id: ");
        String input = scanner.nextLine();
        int chosenAnimalId = 0;
        boolean correctAnimalId = false;
        do {
            try {
                chosenAnimalId = Integer.parseInt(input);
                for(int i = 0; i <= animalList.size(); i++){
                    if(animalList.get(i).getId() == chosenAnimalId){
                        chosenAnimalId = i;
                        correctAnimalId = true;
                        System.out.println("You have chosen to feed " + animalList.get(i).getName() + ".");
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Write a valid animal id");
            }
        } while(!correctAnimalId);
        System.out.println("With what crop would you like to try feeding it?");
        for(Crop crop: cropList){
            System.out.println(crop.getDescription());
        }
        System.out.println("Write the crops id: ");
        input = scanner.nextLine();
        int chosenCropId = 0;
        boolean correctCropId = false;
        try{
            chosenCropId = Integer.parseInt(input);
            for(int i = 0; i <= cropList.size(); i++){
                if(cropList.get(i).getId() == chosenCropId){
                    chosenCropId = i;
                    correctCropId = true;
                    System.out.println("You have chosen to try feeding with " + cropList.get(i).getName());
                    break;
                }
            }
        }
        catch(Exception e){
            System.out.println("Write a valid crop id.");
        }
        animalList.get(chosenAnimalId).feed(cropList.get(chosenCropId));

    }


}
