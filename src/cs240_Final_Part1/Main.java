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
		
		while (date < 1231) //only runs till the end of December
		{
			hour = 10;
			while (hour <= 19) //only open from 1000 - 1900;
			{
				line = rnd.nextInt(101);
				if (line > 50)
				{
					custLost = line - 50;
					line = 50;
				}
				
				for (int i = 0; i < line; i++)
				{
						customers.enqueue(1 + rnd.nextInt(6));
				}
				
				
				
				hour ++;
			}
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
