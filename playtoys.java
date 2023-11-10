import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class playtoys {
  public static void main(String[] args) {
    ArrayList<Toy> toys = new ArrayList<>();
    Toy toy1 = new Toy(1, "Собака", 5, 10.3);
    Toy toy2 = new Toy(2, "Кошка", 5, 12.00);
    Toy toy3 = new Toy(3, "Чебурашка", 5, 4.35);
    Toy toy4 = new Toy(4, "Лошадь", 5, 26.30);
    Toy toy5 = new Toy(5, "Буратино", 5, 7.35);
    toys.add(toy1);
    toys.add(toy2);
    toys.add(toy3);
    toys.add(toy4);
    toys.add(toy5);

    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("\n\t-----------МЕНЮ-----------");
      System.out.println("\n\t1 - Начать розыгрыш игрушки");
      System.out.println("\t2 - Добавить игрушку");
      System.out.println("\t3 - Список всех игрушек");
      System.out.println("\t4 - Изменить шанс выпадения игрушки");
      System.out.println("\t0 - Выход");

      System.out.print("\nВыберите пункт меню: ");
      int pos = sc.nextInt();
      if (pos == 0) {
        System.out.println("\nДо свидание!\n");
        break;
      } else {
        switch (pos) {
          case 1:
            String priz = playToy(toys);
            if (priz.equals("")) {
              System.out.println("\nВсе игрушки розыграны! Добавьте игрушки!\n");
            } else {
              System.out.println("\nПоздравляем! Вы выграли: " + priz + "! Ура,крутите барабан!");
            }
            break;
          case 2:
            addToy(toys);
            break;
          case 3:
            System.out.println(toys);
            break;
          case 4:
            System.out.print("Введите id игрушки: ");
            int id = sc.nextInt();
            System.out.print("Введите новый шанс выпадения %: ");
            double weigth = sc.nextDouble();
            editToys(toys, id, weigth);
            break;
          default:
            System.out.println("\nВведите корректныю позицию\n");
            break;
        }
      }
    }
    sc.close();
  }

  public static void addToy(ArrayList<Toy> arr) {
    Scanner sc = new Scanner(System.in);
    System.out.print("\nВведите id игрушки: ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Введите название игрушки: ");
    String name = sc.nextLine();
    System.out.print("Введите количество игрушки: ");
    int quantity = sc.nextInt();
    System.out.print("Введите шанс выпадения(вес) игрушки: ");
    double weight = sc.nextDouble();
    Toy toy = new Toy(id, name, quantity, weight);
    arr.add(toy);
    System.out.println("\nИгрушка успешно добавлена!\nЖелаем удачи в розыгрыше!\n");
  }

  public static void editToys(ArrayList<Toy> arr, int chid, double chweigth) {
    for (Toy toy : arr) {
      if (toy.getId() == chid) {
        toy.setWeight(chweigth);
        System.out.println(toy);
        break;
      }
    }
    System.out.println("\nШанс удачно изменен!");
  }

  public static String playToy(ArrayList<Toy> arr) {
    Random rnd = new Random();
    double totalweigth = 0;
    String priz = "";
    for (Toy toy : arr) {
      totalweigth += toy.getWeigth();
    }
    double rndweigth = rnd.nextDouble() * totalweigth;
    double currentweigth = 0;
    for (Toy toy : arr) {
      currentweigth += toy.getWeigth();
      if (rndweigth <= currentweigth) {
        priz = toy.getName();
        toy.setQuantity(toy.getQuantity() - 1);
        if (toy.getQuantity() == 0) {
          arr.remove(toy);
        }
        break;
      }
    }
    return priz;
  }
}
