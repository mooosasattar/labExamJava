public class Wolf extends Encounter {

    public Wolf(Coordinates encounterCoordinates) {
        super("Wolf       ", "you hear distant howling", encounterCoordinates);
    }

    public void whenEncountered() {
        System.out.println("You are attacked by wolves!");
        playerStatus.takeDamage(20);
    }

}
