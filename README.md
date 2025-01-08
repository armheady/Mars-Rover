

# Mars Rover

## Description
The Mars Rover project simulates the exploration of the surface of Mars by rovers.
The surface of Mars is represented by a Plateau. You can assume that the Plateau is a square/rectangular grid for the purpose of this task.
Rovers navigate the Plateau by following a sequence of commands.

## The Plateau
The Plateau is divided into a grid.

## The Rover Position
A Rover's position is represented by x and y coordinates and the letters N, S, W, E to represent North, South, West, East (the four cardinal compass points) respectively.

Example: 
```
0 0 N
```
This means the Rover is at the bottom-left corner facing in the North direction.

Assume that the square directly North from (x, y) is (x, y + 1), and the square directly East from (x, y) is (x + 1, y).

## Program Inputs

### First Line: Plateau Creation
The first line inputted into the program represents the upper-right coordinates of the Plateau.

Example:
```
5 5
```
This Plateau has maximum (x, y) coordinates of (5, 5), and is therefore a Plateau of size (6,6).

Assume that the lower-left coordinate is (0, 0).

### Subsequent Lines: Rover Creation & Instructions
Following the plateau creation, each Rover receives two lines of input. The first line of input is to land the Rover at a particular starting position, e.g.
```
1 2 N
```
This lands the Rover at position (1,2) facing North.


## Output
For the Rover, the output represents its final position: the coordinates and where it is facing.

## Example
Given the following input:
```
5 5
1 2 N
LMLMLMLMM
```
This creates a plateau of size (5,5) and lands the rovers on it. The rover lands at (1,2)N and moves `LMLMLMLMM`.

The expected output is:
```
1 3 N
```

## Installation
To run this project, you will need to have Java installed on your machine.

### Using IntelliJ IDEA
1. Clone the repository:
   ```sh
   git clone https://github.com/armheady/Mars-Rover.git
   ```
2. Open IntelliJ IDEA and select "Open" from the "File" menu.
3. Navigate to the cloned repository directory and select it.
4. IntelliJ IDEA will prompt you to import the project. Select "Import Project from Existing Sources" and follow the prompts.
5. Once the project is imported, navigate to the `src` directory and locate the `Main.java` file.
6. Right-click on `Main.java` and select "Run 'Main.main()'".

