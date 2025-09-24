public class Animal {
    public void makeSound(){
        System.out.println("I am an animal!");
    }
}

public class Dog extends Animal {
    @Override
    public void makeSound(){
        System.out.println("I am a dog!");
    }
}

public class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("I am a cat!");
    }
}

public class Main {

    public static void main(String[] args) {

        Animal animal = new Animal();
        Dog dog = new Dog();
        Cat cat = new Cat();

        Animal[] animals = {animal, dog, cat};

        for(int i = 0; i < animals.length; i++){

            //dynamic binding in action, here the JVM runtime checks which object wants to ivoke makeSound()
            animals[i].makeSound();
        }
    }

}