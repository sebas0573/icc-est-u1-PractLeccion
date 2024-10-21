import controllers.Controller;
import controllers.SearchMethods;
import controllers.SortingMethods;
import views.View;

public class App {
    public static void main(String[] args) throws Exception {
        ///crear vista

        View vista = new View();

        ///crear clases con los metodos
        SortingMethods sortingMethods = new SortingMethods();
        SearchMethods searchMethods = new SearchMethods();

        ///crear controlador
        Controller controller = new Controller(vista, sortingMethods, searchMethods);

        //iniciar la aplicacion

    }
}
