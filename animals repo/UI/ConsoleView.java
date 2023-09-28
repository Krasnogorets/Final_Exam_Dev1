package UI;

import Animals.Animals;

import java.util.List;
import java.util.Scanner;

public class ConsoleView implements View <Animals>{
    protected Scanner scanner;
    public ConsoleView() {
        scanner = new Scanner(System.in);
    }
    @Override
    public String getName() {
        System.out.printf("���: ");
        return scanner.nextLine();
    }

    @Override
    public String getBirthday() {
        System.out.printf("������� ���� �������� � ������� 'dd.mm.yyyy': ");
        return scanner.nextLine();
    }

    @Override
    public <T> void printAll (List <T> list, Class <T> clazz) {
        System.out.print("\033[H\033[J");
        if (list.isEmpty())
            System.out.println("������ ����");
        else {
            if (clazz == Animals.class)
                System.out.println("\n          ��� ��������:");
            for (T item : list) {
                System.out.println(item);
            }
        }
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }
}
