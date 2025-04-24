package solver;

//package solver;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class JacobiSolver implements IterativeSolver {

 private int iterations = 0;
 private long execTime = 0;

 @Override
 public RealVector solve(RealMatrix A, RealVector b, double tol, int maxIter) {
     int n = A.getRowDimension();
     RealVector xOld = new ArrayRealVector(n); // x(0) = 0
     RealVector xNew = new ArrayRealVector(n);

     long startTime = System.currentTimeMillis();

     for (int k = 0; k < maxIter; k++) {
         iterations = k + 1;

         for (int i = 0; i < n; i++) {
             double sigma = 0.0;

             for (int j = 0; j < n; j++) {
                 if (j != i) {
                     sigma += A.getEntry(i, j) * xOld.getEntry(j);
                 }
             }

             xNew.setEntry(i, (b.getEntry(i) - sigma) / A.getEntry(i, i));
         }

         // Controllo di convergenza
         RealVector Ax = A.operate(xNew);
         RealVector residual = Ax.subtract(b);
         double relativeError = residual.getNorm() / b.getNorm();
         if (relativeError < tol) break;

         // x(k+1) diventa x(k)
         xOld = xNew.copy();
     }

     execTime = System.currentTimeMillis() - startTime;
     return xNew;
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

