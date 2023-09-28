package Animals;

import java.time.LocalDate;

public abstract class Constructor {
    protected abstract Animals createNewAnimals(AnimalsType type);
    public Animals createNewAnimals(AnimalsType type, String name, LocalDate date) {

        Animals animals = createNewAnimals(type);
        animals.setName(name);
        animals.setBirthday(date);
        return animals;
    }


}
