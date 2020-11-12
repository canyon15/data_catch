import java.util.Scanner;

// Main lets find out how random, random is.
public class Main {



    public static void main(String[] args) {
        DataCatch random = new DataCatch();
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        char ans = 'n';

        Random num = new Random(0, 100);
        int n = num.getNumber();
        System.out.println("random number between 0-100: " + n);
        random.save(n);

        while(loop){
            System.out.println("check again? (y/n)");
            ans = in.next().charAt(0);
            
            if(ans == 'y'){
                num.newNumber();
                n = num.getNumber();
                System.out.println("random number between 0-100: " + n);
                random.save(n);
            }
            else{
                loop = false;
            }

        }


              
        
    }
}