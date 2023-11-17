package handelsakademin.oop;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Farm {
    Scanner scanner = new Scanner(System.in);
    AnimalManager animalManager;
    CropManager cropManager;


    // In the constructor for Farm we check for files that already have existing animals and crops in them.
    // If they exist we add them to a list and send it into the animalManager and the cropManager.
    public Farm() {
        File animalFile = new File("animalFile.txt");
        File cropFile = new File ("cropFile.txt");

        ArrayList <Animal> animalList = new ArrayList<>();
        ArrayList <Crop> cropList = new ArrayList<>();

        try {
            if (animalFile.exists()) {
                FileReader fileReaderAnimal = new FileReader(animalFile);
                BufferedReader bufferedReaderAnimal = new BufferedReader(fileReaderAnimal);

                String readLine = bufferedReaderAnimal.readLine();
                while(readLine != null){
                    String [] attributesAnimal = readLine.split(",");
                    int id = Integer.parseInt(attributesAnimal[0]);
                    String name = attributesAnimal[1];
                    String species = attributesAnimal[2];
                    String [] acceptableCrops = attributesAnimal[3].split("@");
                    ArrayList <String> acceptableCropTypes = new ArrayList<>();
                    Collections.addAll(acceptableCropTypes, acceptableCrops);

                    Animal tempAnimal = new Animal(id, name, species, acceptableCropTypes);
                    animalList.add(tempAnimal);
                    readLine = bufferedReaderAnimal.readLine();
                }
                bufferedReaderAnimal.close();
            }

            if (cropFile.exists()){
                FileReader fileReaderCrop = new FileReader(cropFile);
                BufferedReader bufferedReaderCrop = new BufferedReader(fileReaderCrop);
                String readLine = bufferedReaderCrop.readLine();
                while(readLine != null) {
                    String[] attributesCrops = readLine.split(",");
                    int id = Integer.parseInt(attributesCrops[0]);
                    String name = attributesCrops[1];
                    String cropType = attributesCrops[2];
                    int quantity = Integer.parseInt(attributesCrops[3]);

                    Crop tempCrop = new Crop(id, name, cropType, quantity);
                    cropList.add(tempCrop);
                    readLine = bufferedReaderCrop.readLine();
                }
                bufferedReaderCrop.close();
            }

        }
        catch (IOException e) {
            System.out.println("Could not read from files...");
        }

        cropManager = new CropManager(cropList);
        animalManager = new AnimalManager(animalList);
    }

    // mainMenu is where the user choose where to go, if they want to go to animal menu, crop menu, save the program or quit.
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

                    animalManager.animalMenu(cropManager.getCrops());
                    break;

                case "2":

                    cropManager.cropMenu();
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

    // Saves all the animals into files.
    // Will create new files if they don't already exist, and then turn the animalList and cropList gotten from the managers
    // into CSV-format and write them in the files.
    private void save(){
        File animalFile = new File("animalFile.txt");
        File cropFile = new File("cropFile.txt");

        ArrayList <Animal> animalList = animalManager.getAnimals();
        ArrayList <Crop> cropList = cropManager.getCrops();

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
            System.out.println("Successfully saved.");

        } catch (IOException e) {
            System.out.println("There was an error when writing in the file...");
        }

    }

}
