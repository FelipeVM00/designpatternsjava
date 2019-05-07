package isw.state.states;

import isw.state.Server;

public abstract class AbstractServerState {

    public AbstractServerState() {
    }

    public abstract void handleMessage(
            Server server, String message);

}
