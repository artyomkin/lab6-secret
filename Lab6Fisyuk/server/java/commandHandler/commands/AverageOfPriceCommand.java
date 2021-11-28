package commandHandler.commands;

import DOM.Ticket;
import commandHandler.utils.CollectionManager;
import common.Response;

import java.util.Iterator;
import java.util.Map;

/**
 * Command that show average price of all elements
 * **/
public class AverageOfPriceCommand extends AbstractCommand{

    private CollectionManager collectionManager;

    public AverageOfPriceCommand(CollectionManager collectionManager){
        super("average_of_price", "show average price");
        this.collectionManager = collectionManager;
    }

    /**
     * @see Executable
     * **/
    @Override
    public Response execute(String arg){
        if(collectionManager.getSize() == 0){
            return new Response("Collection is empty", true);
        }
        double avgPrice = collectionManager.getStream().mapToDouble(Ticket::getPrice).sum();
        avgPrice /= collectionManager.getSize();
        return new Response("Average price is " + avgPrice, false);
    }

}
