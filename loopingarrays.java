public class loopingarrays {
    public static void main(String[] args) {
        
        int[][]mall={{50,43,98},
                     {76,84,99},
                     {21,43,78},
                     {87,65,16}};

        int[][]hst={{67,78,54},
                    {34,87,24},
                    {90,87,65},
                    {12,34,87}};

        int [][] sum_monthly_sales = new int[4][3];
        int [] sum_quaterly_sales = new int[4];
        int  sum_yearly_sales = 0;

        
        for(int i = 0; i < mall.length; i++){
            for(int j = 0; j < mall[i].length; j++){
              sum_monthly_sales[i][j] = mall[i][j] + hst[i][j];
              
              sum_quaterly_sales[i]+=sum_monthly_sales[i][j];

              sum_yearly_sales += sum_quaterly_sales[i];
            }
        }

        
        System.out.println("The combined monthly sales: ");
        for (int i = 0; i < sum_monthly_sales.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < sum_monthly_sales[i].length; j++) {
                System.out.print(sum_monthly_sales[i][j] + " ");
            }
            System.out.println("]");
        }

        System.out.print("The combined quarterly sales: [ ");
        for (int i = 0; i < sum_quaterly_sales.length; i++) {
            System.out.print(sum_quaterly_sales[i] + " ");
        }
        System.out.println("]");

        System.out.println("The total yearly sales: " + sum_yearly_sales);
    }
}
