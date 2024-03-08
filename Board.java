class Board()
//instance variables 
{
int len;
Piece p;
int col;
Piece [][] B;

public Board()
//constructor, initially each spot set to null
{
    len=5;
    for(int i=0; i<len; i++){
        for(int j=0; j<len; j++){
            B[i][j]=null;
        }
    }
}
public Board( int col)
//constructor 
{
this.len=col;
}
public int getSize()
//return board size 
{
return len;
}
public String toString()
//return the board String to visible set of columns 
{




}
public add(Piece P, int col)
//add piece to a column     
{
    while(int j=0; j<len; ){
        if B[col][j]
    }
}







}
