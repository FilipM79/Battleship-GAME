package battleship;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Field extends Main {

    String[][] field = new String[11][21];
    public String[][] blank() {
        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)){

            for (int rows = 0; rows < field.length; rows++) {
                for (int columns = 0; columns < field[rows].length; columns += 2) {
                    field[rows][columns] = fileScanner.next() + " ";
                }
            } field[0][0] = "  ";

            for (String[] strings : field) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                } System.out.println();
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        return new String[0][];
    }

    public String[][] newField() {

        Coordinates coordinates = new Coordinates();

        if (coordinates.getRowDiff() == 0) {
            for (int i = coordinates.getK1RowNum(); i < coordinates.getK2RowNum() + 1; i++) {
                for (int j = coordinates.getK1ColumnNum(); j < coordinates.getK2ColumnNum() + 1; j += 2) {
                    battleField[coordinates.getK1RowNum()][j] = "O ";
                }
            }
            for (String[] strings : battleField) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                }
                System.out.println();
            }

        } else if (coordinates.getColumnDiff() == 0) {
            for (int i = coordinates.getK1RowNum(); i < coordinates.getK2RowNum()+ 1; i++) {
                battleField[i][coordinates.getK2ColumnNum()] = "O ";
            }
            for (String[] strings : battleField) {
                for (int j = 0; j < strings.length; j += 2) {
                    System.out.print(strings[j]);
                }
                System.out.println();
            }
        }
        return new String[0][];
    }
}
