package battleship;

class SeaBattle {

    void play () {

        Field field = new Field();
        MakeShip makeShip = new MakeShip();

        field.makeBlankField();
        field.printBlankField();

        makeShip.aircraftCarrier();
        field.addNewShip();
        field.printBattlefield();

        makeShip.battleShip();
        field.addNewShip();
        field.printBattlefield();

        makeShip.submarine();
        field.addNewShip();
        field.printBattlefield();

        makeShip.destroyer();
        field.addNewShip();
        field.printBattlefield();

        makeShip.patrolBoat();
        field.addNewShip();
        field.printBattlefield();
    }
}
