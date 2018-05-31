package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<String, Connection>();

    private static class Handler extends Thread {
        Socket socket;

        public Handler(Socket socket1) {
            this.socket = socket1;
        }


        public void run() {
            super.run();
            ConsoleHelper.writeMessage("" + socket.getRemoteSocketAddress());
            String username = null;
            try {
                Connection connection = new Connection(socket);
                username = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, username));
                sendListOfUsers(connection, username);
                serverMainLoop(connection, username);
                connectionMap.remove(username);
                sendBroadcastMessage(new Message(MessageType.USER_REMOVED, username));
                System.out.println("Соединение с удаленным адресом закрыто.");
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            Message msg = null;
            while (true) {
                msg = connection.receive(); // return (Message) in.readObject();
                if (msg.getType() == MessageType.TEXT) {
                    String name_Message = userName + ": " + msg.getData();
                    sendBroadcastMessage(new Message(MessageType.TEXT, name_Message));
                } else {
                    ConsoleHelper.writeMessage("Error");
                }
            }
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry <String, Connection> pair : connectionMap.entrySet()) {
                if (!pair.getKey().equals(userName)) {
                    connection.send(new Message(MessageType.USER_ADDED, pair.getKey()));
                }
            }
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String name = null;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST)); // ept, нужно создать NEW сообщение запроса
                Message message = connection.receive(); // возвращаемое из Connection -> (Message) in.readObject();
                if (message.getType() == MessageType.USER_NAME) {
                    name = message.getData();
                    if (!name.isEmpty() && !connectionMap.containsKey(name)) {
                        connectionMap.put(name, connection);
                        connection.send(new Message(MessageType.NAME_ACCEPTED));
                        break;
                    }
                }
            }
            return name;
        }
    }

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
            try {
                pair.getValue().send(message);
            } catch (IOException e) {
                System.err.println("Не смогли отправить сообщение пользователю - " + pair.getKey());
            }
        }
    }

    public static void main(String[] args) throws IOException {
        int i = ConsoleHelper.readInt();
        ServerSocket serverSocket = new ServerSocket(i);
        System.out.println("Сервер запущен.");
        while (true) {
            try {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            } catch (IOException e) {
                System.out.println(e);
                serverSocket.close();
                break;
            }
        }
    }
}
