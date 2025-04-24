package solver;

//package solver;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

public class ConjugateGradientSolver implements IterativeSolver {

 private int iterations = 0;
 private long execTime = 0;

 @Override
 public RealVector solve(RealMatrix A, RealVector b, double tol, int maxIter) {
     int n = A.getRowDimension();
     RealVector x = new ArrayRealVector(n); // x(0) = 0
     RealVector r = b.copy();               // r(0) = b
     RealVector p = r.copy();               // p(0) = r

     long startTime = System.currentTimeMillis();

     for (int k = 0; k < maxIter; k++) {
         iterations = k + 1;

         RealVector Ap = A.operate(p);
         double alpha = r.dotProduct(r) / p.dotProduct(Ap);

         x = x.add(p.mapMultiply(alpha));  // x(k+1)
         RealVector rNext = r.subtract(Ap.mapMultiply(alpha));  // r(k+1)

         if (rNext.getNorm() / b.getNorm() < tol) break;

         double beta = rNext.dotProduct(rNext) / r.dotProduct(r);
         p = rNext.add(p.mapMultiply(beta));  // p(k+1)
         r = rNext;
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

