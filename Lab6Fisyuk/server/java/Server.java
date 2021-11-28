import commandHandler.commands.*;
import commandHandler.utils.CollectionManager;
import commandHandler.utils.CommandManager;
import commandHandler.utils.FileManager;
import commandHandler.utils.Logger;
import common.Request;
import common.Response;
import connectionReciever.ConnectionReciever;
import requestReader.RequestReader;
import responseSender.ResponseSender;

import java.net.DatagramSocket;
import java.util.Scanner;

public class Server {
    public void run(String filepath){
        FileManager fileManager = new FileManager(filepath);
        CollectionManager collectionManager = new CollectionManager(fileManager.load());
        Scanner scanner = new Scanner(System.in);
        DatagramSocket socket = new ConnectionReciever(14412).getConn();
        RequestReader requestReader = new RequestReader(socket);
        ResponseSender responseSender = new ResponseSender(socket);
        CommandManager commandManager = new CommandManager(
                new InfoCommand(collectionManager),
                new ShowCommand(collectionManager),
                new InsertCommand(collectionManager),
                new UpdateCommand(collectionManager),
                new RemoveKeyCommand(collectionManager),
                new ClearCommand(collectionManager),
                new RemoveGreaterCommand(collectionManager),
                new ReplaceIfLowerCommand(collectionManager),
                new ExitCommand(collectionManager, fileManager),
                new ExecuteScriptCommand(),
                new RemoveLowerKeyCommand(collectionManager),
                new AverageOfPriceCommand(collectionManager),
                new CountGreaterThanRefundableCommand(collectionManager),
                new PrintFieldAscendingRefundable(collectionManager)
        );
        HelpCommand helpCommand = new HelpCommand();
        helpCommand.setCommandManager(commandManager);
        commandManager.addCommand(helpCommand);

        while (socket != null){
            Request request;
            do{
                request = requestReader.getRequest();
            }while(request.getCommand() == null);
            Response response = commandManager.executeCommand(request.getCommand().getCommand(), request.getCommand().getArgument());
            if(response == null){
                response = new Response("Unknown command",true);
            }
            responseSender.sendResponse(response,requestReader.getAddress(), requestReader.getPort());
        }
    }
}
