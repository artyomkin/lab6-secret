package common;

import DOM.*;

import java.io.Serializable;

public class Request implements Serializable {
    private Command command;

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
