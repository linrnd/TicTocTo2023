import java.util.Arrays;
import java.util.Scanner;


public class Main {

    public static boolean winner;
    public static String p1= "A";
    public static String p2 = "B";
    public static void main(String[] args) {
        String TBoard[][]=new String [3][7];
        BuildBoard(TBoard);
        ChoosePlayeer(TBoard);




    }
    public static void WinGame(boolean winner, String player, String TBoard[][]){
        //horizontal , 3 conditions

        if(TBoard[0][1]==TBoard[0][3]&&TBoard[0][3]==TBoard[0][5]){
            winner=true;
        }
        if(TBoard[1][1]==TBoard[1][3]&&TBoard[1][3]==TBoard[1][5]){
            winner=true;
        }
        if(TBoard[2][1]==TBoard[2][3]&&TBoard[2][3]==TBoard[2][5]){
            winner=true;
        }
        //  X, 2 conditions
        if(TBoard[0][1]==TBoard[1][3]&&TBoard[1][3]==TBoard[0][5]){
            winner=true;
        }
        if(TBoard[0][1]==TBoard[1][3]&&TBoard[1][3]==TBoard[2][5]){
            winner=true;
        }
        // Vertical 3 conditions
         if(TBoard[0][1]==TBoard[1][1]&&TBoard[1][1]==TBoard[2][1]){
             winner=true;
        }
        if(TBoard[0][3]==TBoard[1][3]&&TBoard[1][3]==TBoard[2][3]){
            winner=true;
        }
        if(TBoard[0][5]==TBoard[1][5]&&TBoard[1][5]==TBoard[2][5]){
            winner=true;
        }
        winner=false;
    }

    public static void BuildBoard(String TBoard[][]){

        TBoard [0][0]="+";
        TBoard [0][2]="+";
        TBoard [0][4]="+";
        TBoard [0][6]="+";
        TBoard [2][0]="+";
        TBoard [2][2]="+";
        TBoard [2][4]="+";
        TBoard [2][6]="+";
        TBoard [1][0]="+";
        TBoard [1][2]="+";
        TBoard [1][4]="+";
        TBoard [1][6]="+";
        for(String[] t: TBoard) {
            System.out.println(Arrays.toString(t));
        }
    }
    public static void PutChess(String player,String TBoard[][]){
        //TBoard[0][1], TBoard[0][3], TBoard[0][5], 1,2,3
        //TBoard[1][1], TBoard[1][3], TBoard[1][5], 4,5,6
        //TBoard[2][1], TBoard[2][3], TBoard[2][5],7,8,9
       while(winner==false) {
           Scanner sc = new Scanner(System.in);
           System.out.println("Please choose the number (1-9) of space to put your chess");
           String n = sc.nextLine();
           System.out.println(n);
           if (n == "1") {
               TBoard[0][1] = player;
           }
           if (n == "2") {
               TBoard[0][3] = player;
           }
           if (n == "3") {
               TBoard[0][5] = player;
           }
           if (n == "4") {
               TBoard[1][1] = player;
           }
           if (n == "5") {
               TBoard[1][3] = player;
           }
           if (n == "6") {
               TBoard[1][5] = player;
           }
           if (n == "7") {
               TBoard[2][1] = player;
           }
           if (n == "8") {
               TBoard[2][3] = player;
           }
           if (n == "9") {
               TBoard[2][5] = player;
           }
           if(!n.matches("1|2|3|4|5|6|7|8|9")){
               System.out.println("The input can be only number 1 to 9, other kind of input are not allowed!");
               PutChess(player,TBoard);
           }
           BuildBoard(TBoard);
           break;
       }
    }
    public static void ChoosePlayeer(String TBoard[][]){
            System.out.println("First player please type A or B");
            Scanner p = new Scanner(System.in);
            String s1 = p.nextLine();
            if(s1.equalsIgnoreCase(p1)||s1.equalsIgnoreCase(p2)) {
                PutChess(s1,TBoard);
            }
            else{
                System.out.println("Warning,invalid Input, please give another input.");
                ChoosePlayeer(TBoard);
            }
            String s2 = p.nextLine();
            if(!s1.equals(s2)){
                PutChess(s2,TBoard);
            }else if (s1.equalsIgnoreCase(s2)){
                System.out.println("Warning, no one can put same chess >2 times in a row, Now let another player play! ");
                if(s1.equalsIgnoreCase(p1)){
                    PutChess(p2,TBoard);
                }else{
                    PutChess(p1,TBoard);
                }
            }
    }
}