import java.util.Scanner;

public class EigenvaluesCalculator {
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

        // Step 3: Compute and display eigenvalues
        if (N == 2) {
            computeEigenvalues2x2(matrix);
        } else if (N == 3) {
            computeEigenvalues3x3(matrix);
        } else {
            computeEigenvaluesQR(matrix, N);
        }

        scanner.close();
    }

    // Method for 2x2 matrix: Solve characteristic equation
    private static void computeEigenvalues2x2(double[][] matrix) {
        double a = matrix[0][0], b = matrix[0][1];
        double c = matrix[1][0], d = matrix[1][1];

        // Characteristic equation: λ² - (a+d)λ + (ad-bc) = 0
        double trace = a + d;
        double determinant = (a * d) - (b * c);
        double discriminant = trace * trace - 4 * determinant;

        if (discriminant < 0) {
            System.out.println("Eigenvalues are complex.");
        } else {
            double lambda1 = (trace + Math.sqrt(discriminant)) / 2;
            double lambda2 = (trace - Math.sqrt(discriminant)) / 2;
            System.out.println("Eigenvalues: " + lambda1 + ", " + lambda2);
        }
    }

    // Method for 3x3 matrix: Solve cubic characteristic equation using Cardano’s method
    private static void computeEigenvalues3x3(double[][] matrix) {
        double a = matrix[0][0], b = matrix[0][1], c = matrix[0][2];
        double d = matrix[1][0], e = matrix[1][1], f = matrix[1][2];
        double g = matrix[2][0], h = matrix[2][1], i = matrix[2][2];

        // Compute characteristic polynomial coefficients
        double trace = a + e + i;
        double determinant = a * (e * i - f * h) - b * (d * i - f * g) + c * (d * h - e * g);
        double sumOfMinors = (a * e) + (a * i) + (e * i) - (b * d) - (c * g) - (f * h);

        // Solve using the cubic equation formula (Cardano's formula)
        double Q = (trace * trace - 3 * sumOfMinors) / 9;
        double R = (2 * trace * trace * trace - 9 * trace * sumOfMinors + 27 * determinant) / 54;
        double discriminant = R * R - Q * Q * Q;

        if (discriminant > 0) { // One real root, two complex
            double theta = Math.acos(R / Math.sqrt(Q * Q * Q));
            double lambda1 = -2 * Math.sqrt(Q) * Math.cos(theta / 3) + trace / 3;
            double lambda2 = -2 * Math.sqrt(Q) * Math.cos((theta + 2 * Math.PI) / 3) + trace / 3;
            double lambda3 = -2 * Math.sqrt(Q) * Math.cos((theta + 4 * Math.PI) / 3) + trace / 3;
            System.out.println("Eigenvalues: " + lambda1 + ", " + lambda2 + ", " + lambda3);
        } else {
            System.out.println("Complex or repeated roots.");
        }
    }

    // Method for N x N matrix (N ≥ 4): Use QR algorithm for numerical approximation
    private static void computeEigenvaluesQR(double[][] matrix, int N) {
        double[][] A = matrix.clone();
        int iterations = 1000;
        double tolerance = 1e-6;

        for (int iter = 0; iter < iterations; iter++) {
            // QR Decomposition
            double[][] Q = new double[N][N];
            double[][] R = new double[N][N];
            qrDecomposition(A, Q, R, N);

            // Update A = R * Q
            A = multiplyMatrices(R, Q, N);

            // Check for convergence (diagonal elements are eigenvalues)
            boolean converged = true;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (i != j && Math.abs(A[i][j]) > tolerance) {
                        converged = false;
                        break;
                    }
                }
            }
            if (converged) break;
        }

        // Print eigenvalues (diagonal elements)
        System.out.println("Eigenvalues:");
        for (int i = 0; i < N; i++) {
            System.out.println(A[i][i]);
        }
    }

    // QR decomposition: Compute Q and R matrices
    private static void qrDecomposition(double[][] A, double[][] Q, double[][] R, int N) {
        double[][] tempA = A.clone();

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N; i++) {
                Q[i][j] = tempA[i][j];
            }
            for (int k = 0; k < j; k++) {
                double dotProduct = 0;
                for (int i = 0; i < N; i++) {
                    dotProduct += Q[i][j] * Q[i][k];
                }
                for (int i = 0; i < N; i++) {
                    Q[i][j] -= dotProduct * Q[i][k];
                }
            }
            double norm = 0;
            for (int i = 0; i < N; i++) {
                norm += Q[i][j] * Q[i][j];
            }
            norm = Math.sqrt(norm);
            for (int i = 0; i < N; i++) {
                Q[i][j] /= norm;
            }
        }

        // Compute R = Q^T * A
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                R[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    R[i][j] += Q[k][i] * A[k][j];
                }
            }
        }
    }

    // Matrix multiplication helper function
    private static double[][] multiplyMatrices(double[][] A, double[][] B, int N) {
        double[][] C = new double[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    C[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return C;
    }
}