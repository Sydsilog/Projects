import java.util.Scanner;

public class Lab2_Sy {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        

        System.out.print("Enter your initial balance: ");
        String Bal = sc.nextLine();
        
        if (Bal.matches("[a-zA-Z]+")) {
            System.out.println("Enter numbers only...");
        }
        else{
            int intBal = Integer.parseInt(Bal);
            boolean start = true;
            while (start) {
                if (checkPrice(intBal)) {

                    displayItems();
                    System.out.print("Enter the item number you want to buy: ");
                    String item = sc.nextLine();
                    if (item.matches("[a-zA-Z]+")){
                        System.out.println("Invalid Input.");
                    }
                    else{
                        int intItem = Integer.parseInt(item);
                        if (intItem>3){
                            System.out.println("Invalid Input...");
                        }
                        else{
                            intBal= calculate(sc, intBal, item);
                            if (intBal>=15) {
                                
                                boolean again = true;
                                while (again) {
                                    System.out.print("Do you want to buy another item? [yes] or [no]: ");
                                    String choice = sc.nextLine().toLowerCase();
                                    if (choice.equals("no")){
                                        System.out.println("Thank you for using the Vending Machine!");
                                        again = false;
                                        start=false;
                                    }
                                    else if (choice.equals("yes")){
                                        again = false;
                                    }
                                    else{
                                        System.out.println("Invalid input...Try again");
                                    }
                                }
                            }
                            else {
                                
                                System.out.println("You have no remaining balance. Ending Machine.");
                                System.out.println("Thank you for using the Vending Machine!");
                                start = false;
                            }
                        }
                    }
                }
                else{
                    System.out.println("Insufficient Balance!");
                    break;
                }
            }
        }
    }







    public static int calculate(Scanner sc,int bal,String item){
        int soda = 25;
        int chips = 15;
        int chocolate = 20;

        if (item.equals("1") && bal>=soda){
            bal -= soda;
            System.out.println("Item purchased successfully. Your remaining balance is $"+ bal);
        }
        else if(item.equals("1") && bal<soda){
            System.out.println("Insufficient Balance!");
        }


        if (item.equals("2") && bal>=chips){
            bal -= chips;
            System.out.println("Item purchased successfully. Your remaining balance is $"+ bal);
        }
        else if(item.equals("2") && bal<chips){
            System.out.println("Insufficient Balance!");
        }


        if (item.equals("3") && bal>=chocolate){
            bal -= chocolate;
            System.out.println("Item purchased successfully. Your remaining balance is $"+ bal);
        }
        else if(item.equals("3") && bal<chocolate){
            System.out.println("Insufficient Balance!");
        }

        return bal;
        
    }





    public static boolean checkPrice(int intBal){
        if (intBal<15 || intBal<0){
            return false;
            
        }
        else if (intBal==0){
            return false;
        }
        else {
            return true;
        }
        
    }

    public static void displayItems(){
        System.out.println("Available Items: \n1. Soda - $25 \n2. Chips - $15 \n3. Chocolate - $20");
    }

}
