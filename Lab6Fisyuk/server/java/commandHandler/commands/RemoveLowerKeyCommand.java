package commandHandler.commands;

import DOM.Ticket;
import commandHandler.utils.CollectionManager;
import common.Response;

import java.util.Iterator;
import java.util.Map;

/**
 * Removes all elements that are more than specified one
 * **/
public class RemoveLowerKeyCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public RemoveLowerKeyCommand(CollectionManager collectionManager){
        super("remove_lower_key","removes all elements that have key less than specified");
        this.collectionManager = collectionManager;
    }
    /**
     * @param arg that will be used to perform the remove
     * @see Executable
     * **/
    @Override
    public Response execute(String arg) {
        if(collectionManager.getSize() == 0) {
            return new Response("Collection is empty", true);
        }
        Integer key;
        try{
            key = Integer.parseInt(arg);
        } catch (NumberFormatException e){
            return new Response("Key must be a number", true);
        }
        Iterator it = collectionManager.getIterator();
        while(it.hasNext()){
            Map.Entry<Integer, Ticket> entry = (Map.Entry<Integer, Ticket>) it.next();
            Integer currentKey = entry.getKey();
            if (currentKey.compareTo(key)<0){
                it.remove();
            }
        }
        return new Response();
    }
}