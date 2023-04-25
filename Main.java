import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Toys toys = new Toys();
    List<Integer> weights = new ArrayList<>();
    int count = 0;
    try {
      FileReader reader = new FileReader("toys.txt");
      Scanner scan = new Scanner(reader);

      while (scan.hasNextLine()) {
        String line = scan.nextLine();
        String[] valuesLine = line.split(" ");
        int id = Integer.parseInt(valuesLine[0]);
        int weight = Integer.parseInt(valuesLine[1]);
        String name = valuesLine[2];

        weights.add(weight);
        toys.put(new Toy(id, name, weight));
      }
      reader.close();
      scan.close();
    } catch (IOException e) {
      System.out.println("Произошла ошибка при чтении файла.");
      e.getMessage();
    }

    for (int weight : weights) {
      count += weight;
    }

    Random random = new Random();

    try {
      FileWriter writer = new FileWriter("result.txt");

      for (int i = 0; i < 10; i++) {
        int index = random.nextInt(count);
        for (int j = 0; j < weights.size(); j++) {
          index -= weights.get(j);
          if(index < 0) {
            writer.write(toys.getToys().get(j).toString());
            break;
          }
        }
      }
      writer.close();
    } catch (IOException e) {
      System.out.println("Произошла ошибка при записи в файл.");
      e.getMessage();
    }
  }
}
