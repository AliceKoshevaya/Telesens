package ua.nure.koshova;

public abstract class Matrix {

    public abstract Matrix newInstance(int n);

    public abstract void setMatrix(int i, int j, double value);

    public abstract double getMatrix(int i, int j);

    public abstract int getSize();

    public abstract int getElementCount();

    public abstract Matrix fillMatrix();

    public abstract Matrix printMatrix();

    public abstract Matrix fillMatrixManually();

    public Matrix matrixMultiplication(Matrix matrix) {
        Matrix result = newInstance(matrix.getSize());
        int size = getSize();
        double sum = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int l = 0; l < size; l++) {
                    sum = sum + getMatrix(i, l) * matrix.getMatrix(l, j);
                    result.setMatrix(i, j, sum);
                }
                sum = 0;
            }
        }
        return result;
    }

    public Matrix inverseMatrix() {
        int i, j, k;
        int size = this.getSize();
        Matrix matrix1 = newInstance(this.getSize());
        for (i = 0; i < size; i++) {
            for (j = 0; j < size; j++) {
                if (i == j) {
                    matrix1.setMatrix(i, j, 1);
                } else {
                    matrix1.setMatrix(i, j, 0);
                }
            }
        }
        for (k = 0; k < size; k++) {
            for (j = k + 1; j < size; j++) {
                this.setMatrix(k, j, this.getMatrix(k, j) / this.getMatrix(k, k));
            }
            for (j = 0; j < size; j++) {
                matrix1.setMatrix(k, j, matrix1.getMatrix(k, j) / this.getMatrix(k, k));
            }
            this.setMatrix(k, k, this.getMatrix(k, k) / this.getMatrix(k, k));
            if (k > 0) {
                for (i = 0; i < k; i++) {
                    for (j = 0; j < size; j++) {
                        matrix1.setMatrix(i, j, matrix1.getMatrix(i, j) - matrix1.getMatrix(k, j) * this.getMatrix(i, k));
                    }
                    for (j = size - 1; j >= k; j--) {
                        this.setMatrix(i, j, this.getMatrix(i, j) - this.getMatrix(k, j) * this.getMatrix(i, k));
                    }
                }
            }
            for (i = k + 1; i < size; i++) {
                for (j = 0; j < size; j++) {
                    matrix1.setMatrix(i, j, matrix1.getMatrix(i, j) - matrix1.getMatrix(k, j) * this.getMatrix(i, k));
                }
                for (j = size - 1; j >= k; j--) {
                    this.setMatrix(i, j, this.getMatrix(i, j) - this.getMatrix(k, j) * this.getMatrix(i, k));
                }
            }
        }
        return matrix1;
    }

    public double getDeteminant() {
        return determinant(this);
    }

    private double determinant(Matrix matrix) {
        double calcResult = 0.0;
        if (matrix.getSize() == 2) {
            calcResult = matrix.getMatrix(0, 0) * matrix.getMatrix(1, 1) - matrix.getMatrix(1, 0) * matrix.getMatrix(0, 1);
        } else {
            int coefficient = 1;
            for (int i = 0; i < matrix.getSize(); i++) {
                if (i % 2 == 1) {
                    coefficient = -1;
                } else {
                    coefficient = 1;
                }
                calcResult = calcResult + (coefficient * getMatrix(0, i) * this.determinant(this.GetMinor(matrix, 0, i)));
            }
        }
        return calcResult;
    }

    public Matrix GetMinor(Matrix matrix, int row, int column) {
        int minorLength = matrix.getSize() - 1;
        Matrix matrixMinor = newInstance(minorLength);
        int extraLine = 0;
        int extraColumn = 0;
        for (int i = 0; i <= minorLength; i++) {
            extraColumn = 0;
            for (int j = 0; j <= minorLength; j++) {
                if (i == row) {
                    extraLine = 1;
                } else {
                    if (j == column) {
                        extraColumn = 1;
                    } else {
                        matrixMinor.setMatrix(i - extraLine, j - extraColumn, matrix.getMatrix(i, j));
                    }
                }
            }
        }
        return matrixMinor;
    }
}



