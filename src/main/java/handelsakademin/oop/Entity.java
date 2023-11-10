package handelsakademin.oop;

public class Entity {
    protected int id;
    protected String name;


    public Entity(String name) {
        this.name = name;
    }

    public String getDescription (){
        return ("Id: " + id + ", Name: " + name);
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
