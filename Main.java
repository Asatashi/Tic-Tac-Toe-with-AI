package tictactoe;


import java.util.Arrays;

public class Main {

    public static void displayTable(StringBuilder tableString) {       //it displays the game board
        //now get rid of "[],"  in array before printing all things

        System.out.println("---------");
        System.out.print("|");
        for (int i = 0; i < 2; i++) {
            System.out.print(tableString.charAt(i));
        }
        System.out.println("|");
        System.out.print("|");
        for (int i = 3; i < 5; i++) {
            System.out.print(tableString.charAt(i));
        }
        System.out.println("|");
        System.out.print("|");
        for (int i = 6; i < 9; i++) {
            System.out.print(tableString.charAt(i));
        }
        System.out.println("|");
        System.out.println("---------");
    }


    public static void main(String[] args) {
        char[][] table = new char[3][3];
        char c = '_';
        for (char[] chars : table) {
            Arrays.fill(chars, c);
        }
        System.out.println(Arrays.deepToString(table));
        StringBuilder tableString = new StringBuilder();
        tableString.append(Arrays.deepToString(table));
        System.out.println("Enter the cells: " + tableString);
        displayTable(tableString);
    }
}
