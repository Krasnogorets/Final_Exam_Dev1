package Controler;

import Animals.Animals;
import Services.AnimalsRepo;
import Services.Repo;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import Exceptions.UncorrectDataException;
import Animals.*;
import UI.*;

public class AnimalsControler {
    private AnimalsRepo animalsRepository;
    private Constructor animalConstructor;
    private final View<Animals> view;
    private Validator validator;

    public AnimalsControler(AnimalsRepo animalsRepository) {
        this.animalsRepository = animalsRepository;
        this.animalConstructor = new AnimalsConstructor();
        this.view = new ConsoleView();
        this.validator = new Validator();
    }

    public void createAnimal(AnimalsType type) {

        String[] data = new String[] { view.getName(), view.getBirthday() };
        validator.validate(data);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        try {
            int res = animalsRepository.create(animalConstructor.createNewAnimals(type, data[0], birthday));
            view.showMessage(String.format("%d запись добавлена", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void updateAnimal(int id) {

        Animals animal = getById(id);
        String[] data = new String[] { view.getName(), view.getBirthday() };

        validator.validate(data);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        LocalDate birthday = LocalDate.parse(data[1], formatter);
        animal.setName(data[0]);
        animal.setBirthday(birthday);
        try {
            int res = animalsRepository.update(animal);
            view.showMessage(String.format("%d запись изменена \n", res));
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }

    }

    public void getAllAnimals() {
        try {
            view.printAll(animalsRepository.getAll(), Animals.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public boolean trainAnimal(int id, String command) {
        try {
            if (checkCommand(animalsRepository.getCommandsById(id, 1),command)){
                view.showMessage("это мы уже умеем");
                 getCommands(id);}
            else {
                if (!checkCommand(animalsRepository.getCommandsById(id, 2),command)){
                    view.showMessage("невыполнимая команда");
                    view.showMessage("cписок команд, чему можно научить:");
                    getCommands1(id);}
                else {
                    animalsRepository.train(id, command);
                    view.showMessage("команда разучена\n");
                    return true;
                }
            }
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return false;
    }

    public Animals getById(int id) {
        try {
            return animalsRepository.getById(id);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
        return null;
    }

    public void delete(int id) {
        try {
            animalsRepository.delete(id);
            view.showMessage("запись удалена");
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

    public void getCommands(int id) {
        try {
            view.printAll(animalsRepository.getCommandsById(id, 1), String.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }
    public void getCommands1(int id) {
        try {
            view.printAll(animalsRepository.getCommandsById(id, 2), String.class);
        } catch (RuntimeException e) {
            view.showMessage(e.getMessage());
        }
    }

   public boolean checkCommand(List<String> temp,String command){
       for (String item : temp) {
           if(item.equals(command)){
               return true;
           }
       }
        return false;
   }
}
