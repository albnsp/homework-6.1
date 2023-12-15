import java.util.Arrays;

public class Task03 {
    public static void main(String[] args) {
        String[] strings = {"Привет, мир", "Java - замечательный язык", "Программирование - это весело"};

        System.out.println("Исходный массив: " + arrayToString(strings));

        // Сортировка массива в обратном порядке (без учета регистра)
        Arrays.sort(strings, (s1, s2) -> s2.compareToIgnoreCase(s1));
        System.out.println("Массив после сортировки в обратном порядке: " + arrayToString(strings));

        // Сортировка массива по количеству слов в строке
        Arrays.sort(strings, (s1, s2) -> countWords(s1) - countWords(s2));
        System.out.println("Массив после сортировки по количеству слов: " + arrayToString(strings));
    }

    // Метод для преобразования массива строк в одну строку через пробел
    private static String arrayToString(String[] strings) {
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            sb.append(s).append(" ");
        }
        return sb.toString().trim();
    }

    // Метод для подсчета количества слов в строке
    private static int countWords(String s) {
        return s.split("\\s+").length;
    }
}