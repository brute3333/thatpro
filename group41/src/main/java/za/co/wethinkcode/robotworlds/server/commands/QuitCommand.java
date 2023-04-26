<<<<<<< HEAD
package za.co.wethinkcode.robotworlds.server.commands;

public class QuitCommand extends  Command{
    public QuitCommand() {
        super("quit", "Exit the program");
    }

    @Override
    public boolean execute(Server server, String[] args) {
        try {
            server.stop();
            server.getServerSocket().close();
            return true;
        } catch (IOException e) {
            System.err.println("Failed to stop server: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean execute(Robot target) {
        return false;
    }
}
