package tictactoe;


import java.util.Arrays;

public class Main {

    public static void display(String[][] x) {
        for (String[] strings : x) {
            for (String string : strings) {
                System.out.print(string + " ");
            }
            System.out.println();
        }
    }

    public static void displayTable(StringBuilder tableString, String[][] table) {       //it displays the game board
            tableString.append(Arrays.toString(table));     //the game board displays correctly
            System.out.println();                           //now i will take care of user input and errors
            tableString.append(Arrays.deepToString(table));
            System.out.println("---------");
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {
                System.out.print(table[0][i]);
            }
            System.out.println("|");
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {
                System.out.print(table[1][i]);
            }
            System.out.println("|");
            System.out.print("| ");
            for (int i = 0; i < 3; i++) {
                System.out.print(table[2][i]);
            }
            System.out.println("|");
            System.out.println("---------");
        }

    public static void main(String[] args) {
        String[][] table = new String[3][3];
        String s = "  ";
        for (String[] strings : table) {
            Arrays.fill(strings, s);
        }
        StringBuilder tableString = new StringBuilder();
        tableString.append(Arrays.deepToString(table));
        displayTable(tableString,table);
    }
}
