/*
  This class contains the blue print for every Coordinate.
*/

import java.util.ArrayList;
import java.util.Random;

public class Coordinate{

  //(x, y) location of the coordinate.
  public int x;
  public int y;

  //Every Coordinate has one event and a list of Tickets.
  public int eventID;
  public ArrayList<Ticket> tickets;

  public Coordinate(int x, int y, int eventID){
      this.x = x;
      this.y = y;
      this.eventID = eventID;
      tickets = new ArrayList<Ticket>();
  }

  public void generateTickets(){
    Random rand = new Random();
    int numTickets = rand.nextInt(6); //Assume each event has at most 5 tickets.
    for(int i = 0; i < numTickets; i++){
      int price = rand.nextInt(100) + 1;
      tickets.add(new Ticket(price));
    }
  }


}
