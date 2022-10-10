import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class CartSpringMain {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(App.class);

        System.out.println("Commands:\n" +
                "create  - create new cart\n" +
                "insert  - add product with id\n" +
                "delete - remove product by id\n" +
                "display - show the products\n" +
                "end - finish session");

        Scanner scanner = new Scanner(System.in);
        CartSpringService cartSpringService = null;
        while (true) {
            System.out.println("Enter command");
            String command = scanner.next().toLowerCase().trim();

            switch (command) {
                case "create": {
                    cartSpringService = context.getBean(CartSpringService.class);
                    break;
                }
                case "insert": {
                    if (cartSpringService == null) {
                        System.out.println("Create cart.");
                        break;
                    }
                    System.out.println("Enter product id");
                    long id = scanner.nextLong();
                    cartSpringService.addProductSpringDTOToCart(id);
                    break;
                }
                case "delete": {
                    if (cartSpringService == null) {
                        System.out.println("Create cart!");
                        break;
                    }
                    System.out.print("Enter product id you want to delete: ");
                    Long id = scanner.nextLong();
                    cartSpringService.removeProductSpringDTOFromCart(id);
                    break;
                }
                case "display":
                    if (cartSpringService == null) {
                        System.out.println("Create Cart!");
                        break;
                    }
                    cartSpringService.getCartSpringProducts().forEach(System.out::println);
                    System.out.println();
                    break;
                case "end":
                    return;
            }
        }
    }
}

