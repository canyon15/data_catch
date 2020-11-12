
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Map;
import java.util.HashMap;
import java.io.BufferedWriter;
import java.io.FileWriter;

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
            System.out.println("An error occured.");
            e.printStackTrace();
        }


    }

    public void save(int num){
        int n = 0;
        if (this.values.containsKey(num)){
            n = this.values.get(num);
            n += 1;
            this.values.replace(num, n);
        }
        else{
            this.values.put(num, 1);
        }
        sWrite(values);
    }

    private void sWrite(Map values){
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




    
}
