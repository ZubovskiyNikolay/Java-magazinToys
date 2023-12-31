public class Toy {
  private int id;
  private String name;
  private int quantity;
  private double weight;

  public Toy(int id, String name, int quantity, double weight){
    this.id = id;
    this.name = name;
    this.quantity = quantity;
    this.weight = weight;
  }
  public void setId(int id){
    this.id = id;
  }
  public void setName(String name){
    this.name = name;
  }
  public void setQuantity(int quantity){
    this.quantity = quantity;
  }
  public void setWeight(double weight){
    this.weight = weight;
  }
  public int getId(){
      return id;
  }
  public String getName(){
    return name;
  }
  public int getQuantity(){
    return quantity;
  }
  public double getWeigth(){
    return weight;
  }
  @Override
  public String toString() {
    return "\n" + "\nid игрушки: " + id + "\n" + 
            "Название игрушки: " + name + "\n" +
            "Количество: " + quantity + "\n" +
            "Шанс выпадения %: " + weight;
  }
}
