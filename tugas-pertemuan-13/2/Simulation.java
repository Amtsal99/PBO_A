abstract class Animal {
    protected String name;
    protected int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public abstract String move();
    public abstract String eat();

    @Override
    public String toString() {
        return name + ", Age: " + age;
    }
}

class Rabbit extends Animal {
    public Rabbit(String name, int age) {
        super(name, age);
    }

    @Override
    public String move() {
        return name + " hops around.";
    }

    @Override
    public String eat() {
        return name + " eats grass.";
    }
}

class Fox extends Animal {
    public Fox(String name, int age) {
        super(name, age);
    }

    @Override
    public String move() {
        return name + " runs swiftly.";
    }

    @Override
    public String eat() {
        return name + " hunts and eats rabbits.";
    }
}

public class Simulation {
    public static void main(String[] args) {
        Animal[] animals = {
            new Rabbit("Snowy", 2),
            new Rabbit("Thumper", 3),
            new Fox("Foxy", 5)
        };

        for (Animal animal : animals) {
            System.out.println(animal);
            System.out.println(animal.move());
            System.out.println(animal.eat());
            System.out.println("--------------------");
        }
    }
}
