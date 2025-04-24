package model;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class VectorUtils {

 /**
  * Crea un vettore con tutti 1, usato come soluzione esatta x
  */
 public static RealVector createExactSolution(int size) {
     double[] data = new double[size];
     for (int i = 0; i < size; i++) data[i] = 1.0;
     return new ArrayRealVector(data);
 }

 /**
  * Calcola b = Ax
  */
 public static RealVector computeB(RealMatrix A, RealVector x) {
     return A.operate(x); // prodotto matrice-vettore
 }

 /**
  * Calcola la norma euclidea di un vettore
  */
 public static double norm(RealVector v) {
     return v.getNorm();
 }

 /**
  * Calcola il vettore nullo (tutti zero)
  */
 public static RealVector createZeroVector(int size) {
     return new ArrayRealVector(size); // default = zeri
 }
}
