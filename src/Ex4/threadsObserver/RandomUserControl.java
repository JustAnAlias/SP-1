package threadsObserver;


import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

public class RandomUserControl extends Observable implements Runnable{

    Observer o;
    public RandomUserControl(Observer o) {
        this.o = o;
    }
    
  
  public void fetchRandomUser() {
   RandomUser user= null;
    try {
      user = RandomUserGenerator.getRandomUser();
    } catch (InterruptedException ex) {
      Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
    }
   this.setChanged();
   this.notifyObservers(user);
  }

    @Override
    public void run() {
        this.addObserver(o);
        fetchRandomUser();
    }
}
