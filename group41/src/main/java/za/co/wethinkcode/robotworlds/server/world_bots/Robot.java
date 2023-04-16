package za.co.wethinkcode.robotworlds.server.world_bots;
import za.co.wethinkcode.robotworlds.server.commands.Command;


public class Robot {
    private String status;
    private String name;
    private String state;
    private String make;

    public String getMake() {
        return make;
    }

    public String getStateToBeReturnedToTheUser() {
        return stateToBeReturnedToTheUser;
    }

    public void setStateToBeReturnedToTheUser(String stateToBeReturnedToTheUser) {
        this.stateToBeReturnedToTheUser = stateToBeReturnedToTheUser;
    }

    private String stateToBeReturnedToTheUser;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }


    public Robot(String make, String name) {
        this.make = make;
        this.name = name;
        this.state="normal";
        this.status = "Ready";
    }


    public boolean handleCommand(Command command) {
        return command.execute(this);
    }

    public String getStatus() {
        return this.status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getName() {
        return name;
    }
}

