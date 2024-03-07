# Project-Connect4

CMSC157: OOP Workshop
Class Project: Connect4

All members of the group will make branches as they work on bits of this code.

# Piece Class

This class represents individual pieces.  Each piece has a character representation for its player; perhaps ‘X’ and ‘O’ are good for now.  These different representations indicate the players.  We should have constants for PLAYER1 (an ‘X’) and PLAYER2 (an ‘O’).  We may extend this in the future to include graphics, etc.

Here are methods we’ll need:

Piece(Character player): construct a piece with a specified player

toString(): represent the piece as a string using its character representation.

# Board Class: hold each Piece(s) class

This is the board, which is NxN, where N is input on the command line.  The default value of N should be 5.  The board itself should be a two-dimensional array of Pieces.

Board(): build board of default size

Board(int len): build a board that is len X len Pieces.  Initially, each spot in the board is blank (null).

getSize(): return the board’s size.

toString(): Return the board a String that is a visible set of columns like this for a 5x5 board.

 0 1 2 3 4
| | | | | |
| | | | | |
| | | | | |
| | | | | |
|X| | | | |

add(Piece p, int col): add a piece to a column.  The piece should fall to the lowest unoccupied position in that column of the board.  

We’ll have to do something about full columns!

# Main class (for testing on repl.it)

main(): Create a testing main method that allows us to drop pieces of either type into a column.  The method should print the board after each drop, perhaps like this:

Enter at column 0-4:  0

 0 1 2 3 4
| | | | | |
| | | | | |
| | | | | |
| | | | | |
|X| | | | |

Enter at column 0-4: 4

 0 1 2 3 4
| | | | | |
| | | | | |
| | | | | |
| | | | | |
|X| | | |O|

Enter at column 0-4: 0

 0 1 2 3 4
| | | | | |
| | | | | |
| | | | | |
|X| | | | |
|X| | | |O|

You will have to determine additional methods as we go along.  Obviously, documenting your work is essential since all of us are working on one application!

# Connect4 Class: the roles of the game

Connect4()

Connect4(size)

winner()

toString()

gameOver()

move(player,column)

# Getting Started

Work with your partners to create a GitHub repository for this project. You should meet and outline a basic structure for the application.  Much of it will be unclear but try to determine the relationship among the classes.  I suggest that each of you take one of the classes above, open a branch, and begin some basic coding of that class.
