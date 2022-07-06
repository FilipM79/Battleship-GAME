package battleship;

public class Validate {

    Coordinates coordinates = new Coordinates();

    public static class Checking extends Validate {

        public void aircraftCarrier() {

            Vessel aircraftCarrier = new Vessel("Aircraft Carrier", 5);

            if (aircraftCarrier.length - 1 == coordinates.getColumnDiff()
                    || aircraftCarrier.length - 1  == coordinates.getRowDiff()) {

                System.out.println();
                coordinates.setCorrectLength(true);

            } else {
                coordinates.setCorrectLength(false);
            }
        }

        public void battleShip() {

            Vessel battleShip = new Vessel("Battleship", 4);

            if (battleShip.length - 1 == coordinates.getColumnDiff()
                    || battleShip.length - 1 == coordinates.getRowDiff()) {

                System.out.println();
                coordinates.setCorrectLength(true);

            } else {
                coordinates.setCorrectLength(false);
            }
        }

        public void submarine() {

            Vessel submarine = new Vessel("Submarine", 3);

            if (submarine.length - 1 == coordinates.getColumnDiff()
                    || submarine.length - 1 == coordinates.getRowDiff()) {

                System.out.println();
                coordinates.setCorrectLength(true);

            } else {
                coordinates.setCorrectLength(false);
            }
        }

        public void destroyer() {

            Vessel destroyer = new Vessel("Destroyer", 3);

            if (destroyer.length - 1 == coordinates.getColumnDiff()
                    || destroyer.length - 1 == coordinates.getRowDiff()) {

                System.out.println();
                coordinates.setCorrectLength(true);

            } else {
                coordinates.setCorrectLength(false);
            }
        }

        public void patrolBoat() {

            Vessel patrolBoat = new Vessel("Patrol Boat", 2);

            if (patrolBoat.length - 1 == coordinates.getColumnDiff()
                    || patrolBoat.length - 1 == coordinates.getRowDiff()) {

                System.out.println();
                coordinates.setCorrectLength(true);

            } else {
                coordinates.setCorrectLength(false);
            }
        }
    }

    String isError() {

        coordinates.setConditionForValidate(true);

        if (Game.getInputString() == null || "".equals(Game.getInputString())) {
            coordinates.setConditionForValidate(false);
            return "Error, input coordinates are empty. Try again.";

        } else if (!coordinates.isCorrectLength()) {
            coordinates.setConditionForValidate(false);
            return "Error, wrong length. Try again.";

        } else if (coordinates.getSpaceIndex() == -1) {
            coordinates.setConditionForValidate(false);
            return "Error, there is no space between input coordinates. Try again.";

        } else if (coordinates.getColumnDiff() != 0 && coordinates.getRowDiff() != 0) {
            coordinates.setConditionForValidate(false);
            return "Error, you can only position a vessel horizontally or vertically. Try again.";

        } else if (coordinates.getK1ColumnNum() > 21 || coordinates.getK2ColumnNum() > 21
                || coordinates.getK1RowNum() > 11 || coordinates.getK2RowNum() > 11) {

            coordinates.setConditionForValidate(false);
            return "Error, input coordinates out of battleField. Try again.";

        } else {
            coordinates.setConditionForValidate(true);
            return "";
        }
    }
}
