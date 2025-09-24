class Animal {
    public void makeSound() {
        System.out.println("The animal is animal");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("The dog barks: ");
    }
}

Animal myAnimal = new Animal();
Animal myDog = new Dog();

myAnimal.makeSound(); // the animal is animal
myDog.makeSound(); // The dog bakrs;