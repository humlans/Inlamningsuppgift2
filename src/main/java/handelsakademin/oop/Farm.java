package handelsakademin.oop;

import java.io.File;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Scanner;

public class Farm {
    Scanner scanner = new Scanner(System.in);

    ArrayList <Crop> cropList = new ArrayList<>();
    ArrayList <Animal> animalList = new ArrayList<>();
    public Farm() {
        // Add if-sats when there is already a file with saved object to take those instead of adding new ones
        if (true){
            beginningAddAnimals();
            beginningAddCrops();
        }
        else{
            System.out.println("Do a function for turning the information in the files into objects and run it here, to create lists?");

        }

    }

    public void mainMenu(){

        boolean running = true;

        while (running) {

            System.out.println("1. Go to the Animal Menu");
            System.out.println("2. Go to the Crop Menu");
            System.out.println("3. Save the animals and crops in files");
            System.out.println("4. Quit");
            System.out.println("Choose what you want to do: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    System.out.println("You will now be directed to the Animal Menu.");
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    AnimalManager animalManager = new AnimalManager();
                    animalManager.animalMenu(animalList, cropList);
                    break;

                case "2":
                    System.out.println("You will now be directed to the Crop Menu.");
                    System.out.println("Press enter to continue...");
                    scanner.nextLine();
                    CropManager cropManager = new CropManager();
                    cropManager.cropMenu(cropList);
                    break;

                case "3":
                    break;

                case "4":
                    System.out.println("Did you remember to save before quitting?");
                    System.out.println("Any unsaved progress will disappear after quitting.");
                    System.out.println("If you want to save write yes, any other text will not save the program: ");
                    String answer = scanner.nextLine();
                    if(answer.equalsIgnoreCase("yes")){
                        save();
                        System.out.println("Your progress has now been saved.");
                    }
                    System.out.println("You have chosen to quit the farm application.");
                    System.out.println("Goodbye");
                    running = false;
                    break;

                default:
                    System.out.println("Write one of the existing numbers from the menu");
                    break;

            }
        }
    }

    // Not done
    // Friday
    private void save(){
        File theFolder = new File("theFolder");
        File animalFile = new File("animalFile");
        File cropFile = new File("cropFile");

        if(theFolder.exists()){
            if(animalFile.exists()){

            }
            else{

            }
            if(cropFile.exists()){

            }
            else{

            }
        }
        else{

        }

    }

    // I have to solve the problem of the list being more dynamic and being able to change between the animals...
    private void beginningAddAnimals(){
        ArrayList <String> acceptableCropTypes = new ArrayList<>();
        acceptableCropTypes.add("Vegetable");

        animalList.add(new Animal("Leonard", "Horse", acceptableCropTypes));
        animalList.add(new Animal("Otto", "Pig", acceptableCropTypes));
        animalList.add(new Animal("Pluto", "Chicken", acceptableCropTypes));
    }

    private void beginningAddCrops(){

        cropList.add(new Crop("Corn", "Vegetable", 50));
        cropList.add(new Crop("Pear", "Fruit", 68));
        cropList.add(new Crop("Pumpkin seed", "Seed", 200));
        cropList.add(new Crop("Spinach", "Vegetable", 13));
        cropList.add(new Crop("Sunflower seed", "Seed", 450));

    }

    // Remember to erase this before turning in project
    private void ExtraAnimalsAndCropsIfNeeded(){
        /*
        cropList.add(new Crop("Broccoli", "Vegetable", 10));
        cropList.add(new Crop("Bell pepper", "Vegetable", 4));
        cropList.add(new Crop("Leaf", "Eucalyptus", 764));
        cropList.add(new Crop("Cucumber", "Vegetable", 20));
        cropList.add(new Crop("Radish", "Vegetable", 100));
        cropList.add(new Crop("Lettuce", "Vegetable", 32));
        cropList.add(new Crop("Carrot", "Vegetable", 156));
        cropList.add(new Crop("Apple", "Fruit", 250));
        cropList.add(new Crop("Kiwi", "Fruit", 3));
        cropList.add(new Crop("Grapes", "Fruit", 149));
        cropList.add(new Crop("Banana", "Fruit", 53));
        cropList.add(new Crop("Watermelon", "Fruit", 7));


        animalList.add(new Animal("Fridtjof", "Giraffe"));
        animalList.add(new Animal("Carmencita", "Zebra"));
        animalList.add(new Animal("Roxy", "Zebra"));
        animalList.add(new Animal("Nils", "Grass Carp"));
        animalList.add(new Animal("Troy", "Pig"));
        animalList.add(new Animal("Key", "Pig"));
        animalList.add(new Animal("Beatrix", "Pig"));
        animalList.add(new Animal("Shiro", "Pig"));
        animalList.add(new Animal("Honey", "Pig"));
        animalList.add(new Animal("Piggy", "Pig"));
        animalList.add(new Animal("Mister", "Pig"));
        animalList.add(new Animal("Herbert", "Grass Carp"));
        animalList.add(new Animal("Sam", "Grass Carp"));
        animalList.add(new Animal("Missy", "Grass Carp"));
        animalList.add(new Animal("Red", "Chicken"));
        animalList.add(new Animal("Dot", "Chicken"));
        animalList.add(new Animal("Blitzen", "Reindeer"));
        animalList.add(new Animal("Santa", "Reindeer"));
        animalList.add(new Animal("Snowball", "Rabbit"));
        animalList.add(new Animal("Ducky", "Rabbit"));
        animalList.add(new Animal("Chris", "Rabbit"));
        animalList.add(new Animal("Jupiter", "Iguana"));
        animalList.add(new Animal("Alien", "Iguana"));
        animalList.add(new Animal("Grey", "Iguana"));
        animalList.add(new Animal("Baloo", "Panda"));
        animalList.add(new Animal("Boogey", "Panda"));
        animalList.add(new Animal("Nora", "Panda"));
        animalList.add(new Animal("Trixie", "Panda"));
        animalList.add(new Animal("Tulip", "Koala"));
        animalList.add(new Animal("Gandalf", "Koala"));
        */
    }
}
