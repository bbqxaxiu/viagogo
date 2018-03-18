/*
  This class contains the blueprint for a Grid.
*/

import java.util.Random;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.HashMap;

public class Grid{

  public ArrayList<Coordinate> coordinates;
  public ArrayList<Integer> idsAlreadyUsed;
  public int numCoordinates;
  public Random rand;

  public Grid(){
    coordinates = new ArrayList<Coordinate>();
    idsAlreadyUsed = new ArrayList<Integer>();
    rand = new Random();

    //Assume there are 1-20 coordinates in the grid.
    numCoordinates = rand.nextInt(20) + 1;
  }

  //Generate a random number of Coordinates, each of which will have a random
  //eventID and a random number of Tickets with random prices.
  public void generateGrid(){
    for(int i = 0; i < numCoordinates; i++){
      int x = rand.nextInt(21) - 10;
      int y = rand.nextInt(21) - 10;
      int eventID = rand.nextInt(401) + 1;

      //Ensure no two events have the same ID.
      while(idsAlreadyUsed.contains(eventID)) eventID = rand.nextInt(401) + 1;

      //Ensure you don't add two coordinates with the same location to the grid.
      while(existsCoordinateWithSameLocation(x, y)){
        x = rand.nextInt(21) - 10;
        y = rand.nextInt(21) - 10;
      }

      Coordinate tempCoordinate = new Coordinate(x, y, eventID);
      idsAlreadyUsed.add(eventID);

      tempCoordinate.generateTickets();
      coordinates.add(tempCoordinate);
    }
  }

  public void fiveClosestEvents(int x, int y){
    HashMap<Integer, Coordinate> hm = new HashMap<Integer, Coordinate>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

    //Calculate the distance between every coordinate and the given location.
    for(int i = 0; i < numCoordinates; i++){
      Coordinate coordinate = coordinates.get(i);
      int manDistance = Math.abs(x - coordinate.x) + Math.abs(y - coordinate.y);
      hm.put(manDistance, coordinate);
    }

    //Using a min heap, which contains the closest distances to the given
    //location, in conjunction with a HashMap that maps distance(s) to
    //coordinate(s) allows us to get the top k closest points.
    for(int distance: hm.keySet()){
      minHeap.add(distance);
    }

    //Output results. Assumes that if there are two events that are the same
    //distance away from a given location, only one of them is outputted.
    System.out.println("\nClosest Events to (" + x + "," + y + "):\n");
    int max;
    if(minHeap.size() < 5) max = minHeap.size();
    else max = 5;
    for(int j = 0; j < max; j++){
      int nextClosestDistance = minHeap.poll();
      Coordinate temp = hm.get(nextClosestDistance);
      int cheapestTicket = getCheapestTicket(temp.tickets);
      System.out.println("Event " + temp.eventID + " - " + "$" + cheapestTicket
              + ", Distance " + nextClosestDistance + "\n");
    }
  }

  //Given an event's list of ticket prices, return the cheapest ticket.
  public int getCheapestTicket(ArrayList<Ticket> tickets){
    //Assume that you return 0 if an event has no tickets.
    if(tickets.size() == 0) return 0;
    else{
      int minPrice = Integer.MAX_VALUE;
      for(int i = 0; i < tickets.size(); i++){
        Ticket currTicket = tickets.get(i);
        if(currTicket.price < minPrice) minPrice = currTicket.price;
      }

      return minPrice;
    }
  }

  //Checks if there's already a coordinate in the grid with the same location.
  public boolean existsCoordinateWithSameLocation(int x, int y){
    boolean result = false;
    for(Coordinate coordinate: coordinates){
      if(coordinate.x == x && coordinate.y == y){
        result = true;
        break;
      }
    }
    return result;
  }
}
