# Viagogo

This repository contains my solution to Viagogo's 2018 coding challenge.

Outline: The OOP approach I used involved creating 3 separate classes, along with 1 tester class. 
  1. Grid class: This class contains the blueprint for a grid. Every Grid has a random number of Coordinates (which itself is      a class) contained within a list. generateGrid() creates a random number of Coordinates, each with a random location and      eventID, and appends it to the Grid's list of Coordinates. fiveClosestPoints() calculates the manhattan distance between      every coordinate in a Grid and the location the user inputted and inserts this information into a HashMap, which maps          distance (from the location the user inputted) to coordinate. We use this HashMap, in conjunction with a min heap, to get      the top 5 (or less, in the case that there are less than 5 coordinates or events in a Grid) closest coordinates or            events. 
  2. Coordinate class: This class contains the blueprint for every coordinate in a Grid. Each Coordinate has a location,            eventID, and list of tikets. generateTickets() creates a random number of Tickets (which itself is a class), each of          which has a random price, and appends it to the Coordinate's list of Tickets. 
  3. Ticket class: This class contains the blueprint for a ticket. Each Ticket has a random, non-zero price. 
  4. Tester class: In the tester class, we grid a Grid object, create coordinates or events for that Grid using                    generateGrid(), and output the top 5 closest coordinates or events using fiveClosestPoints(). 

My code is heavily documented with the assumptions that I made, which include the following: 
  1. Every "Grid" has between 1-20 coordinates or events. 
  2. Every coordinate or event has 0-5 tickets. Each ticket has a price ranging from 1-100.
  3. If there are two coordinates or events that are the same distance away from the user inputted location, we only return        one of the events and its corresponding cheapest ticket price. 
  
