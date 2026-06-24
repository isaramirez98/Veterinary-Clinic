package domain;
import java.io.Serializable;

public class Pet implements Serializable {

    private String name;
    private int age;
    private String specie;
    private String weight;
    private String color;
    private Owner owner;

    public Pet(String name, int age, String specie, String weight, String color) {
        this.name = name;
        this.age = age;
        this.specie = specie;
        this.weight = weight;
        this.color = color;
    }

    public String getInfo() {
        return "\nPet:" + name +
                "\nAge: " + age +
                "\nSpecie:" + specie +
                "\nWeight:" + weight +
                "\nColor:" + color;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getSpecie() {
        return specie;
    }

    public String getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSpecie(String specie) {
        this.specie = specie;
    }

    public void setAge(int age) {
        if (age >= 0)
            this.age = age;
    }

    public void setWeight(String weight) {
         this.weight = weight;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setOwner(Owner newOwner) {
        if (this.owner != null) {
            this.owner.getPets().remove(this);
        }
        this.owner = newOwner;
        if (newOwner != null) {
            if (!newOwner.getPets().contains(this)) {
                newOwner.getPets().add(this);
            }
        }
    }

    @Override
    public String toString() {
        return getInfo();
    }
}
