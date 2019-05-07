package isw.state.gui;

import java.io.OutputStream;
import java.io.PrintStream;
import isw.state.Server;
import isw.state.states.AbstractServerState;
import isw.state.states.StartingServerState;
import isw.state.states.StopServerState;

public class ServerPanel extends javax.swing.JPanel {

    private Server server;
    private int messageCouter;

    public ServerPanel() {
        initComponents();

        PrintStream defaultPrinter = System.out;
        PrintStream interceptor = new TextAreaPrinter(defaultPrinter);
        System.setOut(interceptor);

        server = new Server();
    }

    private class TextAreaPrinter extends PrintStream {

        public TextAreaPrinter(OutputStream out) {
            super(out, true);
        }

        @Override
        public void print(String line) {
            println(line);
        }

        @Override
        public void println(String line) {
            line = line + "\n";
            super.print(line);
            jTextArea1.append(line);
            jTextArea1.setCaretPosition(jTextArea1.getDocument().getLength());
        }

    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        btnSendMessage = new javax.swing.JButton();
        btnStart = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/META-INF/server.png"))); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setAlignmentY(0.0F);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.Y_AXIS));
        jPanel1.add(jLabel5);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane1);

        btnSendMessage.setText("sendMessage");
        btnSendMessage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageEvent(evt);
            }
        });

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startAction(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 446, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addComponent(btnSendMessage, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 273, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSendMessage)
                .addContainerGap())
        );
    }

    private void sendMessageEvent(java.awt.event.ActionEvent evt) {
        server.handleMessage("Send Message + " + ++messageCouter);
    }

    private void startAction(java.awt.event.ActionEvent evt) {
        AbstractServerState state = server.getState();
        if (state instanceof StopServerState) {
            btnStart.setText("Stop");
            server.setState(new StartingServerState(server));
        } else {
            if (state instanceof StartingServerState) {
                server.setState(new StopServerState(server));
            } else {
                btnStart.setText("Start");
                server.setState(new StopServerState(server));
            }
        }
        
    }

    private javax.swing.JButton btnSendMessage;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;

}
