package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    private Person[] personas;

    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        System.out.println("Controller Created");
    }

    public void start() {
        int option;
        do {
            option = view.showMenu();
            switch (option) {
                case 1:
                    inputPersonas();
                    break;
                case 2:
                    sortPersons();
                    break;
                case 3:
                    addPerson();
                    break;
                case 4:
                    searchPerson();
                    break;
                case 100:
                    System.out.println("Adiós");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        } while (option != 100);
    }

    public void inputPersonas() {
        int numPersonas = view.inputInt("Ingrese el número de personas");
        personas = new Person[numPersonas];
        for (int i = 0; i < numPersonas; i++) {
            personas[i] = view.inputPerson();
        }
    }

    public void addPerson() {
        if (personas == null) {
            view.showMessage("No hay personas registradas. Agregue personas primero.");
            inputPersonas();
        } else {
            int numPersonas = view.inputInt("Ingrese el número de personas a añadir");
            Person[] personasTotal = new Person[personas.length + numPersonas];
            System.arraycopy(personas, 0, personasTotal, 0, personas.length);

            for (int i = personas.length; i < personasTotal.length; i++) {
                personasTotal[i] = view.inputPerson();
            }
            personas = personasTotal;
        }
    }

    public void sortPersons() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No hay personas para ordenar.");
            return;
        }
        int sortingOption = view.selectSortingMethod();
        if (sortingOption == 1) {
            sortingMethods.sortByNameWithBubble(personas);
        } else if (sortingOption == 2) {
            sortingMethods.sortByAgeWithSelection(personas);
        } else {
            view.showMessage("Opción no válida");
        }
        view.displayPersons(personas);
    }

    public void searchPerson() {
        if (personas == null || personas.length == 0) {
            view.showMessage("No hay personas para buscar.");
            return;
        }
        int searchOption = view.inputInt("Buscar por: 1. Nombre, 2. Edad");
        Person found = null;
        if (searchOption == 1) {
            String name = view.inputName();
            found = searchMethods.binarySearchByName(personas, name);
        } else if (searchOption == 2) {
            int age = view.inputAge();
            found = searchMethods.binarySearchByAge(personas, age);
        } else {
            view.showMessage("Opción no válida");
            return;
        }
        view.displaySearchResult(found);
    }
}





