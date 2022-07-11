package battleship;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CheckSurroundings {

    String[][] shipSurroundingField;
    List<String> checkAroundShip = new ArrayList<>();
    boolean checkSurroundings;

    String checkTestField () {

        checkAroundShip.clear();

//      Making a small array field that surrounds a ship, horizontally or ...
        if (Field.rowDiff == 0) {
            shipSurroundingField = new String[3][Field.currentShipLength + 2];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(Field.testField[i + Field.c1RowNum], Field.c1ColumnNum, shipSurroundingField[i],
                        0, Field.currentShipLength + 2);
            }
        }

        if (Field.columnDiff == 0) {
            shipSurroundingField = new String[Field.currentShipLength + 2][3];
            for (int i = 0; i < Field.currentShipLength + 2; i++) {
                System.arraycopy(Field.testField[i + Field.c1RowNum], Field.c1ColumnNum, shipSurroundingField[i],
                        0, 3);
            }
        }

//          populating list for checking around ship.
        for (String[] array : shipSurroundingField) {
            checkAroundShip.addAll(Arrays.asList(array));
        }

        checkSurroundings = checkAroundShip.contains("O ");

        if (checkSurroundings) {
            return """
                    Too close to another ship. Ships cannot touch. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
            return "";
        }
    }
}
