public class PlayerStatus {

    private static PlayerStatus uniquePlayerStatus;
    private boolean isGameOver = false;
    private int playerHealth = 100;

    private PlayerStatus() {
    }

    public static PlayerStatus getInstance() {
        if (uniquePlayerStatus == null) {
            uniquePlayerStatus = new PlayerStatus();
        }
        return uniquePlayerStatus;
    }

    public void takeDamage(int damage) {
        playerHealth -= damage;
        System.out.println("you took " + damage + " damage");
        if (playerHealth <= 0) {
            System.out.println("you took have no health left -- GAME OVER :(");
            this.gameOver();
        }
    }

    public void gameOver() {
        this.isGameOver = true;
    }

    public boolean getIsGameOver() {
        return isGameOver;
    }

    public int getPlayerHealth() {
        return playerHealth;
    }
}

