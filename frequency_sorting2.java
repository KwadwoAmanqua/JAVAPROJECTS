

public class frequency_sorting2 {
    public static void main(String[] args) {
        int[] ratings= {1,2,5,4,3,5,2,1,3,3,1,4,3,2,5,3,4,5,3,1};

        int[] frequency = new int[6];

        for(int i = 0; i < ratings.length; i++){
            frequency[ratings[i]]++;
        }

        for(int i= 0; i < frequency.length; i++){
            System.out.println("Rating" + (i) + ":" + frequency[i]);
        }
    }
}
