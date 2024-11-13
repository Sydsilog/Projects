
import java.util.Scanner;


public class JavaApplication10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        InventoryManager invManager = new InventoryManager();

        boolean start = true;
        while (start) {
            System.out.println("Options:");
            System.out.println("\t[1] Add Single Product \n\t[2] Add Box Product \n\t[3] Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();
            if (choice.equals("1")) {
                System.out.print("Brand: ");
                String brandName = sc.nextLine().toUpperCase();
                SingleProduct brand = new SingleProduct(brandName);
                System.out.print("Quantity: ");
                int quantity = sc.nextInt();
                sc.nextLine();
                if (quantity==1){
                    invManager.add(brand);
                
                }
                else if (quantity>1){
                    invManager.add(brand, quantity);
                }
            }
            else if (choice.equals("2")){
                System.out.print("Brand: ");
                String brandName = sc.nextLine().toUpperCase();
                System.out.print("Items in Box: ");
                int Items = sc.nextInt();
                System.out.print("Quantity: ");
                int boxItems = sc.nextInt();
                sc.nextLine();
                BoxedProduct brand = new BoxedProduct(brandName, Items);
                if (boxItems==1){
                    invManager.add(brand);
                }
                else if (boxItems>1){
                    invManager.add(brand, boxItems);
                    
                }
            }
            else if (choice.equals("3")){
                invManager.showInventory();
                start=false;
            }
        }
    }
}
