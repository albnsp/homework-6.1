public class Task02 {
    public static void main(String[] args) {
        ArrayPrinter printer = new ArrayPrinter();
        int[] intArray = {1, 2, 3, 4, 5};
        printer.print(intArray);
        String[] stringArray = {"Hello", "World"};
        printer.print(stringArray);
        int[][] int2DArray = {{1, 2, 3}, {4, 5, 6}};
        printer.print(int2DArray);
        float[][] float2DArray = {{1.5f, 2.5f}, {3.5f, 4.5f}};
        printer.print(float2DArray);
    }

    public static class ArrayPrinter {
        public void print(int[] array) {
            for (int num : array) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        public void print(String[] array) {
            for (String str : array) {
                System.out.print(str + " ");
            }
            System.out.println();
        }

        public void print(int[][] array) {
            for (int[] row : array) {
                for (int num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }

        public void print(float[][] array) {
            for (float[] row : array) {
                for (float num : row) {
                    System.out.print(num + " ");
                }
                System.out.println();
            }
        }
    }
}
