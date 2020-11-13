import java.util.Scanner;

// Main lets find out how random, random is.
public class Main {



    public static void main(String[] args) {
        DataCatch random = new DataCatch();
        Scanner in = new Scanner(System.in);
        boolean loop = true;
        char ans = 'n';

        Random num = new Random(1, 100);
        int n = num.getNumber();
        System.out.println("random number between 1-100: " + n);
        random.save(n);

        while(loop){
            System.out.println("Check again: (a)");
            System.out.println("clear file:  (c)");
            System.out.println("to end press a letter (not 'a' or 'c') and press enter.");
            ans = in.next().charAt(0);
            
            if(ans == 'a'){
                num.newNumber();
                n = num.getNumber();
                System.out.println("random number between 1-100: " + n);
                random.save(n);
            }
            else if (ans == 'c'){

            }
            else{
                loop = false;
            }

        }



        in.close();              
        
    }
}