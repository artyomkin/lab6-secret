package commandHandler.commands;

import DOM.Ticket;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import commandHandler.utils.CollectionManager;
import commandHandler.utils.Logger;
import common.Command;
import common.Instruction;
import common.Response;

/**
 * Inserts new element with specified key into collection
 * **/
public class InsertCommand extends AbstractCommand{

    private CollectionManager collectionManager;
    private int resultKey;
    public InsertCommand(CollectionManager collectionManager){
        super("insert", "insert new element with specified key");
        this.collectionManager = collectionManager;
    }
    /**
     * @see Executable
     * @param key that will be used to perform the insert
     * **/
    @Override
    public Response execute(String key){
        if (key == null || key.isEmpty()){
            Logger.error("Empty key in InsertCommand");
            return new Response("Empty key in InsertCommand",true);
        }
        try{
            Ticket ticket = new Gson().fromJson(key,Ticket.class);
            ticket.setId(this.resultKey);
            collectionManager.create(this.resultKey, ticket);
            this.resultKey = 0;
            return new Response();
        } catch (JsonSyntaxException | ClassCastException e){
            try{
                this.resultKey = Integer.parseInt(key);
                if (collectionManager.contains(resultKey)){
                    return new Response("Key " + key + " already exists", true);
                }
                return new Response("",false, Instruction.ASK_TICKET, new Command("insert",""+this.resultKey));
            }catch (NumberFormatException exception){
                Logger.error("Key must be a number");
                return new Response("Key must be a number", true);
            }
        }
    }
}