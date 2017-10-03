package TTTpackage;

import java.util.ArrayList;


public class Cell implements Observable{
    ArrayList<Observer> observers = new ArrayList<Observer>();
    
    private String symbol = "";

    public Cell(String symbol) {
        this.symbol = symbol;
    }

    
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
        notifyListeners();
    }

    @Override
    public void notifyListeners() {
         System.out.println("inside notifyListeners: symbol");
        for (Observer o : observers)
            o.update(symbol);
        
       System.out.println(symbol);
       //System.out.print(button.index);
//To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void registerObserver(Observer o) {
        observers.add(o);
        System.out.println("inside registerObserver");
        
//To change body of generated methods, choose Tools | Templates.
    }

    

   
}
