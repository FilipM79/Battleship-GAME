package battleship;

class SeaBattleGame {

    void play () {

        Field battleField = new Field();
        PositionShip positionShip = new PositionShip();

        battleField.printBlankField();

        positionShip.aircraftCarrier();
        battleField.printUpdatedField();

        positionShip.battleShip();
        battleField.printUpdatedField();

        positionShip.submarine();
        battleField.printUpdatedField();

        positionShip.destroyer();
        battleField.printUpdatedField();

        positionShip.patrolBoat();
        battleField.printUpdatedField();
    }
}
