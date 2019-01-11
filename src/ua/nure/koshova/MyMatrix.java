package ua.nure.koshova;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MyMatrix extends Matrix {

    private double[][] matrix;

    public MyMatrix(int n){
        matrix = new double[n][n];
    }

    @Override
    public Matrix newInstance(int n) {
        return new MyMatrix(n);
    }

    @Override
    public void setMatrix(int i, int j, double value) {
        matrix[i][j] = value;
    }

    @Override
    public double getMatrix(int i, int j) {
        return matrix[i][j];
    }

    @Override
    public int getSize() {
        return matrix.length;
    }

    @Override
    public int getElementCount() {
        return matrix.length*matrix.length;
    }


    @Override
    public Matrix fillMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = Math.random() * 10;
            }
        }
        return this;
    }

    public Matrix fillMatrixManually() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < getSize(); i++) {
            for (int j = 0; j < getSize(); j++) {
                try {
                    this.setMatrix(i,j,Double.parseDouble(reader.readLine()));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return this;
    }

    public Matrix printMatrix() {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        return this;
    }

}
