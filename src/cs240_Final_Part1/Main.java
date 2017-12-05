/**
 * 
 */
package cs240_Final_Part1;

import cs240_Final_Part1.ListLinked;
import cs240_Final_Part1.StackLinked;
import java.util.Random;

/**
 * @author bjhau
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int date = 1201;
		int hour = 0;
		int delivery = 0;
		int custLost = 0;
		int line = 0;
		int customerNum = 1;
		int orderNum = 0;
		/*
		 * 1. Bun
		 * 2. Patty
		 * 3. Lettuce
		 * 4. Tomato
		 * 5. Onion
		 * 6. Cheese
		 */
		Counter foodLost = new Counter();
		/*
		 * 1. Number One
		 * 2. Number Two
		 * 3. Number Three
		 * 4. Number Four
		 * 5. Number Five
		 * 6. Number Six
		 */
		Counter itemsOrdered = new Counter();
		
		Random rnd = new Random(System.currentTimeMillis());

		// Make all of the menu options
		ListLinked<String> burger = new ListLinked<String>();
		ListLinked<String> cBurger = new ListLinked<String>();
		ListLinked<String> vegan = new ListLinked<String>();
		ListLinked<String> burgerNO = new ListLinked<String>();
		ListLinked<String> cBurgerNO = new ListLinked<String>();
		ListLinked<String> burgerNT = new ListLinked<String>();

		// initialize all the menu options
		burger(burger);
		cBurger(cBurger);
		vegan(vegan);
		burgerNO(burgerNO);
		cBurgerNO(cBurgerNO);
		burgerNT(burgerNT);

		// make the stacks for all of the food. The saved integer is the expiration
		// date.
		StackLinked<Integer> bun = new StackLinked<Integer>();
		StackLinked<Integer> patty = new StackLinked<Integer>();
		StackLinked<Integer> lettuce = new StackLinked<Integer>();
		StackLinked<Integer> tomato = new StackLinked<Integer>();
		StackLinked<Integer> onion = new StackLinked<Integer>();
		StackLinked<Integer> cheese = new StackLinked<Integer>();

		delivery = rnd.nextInt(4) + date; // when the next delivery date will be.

		for (int i = 0; i < rnd.nextInt(300) + 700; i++) // adds between 700-1000 items of randomized food tot he stacks
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
		
		QueueFixedSize<Integer> customers = new QueueFixedSize<Integer>(50);
		
		while (date <= 1231) //only runs till the end of December
		{
			hour = 10;
			customerNum = 1;
			foodLost.clearAll();
			itemsOrdered.clearAll();
			
			while (hour <= 19) //only open from 1000 - 1900;
			{
				line = 1 + rnd.nextInt(100); // how many customers are showing up that hour ( 1-100)
				if (line > 50) // the queue can only hold 50 people, anyone over 50 is a walk away. adds the excess to the lost customer list and caps at 50.
				{
					custLost += line - 50;
					line = 50;
				}
				
				for (int i = 0; i < line; i++) //add customers and their order number to the queue
				{
						customers.enqueue(1 + rnd.nextInt(6));
				}
				
				while(!customers.isEmpty()) // empty the queue/customers ordering
				{
					try {
						orderNum = customers.dequeue();
					} catch (EmptyQueueException e) {
						e.printStackTrace();
					}
					itemsOrdered.increment(orderNum);
				}
				
				hour ++;
			}
			date++;
		}
	}

	private static void burger(ListLinked<String> burger) {
		burger.add("bun");
		burger.add("patty");
		burger.add("lettuce");
		burger.add("tomato");
		burger.add("onion");
	}

	private static void cBurger(ListLinked<String> cBurger) {
		cBurger.add("cheese");
		cBurger.add("bun");
		cBurger.add("patty");
		cBurger.add("lettuce");
		cBurger.add("tomato");
		cBurger.add("onion");
	}

	private static void vegan(ListLinked<String> vegan) {
		vegan.add("lettuce");
		vegan.add("lettuce");
		vegan.add("tomato");
		vegan.add("onion");
	}

	private static void burgerNO(ListLinked<String> burgerNO) {
		burgerNO.add("bun");
		burgerNO.add("patty");
		burgerNO.add("lettuce");
		burgerNO.add("tomato");
	}

	private static void cBurgerNO(ListLinked<String> cBurgerNO) {
		cBurgerNO.add("cheese");
		cBurgerNO.add("bun");
		cBurgerNO.add("patty");
		cBurgerNO.add("lettuce");
		cBurgerNO.add("tomato");
	}

	private static void burgerNT(ListLinked<String> burgerNT) {
		burgerNT.add("bun");
		burgerNT.add("patty");
		burgerNT.add("lettuce");
		burgerNT.add("onion");
	}

}
