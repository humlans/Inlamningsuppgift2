package handelsakademin.oop;

public class Crop extends Entity{
    private String cropType;
    private int quantity;

    private static int nextId = 1;

    public Crop(String name, String cropType, int quantity) {
        super(name);
        id = nextId;
        nextId ++;
        this.cropType = cropType;
        this.quantity = quantity;
    }

    @ Override
    public String getDescription(){
        return ("Id: " + getId() + ", Name: " + name + ", Crop type: " + cropType + ", Quantity: " + quantity );
    }

    public void addCrop(int addedQuantity){
        quantity = quantity + addedQuantity;
    }

    public boolean takeCrop (int reducedQuantity){
        if (reducedQuantity < quantity){
            quantity = quantity - reducedQuantity;
            return true;
        }

        return false;
    }


    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }
}
