package battleship;

class SeaBattle {
    void play () {

        Field field = new Field();

        field.makeBlankField();
        field.printBlankField();

        field.makeAircraftCarrier();
        field.addShipToField();
        field.printBattlefield();

        field.makeBattleShip();
        field.addShipToField();
        field.printBattlefield();

        field.makeSubmarine();
        field.addShipToField();
        field.printBattlefield();

        field.makeCruiser();
        field.addShipToField();
        field.printBattlefield();

        field.makeDestroyer();
        field.addShipToField();
        field.printBattlefield();

        System.out.println("\nThe game starts!");
        field.printFogField();
        System.out.println("\nTake a shot!");

        while (!field.endGame) {
            field.shoot();
            field.addShotToField();
            field.printBattlefield();
            field.printFogField();
            field.shotMessage();
        }
    }
}
