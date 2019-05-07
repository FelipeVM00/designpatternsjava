package isw.state.states;

import isw.state.Server;

public class StopServerState extends AbstractServerState {

    public StopServerState(Server server){
        server.getMessageProcess().stop();
    }
    
    @Override
    public void handleMessage(Server server, String message) {
        System.out.println("The server is stopped");
    }
}
