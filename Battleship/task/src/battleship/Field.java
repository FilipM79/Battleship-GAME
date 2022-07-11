package battleship;

import java.io.File;
import java.io.IOException;
import java.util.*;

class Field {

    String userInput;
    int currentShipLength;
    String[][] blankField = new String[11][21];
    String[][] battlefield = new String[11][11];
    String[][] testField = new String[13][13];
    String[][] shipSurroundingField;
    List<String> listOfValuesAroundShip = new ArrayList<>();
    boolean surroundingsOccupied;
    boolean appropriateLength;
    boolean loopCondition;

    static int c1RowNum;
    static int c2RowNum;
    static int c1ColumnNum;
    static int c2ColumnNum;
    static int rowDiff;
    static int columnDiff;

    static class Ship {

        Ship(String name, int length) {
            this.name = name;
            this.length = length;
        }

        String name;
        int length;
    }

    void makeBlankField() {
//    Making blank game field from file
        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)) {

            for(String[] arr1 : blankField)
                Arrays.fill(arr1, " ");

//            Populating blank field from file
            for (int rows = 0; rows < blankField.length; rows++) {
                for (int columns = 0; columns < blankField[rows].length; columns += 2) {
                    blankField[rows][columns] = fileScanner.next() + " ";
                }
            } blankField[0][0] = "  ";

//            Populating battlefield from blank field.
            for (int i = 0; i < battlefield.length; i++) {
                for (int j = 0; j < battlefield[i].length; j++) {
                    battlefield[i][j] = blankField[i][j * 2];
                }
            }
//
//            Populating previousStateField with "* "
            for(String[] arr1 : testField)
                Arrays.fill(arr1, "* ");

//            Populating updatedFieldCopy from updated field.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, testField[i + 1], 1, 11);
            }

            testField[1][1] = "* ";

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    void printBlankField() {
        System.out.println();
        for (String[] strings : blankField) {
            for (int j = 0; j < strings.length; j += 2) {
                System.out.print(strings[j]);
            } System.out.println();
        }
    }
    String checkUserInput(String userInput, int currentShipLength) {
//    Validates if input string is ok.


//        Checking if input format is ok.
        if (userInput.isBlank()) {
            return """
                    Error. Input coordinates are empty. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else if (!userInput.contains(" ")) {
            return """
                    Error. There is no space between input coordinates. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
//
            generateCoordinates(userInput, currentShipLength);

//            Checking for other errors in input.
            if (Field.c1ColumnNum > 11 || Field.c2ColumnNum > 11
                    || Field.c1RowNum > 11 || Field.c2RowNum > 11) {
                return """
                        Error. Input coordinates are out of battlefield range.
                        Row range is: A-J, column range is: 1-10. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (columnDiff != 0 && rowDiff != 0) {
                return """
                        Error. You can only position a ship horizontally or vertically, not diagonally. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else if (!appropriateLength) {
                return """
                        Error. Incorrect length of the ship. Try again.
                        Input should contain two coordinates with a space between them.
                        Example: 'b2 e2', or 'C1 C5'.""";

            } else {
//          If everything is ok with the input.
                return "";
            }
        }
    }
    void generateCoordinates(String userInput, int currentShipLength) {

        int ascii_A_index = 64;
        int inputLength = userInput.length();

        int spaceIndex = userInput.indexOf(" ");
        String c1 = userInput.substring(0, spaceIndex);
        String c2 = userInput.substring(spaceIndex + 1, inputLength);

        c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
        c2RowNum = (byte) c2.charAt(0) - ascii_A_index;
        c1ColumnNum = Integer.parseInt(c1.substring(1));
        c2ColumnNum = Integer.parseInt(c2.substring(1));

//            Switching places if first input value is bigger than second.
        if (c2RowNum < c1RowNum) {
            int temporary = c1RowNum;
            c1RowNum = c2RowNum;
            c2RowNum = temporary;
        } rowDiff = Math.abs(c2RowNum - c1RowNum);
//            Switching places if first input value is bigger than second.
        if (c2ColumnNum < c1ColumnNum) {
            int temporary = c1ColumnNum;
            c1ColumnNum = c2ColumnNum;
            c2ColumnNum = temporary;
        } columnDiff = Math.abs(c2ColumnNum - c1ColumnNum);

//            Confirming that the length of the ship is correct.
        appropriateLength = (currentShipLength - 1 == columnDiff || currentShipLength - 1 == rowDiff);

    }
    void makeAircraftCarrier() {

        loopCondition = true;
        while (loopCondition) {
            Ship ship = new Ship("Aircraft Carrier", 5);
            validateShip(ship.name, ship.length);
        }
    }
    void makeBattleShip() {

        loopCondition = true;
        while (loopCondition) {
            Ship ship = new Ship("Battleship", 4);
            validateShip(ship.name, ship.length);
        }
    }
    void makeSubmarine() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Submarine", 3);
            validateShip(ship.name, ship.length);
        }
    }
    void makeCruiser() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Cruiser", 3);
            validateShip(ship.name, ship.length);
        }
    }
    void makeDestroyer() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Destroyer", 2);
            validateShip(ship.name, ship.length);
        }
    }
    String checkForShipsNearby() {

        listOfValuesAroundShip.clear();

//      Making a small array field that surrounds a ship, horizontally or ...
        if (rowDiff == 0) {
            shipSurroundingField = new String[3][currentShipLength + 2];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(testField[i + Field.c1RowNum], Field.c1ColumnNum, shipSurroundingField[i],
                        0, currentShipLength + 2);
            }
        }
//      ... vertically.
        if (columnDiff == 0) {
            shipSurroundingField = new String[currentShipLength + 2][3];
            for (int i = 0; i < currentShipLength + 2; i++) {
                System.arraycopy(testField[i + Field.c1RowNum], Field.c1ColumnNum, shipSurroundingField[i],
                        0, 3);
            }
        }

//      Populating list for checking around ship.
        for (String[] array : shipSurroundingField) {
            listOfValuesAroundShip.addAll(Arrays.asList(array));
        }

        surroundingsOccupied = listOfValuesAroundShip.contains("O ");

        if (surroundingsOccupied) {
            return """
                    Error. Too close to another ship. Ships cannot touch. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
            return "";
        }
    }
    void validateShip(String shipName, int shipLength) {

        System.out.println("\nEnter the coordinates of the " + shipName + " (" + shipLength + " cells):");
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);

        currentShipLength = shipLength;

        try {
            userInput = scanner.nextLine().toUpperCase().trim();
            Field field = new Field();

            if (Objects.equals(field.checkUserInput(userInput, currentShipLength), "")) {
                if (Objects.equals(checkForShipsNearby(), "")) {
                    loopCondition = false;
                } else {
                    System.out.println(checkForShipsNearby());
                }
            } else {
                System.out.println(field.checkUserInput(userInput, currentShipLength));
            }

        } catch (Exception e) {
            System.out.println("Error. Invalid input. Try again.");
            System.out.println("Input should contain two coordinates with a space between them.");
            System.out.println("Example: 'b2 e2', or 'C1 C5'.");
        }
    }
    void addNewShipToField() {

        try {
//          Putting the ship in the field horizontally or ...
            if (rowDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    for (int j = c1ColumnNum; j < c2ColumnNum + 1; j++) {
                        battlefield[c1RowNum][j] = "O ";
                    }
                }

//          * ...vertically
            } else if (columnDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    battlefield[i][c2ColumnNum] = "O ";
                }
            }

            //            Populating updatedFieldCopy from updated field.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, testField[i + 1], 1, 11);
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    void printBattlefield() {
        System.out.println();
        for (String[] strings : battlefield) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }
    void shoot() {

    }


}
