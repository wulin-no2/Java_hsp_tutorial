public class homework01{
	public static void main(String[] args){
		// 1) total = 100000
		// 2)> 50000, pay 5%
		// 3)<= 50000, pay 1000
		// how many times? use "while break"

		Double totalMoney = 100000d;
		int count = 0 ;
		while(totalMoney > 50000){
				totalMoney = totalMoney - totalMoney * 5 * 0.01;
				count++;
			};
		while(totalMoney <= 50000 & totalMoney > 999){ 
			totalMoney = totalMoney - 1000;
			count++;
			};
		System.out.println(count);

	}


}
// the result is 62.