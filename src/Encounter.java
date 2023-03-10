import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public abstract class Encounter {

    static ArrayList<String> encounterShuffle = new ArrayList<String>();
    private final Coordinates encounterCoordinates;
    private final String name;
    private final String nearbyAlert;
    protected PlayerStatus playerStatus = PlayerStatus.getInstance();

    public Encounter(String name, String nearbyAlert, Coordinates encounterCoordinates) {
        this.name = name;
        this.nearbyAlert = nearbyAlert;
        this.encounterCoordinates = encounterCoordinates;
    }

    public static String returnRandomEncounter() {
        String[] encounters = {"Lake", "Wolf", "Flatlands", "FinishPoint"};
        Random random = new Random();
        int index = random.nextInt(encounters.length);
        return encounters[index];
    }

    public static void generateRandomEncounterWithMinOneFinish(int mapSize) {
        encounterShuffle.add("FinishPoint");
        int arraySize = (mapSize -2);
        for (int i = arraySize; i >= 0; i--) {
            encounterShuffle.add(returnRandomEncounter());
        }
        Collections.shuffle(encounterShuffle);
    }

    public void printEncounterDetails() {
        System.out.println(name + " " + encounterCoordinates.toString());
    }

    abstract public void whenEncountered();

    public String getName() {
        return name;
    }

    public String getNearbyAlert() {
        return nearbyAlert;
    }

    public PlayerStatus getPlayerStatus() {
        return playerStatus;
    }
}
