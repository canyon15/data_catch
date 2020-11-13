
import java.time.LocalDateTime;
// Random class.
// returns random integer between 2
// client provided ints.
public class Random {

    private int low;
    private int high;
    private int second;
    private int nanoS; 
    private int minute;
    private int hour;
    private LocalDateTime t;

    // Constructor
    public Random(int low, int high) {
        if (low > high){
            this.low = high;
            this.high = low;
        }
        else{
            this.low = low;
            this.high = high;
        }
        this.newNumber();
    }
    //changes number Random object returns
    public void newNumber(){
        this.t = LocalDateTime.now();
        this.second = t.getSecond();
        this.nanoS = t.getNano();
        this.minute = t.getMinute();
        this.hour = t.getHour();

    }
    // Return random number.
    public int getNumber(){
        int num = 0;
        int one = 0;
        int two = 0;
        int three = 0;
        int four = 0;
        int diff = this.high - this.low + 1;
        one = (int) (this.nanoS / (this.second + 1));
        
        two = (int) (one * this.hour);
        
        three = (int) (Math.abs(two) / this.minute);
        
        four = (int) (three % diff);

        num = four;
        
        num += low;
        
        if (num < 0){
            System.out.println("nanoS / second = " + one);
            System.out.println("one * hour = " + two);
            System.out.println("two / minute = " + three);
            System.out.println("three % difference = " + four);
        }
        
        return num;
   }


}
