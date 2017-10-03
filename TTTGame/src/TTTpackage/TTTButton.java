package TTTpackage;

import java.awt.*;

public class TTTButton extends Button implements Observer {
    int index = 0;
    private String symbol;

    public TTTButton(int index) throws HeadlessException {
        this.index = index;
        
    }

    @Override
    public void update(String symbol) {
        this.symbol = symbol;
       System.out.println("inside Update");
        
    }
}

