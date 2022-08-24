import models.Cart;
import models.Item;
import models.Store;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static Cart cart = new Cart();
    static Store store = new Store();

    public static void main(String[] args) {
        System.out.println("\n\t******************************JAVA GROCERS******************************\n");

        try {
            loadItems("products.txt");
            System.out.println(store);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            manageContacts();

        }
    }

    /**
     * Name: manageItems
     * Inside the function:
     * • 1. Starts a new instance of Scanner;
     * • 2. Creates an infinite loop:
     * •        The user can choose to a) add or b) remove c) checkout.
     * •          case a: asks for the aisle and item number. Then, adds item to cart.
     * •          case b: asks for the name. Then, removes item from cart.
     * •          case c: prints the receipt and closes Scanner.
     * •        Prints the updated shopping cart.
     */
    public static void manageContacts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nUPDATED STORE\n" + store);
            System.out.println("Options: \n\ta) Add to cart\n\tb) Remove from cart \n\tc) Checkout");
            String response = scanner.nextLine();
            switch (response) {
                default -> {
                    continue;
                }
                case "a" -> {
                    System.out.print("\nChoose an aisle number between: 1 – 7: ");
                    int row = scanner.hasNextInt() ? scanner.nextInt() - 1 : 404;
                    scanner.nextLine();
                    System.out.print("\nChoose an aisle number between: 1 – 3: ");
                    int column = scanner.hasNextInt() ? scanner.nextInt() - 1 : 404;
                    scanner.nextLine();
                    if (row == 404 || column == 404) {
                        System.out.println("Invalid Input");
                        continue;
                    }else{
                        if (row < 0 || row > 6 || column < 0 || column > 2){
                            System.out.println("Out of bounds");
                            continue;
                        }
                    }
                    Item item = new Item(store.getItems(row, column));
                    if (!(cart.add(item))) {
                        System.out.println(item.getName() + " is already in your shopping cart");
                    } else {
                        System.out.println(item.getName() + " was added to your shopping cart");
                    }
                }
                case "b" -> {
                    if (cart.isEmpty()){
                        System.out.println("Can't delete from empty cart");
                    }
                    System.out.print("Enter the item you'd like to remove: ");
                    String nameToDelete = scanner.nextLine();
                    cart.remove(nameToDelete);
                    System.out.println("was deleted from your shopping cart");

                }
                case "c" -> {
                    if (cart.isEmpty()){
                        System.out.println("add something to the cart first");
                        continue;
                    }
                    System.out.println(cart.checkout());
                    scanner.close();
                    return;

                }


            }
            System.out.println("\n\nSHOPPING CART\n\n" + cart);
            System.out.print("\nEnter anything to continue: ");
            scanner.nextLine();

        }
    }

    /**
     * Name: loadItems
     *
     * @param fileName (String)
     * @throws FileNotFoundException Inside the function:
     *                               1. loads items from <fileName>.txt.
     *                               • while loop runs through every line in <fileName>
     *                               • scan.nextLine() picks up the entire line.
     *                               • splits each String using the ";" separator.
     *                               • splits both fields in each String using the "=" separator.
     *                               • Parse each price into a Double.
     *                               2. adds all items to the store object's items field.
     */
    public static void loadItems(String fileName) throws FileNotFoundException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Scanner scanner = new Scanner(fileInputStream);
        for (int i = 0; scanner.hasNextLine(); i++) {
            String line = scanner.nextLine();
            String[] items = line.split(";");
            for (int j = 0; j < items.length; j++) {
                String[] fields = items[j].split("=");
                store.setItems(i, j, new Item(fields[0], Double.parseDouble(fields[1])));
            }
        }
        scanner.close();
    }
}
