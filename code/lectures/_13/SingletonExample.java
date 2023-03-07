package lectures._13;

public class SingletonExample {
    private static final GameSystem instance = new GameSystem(
            "v1.0.0"
    );

    public static GameSystem getInstance() {
        return SingletonExample.instance;
    }

    static class GameSystem {
        private String version;

        private GameSystem(String version) {
            this.setVersion(version);
        }

        public String getVersion() {
            return this.version;
        }


        private void setVersion(String value) {
            this.version = value;
        }
    }
}
