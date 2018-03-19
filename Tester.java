/*
  This class is the tester class for the Viagogo coding challenge.
*/

import java.util.ArrayList;
import java.util.Scanner;

public class Tester{
  
  public static void main(String[] args){
    Grid grid = new Grid();
    grid.generateGrid();

    for(int i = 0; i < grid.coordinates.size(); i++){
      
      Coordinate coordinate = grid.coordinates.get(i);
      ArrayList<Ticket> tickets = coordinate.tickets;
      ArrayList<Integer> prices = new ArrayList<Integer>();

      for(int j = 0; j < tickets.size(); j++){
        prices.add(tickets.get(j).price);
      }

      //Uncomment this to see each coordinate you add to the grid along with
      //its corresponding eventID and ticket prices.
      /*
      System.out.print("Coordinate at location (" + coordinate.x + "," +
                coordinate.y + ")" + " with event ID " + coordinate.eventID);
      System.out.println(" has the following ticket prices: " + prices);
      */
    }

    Scanner scanner = new Scanner(System.in);
    System.out.println("\nPlease Input Coordinates:\n");
    String input = scanner.next(); //Assumes input formatted like "4,2"
    int x = Character.getNumericValue(input.charAt(0));
    int y = Character.getNumericValue(input.charAt(2));
    grid.fiveClosestEvents(x, y);
  }
  
}
