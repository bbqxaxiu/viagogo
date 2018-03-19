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

Answers to follow up questions:  
  1. If I had to change my program to support multiple events at the same location, I would create a separate Event class          (which would have its eventID and list of tickets) and make it such that every Coordinate object had a list of Events          instead of just one. (The way my program is currently set up, we assume that every Coordinate only has one event, so the      event and the coordinate are synonymous). From here, we can then modify fiveClosestPoints() so that it runs through the        list of Events of every Coordinate that is a given distance away from the location the user inputted and returns the          cheapest ticket for that Event along with the Event's eventID. 
  2. If I had to change my program to support a much larger world size, I would break up every quandrant of this new world          into a separate class: that is, I would have 4 Grid classes corresponding to the 1st, 2nd, 3rd, and 4th quadrant. (As it      is now, the Grid class encapsulates the whole world instead of just one quadrant of the world). From here, we can reuse        the Coordinate and Ticket classes for each Grid. This easy fix exploits the flexible nature of my OOP approach to this        coding challenge. 
  
To run and test the program, compile and run the tester class (Tester.java). 
