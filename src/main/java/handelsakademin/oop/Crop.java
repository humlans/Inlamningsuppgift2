package handelsakademin.oop;

public class Crop extends Entity{
    private String cropType;
    private int quantity;

    private static int nextId = 1;

    // In the first constructor the name, cropType and quantity is decided by the user.
    // The id is generated automatically by using the static variable nextId.
    public Crop(String name, String cropType, int quantity) {
        super(name);
        id = nextId;
        nextId ++;
        this.cropType = cropType;
        this.quantity = quantity;
    }

    // Because of crops that are saved in the files there is another constructor that also takes the id.
    public Crop(int id, String name, String cropType, int quantity) {
        super(name);
        this.id = id;
        this.cropType = cropType;
        this.quantity = quantity;
    }

    // The method returns a string with all the information of the crop.
    @ Override
    public String getDescription(){
        return ("Id: " + getId() + ", Name: " + name + ", Crop type: " + cropType + ", Quantity: " + quantity );
    }

    // This method adds a new amount of a crop to get a higher quantity.
    // A restriction is added so that the quantity have to be above zero to be added.
    public void addCrop(int addedQuantity){
        if(addedQuantity > 0) {
            quantity = quantity + addedQuantity;
            System.out.println("Successfully added " + addedQuantity + " pieces, the total amount is now " + quantity);
        }
        else {
            System.out.println("The added quantity have to be above 0");
        }
    }

    // takeCrop reduces the quantity with a given quantity, if it is possible to take away that amount it will
    // and then return true. If the quantity is too low, it will return false.
    public boolean takeCrop (int reducedQuantity){
        if (reducedQuantity <= quantity){
            quantity = quantity - reducedQuantity;
            return true;
        }
        else {
            return false;
        }
    }

    // Returns a CSV-string in order to save it into a file.
    public String getCSV(){
        return id + "," + name + "," + cropType + "," + quantity;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }
}
