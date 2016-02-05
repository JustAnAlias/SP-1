package fibonacciobserver_rl;


import java.util.ArrayList;
import java.util.List;

public class FibonacciTask extends Thread{
    private long tal;
    List<FibonacciObserver> observers = new ArrayList();
    
    public void registerFibonacciObserver(FibonacciObserver o){
      observers.add(o);
    }
    
    public FibonacciTask(long n) {
        this.tal = n;
    }
    
    // moved to this file instead
    private long fib(long n) {
    if ((n == 0) || (n == 1)) {
      return n;
    } else {
      return fib(n - 1) + fib(n - 2);
    }
  }
    
    @Override
    public void run() {
        //Call the Fibonacci method from here
        //long tal = ......
        long number = fib(tal);
        for(FibonacciObserver observer : observers){
          observer.dataReady(number);
        }
    }
}
