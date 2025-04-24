package main;


import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import model.MatrixLoader;
import model.VectorUtils;
import solver.ConjugateGradientSolver;
import solver.GaussSeidelSolver;
import solver.GradientSolver;
import solver.IterativeSolver;
import solver.JacobiSolver;

public class Main {
 public static void main(String[] args) {
     try {
         // === INPUT ===
    	 String[] filePaths = {
                 "src/matrici/spa1.mtx",
                 "src/matrici/spa2.mtx",
                 "src/matrici/vem1.mtx",
                 "src/matrici/vem2.mtx"
             };
    	 
         double[] tolerances = {1e-4, 1e-6, 1e-8, 1e-10};
         int maxIter = 20000;


         for (String filePath : filePaths) {
             System.out.println("\n===================================");
             System.out.println("File matrice: " + filePath);
             System.out.println("===================================");

             RealMatrix A = MatrixLoader.loadMatrix(filePath);
             RealVector xExact = VectorUtils.createExactSolution(A.getColumnDimension());
             RealVector b = VectorUtils.computeB(A, xExact);


         for(double tol : tolerances) {
        	 
        	    System.out.println("\n==============================");
                System.out.println("Tolleranza: " + tol);
                System.out.println("==============================");
        
         // === Jacobi ===
         IterativeSolver jacobi = new JacobiSolver();
         RealVector xJacobi = jacobi.solve(A, b, tol, maxIter);
         double errJacobi = xJacobi.subtract(xExact).getNorm() / xExact.getNorm();

         // === Gauss-Seidel ===
         IterativeSolver gs = new GaussSeidelSolver();
         RealVector xGS = gs.solve(A, b, tol, maxIter);
         double errGS = xGS.subtract(xExact).getNorm() / xExact.getNorm();

         // === Gradiente ===
         IterativeSolver grad = new GradientSolver();
         RealVector xGrad = grad.solve(A, b, tol, maxIter);
         double errGrad = xGrad.subtract(xExact).getNorm() / xExact.getNorm();
         
         IterativeSolver cg = new ConjugateGradientSolver();
         RealVector xCG = cg.solve(A, b, tol, maxIter);
         double errCG = xCG.subtract(xExact).getNorm() / xExact.getNorm();

         // === Risultati ===
         System.out.println("\nMetodo: Jacobi");
         System.out.println("Iterazioni: " + jacobi.getIterationCount());
         System.out.println("Tempo (ms): " + jacobi.getExecutionTimeMillis());
         System.out.println("Errore relativo: " + errJacobi);

         System.out.println("\nMetodo: Gauss-Seidel");
         System.out.println("Iterazioni: " + gs.getIterationCount());
         System.out.println("Tempo (ms): " + gs.getExecutionTimeMillis());
         System.out.println("Errore relativo: " + errGS);

         System.out.println("\nMetodo: Gradiente");
         System.out.println("Iterazioni: " + grad.getIterationCount());
         System.out.println("Tempo (ms): " + grad.getExecutionTimeMillis());
         System.out.println("Errore relativo: " + errGrad);

         System.out.println("\nMetodo: Gradiente Coniugato");
         System.out.println("Iterazioni: " + cg.getIterationCount());
         System.out.println("Tempo (ms): " + cg.getExecutionTimeMillis());
         System.out.println("Errore relativo: " + errCG);
       }
       }
     } catch (Exception e) {
         System.err.println("Errore: " + e.getMessage());
         e.printStackTrace();
     }
 }
}
