package views;

import java.util.Scanner;
import models.Person;

public class View {
    private Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {
        System.out.println("Menu");
        System.out.println("1. Ingresar Personas");
        System.out.println("2. Ordenar Personas");
        System.out.println("3. Añadir Persona");
        System.out.println("4. Buscar Persona");
        System.out.println("100. Salir");
        return inputInt("Seleccione una opción");
    }

    public int inputInt(String message) {
        while (true) {
            try {
                System.out.print(message + ": ");
                return scanner.nextInt();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.println("Entrada inválida. Intente de nuevo.");
            }
        }
    }

    public Person inputPerson() {
        String name = inputName();
        int age = inputAge();
        return new Person(name, age);
    }

    public String inputName() {
        System.out.print("Ingrese el nombre: ");
        return scanner.next();
    }

    public int inputAge() {
        return inputInt("Ingrese la edad");
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public int selectSortingMethod() {
        System.out.println("*******Ingrese la condición para ordenar********");
        System.out.println("1. Por nombre");
        System.out.println("2. Por edad");
        return inputInt("Ingrese una opción");
    }

    public void displayPersons(Person[] persons) {
        if (persons == null || persons.length == 0) {
            System.out.println("No hay personas para mostrar.");
        } else {
            for (Person person : persons) {
                System.out.println(person.getName() + " - " + person.getAge());
            }
        }
    }

    public void displaySearchResult(Person person) {
        if (person != null) {
            System.out.println("Persona encontrada: " + person.getName() + " - " + person.getAge());
        } else {
            System.out.println("Persona no encontrada.");
        }
    }
}




