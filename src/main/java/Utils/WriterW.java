package Utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by makovskiy on 15.12.2014.
 */
public class WriterW {

    private File newFile = new File("tableResults.txt");
    private FileWriter fileW;
    private BufferedWriter buffW ;

    public WriterW()  {

        try {
            fileW = new FileWriter(newFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        buffW = new BufferedWriter(fileW);

    }

    public void myFileWriter(String text) throws IOException {

                buffW.write(text+"\n");

    }

     public void close()  {

        System.out.println("file written");
         try {
             buffW.close();
         } catch (IOException e) {
             e.printStackTrace();
         }
     }
}

