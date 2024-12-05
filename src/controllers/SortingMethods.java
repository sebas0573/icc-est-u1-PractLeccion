package controllers;

import models.Person;

public class SortingMethods {

    public void sortByNameWithBubble(Person[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (personas[j].getName().compareToIgnoreCase(personas[j + 1].getName()) > 0) {
                    Person temp = personas[j];
                    personas[j] = personas[j + 1];
                    personas[j + 1] = temp;
                }
            }
        }
    }

    public void sortByAgeWithSelection(Person[] personas) {
        int n = personas.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (personas[j].getAge() < personas[minIndex].getAge()) {
                    minIndex = j;
                }
            }
            Person temp = personas[i];
            personas[i] = personas[minIndex];
            personas[minIndex] = temp;
        }
    }
}





