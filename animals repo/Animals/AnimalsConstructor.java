package Animals;

public class AnimalsConstructor extends Constructor{
    @Override
    protected Animals createNewAnimals(AnimalsType type) {
        switch (type){
            case Cat:
                return new Cat();
            case Dog:
                return new Dog();
            case Hamster:
                return new Hamster();
            case Horse:
                return new Horse();
            case Donkey:
                return new Donkey();
            case Camel:
                return new Camel();
        }
        return null;
    }
}
