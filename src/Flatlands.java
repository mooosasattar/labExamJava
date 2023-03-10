public class Flatlands extends Encounter {
    public Flatlands(Coordinates encounterCoordinates) {
        super("Flatland   ", "you see boring open planes", encounterCoordinates);
    }

    public void whenEncountered() {
        System.out.println("Nothing to see here...");
    }
}

