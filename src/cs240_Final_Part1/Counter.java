/**
 * 
 */
package cs240_Final_Part1;

/**
 * @author Ben
 *
 */
public class Counter {

	private int one, two, three, four, five, six;

	public Counter() {
		one = 0;
		two = 0;
		three = 0;
		four = 0;
		five = 0;
		six = 0;
	}

	public void increment(int num) {
		switch (num) {
		case 1:
			one++;
			break;
		case 2:
			two++;
			break;
		case 3:
			three++;
			break;
		case 4:
			four++;
			break;
		case 5:
			five++;
			break;
		case 6:
			six++;
			break;
		default:
			System.out.println("Invalid increment entry!");
			break;
		}
	}

	public void clearAll() {
		one = 0;
		two = 0;
		three = 0;
		four = 0;
		five = 0;
		six = 0;
	}

	public int get(int num) {
		switch (num) {
		case 1:
			return one;
		case 2:
			return two;
		case 3:
			return three;
		case 4:
			return four;
		case 5:
			return five;
		case 6:
			return six;
		default:
			System.out.println("Invalid get entry!");
			return -1;
		}
	}
}
