package UI;

import Animals.*;
import Controler.*;
import Exceptions.UncorrectDataException;
import Services.AnimalsRepo;

import java.util.Scanner;

public class Menu {
    AnimalsControler animalsControler;

    public Menu(AnimalsControler controller) {
        this.animalsControler = controller;
    }

    public void start() {

        System.out.print("\033[H\033[J");
        try (Scanner in = new Scanner(System.in); Counter count = new Counter()) {

            boolean flag = true;
            int id;
            while (flag) {

                System.out.println(
                        "\n1 - ������ ���� ��������\n2 - ������� ����� ��������\n3 - �������� ������ � ��������\n4 - ��� ����� ��������\n5 - �����������\n6 - ������� ������\n0 - �����");
                String key = in.next();
                switch (key) {
                    case "1":
                        animalsControler.getAllAnimals();
                        break;
                    case "2":
                        AnimalsType type = menuChoice(in);
                        if (type != null) {
                            try {
                                animalsControler.createAnimal(type);
                                count.add();
                                System.out.println("��");
                            } catch (UncorrectDataException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                        break;
                    case "3":
                        while (true) {
                            id = menuChoiceAnimal(in);
                            if (id != 0)
                                try {
                                    animalsControler.updateAnimal(id);
                                } catch (UncorrectDataException e) {
                                    System.out.println(e.getMessage());
                                }
                            else
                                break;
                        }
                        break;
                    case "4":
                        while (true) {
                            id = menuChoiceAnimal(in);
                            if (id != 0)
                                animalsControler.getCommands(id);
                            else
                                break;
                        }
                        break;
                    case "5":
                        id = menuChoiceAnimal(in);
                        if (id != 0)
                            menuTrainPet(id, in);
                        break;
                    case "6":
                        id = menuChoiceAnimal(in);
                        if (id != 0)
                            animalsControler.delete(id);
                        break;
                    case "0":
                        flag = false;
                        break;
                    default:
                        System.out.println("������ �������� ���");
                        break;
                }
            }
        }
    }

    private AnimalsType menuChoice(Scanner in) {
        System.out.println("����� �������� ��������:\n" +
                "1 - �����\n" +
                "2 - ������\n" +
                "3 - �����\n" +
                "4 - ������\n" +
                "5 - �����\n" +
                "6 - �������\n" +
                "0 - ������� � �������� ����");

        while (true) {
            String key = in.next();
            switch (key) {
                case "1":
                    return AnimalsType.Cat;
                case "2":
                    return AnimalsType.Dog;
                case "3":
                    return AnimalsType.Hamster;
                case "4":
                    return AnimalsType.Horse;
                case "5":
                    return AnimalsType.Donkey;
                case "6":
                    return AnimalsType.Camel;
                case "0":
                    return null;
                default:
                    System.out.println("������ �������� ���, ������� ����� �� 0 �� 6");
                    break;
            }
        }
    }

    private int menuChoiceAnimal(Scanner in) {
        System.out.println("\n������� ����� ���������, 0 ��� �������� � �������� ����: ");
        while (true) {
            int id = in.nextInt();
            in.nextLine();
            if (id == 0)
                return id;
            if (animalsControler.getById(id) == null) {
                System.out.println("��������� � ����� ������� ���, ���������� ��� ���, 0 ��� �������� � �������� ����:");
            } else
                return id;

        }
    }

    private void menuTrainPet(int petId, Scanner in) {
        Scanner sc = in;
        System.out.println("c����� ������, ��� �����:");
        animalsControler.getCommands(petId);
        System.out.println("c����� ������, ���� ����� �������:");
        animalsControler.getCommands1(petId);
        while (true) {
            System.out.println("������� ����� �������, 0 ��� �������� � �������� ����: ");
            String command = sc.nextLine();
            if (command.length() == 1 && command.equals("0"))
                return;
            if (animalsControler.trainAnimal(petId, command))
                System.out.println("��� ��!");
        }
    }
}
