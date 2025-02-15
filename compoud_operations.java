public class compoud_operations {
    public static void main(String[] args) {
        int i;

        for(i = 0; i < 5; i++){
            System.out.println(i+=2);
        }
        System.out.println("------------");
        for(i = 0; i < 5; i++){
            System.out.println(i++);
        }
        System.out.println("------------");
        for(i = 0; i < 5; i++){
            System.out.println(++i);
        }
        System.out.println("------------");
        for (i = 0; i <= 25; i += 3 ){
            if(i == 9) break;{
                System.out.println(i *= 2);
            }
        }
        System.out.println("------------");
        for (i = 2; i < 25;  i-- ){
            if(i == 15) break;{
                System.out.println(i *= 2);
            }
        }
    }
    
}
