
import Controler.AnimalsControler;
import Services.AnimalsRepo;
import UI.Menu;


public class main {
    public static void main(String[] args) {

        AnimalsRepo myFriends = new AnimalsRepo();
        AnimalsControler controller = new AnimalsControler(myFriends);
        new Menu(controller).start();
    }
}
