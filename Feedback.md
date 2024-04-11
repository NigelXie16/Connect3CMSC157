# CMSC 157
# Hi!  My instructor feedback to you will be in this file that I will update and push from time to time!
-sven


# 3/28/24

I tried running Board and got this:

Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
	at Board.toString(Board.java:57)
	at Board.main(Board.java:82)

You have a loop to len in toString that causes this.  In general, you should use arr.length in your loops, so you don't go off the end of arrays.


At this point I would expect your non-graphics game to work, so clearly there is much to be done here.


# 4/1/24

Added some comments, marked 'XX' to your code.

# 4/8/24

Your work on the GUI interface is very good--just what was called for!

I fixed a minor char return to get Connect4 to compile.  It works, but lacks a main loop you might use for testing.  Add that interaction so you can test it!

Board has a method to find winner, but it needs to be generalized and tested thoroughly.  Check it out.

# 4/11/24

I realized that you had implemented some logic to run the game from Game.java and gave it a try.

It worked fairly well (drawn upside down!).

No winner was detected and eventually it crashed when i tried to insert beyond the capacity of a column.  You need tests for this.

Player 2's turn (Enter column number): 
1
0 1 2 3 4 
|X|O|O| | |
|X|O| | | |
|X|O| | | |
|X|O| | | |
|X| | | | |

Player 1's turn (Enter column number): 
0
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 5 out of bounds for length 5
        at Board.add(Board.java:72)
        at Connect4.move(Connect4.java:51)
        at Game.start(Game.java:25)
        at Game.main(Game.java:8)
(base) sven@cog:Connect3CMSC157$ 

------------------------------

The GUI seems to be where it was last time I checked.

