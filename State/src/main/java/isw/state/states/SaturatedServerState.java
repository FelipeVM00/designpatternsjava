package isw.state.states;

import isw.state.Server;

public class SaturatedServerState extends AbstractServerState {

    private Thread monitoringThread;

    public SaturatedServerState(final Server server) {
        server.getMessageProcess().start();
        monitoringThread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    while (true) {
                    	Thread.sleep(500); //Para garantizar que se haga el cambio de estado
                        if (server.getMessageProcess()
                                .countMessage() < 
                                server.getMaxRequest()) {
                            server.setState(
                                    new StartServerState(server));
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
        });
        monitoringThread.start();
    }

    @Override
    public void handleMessage(Server server, String message) {
        System.out.println("Cant´t process request, Server Saturated");
    }
}