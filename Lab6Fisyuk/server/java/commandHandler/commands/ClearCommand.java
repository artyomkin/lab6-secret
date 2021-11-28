package commandHandler.commands;

import commandHandler.utils.CollectionManager;
import common.Response;

/**
 * Clear whole collection by removing all elements
 * **/
public class ClearCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public ClearCommand(CollectionManager collectionManager){
        super("clear", "clear the collection");
        this.collectionManager = collectionManager;
    }
    /**
     *  @see Executable
     * **/
    @Override
    public Response execute(String arg) {
        collectionManager.deleteAll();
        return new Response();
    }
}