
package za.co.wethinkcode.robotworlds.server.commands;
import za.co.wethinkcode.robotworlds.server.world_bots.Robot;
public abstract class Command {
    private final String name;
    private String argument;
    public Command(String name){
        this.name = name.trim().toLowerCase();
        this.argument = "";
    }
    public Command(String name, String argument) {
        this(name);
        this.argument = argument.trim();
    }
    public abstract boolean execute(Robot target);
    public String getName() {                                                                           //<2>
        return name;
    }
    public String getArgument() {
        return this.argument;
    }
    public static Command create(String instruction) {
        String[] args = instruction.toLowerCase().trim().split(" ");
        switch (args[0]){
           case "quit":
               return new QuitCommand();

            case "dump":
                return new DumpCommand();

            default:
                throw new IllegalArgumentException("Unsupported command: " + instruction);
        }
    }
}