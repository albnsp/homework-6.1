public class Task01 {
    public static void main(String[] args) {
        Matrix a = new Matrix(new int[][]{{1, 2}, {3, 4}});
        Matrix b = new Matrix(new int[][]{{5, 6}, {7, 8}});

        Matrix c = a.add(b);
        c.print();

        Matrix d = a.multiply(b);
        d.print();

        Matrix e = a.multiply(2);
        e.print();

        int determinant = a.determinant();
        System.out.println("Определитель: " + determinant);
    }

    public static class Matrix {
        private int[][] data;
        private int size;

        public Matrix(int size) {
            this.size = size;
            this.data = new int[size][size];
        }

        public Matrix(int[][] data) {
            this.size = data.length;
            this.data = new int[size][size];
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    this.data[i][j] = data[i][j];
                }
            }
        }

        public static Matrix identity(int size) {
            Matrix result = new Matrix(size);
            for (int i = 0; i < size; i++) {
                result.data[i][i] = 1;
            }
            return result;
        }

        public static Matrix zero(int size) {
            return new Matrix(size);
        }

        public Matrix add(Matrix other) {
            Matrix result = new Matrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result.data[i][j] = this.data[i][j] + other.data[i][j];
                }
            }
            return result;
        }

        public Matrix multiply(Matrix other) {
            Matrix result = new Matrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    int sum = 0;
                    for (int k = 0; k < size; k++) {
                        sum += this.data[i][k] * other.data[k][j];
                    }
                    result.data[i][j] = sum;
                }
            }
            return result;
        }

        public Matrix multiply(int scalar) {
            Matrix result = new Matrix(size);
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    result.data[i][j] = this.data[i][j] * scalar;
                }
            }
            return result;
        }

        public int determinant() {
            if (size == 1) {
                return data[0][0];
            }
            if (size == 2) {
                return data[0][0] * data[1][1] - data[0][1] * data[1][0];
            }
            int result = 0;
            for (int i = 0; i < size; i++) {
                result += Math.pow(-1, i) * data[0][i] * submatrix(0, i).determinant();
            }
            return result;
        }

        public Matrix submatrix(int row, int col) {
            Matrix result = new Matrix(size - 1);
            int r = 0;
            for (int i = 0; i < size; i++) {
                if (i == row) {
                    continue;
                }
                int c = 0;
                for (int j = 0; j < size; j++) {
                    if (j == col) {
                        continue;
                    }
                    result.data[r][c] = data[i][j];
                    c++;
                }
                r++;
            }
            return result;
        }

        public void print() {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    System.out.print(data[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
