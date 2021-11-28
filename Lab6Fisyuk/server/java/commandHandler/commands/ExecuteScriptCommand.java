package commandHandler.commands;

import commandHandler.utils.Logger;
import common.Instruction;
import common.Response;

import java.io.Console;
import java.util.Stack;

/**
 * Execute the script from file
 * **/
public class ExecuteScriptCommand extends AbstractCommand{//TODO беда
    private Stack<String> scriptStack = new Stack<>();

    public ExecuteScriptCommand(){
        super("execute_script","read and execute script from specified file. " +
                "Script contains same commands as user uses in interactive mode");
    }
    /**
     * @see Executable
     * @param filePath Путь к файлу
     * **/
    @Override
    public Response execute(String filePath) {
        return new Response(filePath, false, Instruction.SCRIPT);
    }
}