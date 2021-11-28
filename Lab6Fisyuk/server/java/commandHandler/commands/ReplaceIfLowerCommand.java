
package commandHandler.commands;


import DOM.Ticket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import commandHandler.utils.CollectionManager;
import common.Command;
import common.Instruction;
import common.Response;

/**
 * Replaces one element with another if first element is less than specified
 * **/
public class ReplaceIfLowerCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private int key;
    public ReplaceIfLowerCommand(CollectionManager collectionManager){
        super("replace_if_lower","replace element by key if new element is less than old one");
        this.collectionManager = collectionManager;
    }
    /**
     * @see Executable
     * @param arg that will be used to perform the remove
     * **/

    @Override
    public Response execute(String arg) {
        if (collectionManager.getSize() == 0){
            return new Response("Collection is empty", true);
        }
        if (arg == null || arg.isEmpty()){
            return new Response("Key is empty or null", true);
        }
        try{
            Ticket newTicket = new Gson().fromJson(arg,Ticket.class);
            Ticket oldTicket = collectionManager.read(key);
            if(oldTicket == null){
                return new Response("Ticket with such key doesn't exist",true);
            }
            newTicket.setId(this.key);
            if (newTicket.compareTo(oldTicket)<0) {
                collectionManager.update(key, newTicket);
            }
            this.key = 0;
            return new Response();
        } catch (JsonSyntaxException | ClassCastException e){
            try{
                key = Integer.parseInt(arg);
                return new Response("",false, Instruction.ASK_TICKET, new Command("replace_if_lower",""+this.key));
            } catch (NumberFormatException exception){
                return new Response("Key must be a number", true);
            }
        }
    }
}