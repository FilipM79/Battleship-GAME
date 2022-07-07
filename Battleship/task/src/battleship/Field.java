package battleship;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Field {

    String[][] field = new String[11][21];
    String[][] updatedField = new String[11][21];

    public void blank() {

        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)) {

            for (int rows = 0; rows < field.length; rows++) {
                for (int columns = 0; columns < field[rows].length; columns += 2) {
                    field[rows][columns] = fileScanner.next() + " ";
                }
            } field[0][0] = "  ";

            for (String[] strings : field) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                }
                System.out.println();
            }

            // copying field to updatedField
            for (int i = 0; i < updatedField.length; i++) {
                for (int j = 0; j < updatedField[i].length; j += 2) {
                    updatedField[i][j] = field[i][j];
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void newField() {

        CheckUserInput checkUserInput = new CheckUserInput();

        try {
            if (checkUserInput.getRowDiff() == 0) {
                for (int i = checkUserInput.getK1RowNum(); i < checkUserInput.getK2RowNum() + 1; i++) {
                    for (int j = checkUserInput.getK1ColumnNum(); j < checkUserInput.getK2ColumnNum() + 1; j += 2) {
                        updatedField[checkUserInput.getK1RowNum()][j] = "O ";
                    }
                }
                for (String[] strings : updatedField) {
                    for (int j = 0; j < strings.length; j += 2) {
                        System.out.print(strings[j]);
                    }
                    System.out.println();
                }

            } else if (checkUserInput.getColumnDiff() == 0) {
                for (int i = checkUserInput.getK1RowNum(); i < checkUserInput.getK2RowNum() + 1; i++) {
                    updatedField[i][checkUserInput.getK2ColumnNum()] = "O ";
                }
                for (String[] strings : updatedField) {
                    for (int j = 0; j < strings.length; j += 2) {
                        System.out.print(strings[j]);
                    }
                    System.out.println();
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}