public class Lake extends Encounter {

    public Lake(Coordinates encounterCoordinates) {
        super("Lake       ", "there is a vast expanse of water", encounterCoordinates);
    }

    public void whenEncountered() {
        System.out.println("The water is icy cold!");
        playerStatus.takeDamage(10);
    }


}
