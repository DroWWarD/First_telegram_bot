import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.SendMessage;

import java.util.Arrays;


public class Bot {
    private final TelegramBot bot = new TelegramBot("PLACE_FOR_YOUR_TOKEN");

    public void serve() {
        bot.setUpdatesListener(updates -> {
            try {
                updates.forEach(this::process);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update) {
        if (update.message() != null) {
            long chatId = update.message().chat().id();
            long userId = update.message().from().id();
            String message = update.message().text();
//----------------------------- вычисляем мат. выражение---------
            String solution = "/solution ";
            if (message.toLowerCase().startsWith(solution)) {
                try {
                    MathExpressions.recurse(message.substring(solution.length()), 0);
                    SendMessage response = new SendMessage(chatId, "" + MathExpressions.result);
                    bot.execute(response);
                } catch (Exception e) {
                    System.out.println("ERRORR");
                    SendMessage response = new SendMessage(chatId, "Мат. выражение введено не корректно.");
                    bot.execute(response);
                }
            }

//------------------------------рисуем график функции от "х" ----------------
            String graph = "/graph ";
            if (message.toLowerCase().startsWith(graph)){
                double[] graphArray = new double[11];
                for (int i = 0; i < graphArray.length ; i++) {
                    MathExpressions.recurse(message.substring(graph.length()).replaceAll("x", String.valueOf(i)), 0);
                    graphArray[i] = Double.parseDouble(MathExpressions.result);
                }
                GraphPrinter graphPrinter = new GraphPrinter();
                graphPrinter.makeGraphField(graphArray);
                SendMessage response = new SendMessage(chatId, graphPrinter.graphString);
                bot.execute(response);
            }
        }
    }
}

