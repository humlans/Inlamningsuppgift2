package handelsakademin.oop;

import java.util.ArrayList;
import java.util.Scanner;

public class AnimalManager {

    private ArrayList <Animal> animalList;

    // In the constructor for the AnimalManager, we also check to see if the list is empty.
    // If it is, a number of animals will be added to it.
    public AnimalManager(ArrayList<Animal> animalList) {
        this.animalList = animalList;
        if(animalList.isEmpty()){
            ArrayList <String> acceptableCropTypes = new ArrayList<>();
            acceptableCropTypes.add("Vegetable");
            animalList.add(new Animal("Leonard", "Horse", acceptableCropTypes));

            ArrayList <String> acceptableCropTypesPig = new ArrayList<>();
            acceptableCropTypesPig.add("Vegetable");
            acceptableCropTypesPig.add("Seed");
            animalList.add(new Animal("Otto", "Pig", acceptableCropTypesPig));
            animalList.add(new Animal("Klas", "Pig", acceptableCropTypesPig));

            ArrayList <String> acceptableCropTypesChicken = new ArrayList<>();
            acceptableCropTypesChicken.add("Seed");
            animalList.add(new Animal("Pluto", "Chicken", acceptableCropTypesChicken));
            animalList.add(new Animal("Dotty", "Chicken", acceptableCropTypesChicken));
            animalList.add(new Animal("Red", "Chicken", acceptableCropTypesChicken));

            ArrayList <String> acceptableCropTypesGiraffe = new ArrayList<>();
            acceptableCropTypesGiraffe.add("Leaf");
            animalList.add(new Animal("Fridtjof", "Giraffe", acceptableCropTypesGiraffe));

            ArrayList <String> acceptableCropTypesZebra = new ArrayList<>();
            acceptableCropTypesZebra.add("Fruit");
            acceptableCropTypesZebra.add("Vegetables");
            animalList.add(new Animal("Carmencita", "Zebra", acceptableCropTypesZebra));

            ArrayList <String> acceptableCropTypesKoala = new ArrayList<>();
            acceptableCropTypesKoala.add("Eucalyptus");
            animalList.add(new Animal("Tulip", "Koala", acceptableCropTypesKoala));
        }
    }


    // This is the animalMenu that will be run when choosing it in the Farm-class.
    public void animalMenu(ArrayList <Crop> cropList){
        Scanner scanner = new Scanner(System.in);
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
                    break;
                default:
                    System.out.println("Write a valid number.");
                    break;
            }

        } while (!input.equals("5"));
    }

    private void viewAnimals() {
        System.out.println("These are your animals:");
        for(Animal animal : animalList){
            System.out.println(animal.getDescription());
        }
    }

    // Add animal will ask the user for all the information needed to create a new animal
    // and then it will create a new animal with those variables.
    // But if any of the three variables is not given a value it cannot be created.
    private void addAnimal() {
        Scanner scanner = new Scanner(System.in);
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

        if(!name.isEmpty() && !species.isEmpty() && !acceptableCropTypes.isEmpty()) {
            animalList.add(new Animal(name, species, acceptableCropTypes));
            System.out.println("You have successfully added the following animal:");
            System.out.println(animalList.get(animalList.size() - 1).getDescription());
        }
        else{
            System.out.println("Did not add a new animal.");
            System.out.println("Please give your new animal a name, species and add something to it's diet.");
            System.out.println("Try again.");
        }

    }

    // By using the animals id, one animal is removed from animalList.
    private void removeAnimal() {
        Scanner scanner = new Scanner(System.in);

        viewAnimals();

        System.out.println("Which animal would you like to remove? Write the id:");
        try{
            int idToRemove = Integer.parseInt(scanner.nextLine());
            for(int i = 0; i < animalList.size(); i++){
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

    // The feedMethod tries to feed an animal with a crop by using their id.
    // If the cropType is a part of the animals diet and there is more than one of said crop the feeding will be successful.
    // Otherwise, a message explaining the failure will be printed.
    private void feedAnimal(ArrayList<Crop> cropList){
        Scanner scanner = new Scanner(System.in);
        String input;

        viewAnimals();

        int chosenAnimalId = 0;
        boolean correctAnimalId = false;
        do {
            System.out.println("Which animal would you like to feed?");
            System.out.println("Write their id: ");
            input = scanner.nextLine();
            try {
                chosenAnimalId = Integer.parseInt(input);
                for(int i = 0; i < animalList.size(); i++){
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
        boolean correctCropId = false;
        int chosenCropId = 0;
        do {
            System.out.println("Write the crops id: ");
            input = scanner.nextLine();
            try {
                chosenCropId = Integer.parseInt(input);
                for (int i = 0; i < cropList.size(); i++) {
                    if (cropList.get(i).getId() == chosenCropId) {
                        chosenCropId = i;
                        correctCropId = true;
                        System.out.println("You have chosen to try feeding with " + cropList.get(i).getName());
                        break;
                    }
                }
            } catch (Exception e) {
                System.out.println("Write a valid crop id.");
            }
        } while(!correctCropId);

        animalList.get(chosenAnimalId).feed(cropList.get(chosenCropId));

    }

    public ArrayList<Animal> getAnimals(){
        return animalList;
    }

}
