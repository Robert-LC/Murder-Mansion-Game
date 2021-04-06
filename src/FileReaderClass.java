import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class FileReaderClass
{
    String e;
    public void readFile(String path, Mansion m) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader("rooms.txt")))
        {
            while((e = fileReader.readLine())!= null)
            {
                String[] info = e.split(",");
                Room r = new Room();
                for (int i = 0; i < info.length; i++)
                {
                    r
                }
            }
        }
        catch (IOException ex)
        {
            System.out.println("File not found");
        }
    }
}

