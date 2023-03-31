
    import java.util.Scanner;
public class Bank {
         Scanner s=new Scanner(System.in);
          int pincount=0,wcount=0;  
          double acBal=1000000;
          public void deposite() {
              System.out.println("Enter deposite amount");
              int amount=s.nextInt();
              if(amount%100==0) {
                  if(amount<=50000) {
                      
                      acBal=acBal+amount;
                      System.out.println("Available bal: "+acBal);
                  }
                  else {
                      System.out.println("deposite limit is 50000 only");
                  }
                  
              }
              else {
                  System.out.println("Please enter multiples of 100 only");
              }
          }
          public void withdraw() {
              System.out.println("Enter withdraw amount");
              int amount=s.nextInt();
           int amt=amount;
                if(amount%100==0) {
                  if(amount<=(acBal-500)) {
                      if(amount<=20000) {
                        int twok=amount/2000;
                        amount=amount%2000;
                        int five=amount/500;
                        amount=amount%500;
                        int twohundred=amount/200;
                        amount=amount%200;
                        int hundred=amount%100;
                        System.out.println("Two thousand Notes :"+twok);
                        System.out.println("Five Hundred Notes :"+five);
		                    System.out.println("Two Hundred Notes:"+twohundred);
		                    System.out.println("Hundred Notes :"+hundred);
                          acBal=acBal-amt;
                          wcount++;
                          System.out.println("Available bal: "+acBal);
                      }
                      else {
                          System.out.println("withdraw limit is 20000 only");
                      }
                  }
                  else {
                    System.out.println("insuffient fund in your account");  
                  }
              }
              else {
                  System.out.println("Please enter multiples of 100 only");
              }
          }
          public void viewOptions() {
              System.out.println("==========ABC Bank=================");
              int option=0;
              do {
              System.out.println("\n1. Deposite");
              System.out.println("2. Withdraw");
              System.out.println("3. Bal Enquiry");
              System.out.println("0. EXIT");
              System.out.println("Choose your option");
              option=s.nextInt();
              switch(option) {
              
              case 1:
              {
                  deposite();
                  break;
              }
              case 2:
              {
                  if(wcount<3) {
                  withdraw();
                  }
                  else {
                      System.out.println("your withdraw limit is over for the day");
                  }
                  break;
              }
              case 3:
              {
                  System.out.println("Available bal: "+acBal);
                  break;
              }
              case 0:
              {
                  System.out.println("Thank you, visit again");
                  break;
              }
              default:{
                  System.out.println("Invalid option");
              }
              }
              }
              while(option!=0);
              
          }
        public void validate() {
            System.out.println("Enter pin number");
            int pin=s.nextInt();    
            if(pin==1234) {
                viewOptions();
            }
            else {
                System.out.println("Incorrect pin, please tray again");
                pincount++;
                if(pincount<3) {
                    validate();
                }
                else {
                    System.out.println("your card is blocked for the day.......");
                }
                
            }
        }
    
        public static void main(String[] args) {
             
            Bank obj=new Bank();
            obj.validate();
    
          }
}
 
