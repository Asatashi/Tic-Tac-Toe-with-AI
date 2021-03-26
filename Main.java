package tictactoe;



import java.util.Arrays;
import java.util.InputMismatchException;            //now you can chose at the start if u want to play vs bot or user or maybe watch bots fight each other
import java.util.Scanner;

public class Main {

    protected static void rawTable(String[][] table) {         //it displays board
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

    protected static void gameRules(String[][] table, String xs, String os, int count) {
        if (table[0][0].equals(xs) && table[0][1].equals(xs) && table[0][2].equals(xs)          //that's a lot of repeated code, but my brain isn't working well, and i have no idea how to approach this, i will try to fix it when i will get an idea how to do this correctly
                || table[1][0].equals(xs) && table[1][1].equals(xs) && table[1][2].equals(xs)
                || table[2][0].equals(xs) && table[2][1].equals(xs) && table[2][2].equals(xs)
                || table[0][0].equals(xs) && table[1][0].equals(xs) && table[2][0].equals(xs)
                || table[0][1].equals(xs) && table[1][1].equals(xs) && table[2][1].equals(xs)
                || table[0][2].equals(xs) && table[1][2].equals(xs) && table[2][2].equals(xs)
                || table[0][0].equals(xs) && table[1][1].equals(xs) && table[2][2].equals(xs)
                || table[2][0].equals(xs) && table[1][1].equals(xs) && table[0][2].equals(xs)) {
            System.out.println("O wins");
            correctStartInput(table);
        } else if (table[0][0].equals(os) && table[0][1].equals(os) && table[0][2].equals(os)
                || table[1][0].equals(os) && table[1][1].equals(os) && table[1][2].equals(os)
                || table[2][0].equals(os) && table[2][1].equals(os) && table[2][2].equals(os)
                || table[0][0].equals(os) && table[1][0].equals(os) && table[2][0].equals(os)
                || table[0][1].equals(os) && table[1][1].equals(os) && table[2][1].equals(os)
                || table[0][2].equals(os) && table[1][2].equals(os) && table[2][2].equals(os)
                || table[0][0].equals(os) && table[1][1].equals(os) && table[2][2].equals(os)
                || table[2][0].equals(os) && table[1][1].equals(os) && table[0][2].equals(os)) {
            System.out.println("X wins");
            correctStartInput(table);
        } else if (count == 1) {
            System.out.println("Draw");
            correctStartInput(table);
        }
    }

    protected static void aiEasyXs(String[][] table, String xs) {
        boolean valid = false;
        System.out.println("Making move level \"easy\"");
        while (!valid) {
            int randomNumOne = (int) (Math.random() * 3 + 1);
            int randomNumTwo = (int) (Math.random() * 3 + 1);
            if (table[randomNumOne - 1][randomNumTwo - 1].equals("  ")) {
                table[randomNumOne - 1][randomNumTwo - 1] = xs;
                rawTable(table);
                valid = true;
            }
        }
    }

    protected static void aiEasyOs(String[][] table, String os) {
        boolean valid = false;
        System.out.println("Making move level \"easy\"");
        while (!valid) {
            int randomNumOne = (int) (Math.random() * 3 + 1);
            int randomNumTwo = (int) (Math.random() * 3 + 1);
            if (table[randomNumOne - 1][randomNumTwo - 1].equals("  ")) {
                table[randomNumOne - 1][randomNumTwo - 1] = os;
                rawTable(table);
                valid = true;
            }
        }
    }

    protected static void playerXs(String[][] table, String xs) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the coordinates: > ");
            try {
                int firstInput = scanner.nextInt();
                int secondInput = scanner.nextInt();
                if (table[firstInput - 1][secondInput - 1].equals("  ")) {
                    table[firstInput - 1][secondInput - 1] = xs;
                    rawTable(table);
                    valid = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }

    protected static void playerOs(String[][] table, String os) {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter the coordinates: > ");
            try {
                int firstInput = scanner.nextInt();
                int secondInput = scanner.nextInt();
                if (table[firstInput - 1][secondInput - 1].equals("  ")) {
                    table[firstInput - 1][secondInput - 1] = os;
                    rawTable(table);
                    valid = true;
                } else {
                    System.out.println("This cell is occupied! Choose another one!");
                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                return;
            } catch (IndexOutOfBoundsException e) {
                System.out.println("Coordinates should be from 1 to 3!");
            }
        }
    }

    protected static void correctStartInput(String[][] table) {
        Scanner scanner = new Scanner(System.in);
        String commandOne;
        String commandTwo;
        boolean valid = false;
        String s = "  ";
        for (String[] strings : table) {
            Arrays.fill(strings, s);
        }
        int count = 9;
        while (!valid) {
            try {
                System.out.print("Input command: > ");
                String[] arrayInput = scanner.nextLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    if (arrayInput[j].equals("start") || arrayInput[j].equals("easy") || arrayInput[j].equals("user")) {
                        commandOne = arrayInput[1];
                        commandTwo = arrayInput[2];
                            rawTable(table);
                            for (int i = 0; i < 9; i++) {
                                displayTable(table, commandTwo, commandOne,count);
                                valid = true;
                            }
                    } else if (arrayInput[0].equals("exit")) {
                        System.exit(0);
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Bad parameters!");
            }
        }
    }

    protected static void displayTable(String[][] table, String commandTwo, String commandOne,int count) {       //it displays the game board with user input
        for (String[] strings : table) {
            for (String string : strings) {
                if (!string.equals("  ")) {
                    count--;
                }
            }
        }
        String os = "O ";
        String xs = "X ";
        if ((count == 1 || count == 3 || count == 5 || count == 7 || count == 9)) {
            if (commandOne.equals("easy")) {
                aiEasyXs(table,xs);
            } else {
                playerXs(table,xs);
            }
        } else if (commandTwo.equals("easy")) {
            aiEasyOs(table,os);
        } else {
            playerOs(table,os);
        }
        gameRules(table, os, xs, count);
    }

    public static void main(String[] args) {
        String[][] table = new String[3][3];
        correctStartInput(table);
    }
}