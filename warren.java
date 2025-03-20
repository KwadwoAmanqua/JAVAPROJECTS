

public class warren {
    public static void main(String[] args) {
        
        int[][]mall={{50,43,98},
                    {76,84,99},
                    {21,43,78},
                    {87,65,16}};

        int[][]hst={{67,78,54},
                    {34,87,24},
                    {90,87,65},
                    {12,34,87}};

        int [][]comMonthSales = new int [4][3];
        int [] comQuatSales = new int[4];
        int comYearSales = 0;
        
        for(int i = 0; i < mall.length; i++){
            for(int j = 0; j < mall[i].length; j++){
            comMonthSales[i][j]=mall[i][j]+hst[i][j];
                comQuatSales[i]+=comMonthSales[i][j];
            }
            comYearSales+=comQuatSales[i];
        }
        
        System.out.println("The combined monthly sales: ");
        for (int i = 0; i < comMonthSales.length; i++) {
            System.out.print("[ ");
            for (int j = 0; j < comMonthSales[i].length; j++) {
                System.out.print(comMonthSales[i][j] + " ");
            }
            System.out.println("]");
        }

        System.out.print("The combined quarterly sales: [ ");
        for (int i = 0; i < comQuatSales.length; i++) {
            System.out.print(comQuatSales[i] + " ");
        }
        System.out.println("]");

        System.out.println("The combined yearly sales: " + comYearSales);
    }
}
