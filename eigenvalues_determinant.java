public class eigenvalues_determinant {
    public static void main(String[] args) {
        double[] lambda ={0, 0, 3};
        
        double detA = 1.0;

        for(double k : lambda){
            detA *= k;
        }

        System.out.println("det(A) = " + detA);
    }
}
