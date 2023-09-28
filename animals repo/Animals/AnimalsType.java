package Animals;

public enum AnimalsType {
    Cat,
    Dog,
    Hamster,
    Donkey,
    Horse,
    Camel;

    public static AnimalsType getType (int typeId){
        switch (typeId){
            case 1:
                return AnimalsType.Cat;
            case 2:
                return AnimalsType.Dog;
            case 3:
                return AnimalsType.Hamster;
            case 4:
                return AnimalsType.Horse;
            case 5:
                return AnimalsType.Donkey;
            case 6:
                return AnimalsType.Camel;
            default:
                return null;
        }
    }
}
