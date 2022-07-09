package battleship;

class SeaBattleGame {

    void play () {

        GameField gameField = new GameField();
        ValidateShip validateShip = new ValidateShip();
        CheckUserInput checkUserInput = new CheckUserInput();

        gameField.printBlankField();

        validateShip.aircraftCarrier(); // Validating ship.
        gameField.printUpdatedField(); // Updating game field with a new ship, after the validation.

        validateShip.battleShip();
        gameField.printUpdatedField();

        validateShip.submarine();
        gameField.printUpdatedField();

        validateShip.destroyer();
        gameField.printUpdatedField();

        validateShip.patrolBoat();
        gameField.printUpdatedField();
    }
}
