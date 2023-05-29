package third.task;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main
{
    public static void main(String[] args) throws FileNotFoundException
    {
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\Lina\\IdeaProjects\\HomeWork10\\src\\main\\java\\third\\task\\words.txt"));
        try
        {
            String line = reader.readLine();
            List<String> wordsList = new ArrayList<>();
            while (line != null)
            {
                String[] words = line.split(" ");
                for (int i = 0; i < words.length; i++)
                {
                    if (!words[i].equals(""))
                    {
                        wordsList.add(words[i]);
                    }
                }
                line = reader.readLine();
            }

            HashMap<String, Integer> map = new HashMap<>();
            for (String word : wordsList)
            {
                if (!map.containsKey(word))
                {
                    map.put(word, 1);
                } else
                {
                    map.put(word, map.get(word) + 1);
                }
            }

            HashMap<Integer, Object> mapWithValuesOnlyAsKey = new HashMap<>();

            for (Integer item : map.values())
            {
                mapWithValuesOnlyAsKey.put(item, null);
            }

            ArrayList<Integer> distinctValues = new ArrayList<>();

            for (var item : mapWithValuesOnlyAsKey.keySet())
            {
                distinctValues.add(item);
            }

            Collections.sort(distinctValues, Collections.reverseOrder());

            for (Integer item : distinctValues)
            {
                for (var mapItem : map.entrySet())
                {
                    if (mapItem.getValue().equals(item))
                    {
                        System.out.println(String.format("%1$s %2$s", mapItem.getKey(), mapItem.getValue()));
                    }
                }
            }
            reader.close();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }
}
