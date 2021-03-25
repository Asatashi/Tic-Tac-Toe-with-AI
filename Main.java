package tictactoe;



import java.util.Arrays;
import java.util.InputMismatchException;            //now you can chose at the start if u want to play vs bot or user or maybe watch bots fight each other
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

    public static void gameRules(String[][] table, String xs, String os, int count) {
        if (table[0][0].equals(xs) && table[0][1].equals(xs) && table[0][2].equals(xs)          //that's a lot of repeated code, but my brain isn't working well, and i have no idea how to approach this, i will try to fix it when i will get an idea how to do this correctly
                || table[1][0].equals(xs) && table[1][1].equals(xs) && table[1][2].equals(xs)
                || table[2][0].equals(xs) && table[2][1].equals(xs) && table[2][2].equals(xs)
                || table[0][0].equals(xs) && table[1][0].equals(xs) && table[2][0].equals(xs)
                || table[0][1].equals(xs) && table[1][1].equals(xs) && table[2][1].equals(xs)
                || table[0][2].equals(xs) && table[1][2].equals(xs) && table[2][2].equals(xs)
                || table[0][0].equals(xs) && table[1][1].equals(xs) && table[2][2].equals(xs)
                || table[2][0].equals(xs) && table[1][1].equals(xs) && table[0][2].equals(xs)) {
            System.out.println("O wins");
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
            System.out.println("X wins");
            rawTable(table);
            System.exit(0);
        } else if (count == 1) {
            System.out.println("Draw");
            rawTable(table);
            System.exit(0);
        }
    }

    public static void aiEasyXs(String[][] table, String xs) {
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

    public static void aiEasyOs(String[][] table, String os) {
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

    public static void playerXs(String[][] table, String xs) {
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

    public static void playerOs(String[][] table, String os) {
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

    public static void correctStartInput(String[][] table) {
        Scanner scanner = new Scanner(System.in);
        String commandOne;
        String commandTwo;
        String userCorrect = "user";
        String aiCorrect = "easy";
        boolean valid = false;
        while (!valid) {
            try {
                System.out.print("Input command: > ");
                String[] arrayInput = scanner.nextLine().split(" ");
                for (int j = 0; j < 3; j++) {
                    if (arrayInput[j].equals("start") || arrayInput[j].equals("easy") || arrayInput[j].equals("user")) {
                        commandOne = arrayInput[1];
                        commandTwo = arrayInput[2];
                        if (commandOne.equals(userCorrect) && commandTwo.equals(aiCorrect) || commandOne.equals(aiCorrect) && commandTwo.equals(userCorrect)) {
                            rawTable(table);
                            for (int i = 0; i < 9; i++) {
                                displayTable(table, commandTwo, commandOne);
                                valid = true;
                            }
                        } else if (commandOne.equals(aiCorrect) && commandTwo.equals(aiCorrect)) {
                            rawTable(table);
                            for (int i = 0; i < 9; i++) {
                                displayTable(table, commandTwo, commandOne);
                                valid = true;
                            }
                        } else if (commandOne.equals(userCorrect) && commandTwo.equals(userCorrect)) {
                            rawTable(table);
                            for (int i = 0; i < 9; i++) {
                                displayTable(table, commandTwo, commandOne);
                                valid = true;
                            }
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

    public static void displayTable(String[][] table, String commandTwo, String commandOne) {       //it displays the game board with user input
        int count = 9;
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
        String s = "  ";
        for (String[] strings : table) {
            Arrays.fill(strings, s);
        }
        correctStartInput(table);
    }
}