package tictactoe;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void rawTable(String[][] table) {         //it displays board
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


    public static void displayTable(String[][] table, int count) {       //it displays the game board with user input
        Scanner scanner = new Scanner(System.in);
        int firstInput = 0;
        int secondInput = 0;
        String replacement;
        replacement = Arrays.deepToString(table);
        String replace;
        replace = replacement.replaceAll("  ", "_");
        replacement = replace;
        replace = replacement.replaceAll(",", "");
        replacement = replace;
        replace = replacement.replaceAll("\\[", "");
        replacement = replace;
        replace = replacement.replaceAll("]", "");
        replacement = replace;
        replace = replacement.replaceAll(" ", "");
        replacement = replace;
        System.out.println("Enter the cells: > " + replacement);
        rawTable(table);
        String os = "O ";
        String xs = "X ";
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the coordinates: > ");
            try {
                firstInput = scanner.nextInt();
                secondInput = scanner.nextInt();
            } catch (InputMismatchException e) {        //TODO handle repeating catch in line 59
                System.out.println("You should enter numbers!");
            }
//            TODO  loop if input is incorrect (or en error occurs)
//                TODO also make win condition
            try {
                if (table[firstInput - 1][secondInput - 1].equals("  ")) {
                    if (count == 0 || count == 2 || count == 4 || count == 6 || count == 8) {
                        table[firstInput - 1][secondInput - 1] = os;
                    } else {
                        table[firstInput - 1][secondInput - 1] = xs;
                    }
                    valid = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
            rawTable(table);
        }

    public static void main(String[] args) {
        String[][] table = new String[3][3];
        String s = "  ";
        int count = 0;
        for (String[] strings : table) {
            Arrays.fill(strings, s);
        }
        for (int i = 0; i < 9; i++) {
            displayTable(table,count);
            count++;
        }
    }
}
