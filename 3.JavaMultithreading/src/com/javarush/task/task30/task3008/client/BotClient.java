package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class BotClient extends Client {

    public class BotSocketThread extends SocketThread {
        protected void clientMainLoop() throws IOException, ClassNotFoundException {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            super.clientMainLoop();
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            String [] spl = message.split(": ");

            if (spl.length == 2) {
                String name = spl[0];
                String msg = spl[1];

                String form = null;
                switch (msg) {
                    case "дата": {
                        form = "d.MM.YYYY";
                        break;
                    }
                    case "день": {
                        form = "d";
                        break;
                    }
                    case "месяц": {
                        form = "MMMM";
                        break;
                    }
                    case "год": {
                        form = "YYYY";
                        break;
                    }
                    case "время": {
                        form = "H:mm:ss";
                        break;
                    }
                    case "час": {
                        form = "H";
                        break;
                    }
                    case "минуты": {
                        form = "m";
                        break;
                    }
                    case "секунды": {
                        form = "s";
                        break;
                    }

                }
                String str = null;
                if (form != null) {
                    str = new SimpleDateFormat(form).format(Calendar.getInstance().getTime());
                    sendTextMessage("Информация для " + name + ": " + str);
                }
            }
        }


    }

    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    protected boolean shouldSendTextFromConsole() {
        return false;
    }

    public String getUserName() {
        return "date_bot_" + (int)(Math.random() * 100);
    }

    public static void main(String[] args) throws InterruptedException {
        BotClient botClient = new BotClient();
        botClient.run();
    }



}
