

import java.util.ArrayList;

public class InventoryManager {

   ArrayList<SingleProduct> SingleProd = new ArrayList<SingleProduct>();
   ArrayList<BoxedProduct> BoxedProd = new ArrayList<BoxedProduct>();
   ArrayList <String> brands = new ArrayList<String>();

   


   ArrayList<SingleProduct> getSingles(String brand){
       ArrayList<SingleProduct> singleInv  = new ArrayList<>();
       for (int i = 0; i < this.SingleProd.size(); i++) {
           if(this.SingleProd.get(i).getBrand().equals(brand)){
               singleInv.add(this.SingleProd.get(i));
           }
           
       }
    return singleInv;
   }

   

   ArrayList<BoxedProduct> getBoxes(String brand){
    ArrayList<BoxedProduct> BoxedInv  = new ArrayList<>();
       for (int i = 0; i < this.BoxedProd.size(); i++) {
           if(this.BoxedProd.get(i).getBrand().equals(brand)){
               BoxedInv.add(this.BoxedProd.get(i));
           }
       }
    return BoxedInv;
   }

   ArrayList <String> getBrands(){
    return brands;
   }
   

   void add (SingleProduct p){
    if (this.brands.contains(p.getBrand())) {
        this.SingleProd.add(p);
        
    }
    else if (!this.brands.contains(p.getBrand())){
        this.brands.add(p.getBrand());
        this.SingleProd.add(p);
    }
   }

   void add(SingleProduct p, int quantity){
    if (this.brands.contains(p.getBrand())) {
        for (int i = 1; i <= quantity; i++) {
            this.SingleProd.add(p);
        }  
    }
    else if (!this.brands.contains(p.getBrand())){
        this.brands.add(p.getBrand());
        for (int i = 1; i <= quantity; i++) {
            this.SingleProd.add(p);
        } 
    }
   }

   void add (BoxedProduct p){
    if (this.brands.contains(p.getBrand())) {
        this.BoxedProd.add(p);
        
    }
    else if (!this.brands.contains(p.getBrand())){
        this.brands.add(p.getBrand());
        this.BoxedProd.add(p);
    }
   }

   void add(BoxedProduct p, int quantity){
    if (this.brands.contains(p.getBrand())) {
        for (int i = 1; i <= quantity; i++) {
            this.BoxedProd.add(p);
        }  
    }
    else if (!this.brands.contains(p.getBrand())){
        this.brands.add(p.getBrand());
        for (int i = 1; i <= quantity; i++) {
            this.BoxedProd.add(p);
        } 
    }
   }
   
   
   
   
   void showInventory(){
    System.out.println("-INVENTORY REPORT-");
    for (String b: brands) {
        ArrayList<SingleProduct> single = getSingles(b);
        ArrayList<BoxedProduct> boxed = getBoxes(b);
        System.out.println("Brand "+ b);
        System.out.print("Singles: ");
        System.out.println(single.size());
        System.out.print("Boxes: ");
        System.out.println(boxed.size());
        int total = 0;
        for (BoxedProduct boxedProduct : boxed) {
            total+=boxedProduct.getQuantity();
        }
        int totalpieces = total+single.size();
        System.out.print("Total pieces: ");
        System.out.println(totalpieces);
    }
   }
}