package lectures._24.composition;


import java.util.HashMap;

interface Flyable {
    void fly();
}

class BackPoweredRocket implements Attachment, Flyable {
    public void fly() {}

    public void attach(String area, Robot robot) {
        robot.attachments.put(area, this);
    }

}

interface Attachment {
    void attach(String area, Robot robot);
}


public class Robot {
    HashMap<String, Attachment> attachments = new HashMap<>();

    boolean canFly() {
        for (Attachment attachment : this.attachments.values()) {
            if (attachment instanceof Flyable) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Robot robot = new Robot();

        BackPoweredRocket attachment = new BackPoweredRocket();

        System.out.println(robot.canFly());

        attachment.attach("back", robot);

        System.out.println(robot.canFly());
    }
}
