package second.task;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        List<User> listUser = new ArrayList<>();
        try
        {
            BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\Lina\\IdeaProjects\\HomeWork10\\src\\main\\java\\second\\task\\file.txt"));
            String headLine = in.readLine();
            String lineText;
            while ((lineText = in.readLine()) != null)
            {
                String[] line = lineText.split(" ");
                listUser.add(new User(line[0], Integer.parseInt(line[1])));
            }
            for (User user : listUser)
            {
                System.out.println(user);
            }
            in.close();
        } catch (IOException e)
        {
            System.out.println("File read error");
        }
        writeUserListToJson(listUser, "C:\\Users\\Lina\\IdeaProjects\\HomeWork10\\src\\main\\java\\second\\task\\user.json");
    }

    private static void writeUserListToJson(List<User> listUser, String outputFile)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(listUser);
        try (FileWriter fileWriter = new FileWriter("C:\\Users\\Lina\\IdeaProjects\\HomeWork10\\src\\main\\java\\second\\task\\user.json"))
        {
            fileWriter.write(json);
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
