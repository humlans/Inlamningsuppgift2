package handelsakademin.oop;

//The entity class is just an abstract class that animal and crop inherits from
public class Entity {
    protected int id;
    protected String name;


    public Entity(String name) {
        this.name = name;
    }

    // The getDescription method is overridden in the inheriting classes
    public String getDescription (){
        return ("Id: " + id + ", Name: " + name);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
}
