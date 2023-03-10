public class LogAnalytics {
    private static LogAnalytics uniqueLogAnalytics;

    private LogAnalytics() {
        System.out.println("Making a connection to the external database");
    }

    public static LogAnalytics getInstance() {
        if (uniqueLogAnalytics == null) {
            uniqueLogAnalytics = new LogAnalytics();
        }
        return uniqueLogAnalytics;
    }

    public void logMove(Coordinates newCoordinates) {
        System.out.println("Logging:" + newCoordinates.toString());
    }
}
