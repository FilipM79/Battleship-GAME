package battleship;

class SeaBattle {
    void play () {

        Field field = new Field();

        field.makeBlankField();
        field.printBlankField();

        field.makeAircraftCarrier();
        field.addNewShipToField();
        field.printBattlefield();

        field.makeBattleShip();
        field.addNewShipToField();
        field.printBattlefield();

        field.makeSubmarine();
        field.addNewShipToField();
        field.printBattlefield();

        field.makeCruiser();
        field.addNewShipToField();
        field.printBattlefield();

        field.makeDestroyer();
        field.addNewShipToField();
        field.printBattlefield();

        System.out.println("\nThe game starts!");
        field.printBattlefield();

        field.shoot();
        field.addNewShotToField();
        field.printBattlefield();

    }
}
