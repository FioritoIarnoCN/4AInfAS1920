package it.itis.cuneo;

import javax.annotation.processing.FilerException;
import java.io.*;

public class TextFile {

    private char mode;
    private BufferedReader reader;
    private BufferedWriter writer;

    public TextFile(String fileName, char mode) throws IOException{
        this.mode = 'R';

        if(mode == 'W' || mode == 'w'){
            this.mode = 'W';
            writer = new BufferedWriter(new FileWriter(fileName));
        }else{
            reader = new BufferedReader(new FileReader(fileName));
        }
    }

    public void toFile(String line) throws FileException, IOException{

        if (this.mode == 'R') throw new FileException("Read_only" + "file!");

        writer.append(line);
        writer.newLine();
    }

    public String fromFile() throws FileException, IOException{

        String tmp;

        if(this.mode == 'W') throw new FileException("Write-only" + "file");

        tmp = reader.readLine();

        if (tmp == null) throw new FileException("End of file!");
        return tmp;
    }

    public void closeFile() throws IOException{
        if(this.mode == 'W')
            writer.close();
        else
            reader.close();
    }
}
