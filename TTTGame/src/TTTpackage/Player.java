package TTTpackage;


public class Player  {

    
    private String name = "No Name";
    private String symbol = "";
    public boolean flag=false;
    Player[] players = new Player[2];
     Cell[] cell = new Cell[9];

    public Player[] getPlayers() {
        return players;
    }

    public void setPlayers(Player[] players) {
        this.players = players;
    }
    
    
    public String getName() {
        return name;
    }

    public Player(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
        for(int i = 0; i < 9; i++){
            
        cell[i] = new Cell("");
        }
        
    }

   
    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
        
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }
   
 
    public void MarkCell(int index) {
        cell[index].setSymbol(this.symbol);
       
    }
    public void register(Observer o, int index)
    {
         System.out.println("inside register");
        cell[index].registerObserver(o);
       
    }

    public boolean amIaWinner(int i) {
        
        
      int index=i;
       if((cell[0].getSymbol().equals(symbol)
          &&cell[1].getSymbol().equals(symbol)&&cell[2].getSymbol().equals(symbol))){
                            return true;
                            }
       else if(cell[3].getSymbol().equals(symbol)
                                &&cell[4].getSymbol().equals(symbol)
                                &&cell[5].getSymbol().equals(symbol)){
                            return true;
                            }
      else if(cell[6].getSymbol().equals(symbol)
                                &&cell[7].getSymbol().equals(symbol)
                                &&cell[8].getSymbol().equals(symbol)){
                            return true;
                            }
      else if(cell[0].getSymbol().equals(symbol)
                                &&cell[3].getSymbol().equals(symbol)
                                &&cell[6].getSymbol().equals(symbol)){
                            return true;
                            }
      else if(cell[1].getSymbol().equals(symbol)
                                &&cell[4].getSymbol().equals(symbol)
                                &&cell[7].getSymbol().equals(symbol)){
                            return true;
                            }
      else if(cell[2].getSymbol().equals(symbol)
                                &&cell[5].getSymbol().equals(symbol)
                                &&cell[8].getSymbol().equals(symbol)){
                             return true;
                            
                            }
      else if(cell[2].getSymbol().equals(symbol)
                                &&cell[4].getSymbol().equals(symbol)
                                &&cell[6].getSymbol().equals(symbol)){
                             return true;
                            
                            }
      
      else if(cell[0].getSymbol().equals(symbol)
                                &&cell[4].getSymbol().equals(symbol)
                                &&cell[8].getSymbol().equals(symbol)){
                            return true;
                            
      
                            }
      
     
      return false;
    }

    
}            
    

    

