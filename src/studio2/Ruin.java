package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		System.out.println("Enter starting amount of money");
		double startAmount= in.nextDouble();
		System.out.println("Enter win probability");
		double winChance= in.nextDouble();
		System.out.println("Enter win limit");
		double winLimit= in.nextDouble();
		System.out.println("How many days do you want to play?");
		double totalSimulation= in.nextDouble();
		double expectedRuin= 0;
		double alpha= ((1-winChance)/winChance);
		if (winChance== 0.5) {
			expectedRuin= ((1-startAmount)/winLimit);
		}
		else {
			expectedRuin= ((Math.pow(alpha, startAmount)-(Math.pow(alpha, winLimit)))/(1-Math.pow(alpha, winLimit)));
		}
		String winorlose= "";
		for(int count = 1; count <= totalSimulation; count++) {
			while ((startAmount>= 0)&&(startAmount<= winLimit)) {
				if (winChance> Math.random()) {
					startAmount++;
				} 
				else {
					startAmount--;
				}
				if (startAmount== winLimit) {
					winorlose= "win";
				}
				else {
					winorlose= "lose";
					}
		}
			System.out.println("Simluation"+ count+ ": "+ winorlose );
		}
	}

}
