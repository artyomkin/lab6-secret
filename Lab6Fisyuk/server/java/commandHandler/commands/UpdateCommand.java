package commandHandler.commands;

import DOM.Ticket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import commandHandler.utils.CollectionManager;
import common.Command;
import common.Instruction;
import common.Response;

/**
 * Updates the element by its key
 * **/
public class UpdateCommand extends AbstractCommand{
    private CollectionManager collectionManager;
    private int key;
    public UpdateCommand(CollectionManager collectionManager){
        super("update","updates the element with specified id");
        this.collectionManager = collectionManager;
    }

    /**
     * @see Executable
     * @param arg that will be used to perform the update
     * **/
    @Override
    public Response execute(String arg){
        if(arg == null || arg.isEmpty()){
            return new Response("Key is empty", true);
        }
        try{
            Ticket ticket = new Gson().fromJson(arg,Ticket.class);
            ticket.setId(this.key);
            collectionManager.update(this.key, ticket);
            return new Response();
        } catch (JsonSyntaxException | ClassCastException e){
            try{
                this.key = Integer.parseInt(arg);
                if (!collectionManager.contains(this.key)){
                    return new Response("Ticket with such key doesn't exist", true);
                }
                return new Response("",false, Instruction.ASK_TICKET, new Command("update",""+this.key));
            } catch (NumberFormatException exception){
                return new Response("Key must be a number",true);
            }
        }
    }
}