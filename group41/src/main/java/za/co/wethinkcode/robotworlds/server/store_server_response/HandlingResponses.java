package za.co.wethinkcode.robotworlds.server.store_server_response;

import kong.unirest.json.JSONObject;
import za.co.wethinkcode.robotworlds.server.world_bots.*;

public class HandlingResponses {

    private String state;
    private String status;
    private String prompt;




    public void setValues(Robot robot, Play play) {
        this.state = robot.getState();
        this.status = robot.getStatus();
        this.prompt = play.getMyPrompt();
    }

    public String response () {

        JSONObject requesting = new JSONObject();

        requesting.put("state", state);
        requesting.put("status", status);
        requesting.put("prompt", prompt);

        return requesting.toString();
    }
}

