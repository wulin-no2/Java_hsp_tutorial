import java.util.Scanner;

public class homework03{
	public static void main(String[] args){
		Scanner myscanner = new Scanner(System.in);
		System.out.println("please input a year:");
		int a = myscanner.nextInt();
		//if (a instanceof Integer){
			if (a % 4 == 0){
				System.out.println("it's a RUN-year.");
			};
			if (a % 4 != 0){
				System.out.println("it's not a RUN-year.");
			};
		}
		//System.out.println("please input an int.");


	}
//}
//check out if this int is RUN-year.