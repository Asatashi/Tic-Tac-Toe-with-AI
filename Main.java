package tictactoe;


import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {     //TODO win condition done but i have to do initial start chosen by user at the start of the game

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
        int counter = 0;
        counter++;
        int firstInput;
        int secondInput;
        String replacement;
        replacement = Arrays.deepToString(table);
        String replace;
        replace = replacement.replaceAll(" {2}", "_");
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
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                scanner.next();
                scanner.next();
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
        if (    table[0][0].equals(xs) && table[0][1].equals(xs) && table[0][2].equals(xs)          //that's a lot of repeated code, but my brain isn't working well, and i have no idea how to approach this
                || table[1][0].equals(xs) && table[1][1].equals(xs) && table[1][2].equals(xs)
                || table[2][0].equals(xs) && table[2][1].equals(xs) && table[2][2].equals(xs)
                || table[0][0].equals(xs) && table[1][0].equals(xs) && table[2][0].equals(xs)
                || table[0][1].equals(xs) && table[1][1].equals(xs) && table[2][1].equals(xs)
                || table[0][2].equals(xs) && table[1][2].equals(xs) && table[2][2].equals(xs)
                || table[0][0].equals(xs) && table[1][1].equals(xs) && table[2][2].equals(xs)
                || table[2][0].equals(xs) && table[1][1].equals(xs) && table[0][2].equals(xs)) {
            System.out.println("X wins");
            rawTable(table);
            System.exit(0);
        } else if (table[0][0].equals(os) && table[0][1].equals(os) && table[0][2].equals(os)
                || table[1][0].equals(os) && table[1][1].equals(os) && table[1][2].equals(os)
                || table[2][0].equals(os) && table[2][1].equals(os) && table[2][2].equals(os)
                || table[0][0].equals(os) && table[1][0].equals(os) && table[2][0].equals(os)
                || table[0][1].equals(os) && table[1][1].equals(os) && table[2][1].equals(os)
                || table[0][2].equals(os) && table[1][2].equals(os) && table[2][2].equals(os)
                || table[0][0].equals(os) && table[1][1].equals(os) && table[2][2].equals(os)
                || table[2][0].equals(os) && table[1][1].equals(os) && table[0][2].equals(os)) {
            System.out.println("O wins");
            rawTable(table);
            System.exit(0);
        } else if (counter == 9) {
            System.out.println("Draw");
            rawTable(table);
            System.exit(0);
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
