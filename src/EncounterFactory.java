public class EncounterFactory {
    public static Encounter createEncounter(String encounterType, Coordinates encounterCoordinates) {
        switch (encounterType) {
            case "Flatlands":
                return new Flatlands(encounterCoordinates);
            case "Lake":
                return new Lake(encounterCoordinates);
            case "Wolf":
                return new Wolf(encounterCoordinates);
            case "FinishPoint":
                return new FinishPoint(encounterCoordinates);
            default:
                return null;
        }
    }
}
