public class frequency_sorting {
    public static void main(String[] args) {
         int[] remarks = {1,2,5,4,3,5,2,1,3,3,1,4,3,2,5,3,4,5,3,1};

         int[] frequency = new int[6];
        
                
        for (int rating : remarks) {
            frequency[rating]++; 
        }
        
                
        System.out.println("Rating | Frequency");
        for (int i = 1; i <= 5; i++) {
            System.out.println(i + ": " + frequency[i]);
        }
    }
    
}
