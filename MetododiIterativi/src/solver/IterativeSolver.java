package solver;

import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public interface IterativeSolver {

 /**
  * Risolve il sistema Ax = b usando un metodo iterativo.
  *
  * @param A matrice simmetrica e definita positiva
  * @param b vettore membro destro
  * @param tol tolleranza di arresto
  * @param maxIter numero massimo di iterazioni
  * @return soluzione approssimata x
  */
 RealVector solve(RealMatrix A, RealVector b, double tol, int maxIter);

 /**
  * Restituisce il numero di iterazioni fatte
  */
 int getIterationCount();

 /**
  * Restituisce il tempo di esecuzione in millisecondi
  */
 long getExecutionTimeMillis();
}
