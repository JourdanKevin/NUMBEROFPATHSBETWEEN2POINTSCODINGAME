import java.util.*;
import java.io.*;
import java.math.*;
/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {
    
    static int nChemin(int XCount, int YCount, int tab[][]) 
    { 
        //peut aller soit en haut ou a gauche
        // System.err.println(XCount+ ","+ YCount);
        if (XCount == 0 && YCount == 0) return 1; // arriver   
        if (XCount > 0){
            if (YCount > 0){
                if (tab[XCount - 1][YCount] == 0 && tab[XCount][YCount - 1] == 0) // 2 chemin
                    return nChemin(XCount - 1, YCount, tab) + nChemin(XCount, YCount - 1, tab);
            }
            if (tab[XCount - 1][YCount] == 0) // 1 chemin
                return nChemin(XCount - 1, YCount, tab) ;
        }
        if (YCount > 0)
            if (tab[XCount][YCount - 1] == 0) // 1 chemin
                return nChemin(XCount, YCount - 1, tab) ;             
        return 0; // aucun chemin
    } 
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int Y = in.nextInt(); // col
        int X = in.nextInt(); // ligne
        // System.err.println(Y);
        // System.err.println(X);
        int[][] tab = new int[Y][X];
        if (in.hasNextLine()) {
            in.nextLine();
        }
        for (int i = 0; i < X; i++) {
            String ROW = in.nextLine();
            int j = 0;
            // System.err.println(ROW);
            for (String s : ROW.split(""))
                tab[i][j++] = Integer.parseInt(s);
        }
        // Write an answer using System.out.println()
        // To debug: System.err.println("Debug messages...");
        System.out.println(nChemin(X - 1,Y - 1,tab));
    }
}