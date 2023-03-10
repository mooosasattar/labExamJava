public class FinishPoint extends Encounter {

    public FinishPoint(Coordinates encounterCoordinates) {
        super("FinishPoint", "you see a golden beam of light.", encounterCoordinates);
    }

    public void whenEncountered() {
        System.out.println("You have reached your goal!");
        System.out.println("congrats on winning!");
        playerStatus.gameOver();
    }
}
