package battleship;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;

class SeaBattle extends JointVariables {
    void play () {

        Player1 p1 = new Player1();
        Player2 p2 = new Player2();

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
            for (int i = 0; i < 50; ++i) System.out.println();
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
            for (int i = 0; i < 50; ++i) System.out.println();
        } else {
            System.out.println("\nPress Enter and pass the move to another player");
        }

        AtomicBoolean victory = new AtomicBoolean(false);
        while (!victory.get()) {

            p2.printFogField();
            System.out.println("---------------------");
            p1.printBattlefield();
            System.out.println("\nPlayer 1, it's your turn:");
            p1.shoot();
            p2.addShotToField();

            if (p2.endGame) {
                victory.set(true);
                System.out.println("Player 1 wins!");
                break;

            } else {
                System.out.println("Press Enter and pass the move to another player");
                enter = scanner.nextLine();
                if (Objects.equals(enter, "")) {
                    for (int i = 0; i < 50; ++i) System.out.println();
                } else {
                    System.out.println("\nPress Enter and pass the move to another player");
                }
            }

            p1.printFogField();
            System.out.println("---------------------");
            p2.printBattlefield();
            System.out.println("\nPlayer 2, it's your turn:");
            p2.shoot();
            p1.addShotToField();

            if (p2.endGame) {
                victory.set(true);
                System.out.println("\nPlayer 1 wins!");
                break;

            } else {
                System.out.println("Press Enter and pass the move to another player");
                enter = scanner.nextLine();
                if (Objects.equals(enter, "")) {
                    for (int i = 0; i < 50; ++i) System.out.println();
                } else {
                    System.out.println("\nPress Enter and pass the move to another player");
                }
            }
        }
    }
}
