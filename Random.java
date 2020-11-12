
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
        int diff = this.high - this.low + 1;
        num = (int) (this.nanoS / (this.second + 1));
        
        num = (int) (num * this.hour);
        
        num = (int) (num / this.minute);
        
        num = (int) (num % diff);
        
        num += low;
        
        return num;
   }

}
