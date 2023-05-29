package first.task;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        BufferedReader reader;
        try
        {
            reader = new BufferedReader(new FileReader("C:\\Users\\Lina\\IdeaProjects\\HomeWork10\\src\\main\\java\\first\\task\\file.txt"));
            String line = reader.readLine();
            List<String> list = new ArrayList<>();
            while (line != null)
            {
                list.add(line);
                line = reader.readLine();
            }
            List<String> resList = new ArrayList<>();
            for (String numberTelephone : list)
            {
                if (numberTelephone.replace("0", "x")
                        .replace("1", "x").replace("2", "x")
                        .replace("3", "x").replace("4", "x")
                        .replace("5", "x").replace("6", "x")
                        .replace("7", "x").replace("8", "x")
                        .replace("9", "x").equals("(xxx) xxx-xxxx")
                        || numberTelephone.replace("0", "x").replace("1", "x")
                        .replace("2", "x").replace("3", "x")
                        .replace("4", "x").replace("5", "x")
                        .replace("6", "x").replace("7", "x")
                        .replace("8", "x").replace("9", "x")
                        .equals("xxx-xxx-xxxx"))
                {
                    resList.add(numberTelephone);
                }
            }
            for (String validNumberTelephone : resList)
            {
                System.out.println(validNumberTelephone);
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
