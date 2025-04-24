package solver;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class GradientSolver implements IterativeSolver {

 private int iterations = 0;
 private long execTime = 0;

 @Override
 public RealVector solve(RealMatrix A, RealVector b, double tol, int maxIter) {
     int n = A.getRowDimension();
     RealVector x = new ArrayRealVector(n); // x(0) = 0
     RealVector r = b.subtract(A.operate(x)); // r(0) = b - Ax

     long startTime = System.currentTimeMillis();

     for (int k = 0; k < maxIter; k++) {
         iterations = k + 1;

         RealVector Ar = A.operate(r);
         double alpha = r.dotProduct(r) / r.dotProduct(Ar);

         x = x.add(r.mapMultiply(alpha)); // x(k+1) = x(k) + alpha * r
         r = r.subtract(Ar.mapMultiply(alpha)); // r(k+1)

         if (r.getNorm() / b.getNorm() < tol) break;
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
