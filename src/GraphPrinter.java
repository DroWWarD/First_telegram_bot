import java.util.Arrays;

public class GraphPrinter {
    public String graphString = "";
    public String[][] graphField = new String[][]{
            {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"},
        {"x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  ", "x  \n"}};

    public void makeGraphField(double[] array) {
//Получаем округленные значения функции, заполняем новый массив
        long[] dots = new long[11];
        for (int i = 0; i < array.length; i++) {
            dots[i] = Math.round(array[i]);
        }
//Для значений функций, не выбивающихся из диапазона от -10 до +10 меняем в таблице строк  значение с "х" на "о"
        for (int i = graphField.length-1; i > -1 ; i--) {
            if (dots[i] <= 10 && dots[i] >= -10) {
                if (!graphField[(int) dots[i]][i].contains("\n")) {
                    graphField[(int) dots[i]][i] = "o  ";
                } else graphField[(int) dots[i]][i] = "o  \n";
            }
        }
//Собираем строку из массива строк
        for (int i = graphField.length-1; i >-1 ; i--) {
            for (int j = 0; j < graphField[i].length; j++) {
                graphString = graphString + graphField[i][j];
            }
        }
    }
}
