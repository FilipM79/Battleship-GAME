package battleship;

class Game {

    void play () {

        Field battleField = new Field();
        PositionVessel positionVessel = new PositionVessel();
        CheckUserInput check = new CheckUserInput();
        battleField.blank();


        boolean gameLoopCondition = true;
        while (gameLoopCondition) {

            positionVessel.aircraftCarrier();

            if (CheckUserInput.isInputOkCondition() && CheckUserInput.isCorrectLength()) {
                battleField.newField();
                gameLoopCondition = false;
            }
        }

        gameLoopCondition = true;
        while (gameLoopCondition) {

            positionVessel.battleShip();

            if(CheckUserInput.isInputOkCondition() && CheckUserInput.isCorrectLength()) {
                battleField.newField();
                gameLoopCondition = false;
            }
        }

        gameLoopCondition = true;
        while (gameLoopCondition) {

            positionVessel.submarine();

            if(CheckUserInput.isInputOkCondition() && CheckUserInput.isCorrectLength()) {
                battleField.newField();
                gameLoopCondition = false;
            }
        }

        gameLoopCondition = true;
        while (gameLoopCondition) {

            positionVessel.destroyer();

            if(CheckUserInput.isInputOkCondition() && CheckUserInput.isCorrectLength()) {
                battleField.newField();
                gameLoopCondition = false;
            }
        }

        gameLoopCondition = true;
        while (gameLoopCondition) {

            positionVessel.patrolBoat();

            if(CheckUserInput.isInputOkCondition() && CheckUserInput.isCorrectLength()) {
                battleField.newField();
                gameLoopCondition = false;
            }
        }
    }
}
