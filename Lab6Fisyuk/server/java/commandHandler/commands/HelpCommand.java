package commandHandler.commands;

import commandHandler.utils.CommandManager;
import commandHandler.utils.Logger;
import common.Response;

/**
 * Prints the information about available commands that command manager contains
 * **/
public class HelpCommand extends AbstractCommand{

    private CommandManager commandManager;
    public HelpCommand(){
        super("help","prints the information about available commands");
    }
    /**
     * @see Executable
     * **/
    public Response execute(String arg){
        if(commandManager == null){
            Logger.error("CommandManager isn't set in HelpCommand");
            return new Response("CommandManager isn't set",true);
        }
        AbstractCommand[] commands = commandManager.getCommands();
        String content = "";
        for (AbstractCommand command : commands){
            content += command.getName() + " - " + command.getDescription() + "\n";
        }
        return new Response(content,false);
    }

    public void setCommandManager(CommandManager commandManager) {
        this.commandManager = commandManager;
    }
}