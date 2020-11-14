
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.util.Formatter;

//class DataCatch
public class DataCatch{

    private File record;
    private Map<Integer, Integer> values;
    private BufferedWriter BW = null;
    
    public DataCatch(){ 
        this.values = new HashMap<Integer, Integer>();
        try {
            this.record = new File("record.txt");
            if (this.record.createNewFile()) {
                System.out.println("record file created");
            }
            else {
                System.out.println("File already exists.");
            }
    
        } 
        catch(IOException e){
            System.out.println("An error occured in initilizing datacatch.");
            e.printStackTrace();
        }
        sRead();


    }

    public void save(int num){
        int n = 0;
        if (this.values.containsKey(num)){
            n = this.values.get(num);
            n += 1;
            this.values.remove(num);
            this.values.put(num, n);
        }
        else{
            this.values.put(num, 1);
        }
        sWrite(values);
    }


    private void sRead(){
        System.out.println("sRead.");
        boolean k = true;
        int key = 0;
        int value = 0;
        try {
            Scanner reader = new Scanner(this.record);
            while (reader.hasNextInt()){
                if (k){
                    key = reader.nextInt();
                    k = false;
               }
                else{
                    value = reader.nextInt();
                    k = true;
                    this.values.put(key, value);

                }

            }
            reader.close();
        }
        catch (IOException e) {
            System.out.println("An error occured in sRead.");
            e.printStackTrace();
        }
               

    }

    private void sWrite(Map <Integer, Integer> values){
        try{
            this.BW = new BufferedWriter(new FileWriter(this.record));
            for(Map.Entry<Integer, Integer> entry : values.entrySet()){
                BW.write( entry.getKey() + ":" + entry.getValue());
                BW.newLine();
            }

            BW.flush();

        }
        catch(IOException e){
            e.printStackTrace();
        }finally{
            try{
                BW.close();
            }
            catch(Exception e){}
        }

    }

    public void clearFile(){
        try{
            Formatter f = new Formatter(this.record);
            Scanner s = new Scanner(this.record);
            while(s.hasNext()){
                f.format(" ");
            }
            f.close();
            s.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    
}
