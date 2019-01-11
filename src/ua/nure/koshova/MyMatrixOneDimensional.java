package ua.nure.koshova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMatrixOneDimensional extends Matrix {

    private double[] matrix;
    private int size;

    MyMatrixOneDimensional(int size) {
        this.size = size;
        int countElements = size*size;
        matrix = new double[countElements];
    }

    @Override
    public Matrix newInstance(int size) {
        return new MyMatrixOneDimensional(size);
    }

    @Override
    public void setMatrix(int i, int j, double value) {
        matrix[i * size + j] = value;
    }

    @Override
    public double getMatrix(int i, int j) {
        return matrix[i * size + j];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public int getElementCount() {
        return matrix.length;
    }

    @Override
    public Matrix fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Math.random() * 10;
        }
        return this;
    }

    @Override
    public Matrix printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            if (i % 3 == 0) {
                System.out.println();
            }
            System.out.print(matrix[i] + " ");
        }
        return this;
    }

    @Override
    public Matrix fillMatrixManually() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int i = 0;
        for (int j = 0; j < getElementCount(); j++) {
            try {
                this.setMatrix(i, j, Double.parseDouble(reader.readLine()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return this;
    }
}
