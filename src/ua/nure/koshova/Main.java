package ua.nure.koshova;

public class Main {

    public static void main(String[] args) {
        Matrix myMatrix = new MyMatrix(3);
        myMatrix.fillMatrixManually();
        myMatrix.printMatrix();
        System.out.println();
        Matrix resInverse = myMatrix.inverseMatrix();
        resInverse.printMatrix();
        System.out.println(myMatrix.getDeteminant());
//        Matrix myMatrix2 = new MyMatrix(4);
//        myMatrix2.fillMatrixManually();
//        myMatrix2.printMatrix();
//        System.out.println();
//        Matrix res = myMatrix.matrixMultiplication(myMatrix2);
//        res.printMatrix();

//        Matrix one = new MyMatrixOneDimensional(3);
//        one.fillMatrixManually();
//        one.printMatrix();
//        System.out.println();
////        Matrix two = new MyMatrixOneDimensional(3);
////        two.fillMatrixManually();
////        two.printMatrix();
////        Matrix res2 = one.matrixMultiplication(two);
////        System.out.println(res2);
//        Matrix resInverse2 = one.inverseMatrix();
//        resInverse2.printMatrix();
//
//        System.out.println(one.getDeteminant());

    }
}
