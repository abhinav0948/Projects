import java.util.Scanner;
public class ShoppingBill {
  Scanner s = new Scanner(System.in);
  int quantity=0,cost1=0,cost2=0,cost3=0,cost4=0,cost5=0,cost6=0,cost7=0,cost8;

  public void bill() {
  int total=0;
    total=cost1+cost2+cost3+cost4+cost5+cost6+cost7+cost8;
    double bill1=((total*2.5)/100)+total;
    System.out.println("Your total bill including GST is : "+bill1);
  System.out.println("========================================");
  System.out.println("Thanks For Visting Pista House, Vanasthalipuram \n           Please Visit Us Again!!!");
  }
  public void burger() {
    System.out.println("Enter the Quantity of Burger : ");
    quantity=s.nextInt();
    cost1=quantity*150;
  }
  public void sandwich() {
    System.out.println("Enter the Quantity of Sandwich : ");
    quantity=s.nextInt();
    cost2=quantity*100;
  }
  public void chickennug() {
    System.out.println("Enter the Quantity of Chicken Nuggets : ");
    quantity=s.nextInt();
    cost3=quantity*180;
  }
  public void chickensf() {
    System.out.println("Enter the Quantity of Chicken 65 : ");
    quantity=s.nextInt();
    cost4=quantity*180;
  }
  public void paneerroll() {
    System.out.println("Enter the Quantity of Paneer Roll : ");
    quantity=s.nextInt();
    cost5=quantity*150;
  }
  public void chickenmaj() {
    System.out.println("Enter the Quantity of Chicken Majestic : ");
    quantity=s.nextInt();
    cost6=quantity*300;
  }
  public void chickendrum() {
    System.out.println("Enter the Quantity of Chicken Drumstick : ");
    quantity=s.nextInt();
    cost7=quantity*300;
  }
  public void chickenlol() {
    System.out.println("Enter the Quantity of Chicken Lollipop : ");
    quantity=s.nextInt();
    cost8=quantity*300;
  }
  
  public void menu() {
    int select=0;
    do {
  System.out.println("========================================");
  System.out.println("======== Welcome to Pista House ========");
  System.out.println("========================================");
    System.out.println("1. Burger @150");
    System.out.println("2. Sandwich @100");
    System.out.println("3. Chicken Nuggets @180");
    System.out.println("4. Chicken 65 @180");
    System.out.println("5. Paneer Roll @150");
    System.out.println("6. Chicken Majestic @300");
    System.out.println("7. Chicken Drumstick @300");
    System.out.println("8. Chicken Lollipop @300");
    System.out.println("========================================");
    System.out.println("9. Print the Bill");
    System.out.println("========================================");
    select=s.nextInt();
    switch(select) {
      case 1:
        burger();
        break;
        case 2:
        sandwich();
        break;
        case 3:
        chickennug();
        break;
        case 4:
        chickensf();
        break;
        case 5:
        paneerroll();
        break;
        case 6:
        chickenmaj();
        break;
        case 7:
        chickendrum();
        break;
        case 8:
        chickenlol();
        break;
        case 9:
        bill();
        break;
    }
      
    }
      while(select!=9);
  }
  public static void main(String args[]) {
    ShoppingBill obj = new ShoppingBill();
    obj.menu();
    
    
}
}

