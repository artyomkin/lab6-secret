package commandHandler.commands;

import commandHandler.utils.CollectionManager;
import commandHandler.utils.Logger;
import common.Response;

/**
 * Removes the element from collections by its key
 * **/
public class RemoveKeyCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public RemoveKeyCommand(CollectionManager collectionManager){
        super("remove_key","remove the element from collection by its key");
        this.collectionManager = collectionManager;
    }
    /**
     * @see Executable
     * @param key that will be used to perform the remove
     * **/
    @Override
    public Response execute(String key) {
        try{
            if(key.isEmpty()) {
                return new Response("Key is empty", true);
            }
            Integer resultKey = Integer.parseInt(key);
            if (collectionManager.getSize() <= 0){
                return new Response("Collection is already empty", true);
            }
            if(!collectionManager.contains(resultKey)){
                return new Response("Ticket with such key doesn't exist",true);
            }
            collectionManager.delete(resultKey);
            return new Response();
        } catch (NumberFormatException e){
            return new Response("Key must be a number", true);
        }

    }
}