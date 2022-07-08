package battleship;

class Game extends CheckUserInput {

    void play () {

        Field battleField = new Field();
        PositionVessel positionVessel = new PositionVessel();
        CheckUserInput check = new CheckUserInput();

        battleField.blank();

        positionVessel.aircraftCarrier();
        battleField.newField();

        positionVessel.battleShip();
        battleField.newField();

        positionVessel.submarine();
        battleField.newField();

        positionVessel.destroyer();
        battleField.newField();

        positionVessel.patrolBoat();
        battleField.newField();
    }
}
