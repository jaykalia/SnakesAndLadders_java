import java.util.*;
import java.lang.*;
// import java.Math.*;
 class SnakesNLadders
{
  final static int WINPOINT=100;
  static Map <Integer, Integer> snake= new HashMap <Integer,Integer> ();
  static Map <Integer,Integer> ladder=new HashMap <Integer,Integer>();
  {
    snake.put(99,54);
    snake.put(70,55);
    snake.put(52,42);
    snake.put(95,72);

    ladder.put(6,25);
    ladder.put(11,40);
    ladder.put(60,85);
    ladder.put(46,90);
  }
    public void rules()
  {
      System.out.println("1-The object of the game is to reach the 100 mark by moving across the board from the bottom that is from the 0 mark");
      System.out.println("2-first of all decide who goes first, he will be user 1, the second user will be user 2");
      System.out.println("3-when asked print R/r to roll the dice");
      System.out.println("4-there are preset snakes and ladders in the game");
      System.out.println("5-you have to land exactly on the 100 mark to win the game ");
     }
     public void displayTheBoard()
     {  System.out.println("the layout of the board is as follows");

        System.out.println("-----------------------------------------------------------------------------------------------");
      for (int i=100;i>=1;i--)
      {
        System.out.print(i+" ");
        if((i-1)%10==0)
        {
          System.out.println();
        }
      }
      System.out.println("-----------------------------------------------------------------------------------------------");
     }


  public int rollDice()
{
    int n = 0;
    Random r = new Random();
    n=r.nextInt(7);
    return (n==0?1:n);
}


  public int CalculatePlayerValue(int player, int dicevalue)
  {
    player=player+dicevalue;
    if(player>WINPOINT)
    {
      player=player-dicevalue;
    }
    if(snake.containsKey(player))
    {  System.out.println("you got bit by a snake");
      player=snake.get(player);
    }
    if(ladder.containsKey(player))
    {
      System.out.println("you climbed a ladder");
      player=ladder.get(player);
    }

    return player;
  }

   public boolean isWin(int player)
    {
      return WINPOINT==player;
    }


  public void startGame()
  { Scanner sc=new Scanner(System.in);
    String str;
    int player1=0, player2=0;
    int currentPlayer=-1;
    int dicevalue=0;
    do
    {
       System.out.println(currentPlayer==-1?"player 1 turn": "player 2 turn");
       System.out.println("press Y or y to continue");
       str=sc.nextLine();
       dicevalue=rollDice();
       if(currentPlayer==-1)
        {
          player1=CalculatePlayerValue(player1,dicevalue);
          System.out.println("first player: "+ player1);
          System.out.println("second player: "+ player2);
          System.out.println("---------------------------------------------------------------------------------");
          if(isWin(player1))
          {
            System.out.println("player1 wins");
            return;
          }
        }
        else
        {    
          player2=CalculatePlayerValue(player2,dicevalue);
          System.out.println("first player: "+ player1);
          System.out.println("second player: "+ player2);
          System.out.println("---------------------------------------------------------------------------------");
          if(isWin(player2))
          {
            System.out.println("player2 wins");
            return;
          }

        }
        currentPlayer=-currentPlayer;

        }
        while(str.equalsIgnoreCase("y"));
    }
}
  

public class SnakesAndLadders{
  public static void main(String[] args) {
    SnakesNLadders s =new SnakesNLadders();
    s.displayTheBoard();
    s.rules();
    s.startGame();
        
  }
}
