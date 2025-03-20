import java.util.Scanner;

public class EigenValueCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: Get matrix size
        System.out.print("Enter matrix dimension (N): ");
        int N = scanner.nextInt();

        double[][] matrix = new double[N][N];

        // Step 2: Input matrix elements
        System.out.println("Enter the elements of the matrix row by row:");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                matrix[i][j] = scanner.nextDouble();
            }
        }

        // Step 3: Compute the largest eigenvalue using Power Iteration
        double largestEigenvalue = powerIteration(matrix, N);

        // Step 4: Display the result
        System.out.println("Estimated Largest Eigenvalue: " + largestEigenvalue);

        scanner.close();
    }

    // Power Iteration to estimate the largest eigenvalue
    private static double powerIteration(double[][] matrix, int N) {
        double[] eigenvector = new double[N];
        double[] newVector = new double[N];
        double lambda = 0;

        // Initialize the eigenvector with ones
        for (int i = 0; i < N; i++) {
            eigenvector[i] = 1;
        }

        // Iteration count
        int iterations = 1000;
        double tolerance = 1e-6;

        for (int k = 0; k < iterations; k++) {
            // Matrix-vector multiplication
            for (int i = 0; i < N; i++) {
                newVector[i] = 0;
                for (int j = 0; j < N; j++) {
                    newVector[i] += matrix[i][j] * eigenvector[j];
                }
            }

            // Find the maximum absolute value for normalization (approx eigenvalue)
            double maxVal = Math.abs(newVector[0]);
            for (int i = 1; i < N; i++) {
                if (Math.abs(newVector[i]) > maxVal) {
                    maxVal = Math.abs(newVector[i]);
                }
            }

            // Normalize the new vector
            for (int i = 0; i < N; i++) {
                newVector[i] /= maxVal;
            }

            // Check for convergence
            double diff = 0;
            for (int i = 0; i < N; i++) {
                diff += Math.abs(newVector[i] - eigenvector[i]);
            }

            // Update eigenvector
            System.arraycopy(newVector, 0, eigenvector, 0, N);
            lambda = maxVal; // Estimated eigenvalue

            if (diff < tolerance) {
                break; // Stop if converged
            }
        }

        return lambda;
    }
}