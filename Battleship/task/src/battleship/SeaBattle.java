package battleship;

class SeaBattle extends JointVariables {
    void play () {

        Player1 P1 = new Player1();
        Player2 P2 = new Player2();

        P1.makeFields();
        P1.printBlankField();

        P1.addAircraftCarrier();
        P1.addBattleShip();
        P1.addSubmarine();
        P1.addCruiser();
        P1.addDestroyer();

        for (int i = 0; i < 100; ++i) System.out.println();

        P2.makeFields();
        P2.printBlankField();

        P2.addAircraftCarrier();
        P2.addBattleShip();
        P2.addSubmarine();
        P2.addCruiser();
        P2.addDestroyer();

        for (int i = 0; i < 100; ++i) System.out.println();

        System.out.println("\nThe game starts!");
        P1.printFogField();

        boolean victory = false;
        while (!victory) {
            if (!P1.endGame && !P2.endGame) {

                while (!missP1) {
                    System.out.println("\nPlayer1, take a shot!");
                    P1.shoot();
                    P2.addShotToField();
                } missP1 = false;

                while (!missP2) {
                    System.out.println("\nPlayer2, take a shot!");
                    P2.shoot();
                    P1.addShotToField();
                } missP2 = false;

            } else if (P1.endGame) {
                victory = true;
                System.out.println("P2 wins!");

            } else {
                victory = true;
                System.out.println("P1 wins!");
            }
        }
    }
}
