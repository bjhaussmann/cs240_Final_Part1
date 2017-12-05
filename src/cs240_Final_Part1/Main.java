/**
 * 
 */
package cs240_Final_Part1;

import cs240_Final_Part1.ListLinked;
import cs240_Final_Part1.StackLinked;

import java.util.EmptyStackException;
import java.util.Random;

/**
 * @author bjhau
 *
 */
public class Main {

	// make the stacks for all of the food. The saved integer is the expiration
	// date.
	private static StackLinked<Integer> bun = new StackLinked<Integer>();
	private static StackLinked<Integer> patty = new StackLinked<Integer>();
	private static StackLinked<Integer> lettuce = new StackLinked<Integer>();
	private static StackLinked<Integer> tomato = new StackLinked<Integer>();
	private static StackLinked<Integer> onion = new StackLinked<Integer>();
	private static StackLinked<Integer> cheese = new StackLinked<Integer>();

	// Make all of the menu options
	private static ListLinked<String> burger = new ListLinked<String>();
	private static ListLinked<String> cBurger = new ListLinked<String>();
	private static ListLinked<String> vegan = new ListLinked<String>();
	private static ListLinked<String> burgerNO = new ListLinked<String>();
	private static ListLinked<String> cBurgerNO = new ListLinked<String>();
	private static ListLinked<String> burgerNT = new ListLinked<String>();

	private static int delivery = 0;
	private static Random rnd = new Random(System.currentTimeMillis());
	private static int date = 1201;

	/*
	 * 1. Bun 2. Patty 3. Lettuce 4. Tomato 5. Onion 6. Cheese
	 */
	private static Counter foodLost = new Counter();
	private static boolean outOfFood = false;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int hour = 0;
		int custLost = 0;
		int line = 0;
		int customerNum = 1;
		int orderNum = 0;

		/*
		 * 1. Number One 2. Number Two 3. Number Three 4. Number Four 5. Number Five 6.
		 * Number Six
		 */
		Counter itemsOrdered = new Counter();

		// initialize all the menu options
		burger();
		cBurger();
		vegan();
		burgerNO();
		cBurgerNO();
		burgerNT();

		deliver();

		QueueFixedSize<Integer> customers = new QueueFixedSize<Integer>(50);
		DictionaryLinked<Integer, Integer> custDict = new DictionaryLinked<Integer, Integer>();

		while (date <= 1231) // only runs till the end of December
		{
			if (delivery == date) {
				deliver();
			}

			hour = 10; // start time for the new day
			customerNum = 1; // first customer for the new day
			foodLost.clearAll(); // clear food lost for the new day
			itemsOrdered.clearAll(); // clear what items ordered for the new day
			custDict.clear(); // clear the customer dictionary for the new day
			custLost = 0; // clear customers lost from the previous day for the new day

			while (hour <= 19) // only open from 1000 - 1900;
			{
				line = 1 + rnd.nextInt(100); // how many customers are showing up that hour ( 1-100)
				if (line > 50) // the queue can only hold 50 people, anyone over 50 is a walk away. adds the
								// excess to the lost customer list and caps at 50.
				{
					custLost += line - 50;
					line = 50;
				}

				for (int i = 0; i < line; i++) // add customers and their order number to the queue
				{
					// System.out.println(i);
					customers.enqueue(1 + rnd.nextInt(6));
				}

				while (!customers.isEmpty()) // empty the queue/customers ordering
				{
					try {
						orderNum = customers.dequeue();
					} catch (EmptyQueueException e) {
						e.printStackTrace();
					}
					try {
						switch (orderNum) {
						case 1:
							lettuce.pop();
							tomato.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							break;
						case 2:
							lettuce.pop();
							tomato.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							cheese.pop();
							break;
						case 3:
							lettuce.pop();
							lettuce.pop();
							tomato.pop();
							onion.pop();
							break;
						case 4:
							lettuce.pop();
							tomato.pop();
							bun.pop();
							patty.pop();
							break;
						case 5:
							lettuce.pop();
							tomato.pop();
							bun.pop();
							patty.pop();
							cheese.pop();
							break;
						case 6:
							lettuce.pop();
							onion.pop();
							bun.pop();
							patty.pop();
							break;
						}
					} catch (EmptyStackException e) {
						outOfFood = true;
					}
					if (outOfFood == false) {
						itemsOrdered.increment(orderNum);
						custDict.add(customerNum, orderNum);
						customerNum++;
					} else {
						custLost++;
						outOfFood = false;
					}
				}
				hour++;
			}
			System.out.println("---------------  December " + (date % 100) + "   ---------------");
			System.out.println("Lost customer: " + custLost + "\n");

			checkExpiration();

			System.out.println("Buns wasted: " + foodLost.get(1));
			System.out.println("Patties wasted: " + foodLost.get(2));
			System.out.println("Lettuce wasted: " + foodLost.get(3));
			System.out.println("Tomatoes wasted: " + foodLost.get(4));
			System.out.println("Onions wasted: " + foodLost.get(5));
			System.out.println("Cheese wasted: " + foodLost.get(6) + "\n");

			System.out.println("#1's ordered: " + itemsOrdered.get(1));
			System.out.println("#2's ordered: " + itemsOrdered.get(2));
			System.out.println("#3's ordered: " + itemsOrdered.get(3));
			System.out.println("#4's ordered: " + itemsOrdered.get(4));
			System.out.println("#5's ordered: " + itemsOrdered.get(5));
			System.out.println("#6's ordered: " + itemsOrdered.get(6) + "\n");

			for (int i = 1; i <= custDict.getSize(); i++) {
				System.out.println("Customer " + i + " -> #" + custDict.getValue(i));
			}
			System.out.println("\n");
			date++;
		}
	}

	private static void checkExpiration() {
		boolean good = false;
		while (!bun.isEmpty() && good == false) {
			if (bun.peek() <= date) {
				bun.pop();
				foodLost.increment(1);
			} else
				good = true;
		}
		good = false;
		while (!patty.isEmpty() && good == false) {
			if (patty.peek() <= date) {
				patty.pop();
				foodLost.increment(2);
			} else
				good = true;
		}
		good = false;
		while (!lettuce.isEmpty() && good == false) {
			if (lettuce.peek() <= date) {
				lettuce.pop();
				foodLost.increment(3);
			} else
				good = true;
		}
		good = false;
		while (!tomato.isEmpty() && good == false) {
			if (tomato.peek() <= date) {
				tomato.pop();
				foodLost.increment(4);
			} else
				good = true;
		}
		good = false;
		while (!onion.isEmpty() && good == false) {
			if (onion.peek() <= date) {
				onion.pop();
				foodLost.increment(5);
			} else
				good = true;
		}
		good = false;
		while (!cheese.isEmpty() && good == false) {
			if (cheese.peek() <= date) {
				cheese.pop();
				foodLost.increment(6);
			} else
				good = true;
		}
	}

	private static void deliver() {
		StackLinked<Integer> tBun = new StackLinked<Integer>();
		StackLinked<Integer> tPatty = new StackLinked<Integer>();
		StackLinked<Integer> tLettuce = new StackLinked<Integer>();
		StackLinked<Integer> tTomato = new StackLinked<Integer>();
		StackLinked<Integer> tOnion = new StackLinked<Integer>();
		StackLinked<Integer> tCheese = new StackLinked<Integer>();

		// Move all current inventory to a new stack

		while (!bun.isEmpty()) {
			tBun.push(bun.pop());
		}
		while (!patty.isEmpty()) {
			tPatty.push(patty.pop());
		}
		while (!lettuce.isEmpty()) {
			tLettuce.push(lettuce.pop());
		}
		while (!tomato.isEmpty()) {
			tTomato.push(tomato.pop());
		}
		while (!onion.isEmpty()) {
			tOnion.push(onion.pop());
		}
		while (!cheese.isEmpty()) {
			tCheese.push(cheese.pop());
		}

		// add new, fresh inventory
		delivery = rnd.nextInt(4) + date + 3; // when the next delivery date will be.

		for (int i = 0; i < rnd.nextInt(300) + 700; i++) // adds between 700-1000 items of randomized food to the stacks
		{
			int ingredient = rnd.nextInt(6);

			switch (ingredient) {
			case 0:
				bun.push(date + 5);
				break;

			case 1:
				patty.push(date + 4);
				break;

			case 2:
				lettuce.push(date + 3);
				break;

			case 3:
				tomato.push(date + 3);
				break;

			case 4:
				onion.push(date + 5);
				break;

			case 5:
				cheese.push(date + 2);
				break;

			default:
				System.out.println("ERROR IN DELIVERY SWITCH STATEMENT!!!");
			}
		}

		// Move all the old inventory back to the stack while discarding the expired
		// food and incrementing the corresponding counter
		while (!tBun.isEmpty()) {
			if (tBun.peek() >= date)
				bun.push(tBun.pop());
			else
				foodLost.increment(1);
		}
		while (!tPatty.isEmpty()) {
			if (tPatty.peek() >= date)
				patty.push(tPatty.pop());
			else
				foodLost.increment(2);
		}
		while (!tLettuce.isEmpty()) {
			if (tLettuce.peek() >= date)
				lettuce.push(tLettuce.pop());
			else
				foodLost.increment(3);
		}
		while (!tTomato.isEmpty()) {
			if (tTomato.peek() >= date)
				tomato.push(tTomato.pop());
			else
				foodLost.increment(4);
		}
		while (!tOnion.isEmpty()) {
			if (tOnion.peek() >= date)
				onion.push(tOnion.pop());
			else
				foodLost.increment(5);
		}
		while (!tCheese.isEmpty()) {
			if (tCheese.peek() >= date)
				cheese.push(tCheese.pop());
			else
				foodLost.increment(6);
		}
	}

	private static void burger() {
		burger.add("bun");
		burger.add("patty");
		burger.add("lettuce");
		burger.add("tomato");
		burger.add("onion");
	}

	private static void cBurger() {
		cBurger.add("cheese");
		cBurger.add("bun");
		cBurger.add("patty");
		cBurger.add("lettuce");
		cBurger.add("tomato");
		cBurger.add("onion");
	}

	private static void vegan() {
		vegan.add("lettuce");
		vegan.add("lettuce");
		vegan.add("tomato");
		vegan.add("onion");
	}

	private static void burgerNO() {
		burgerNO.add("bun");
		burgerNO.add("patty");
		burgerNO.add("lettuce");
		burgerNO.add("tomato");
	}

	private static void cBurgerNO() {
		cBurgerNO.add("cheese");
		cBurgerNO.add("bun");
		cBurgerNO.add("patty");
		cBurgerNO.add("lettuce");
		cBurgerNO.add("tomato");
	}

	private static void burgerNT() {
		burgerNT.add("bun");
		burgerNT.add("patty");
		burgerNT.add("lettuce");
		burgerNT.add("onion");
	}

}
