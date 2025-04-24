package solver;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class GaussSeidelSolver implements IterativeSolver {

 private int iterations = 0;
 private long execTime = 0;

 @Override
 public RealVector solve(RealMatrix A, RealVector b, double tol, int maxIter) {
     int n = A.getRowDimension();
     RealVector x = new ArrayRealVector(n); // x(0) = 0

     long startTime = System.currentTimeMillis();

     for (int k = 0; k < maxIter; k++) {
         iterations = k + 1;
         RealVector xOld = x.copy(); // per confronto convergenza

         for (int i = 0; i < n; i++) {
             double sigma = 0.0;
             for (int j = 0; j < n; j++) {
                 if (j != i) {
                     sigma += A.getEntry(i, j) * x.getEntry(j); // usa anche x(i+1)
                 }
             }
             x.setEntry(i, (b.getEntry(i) - sigma) / A.getEntry(i, i));
         }

         // Controllo convergenza
         RealVector Ax = A.operate(x);
         RealVector residual = Ax.subtract(b);
         double relativeError = residual.getNorm() / b.getNorm();
         if (relativeError < tol) break;
     }

     execTime = System.currentTimeMillis() - startTime;
     return x;
 }

 @Override
 public int getIterationCount() {
     return iterations;
 }

 @Override
 public long getExecutionTimeMillis() {
     return execTime;
 }
}
