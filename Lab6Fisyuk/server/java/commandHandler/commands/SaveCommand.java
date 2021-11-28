
package commandHandler.commands;

import commandHandler.utils.CollectionManager;
import commandHandler.utils.FileManager;
import common.Response;

/**
 * Saves the collection to file
 * **/
public class SaveCommand extends AbstractCommand{
    private FileManager fileManager;
    private CollectionManager collectionManager;
    public SaveCommand(FileManager fileManager, CollectionManager collectionManager){
        super("save","save collection to file");
        this.fileManager = fileManager;
        this.collectionManager = collectionManager;
    }
    /**
     * @see Executable
     * **/
    public Response execute(String arg){
        fileManager.save(collectionManager);
        return new Response();
    }
}