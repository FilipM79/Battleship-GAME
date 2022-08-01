package battleship;

import java.io.File;
import java.io.IOException;
import java.util.*;

class Player1 extends JointVariables {

    String[][] shipSurroundingField;
    String[][] labelledField = new String[11][11];
    String[][] testField = new String[13][13];
    List<String> listOfValuesAroundShip = new ArrayList<>();
    List<String> listOfLabelledField = new ArrayList<>();

    boolean endGame = false;
    String userInput;
    int sunkCounter = 0;

    protected void makeFields() {
//    Making blank game field from file
        File file = new File("C:\\Users\\Filip\\IdeaProjects" +
                "\\Battleship\\Battleship\\task\\src\\battleship\\battleField.txt");

        try (Scanner fileScanner = new Scanner(file)) {

            for(String[] arr1 : blankField)
                Arrays.fill(arr1, " ");

//          Populating blank field from file
            for (int rows = 0; rows < blankField.length; rows++) {
                for (int columns = 0; columns < blankField[rows].length; columns += 2) {
                    blankField[rows][columns] = fileScanner.next() + " ";
                }
            } blankField[0][0] = "  ";

//          Populating battlefield from blank field.
            for (int i = 0; i < battlefield.length; i++) {
                for (int j = 0; j < battlefield[i].length; j++) {
                    battlefield[i][j] = blankField[i][j * 2];
                }
            }

//          Populating testField with "* "
            for(String[] arr1 : testField)
                Arrays.fill(arr1, "* ");

//          Copying battleField to fogField.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, fogField[i], 0, 11);
            }

//          Copying battleField to labelledField.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, labelledField[i], 0, 11);
            }

//          Copying battleField to testField.
            for (int i = 0; i < 11; i++) {
                System.arraycopy(battlefield[i], 0, testField[i + 1], 1, 11);
            } testField[1][1] = "* ";

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    protected void printBlankField() {
        System.out.println();
        for (String[] strings : blankField) {
            for (int j = 0; j < strings.length; j += 2) {
                System.out.print(strings[j]);
            } System.out.println();
        }
    }
    protected void addAircraftCarrier() {

        loopCondition = true;
        while (loopCondition) {
            Ship ship = new Ship("Aircraft Carrier", 5);
            shipName = ship.name;
            validateShip(ship.name, ship.length);
        }
        addShipToField();
        printBattlefield();
    }
    protected void addBattleShip() {

        loopCondition = true;
        while (loopCondition) {
            Ship ship = new Ship("Battleship", 4);
            shipName = ship.name;
            validateShip(ship.name, ship.length);
        }
        addShipToField();
        printBattlefield();
    }
    protected void addSubmarine() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Submarine", 3);
            shipName = ship.name;
            validateShip(ship.name, ship.length);
        }
        addShipToField();
        printBattlefield();
    }
    protected void addCruiser() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Cruiser", 3);
            shipName = ship.name;
            validateShip(ship.name, ship.length);
        }
        addShipToField();
        printBattlefield();
    }
    protected void addDestroyer() {

        loopCondition = true;

        while (loopCondition) {
            Ship ship = new Ship("Destroyer", 2);
            shipName = ship.name;
            validateShip(ship.name, ship.length);
        }
        addShipToField();
        printBattlefield();
    }
    private void validateShip(String shipName, int shipLength) {

        System.out.println("\nEnter the coordinates of the " + shipName + " (" + shipLength + " cells):");
        System.out.print("> ");

        currentShipLength = shipLength;

        try {
            userInput = scanner.nextLine().toUpperCase().trim();

            if (Objects.equals(checkShipInput(userInput, currentShipLength), "")) {
                if (Objects.equals(checkForShipsNearby(), "")) {
                    loopCondition = false;
                } else {
                    System.out.println(checkForShipsNearby());
                }
            } else {
                System.out.println(checkShipInput(userInput, currentShipLength));
            }

        } catch (Exception e) {
            System.out.println("Error. Invalid input. Try again.");
            System.out.println("Input should contain two coordinates with a space between them.");
            System.out.println("Example: 'b2 e2', or 'C1 C5'.");
        }
    }
    String checkShipInput(String userInput, int currentShipLength) {

//        Checking if input format is ok.
        if (userInput.isBlank()) {
            return "Error. Input coordinates are empty. Try again." + "\n" +
                    "Input should contain two coordinates with a space between them." + "\n" +
                    "Example: 'b2 e2', or 'C1 C5'.";

        } else if (!userInput.contains(" ")) {
            return "Error. There is no space between input coordinates. Try again." + "\n" +
                    "Input should contain two coordinates with a space between them." + "\n" +
                    "Example: 'b2 e2', or 'C1 C5'.";

        } else {
            int ascii_A_index = 64;
            int inputLength = userInput.length();

            int spaceIndex = userInput.indexOf(" ");
            String c1 = userInput.substring(0, spaceIndex);
            String c2 = userInput.substring(spaceIndex + 1, inputLength);

            c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
            c2RowNum = (byte) c2.charAt(0) - ascii_A_index;
            c1ColumnNum = Integer.parseInt(c1.substring(1));
            c2ColumnNum = Integer.parseInt(c2.substring(1));

//            Switching rowNum places if first input value is bigger than second.
            if (c2RowNum < c1RowNum) {
                int temporary = c1RowNum;
                c1RowNum = c2RowNum;
                c2RowNum = temporary;
            } rowDiff = Math.abs(c2RowNum - c1RowNum);

//            Switching columnNum places if first input value is bigger than second.
            if (c2ColumnNum < c1ColumnNum) {
                int temporary = c1ColumnNum;
                c1ColumnNum = c2ColumnNum;
                c2ColumnNum = temporary;
            } columnDiff = Math.abs(c2ColumnNum - c1ColumnNum);

//          Confirming that the length of the ship is correct.
            boolean appropriateLength = (currentShipLength - 1 == columnDiff || currentShipLength - 1 == rowDiff);

//          Checking for other errors in input.
            if (Player1.c1ColumnNum > 11 || Player1.c2ColumnNum > 11 || Player1.c1RowNum > 11 || Player1.c2RowNum > 11 ||
                    Player1.c1ColumnNum < 1 || Player1.c1RowNum < 1) {

                return "Error. Input coordinates are out of battlefield range." + "\n" +
                        "Row range is: A-J, column range is: 1-10. Try again." + "\n" +
                        "Input should contain two coordinates with a space between them." + "\n" +
                        "Example: 'b2 e2', or 'C1 C5'.";

            } else if (columnDiff != 0 && rowDiff != 0) {
                return "Error. You can only position a ship horizontally or vertically, not diagonally. Try again.\n" +
                       "Input should contain two coordinates with a space between them." + "\n" +
                       "Example: 'b2 e2', or 'C1 C5'.";

            } else if (!appropriateLength) {
                return "Error. Incorrect length of the ship. Try again." + "\n" +
                        "Input should contain two coordinates with a space between them." + "\n" +
                        "Example: 'b2 e2', or 'C1 C5'.";

            } else {
//          If everything is ok with the input.
                return "";
            }
        }
    }
    private String checkForShipsNearby() {

        listOfValuesAroundShip.clear();

//      Making a small array field that surrounds a ship, horizontally or ...
        if (rowDiff == 0) {
            shipSurroundingField = new String[3][currentShipLength + 2];
            for (int i = 0; i < 3; i++) {
                System.arraycopy(testField[i + Player1.c1RowNum], Player1.c1ColumnNum, shipSurroundingField[i],
                        0, currentShipLength + 2);
            }
        }
//      ... vertically.
        if (columnDiff == 0) {
            shipSurroundingField = new String[currentShipLength + 2][3];
            for (int i = 0; i < currentShipLength + 2; i++) {
                System.arraycopy(testField[i + Player1.c1RowNum], Player1.c1ColumnNum, shipSurroundingField[i],
                        0, 3);
            }
        }

//      Populating list for checking around ship.
        for (String[] array : shipSurroundingField) {
            listOfValuesAroundShip.addAll(Arrays.asList(array));
        }

        boolean surroundingsOccupied = listOfValuesAroundShip.contains("O ");

        if (surroundingsOccupied) {
            return """
                    Error. Too close to another ship. Ships cannot touch. Try again.
                    Input should contain two coordinates with a space between them.
                    Example: 'b2 e2', or 'C1 C5'.""";

        } else {
            return "";
        }
    }
    void addShipToField() {

        try {
//          Putting the ship in the fields horizontally or ...
            if (rowDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    for (int j = c1ColumnNum; j < c2ColumnNum + 1; j++) {
                        battlefield[c1RowNum][j] = "O ";
                        if (Objects.equals(shipName, "Aircraft Carrier")) {
                            labelledField[c1RowNum][j] = "a ";
                            listOfLabelledField.add("a ");
                        } else if (Objects.equals(shipName, "Battleship")) {
                            labelledField[c1RowNum][j] = "b ";
                            listOfLabelledField.add("b ");
                        } else if (Objects.equals(shipName, "Submarine")) {
                            labelledField[c1RowNum][j] = "s ";
                            listOfLabelledField.add("s ");
                        } else if (Objects.equals(shipName, "Cruiser")) {
                            labelledField[c1RowNum][j] = "c ";
                            listOfLabelledField.add("c ");
                        } else if (Objects.equals(shipName, "Destroyer")) {
                            labelledField[c1RowNum][j] = "d ";
                            listOfLabelledField.add("d ");
                        }
                    }
                }

//          * ...vertically
            } else if (columnDiff == 0) {
                for (int i = c1RowNum; i < c2RowNum + 1; i++) {
                    battlefield[i][c2ColumnNum] = "O ";
                    if (Objects.equals(shipName, "Aircraft Carrier")) {
                        labelledField[i][c2ColumnNum] = "a ";
                        listOfLabelledField.add("a ");
                    } else if (Objects.equals(shipName, "Battleship")) {
                        labelledField[i][c2ColumnNum] = "b ";
                        listOfLabelledField.add("b ");
                    } else if (Objects.equals(shipName, "Submarine")) {
                        labelledField[i][c2ColumnNum] = "s ";
                        listOfLabelledField.add("s ");
                    } else if (Objects.equals(shipName, "Cruiser")) {
                        labelledField[i][c2ColumnNum] = "c ";
                        listOfLabelledField.add("c ");
                    } else if (Objects.equals(shipName, "Destroyer")) {
                        labelledField[i][c2ColumnNum] = "d ";
                        listOfLabelledField.add("d ");
                    }
                }
            }

//          Copying battleField to testField.
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
    void printFogField() {
        System.out.println();
        for (String[] strings : fogField) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
    void shoot() {

        loopCondition = true;
        while (loopCondition) {

            System.out.println("\nPlayer1, take a shot!");
            System.out.print("> ");

            try {
                userInput = scanner.nextLine().toUpperCase().trim();
//              Check for errors in input format
                if (userInput.isBlank()) {
                    System.out.println( "Error. Input is empty. Shoot again.");

                } else if (userInput.length() > 3) {
                    System.out.println( "Error. Too many characters in input. Shoot again.");

                } else {
                    int ascii_A_index = 64;
                    int inputLength = userInput.length();

                    String c1 = userInput.substring(0, inputLength);

                    c1RowNum = (byte) c1.charAt(0) - ascii_A_index;
                    c1ColumnNum = Integer.parseInt(c1.substring(1));

//                  Checking for other errors in input.
                    if (c1ColumnNum > 10 || c1RowNum > 10
                            || c1ColumnNum < 1 || c1RowNum < 1) {
                        System.out.println("Error. Input coordinates are out of battlefield range. Shoot again.");

                    }   else {
//                      If everything is ok with the input.
                        loopCondition = false;
                    }
                }

            } catch (Exception e) {
                System.out.println("Error. Invalid input. Shoot again.");
            }

        }
    }
    void addShotToField() {

        if (Objects.equals(battlefield[c1RowNum][c1ColumnNum], "O ")) {
            battlefield[c1RowNum][c1ColumnNum] = "X ";
            fogField[c1RowNum][c1ColumnNum] = "X ";

            switch (labelledField[c1RowNum][c1ColumnNum]) {
                case "a " -> listOfLabelledField.remove("a ");
                case "b " -> listOfLabelledField.remove("b ");
                case "s " -> listOfLabelledField.remove("s ");
                case "c " -> listOfLabelledField.remove("c ");
                case "d " -> listOfLabelledField.remove("d ");
            }

        } else if (Objects.equals(battlefield[c1RowNum][c1ColumnNum], "X ")){ // ???
            battlefield[c1RowNum][c1ColumnNum] = "X ";
            fogField[c1RowNum][c1ColumnNum] = "X ";
        }

        else if (Objects.equals(battlefield[c1RowNum][c1ColumnNum], "M ")){ // ???
            battlefield[c1RowNum][c1ColumnNum] = "M ";
            fogField[c1RowNum][c1ColumnNum] = "M ";
            missP2 = true;

        } else {
            battlefield[c1RowNum][c1ColumnNum] = "M ";
            fogField[c1RowNum][c1ColumnNum] = "M ";
            missP2 = true;
        }
        shotMessage();
    }
    void shotMessage() {

        String hitOrMiss;
        boolean aircraftCarrierSunk = !listOfLabelledField.contains("a ");
        boolean battleshipSunk = !listOfLabelledField.contains("b ");
        boolean submarineSunk = !listOfLabelledField.contains("s ");
        boolean cruiserSunk = !listOfLabelledField.contains("c ");
        boolean destroyerSunk = !listOfLabelledField.contains("d ");

        if (Objects.equals(labelledField[c1RowNum][c1ColumnNum], "a ")
                || Objects.equals(labelledField[c1RowNum][c1ColumnNum], "b ")
                || Objects.equals(labelledField[c1RowNum][c1ColumnNum], "s ")
                || Objects.equals(labelledField[c1RowNum][c1ColumnNum], "c ")
                || Objects.equals(labelledField[c1RowNum][c1ColumnNum], "d ")) {

            if (aircraftCarrierSunk) {
                if (sunkCounter < 4) {
                    hitOrMiss = "Player 2, you sank an Aircraft Carrier. Choose your next target.";
                    listOfLabelledField.add("a ");
                    sunkCounter++;
                } else {
                    hitOrMiss = "Player 2, you sank the last ship. You won. \nCongratulations!";
                    endGame = true;
                }

            } else if (battleshipSunk) {
                if (sunkCounter < 4) {
                    hitOrMiss = "Player 2, you sank a Battleship. Choose your next target.";
                    listOfLabelledField.add("b ");
                    sunkCounter++;
                } else {
                    hitOrMiss = "Player 2, you sank the last ship. You won. \nCongratulations!";
                    endGame = true;
                }

            } else if (submarineSunk) {
                if (sunkCounter < 4) {
                    hitOrMiss = "Player 2, you sank a Submarine. Choose your next target.";
                    listOfLabelledField.add("s ");
                    sunkCounter++;
                } else {
                    hitOrMiss = "Player 2, you sank the last ship. You won. \nCongratulations!";
                    endGame = true;
                }

            } else if (cruiserSunk) {
                if (sunkCounter < 4) {
                    hitOrMiss = "Player 2, you sank a Cruiser. Choose your next target.";
                    listOfLabelledField.add("c ");
                    sunkCounter++;
                } else {
                    hitOrMiss = "Player 2, you sank the last ship. You won. \nCongratulations!";
                    endGame = true;
                }

            } else if (destroyerSunk) {
                if (sunkCounter < 4) {
                    hitOrMiss = "Player 2, you sank a Destroyer. Choose your next target.";
                    listOfLabelledField.add("d ");
                    sunkCounter++;
                } else {
                    hitOrMiss = "Player 2, you sank the last ship. You won. \nCongratulations!";
                    endGame = true;
                }

            } else {
                hitOrMiss = "Player 2, you hit a ship! Shoot again.";
            }


        } else {
            hitOrMiss = "Player 2, you missed!";
        }

        System.out.println("\n" + hitOrMiss);

//        System.out.println("Press Enter and pass the move to another player.");
//        while (enter.charAt(0) != 10) {
//            enter = scanner.next();
//            if (enter.charAt(0) == 10) {
//                for (int i = 0; i < 100; ++i) System.out.println();
//                System.out.println("Another player shoots now ... ");
//            } else {
//                System.out.println("Press Enter and pass the move to another player.");
//            }
//        }
    }
}
