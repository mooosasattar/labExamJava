import java.util.ArrayList;
import java.util.List;

public class PlayerLocation implements Subject {
    private final int northSouthBoundary;
    private final int eastWestBoundary;
    protected List<Observer> observers;
    private Coordinates playerCoordinates;


    public PlayerLocation(int northSouthBoundary, int eastWestBoundary) {
        this.northSouthBoundary = northSouthBoundary;
        this.eastWestBoundary = eastWestBoundary;
        this.observers = new ArrayList<>();
    }

    public void changeCoordinates(Coordinates updateCoordinates) {
        if (updateCoordinates.getNorthSouth() >= 0 && updateCoordinates.getNorthSouth() <= northSouthBoundary && updateCoordinates.getEastWest() >= 0 && updateCoordinates.getEastWest() <= eastWestBoundary) {
            playerCoordinates = updateCoordinates;
            System.out.println("You are at location:" + playerCoordinates);
            LogAnalytics.getInstance().logMove(playerCoordinates);
            playerCoordinates.getEncounter().whenEncountered();
        } else {
            System.out.println("Out of bounds move attempted - position has not changed, you are at:" + playerCoordinates.toString());
            LogAnalytics.getInstance().logMove(playerCoordinates);
        }
        this.notifyObserver();
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.update(this);
        }
    }

    public Coordinates getPlayerCoordinates() {
        return playerCoordinates;
    }

    public int getNorthSouthBoundary() {
        return northSouthBoundary;
    }

    public int getEastWestBoundary() {
        return eastWestBoundary;
    }

}
