package handelsakademin.oop;

import java.io.*;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Farm {
    Scanner scanner = new Scanner(System.in);

    ArrayList <Crop> cropList = new ArrayList<>();
    ArrayList <Animal> animalList = new ArrayList<>();
    public Farm() {
        File animalFile = new File("animalFile.txt");
        File cropFile = new File ("cropFile.txt");

        try {



            if (!animalFile.exists()){
                beginningAddAnimals();
            }
            else {
                FileReader fileReaderAnimal = new FileReader(animalFile);
                BufferedReader bufferedReaderAnimal = new BufferedReader(fileReaderAnimal);

                String readLine = bufferedReaderAnimal.readLine();
                while(readLine != null){
                    String [] attributesAnimal = readLine.split(",");
                    String name = attributesAnimal[1];
                    String species = attributesAnimal[2];
                    String [] acceptableCrops = attributesAnimal[3].split("@");
                    ArrayList <String> acceptableCropTypes = new ArrayList<>();
                    Collections.addAll(acceptableCropTypes, acceptableCrops);

                    Animal tempAnimal = new Animal(name, species, acceptableCropTypes);
                    animalList.add(tempAnimal);
                    readLine = bufferedReaderAnimal.readLine();
                }
                bufferedReaderAnimal.close();
            }

            if (!cropFile.exists()){
                beginningAddCrops();
            }
            else {
                FileReader fileReaderCrop = new FileReader(cropFile);
                BufferedReader bufferedReaderCrop = new BufferedReader(fileReaderCrop);
                String readLine = bufferedReaderCrop.readLine();
                while(readLine != null) {
                    String[] attributesCrops = readLine.split(",");
                    String name = attributesCrops[1];
                    String cropType = attributesCrops[2];
                    int quantity = Integer.parseInt(attributesCrops[3]);

                    Crop tempCrop = new Crop(name, cropType, quantity);
                    cropList.add(tempCrop);
                    readLine = bufferedReaderCrop.readLine();
                }
                bufferedReaderCrop.close();
            }

        }
        catch (IOException e) {
            System.out.println("Could not read from files...");
        }

    }

    public void mainMenu(){

        boolean running = true;

        while (running) {
            System.out.println("MAIN MENU");
            System.out.println("1. Go to the Animal Menu");
            System.out.println("2. Go to the Crop Menu");
            System.out.println("3. Save the animals and crops in files");
            System.out.println("4. Quit");
            System.out.println("Choose what you want to do: ");
            String input = scanner.nextLine();

            switch (input) {
                case "1":
                    AnimalManager animalManager = new AnimalManager();
                    animalManager.animalMenu(animalList, cropList);
                    break;

                case "2":
                    CropManager cropManager = new CropManager();
                    cropManager.cropMenu(cropList);
                    break;

                case "3":
                    save();
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
    private void save(){
        File animalFile = new File("animalFile.txt");;
        File cropFile = new File("cropFile.txt");;

            if(!animalFile.exists()){
                try {
                    animalFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("Was not able to create a new animal file.");
                }
            }
            if(!cropFile.exists()){
                try {
                    cropFile.createNewFile();
                } catch (IOException e) {
                    System.out.println("Was not able to create a new crop file;");
                }
            }


        try {
            FileWriter fileWriterAnimal = new FileWriter (animalFile);
            BufferedWriter bwAnimal = new BufferedWriter(fileWriterAnimal);
            for(int i = 0; i < animalList.size(); i++){
                bwAnimal.write(animalList.get(i).getCSV());
                if(i < cropList.size()-1){
                    bwAnimal.newLine();
                }
            }
            bwAnimal.close();

            FileWriter fileWriterCrop = new FileWriter(cropFile);
            BufferedWriter bwCrop = new BufferedWriter(fileWriterCrop);
            for(int i = 0; i < cropList.size(); i++){
                bwCrop.write(cropList.get(i).getCSV());
                if(i < cropList.size()-1){
                    bwCrop.newLine();
                }
            }
            bwCrop.close();

        } catch (IOException e) {
            System.out.println("There was an error when writing in the file...");
        }


    }

    private void beginningAddAnimals(){
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

    private void beginningAddCrops(){

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
