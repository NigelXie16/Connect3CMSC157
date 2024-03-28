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




