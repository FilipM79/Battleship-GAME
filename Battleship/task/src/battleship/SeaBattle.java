package battleship;

import java.util.Objects;

class SeaBattle extends JointVariables {
    void play () {

        Player1 p1 = new Player1();
        Player2 p2 = new Player2();
        String enter;

        System.out.println("\nPlayer 1, place your ships on the game field");
        p1.makeFields();
        p1.printBlankField();

        p1.addAircraftCarrier();
        p1.addBattleShip();
        p1.addSubmarine();
        p1.addCruiser();
        p1.addDestroyer();

        System.out.println("\nPress Enter and pass the move to another player");
        enter = scanner.nextLine();
        if (Objects.equals(enter, "")) {
            for (int i = 0; i < 100; ++i) System.out.println();
        } else {
            System.out.println("\nPress Enter and pass the move to another player");
        }

        System.out.println("\nPlayer 2, place your ships on the game field");
        p2.makeFields();
        p2.printBlankField();

        p2.addAircraftCarrier();
        p2.addBattleShip();
        p2.addSubmarine();
        p2.addCruiser();
        p2.addDestroyer();

        System.out.println("\nPress Enter and pass the move to another player");
        enter = scanner.nextLine();
        if (Objects.equals(enter, "")) {
            for (int i = 0; i < 100; ++i) System.out.println();
        } else {
            System.out.println("\nPress Enter and pass the move to another player");
        }

        boolean victory = false;
        while (!victory) {

            if (!p1.endGame && !p2.endGame) {
                while (!missP1 && !p1.endGame && !p2.endGame) {
                    p2.printFogField();
                    System.out.println("---------------------");
                    p1.printBattlefield();
                    System.out.println("\nPlayer 1, it's your turn:");
                    p1.shoot();
                    p2.addShotToField();
                }
                missP1 = false;
                System.out.println("Press Enter and pass the move to another player");
                enter = scanner.nextLine();
                if (Objects.equals(enter, "")) {
                    for (int i = 0; i < 100; ++i) System.out.println();
                } else {
                    System.out.println("\nPress Enter and pass the move to another player");
                }

                while (!missP2 && !p1.endGame && !p2.endGame) {
                    p1.printFogField();
                    System.out.println("---------------------");
                    p2.printBattlefield();
                    System.out.println("\nPlayer 2, it's your turn:");
                    p2.shoot();
                    p1.addShotToField();
                }
                missP2 = false;
                System.out.println("Press Enter and pass the move to another player");
                enter = scanner.nextLine();
                if (Objects.equals(enter, "")) {
                    for (int i = 0; i < 100; ++i) System.out.println();
                } else {
                    System.out.println("\nPress Enter and pass the move to another player");
                }


            } else if (p1.endGame) {
                victory = true;
                System.out.println("\nPlayer 2 wins!");

            } else {
                victory = true;
                System.out.println("\nPlayer 1 wins!");
            }
        }
    }
}
