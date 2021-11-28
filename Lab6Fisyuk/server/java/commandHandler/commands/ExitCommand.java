package commandHandler.commands;


import commandHandler.utils.CollectionManager;
import commandHandler.utils.CommandManager;
import commandHandler.utils.FileManager;
import common.Instruction;
import common.Response;

/**
 * Interrupt the programm
 * **/
public class ExitCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private FileManager fileManager;
    public ExitCommand(CollectionManager collectionManager, FileManager fileManager){
        super("exit","stop the programm");
        this.collectionManager = collectionManager;
        this.fileManager = fileManager;
    }
    /**
     * @see Executable
     * **/
    @Override
    public Response execute(String arg) {
        new SaveCommand(fileManager, collectionManager).execute("");
        return new Response("",false, Instruction.EXIT);
    }
}