// package za.co.wethinkcode.robotworlds.server.commands;

// public class QuitCommand {
// }
package za.co.wethinkcode.robotworlds.server.commands;

import za.co.wethinkcode.robotworlds.server.RobotWorldsServer;

public class QuitCommand implements Command {
    
    private RobotWorldsServer server;
    
    public QuitCommand(RobotWorldsServer server) {
        this.server = server;
    }
    
    @Override
    public void execute(String[] args) {
        server.stopServer(); // stop the server
        System.exit(0); // exit the program
    }
    
    @Override
    public String getName() {
        return "quit";
    }
    
    @Override
    public String getHelp() {
        return "Usage: quit\nStops the server and exits the program.";
    }
}
