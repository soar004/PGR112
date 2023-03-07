package lectures._13;

public class Game {
    private final String version;

    public Game() {
        this.version = SingletonExample.getInstance().getVersion();
    }

    public static void main(String[] args) {
        Game game = new Game();

        System.out.println(game.version);
    }

}
