import java.util.*;

public class project2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter your full name : ");
        String str = s.nextLine();
        System.out.print("Enter your email : ");
        String str1 = s.nextLine();
        System.out.print("Enter your mobile number : ");
        String str2 = s.nextLine();
        System.out.print("Enter your Password : ");
        String str3 = s.nextLine();
        int ucount = 0, lcount = 0, digits = 0, scount = 0;
        if (str.length() >= 5 && str.length() <= 15) {
            if (str1.contains(".") && str1.contains("@")) {
                if (str2.length() == 10) {
                    for (int i = 0; i < str3.length(); i++) {
                        if (str3.charAt(i) >= 'A' && str3.charAt(i) <= 'Z') {
                            ucount++;
                        } else if (str3.charAt(i) >= 'a' && str3.charAt(i) <= 'z') {
                            lcount++;
                        } else if (str3.charAt(i) >= '0' && str3.charAt(i) <= '9') {
                            digits++;
                        } else {
                            scount++;
                        }
                    }

                    if (ucount > 0 && lcount > 0 && digits > 0 && scount > 0) {
                        System.out.println("All conditions satisfied");
                    }

                    else {
                        System.out.println("Entered str3 doesnt meet all the criteria");
                    }
                } else {
                    System.out.println("Entered mobile number doesnt consist 10 characters");
                }
            } else {
                System.out.println("Entered gmail must consist a dot(.) and at(@) symbol");
            }
        } else {
            System.out.println("Entered name should consist of characters from 5 to 15 only");
        }
    }
}
