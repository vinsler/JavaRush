package com.javarush.task.task30.task3008.client;

public class ClientGuiController extends Client {
    private ClientGuiModel model;
    private ClientGuiView view;

    public ClientGuiController() {
        model = new ClientGuiModel();
        view = new ClientGuiView(this);
    }

    protected SocketThread getSocketThread() {
        return new GuiSocketThread();
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.run();
    }
    public String getServerAddress(){
        return view.getServerAddress();
    }

    public int getServerPort() {
        return view.getServerPort();
    }

    public String getUserName() {
        return view.getUserName();
    }

    public ClientGuiModel getModel() {
        return model;
    }

    public class GuiSocketThread extends SocketThread {
        protected void processIncomingMessage(String message) {
            model.setNewMessage(message);
            view.refreshMessages();
        }

        protected void informAboutAddingNewUser(String userName) {
            model.addUser(userName);
            view.refreshUsers();
        }

        protected void informAboutDeletingNewUser(String userName) {
            model.deleteUser(userName);
            view.refreshUsers();
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            view.notifyConnectionStatusChanged(clientConnected);
        }
    }

    public static void main(String[] args) {
        ClientGuiController clientGuiController = new ClientGuiController();
        clientGuiController.run();
    }


}
