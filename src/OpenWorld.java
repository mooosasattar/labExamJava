public class OpenWorld implements Observer {

    private final PlayerStatus playerStatus = PlayerStatus.getInstance();
    private int northSouthBoundary, eastWestBoundary;
    private PlayerLocation playerLocation;
    private Coordinates[][] coordinates;


    public OpenWorld() {
    }

    public static void main(String[] args) {
        OpenWorld world = new OpenWorld();
        world.initialise(2, 2);
        world.playerMove(0, 1);
        world.playerMove(0, 1);
        world.playerMove(1, 1);
        world.playerMove(-1, 0);
        world.playerMove(0, -1);

    }

    private void initialise(int northSouthBoundary, int eastWestBoundary) {
        coordinates = new Coordinates[northSouthBoundary][eastWestBoundary];
        playerLocation = new PlayerLocation(northSouthBoundary, eastWestBoundary);
        playerLocation.registerObserver(this);
        this.northSouthBoundary = northSouthBoundary;
        this.eastWestBoundary = eastWestBoundary;
        Encounter.generateRandomEncounterWithMinOneFinish((northSouthBoundary*eastWestBoundary));
        for (int northSouth = 0; northSouth < northSouthBoundary; northSouth++) {
            for (int eastWest = 0; eastWest < eastWestBoundary; eastWest++) {
                coordinates[northSouth][eastWest] = new Coordinates(northSouth, eastWest, playerLocation);
                coordinates[northSouth][eastWest].getEncounter().printEncounterDetails();
            }
        }
        playerLocation.changeCoordinates(coordinates[0][0]);
    }

    private void playerMove(int northSouthChange, int eastWestChange) {
        if (playerStatus.getIsGameOver()) {
            System.out.println("The game is over");
        } else {
            Coordinates currentCoordinates = playerLocation.getPlayerCoordinates();
            int newCoordinatesNorthSouth = currentCoordinates.getNorthSouth() + northSouthChange;
            int newCoordinatesEastWest = currentCoordinates.getEastWest() + eastWestChange;
            if (newCoordinatesNorthSouth >= 0 && newCoordinatesNorthSouth < northSouthBoundary && newCoordinatesEastWest >= 0 && newCoordinatesEastWest < eastWestBoundary) {
                playerLocation.changeCoordinates(coordinates[newCoordinatesNorthSouth][newCoordinatesEastWest]);
            } else {
                System.out.println("Out of bounds move attempted - position has not changed, you are at:" + currentCoordinates);
            }
//			check if game ended in current turn before printing nearby alerts
            if (!playerStatus.getIsGameOver()) {
                printNearbyAlerts();
                System.out.println("PLAYER HEALTH: " + playerStatus.getPlayerHealth());
            }
        }
        System.out.println("---------------------------");
    }

    private void printNearbyAlerts() {
        Coordinates currentCoordinates = playerLocation.getPlayerCoordinates();
        int currentCoordinatesNorthSouth = currentCoordinates.getNorthSouth();
        int currentCoordinatesEastWest = currentCoordinates.getEastWest();
        int southOf = currentCoordinates.getNorthSouth() - 1;
        int westOf = currentCoordinates.getEastWest() + 1;
        int northOf = currentCoordinates.getNorthSouth() + 1;
        int eastOf = currentCoordinates.getEastWest() - 1;

        if (northOf < northSouthBoundary) {
            System.out.println("To your North " + coordinates[northOf][currentCoordinatesEastWest].getEncounter().getNearbyAlert());
        }
        if (southOf >= 0) {
            System.out.println("To your South " + coordinates[southOf][currentCoordinatesEastWest].getEncounter().getNearbyAlert());
        }
        if (westOf < eastWestBoundary) {
            System.out.println("To your West " + coordinates[currentCoordinatesNorthSouth][westOf].getEncounter().getNearbyAlert());
        }
        if (eastOf >= 0) {
            System.out.println("To your East " + coordinates[currentCoordinatesNorthSouth][eastOf].getEncounter().getNearbyAlert());
        }
    }

    @Override
    public void update(PlayerLocation playerLocation) {
        this.playerLocation = playerLocation;
    }


}

