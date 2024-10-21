package com.javarush.task.task30.task3008.client;


import com.javarush.task.task30.task3008.ConsoleHelper;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class BotClient extends Client {
    public class BotSocketThread extends SocketThread {
        public void clientMainLoop() {
            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
            try {
                super.clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {

            }
        }

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
            if (!message.contains(": ")) return;
            String[] split = message.split(": ");
            String userName = split[0];
            String zapros = split[1];

            SimpleDateFormat date = new SimpleDateFormat("d.MM.YYYY");
            SimpleDateFormat day = new SimpleDateFormat("d");
            SimpleDateFormat month = new SimpleDateFormat("MMMM");
            SimpleDateFormat year = new SimpleDateFormat("YYYY");
            SimpleDateFormat time = new SimpleDateFormat("H:mm:ss");
            SimpleDateFormat hour = new SimpleDateFormat("H");
            SimpleDateFormat minutes = new SimpleDateFormat("m");
            SimpleDateFormat seconds = new SimpleDateFormat("s");

            Calendar calendar = Calendar.getInstance();

            switch (zapros) {
                case "дата":
                    sendTextMessage("Информация для " + userName + ": " + date.format(calendar.getTime()));
                    break;
                case "день":
                    sendTextMessage("Информация для " + userName + ": " + day.format(calendar.getTime()));
                    break;
                case "месяц":
                    sendTextMessage("Информация для " + userName + ": " + month.format(calendar.getTime()));
                    break;
                case "год":
                    sendTextMessage("Информация для " + userName + ": " + year.format(calendar.getTime()));
                    break;
                case "время":
                    sendTextMessage("Информация для " + userName + ": " + time.format(calendar.getTime()));
                    break;
                case "час":
                    sendTextMessage("Информация для " + userName + ": " + hour.format(calendar.getTime()));
                    break;
                case "минуты":
                    sendTextMessage("Информация для " + userName + ": " + minutes.format(calendar.getTime()));
                    break;
                case "секунды":
                    sendTextMessage("Информация для " + userName + ": " + seconds.format(calendar.getTime()));
                    break;
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
        return ("date_bot_" + (int) (Math.random() * 100));
    }

    public static void main(String[] args) {
        BotClient client = new BotClient();
        client.run();
    }
}
