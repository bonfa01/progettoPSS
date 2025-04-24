package model;
import org.apache.commons.math3.linear.OpenMapRealMatrix;
import org.apache.commons.math3.linear.RealMatrix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MatrixLoader {

    /**
     * Carica una matrice simmetrica e sparsa da un file .mtx (Matrix Market).
     * @param path percorso del file .mtx
     * @return matrice caricata come RealMatrix
     */
    public static RealMatrix loadMatrix(String path) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(path));
        String line;

        // Skippa i commenti
        do {
            line = reader.readLine();
        } while (line != null && line.startsWith("%"));

        // Legge dimensioni e numero di elementi
        String[] dims = line.trim().split("\\s+");
        int rows = Integer.parseInt(dims[0]);
        int cols = Integer.parseInt(dims[1]);
        int nnz = Integer.parseInt(dims[2]);

        OpenMapRealMatrix matrix = new OpenMapRealMatrix(rows, cols);

        // Legge valori
        while ((line = reader.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            String[] parts = line.trim().split("\\s+");

            int row = Integer.parseInt(parts[0]) - 1; // da 1-based a 0-based
            int col = Integer.parseInt(parts[1]) - 1;
            double value = Double.parseDouble(parts[2]);

            matrix.setEntry(row, col, value);
            if (row != col) matrix.setEntry(col, row, value); // simmetrica
        }

        reader.close();
        return matrix;
    }
}
