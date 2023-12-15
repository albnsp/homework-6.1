import java.util.Random;

    public class Task04 {
        public static void main(String[] args) {
            int numRows = 5; // Количество строк в треугольнике
            int[][] triangle = generateTriangle(numRows); // Генерация треугольника случайных чисел
            printTriangle(triangle); // Вывод треугольника на консоль

            int maxSum = findMaxPathSum(triangle); // Нахождение пути с максимальной суммой
            System.out.println("Максимальная сумма чисел: " + maxSum);
        }

        // Метод для генерации треугольника случайных чисел
        private static int[][] generateTriangle(int numRows) {
            int[][] triangle = new int[numRows][];

            Random random = new Random();
            for (int i = 0; i < numRows; i++) {
                triangle[i] = new int[i + 1];
                for (int j = 0; j <= i; j++) {
                    triangle[i][j] = random.nextInt(100); // Генерация случайного числа от 0 до 99
                }
            }

            return triangle;
        }

        // Метод для вывода треугольника на консоль
        private static void printTriangle(int[][] triangle) {
            for (int i = 0; i < triangle.length; i++) {
                for (int j = 0; j < triangle[i].length; j++) {
                    System.out.print(triangle[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Метод для нахождения пути с максимальной суммой чисел
        private static int findMaxPathSum(int[][] triangle) {
            int numRows = triangle.length;

            // Создаем копию треугольника для хранения сумм путей
            int[][] maxSumTriangle = new int[numRows][];
            for (int i = 0; i < numRows; i++) {
                maxSumTriangle[i] = new int[i + 1];
            }

            // Инициализируем последнюю строку треугольника суммами чисел
            for (int j = 0; j < triangle[numRows - 1].length; j++) {
                maxSumTriangle[numRows - 1][j] = triangle[numRows - 1][j];
            }

            // Вычисляем максимальную сумму пути для каждой ячейки треугольника, начиная с предпоследней строки
            for (int i = numRows - 2; i >= 0; i--) {
                for (int j = 0; j < triangle[i].length; j++) {
                    maxSumTriangle[i][j] = triangle[i][j] + Math.max(maxSumTriangle[i + 1][j], maxSumTriangle[i + 1][j + 1]);
                }
            }

            // Находим путь с максимальной суммой
            int row = 0;
            int col = 0;
            StringBuilder path = new StringBuilder();

            while (row < numRows - 1) {
                path.append((col == 0 || maxSumTriangle[row + 1][col] > maxSumTriangle[row + 1][col + 1]) ? "Влево, " : "Вправо, ");
                col = (col == 0 || maxSumTriangle[row + 1][col] > maxSumTriangle[row + 1][col + 1]) ? col : col + 1;
                row++;
            }

            System.out.println("Путь с максимальной суммой: " + path.toString());

            return maxSumTriangle[0][0];
        }
    }

