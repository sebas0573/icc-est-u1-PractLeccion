package controllers;

import models.Person;
import views.View;

public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;

    private Person[] personas;

    
    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods){
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        System.out.println("Controller Created");
    }

    public void start(){
        int option = 0;
        do{
            switch(option){
                case 1:
                    inputPersonas();
                    break;
                case 2:
                    addPerson();
                    break;
                case 3:
                    sortPersons();
                case 100:
                    System.out.println("Adios");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
        }while(option != 0);
    }

    public void inputPersonas(){
        System.out.println("Ingrese el numero de personas");
        int numerPersonas = view.inputInt("Ingrese el numero de personas");
        for(int i=0; i<numerPersonas; i++){
            personas[i] = view.inputPerson();
        }
    }

    public void addPerson(){
        if (personas == null) {
            view.showMessage("No existe. Ingrese las personas por primera vez");
            inputPersonas();
        }else{
            int numerPersonas = view.inputInt("Ingrese el numero de personas a adicionar");

            Person[] personasTotal = new Person[personas.length + numerPersonas];

            for(int i = 0; i < personas.length; i++){
                personasTotal[i] = personas[i];
            }

            for(int i = personas.length; i < personasTotal.length; i++){
                personas[i] = view.inputPerson();
            }
            personas = personasTotal;
        }
    }
    public void sortPersons(){
        int sortingOption = view.selectSortingMethod();
        if (sortingOption == 1) {
            sortingMethods.sortByNameWithBubble(personas);
        }else if (sortingOption == 2){
            sortingMethods.sortByAgeWithSelection(personas);
        }else{
            view.showMessage("Opcion no valida");
        }
    }

}
