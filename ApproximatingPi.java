import java.util.Random;
import java.util.Scanner;
import java.lang.Math;

public class ApproximatingPi {

	/**
	 * Generates a new random number between -1/2 and 1/2
	 * 
	 * @return
	 */
	public double randomNum() {

		Random generator = new Random();
		double num = generator.nextDouble();
		return num - 0.5;
	}
	/**
	 * Calculates standard deviation 
	 * 
	 * @param avgs array of averages from the simulated games
	 * @param mean means of the averages
	 * @return Standard deviation
	 */
	public double standDev(double [] avgs, double mean) {
		double sum = 0;
		double sum2 = 0;
		double stDev;
		double [] sqDiffs = new double[avgs.length];
		for (int i = 0; i < avgs.length; i++) {
			sqDiffs[i] = Math.pow((avgs[i] - mean), 2);
		}
		for (double num : sqDiffs) {
			sum2 = sum2 + num;
		}
		stDev = Math.sqrt(sum2/sqDiffs.length);
		return stDev;
	}
	/**
	 * Simulates a specified number of dart games each with a specified amount of throws
	 * and then calculates the average distance from the center
	 */
	public void simulateGames() {
		double sum = 0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the number of games.");
		int numGames = in.nextInt();
		double [] gameAvgs = new double[numGames];
		System.out.println("Enter the number of throws per game.");
		int numThrows = in.nextInt();
		for(int j = 0; j < numGames; j++) {


			double hits = 0;
			for(int i = 0; i < numThrows; i++) {
				double x = randomNum();
				double y = randomNum();
				double d = Math.sqrt((x*x)+(y*y));
				if (d < 0.5) hits++;
				//System.out.println("("+x+","+y+")");
			}
			double avg = 4.0*(hits/numThrows);
			gameAvgs[j] = avg;
		}
		for (double num : gameAvgs) {
			sum = sum + num;
		}
		double mean = sum/numGames;
		double stDev = standDev(gameAvgs, mean);
		System.out.println("Mean: "+mean);
		System.out.println("Standard deviation: "+stDev);

		in.close();	
	}

	public static void main(String[] args) {
		ApproximatingPi nums = new ApproximatingPi();
		nums.simulateGames();

	}

}
