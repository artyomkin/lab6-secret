package commandHandler.commands;

import DOM.Ticket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import commandHandler.utils.CollectionManager;
import common.Command;
import common.Instruction;
import common.Response;

import java.util.Iterator;
import java.util.Map;

/**
 * Removes all elements that are more than specified one
 * **/
public class RemoveGreaterCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    public RemoveGreaterCommand(CollectionManager collectionManager){
        super("remove_greater","removes all elements that more than specified");
        this.collectionManager = collectionManager;
    }
    /**
     * @see Executable
     * **/
    @Override
    public Response execute(String arg) {
        if(collectionManager.getSize() == 0) {
            return new Response("Collection is empty",true);
        }
        Ticket ticket = new Gson().fromJson(arg,Ticket.class);
        if (ticket == null){
            return new Response("",false, Instruction.ASK_TICKET, new Command("remove_greater",""));
        }
        Iterator it = collectionManager.getIterator();
        while(it.hasNext()){
            Map.Entry<Integer, Ticket> entry = (Map.Entry<Integer, Ticket>)it.next();
            Ticket currentTicket = entry.getValue();
            if (ticket.compareTo(currentTicket)<0){
                it.remove();
            }
        }
        return new Response();
    }
}