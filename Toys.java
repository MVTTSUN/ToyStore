import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Toys {
  private PriorityQueue<Toy> queueToys;
  private ArrayList<Toy> toys = new ArrayList<>();

  public Toys() {
    this.queueToys = new PriorityQueue<>(Comparator.comparingInt(Toy::getWeight));
  }

  public void put(Toy toy) {
    this.queueToys.add(toy);
    this.toys.add(toy);
  }

  public Toy get() {
    return this.queueToys.poll();
  }

  public ArrayList<Toy> getToys() {
    return this.toys;
  }
}
