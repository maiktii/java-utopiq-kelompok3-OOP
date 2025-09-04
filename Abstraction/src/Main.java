abstract class Animal {
    public abstract void sound();

    public void sleep() {
        System.out.println("Sleeping...");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Woof Woof!");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow Meow!");
    }
}

public class Main {
    public static void main(String[] args) {
        Animal dog = new Dog();
        dog.sound();
        dog.sleep();

        Animal cat = new Cat();
        cat.sound();
        cat.sleep();
    }
}
