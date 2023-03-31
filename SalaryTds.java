import java.util.Scanner;
  class SalaryTds {
public static void main(String args[]) {
  Scanner s = new Scanner(System.in);
  int salary=0,tds=0;
  System.out.println("Enter the Salary : ");
  salary=s.nextInt();

  if (salary>700000) {
    if (salary<=900000) {
      tds=(salary*15)/100+(salary*10)/100+(salary*5)/100;
      System.out.println("The tds amount is : " +tds);
    }
    else if (salary<=1200000) {
      tds=(salary*20)/100+(salary*15)/100+(salary*10)/100+(salary*5)/100;
      System.out.println("The tds amount is : " +tds);
    }
    else {
      tds=(salary*30)/100+(salary*20)/100+(salary*15)/100+(salary*10)/100+(salary*5)/100;
      System.out.println("The tds amount is : " +tds);
    }
    
  }
  else {
    System.out.println("The TDS amount is 0");
  }
  
  
  
}
}
