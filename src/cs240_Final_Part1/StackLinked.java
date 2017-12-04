/**
 * 
 */
package cs240_Final_Part1;

import java.util.EmptyStackException;

/**
 * @author bjhau
 *
 */
public class StackLinked<T> implements StackInterface<T> {

	protected Node<T> head;	//first node
	
	public StackLinked ()
	{
		head = null;
	}
	
	/**
	 * Adds a new entry to the top of this stack.
	 * @param newEntry  An object to be added to the stack.
	 */
	@Override
	public void push(T newEntry) {
		head = new Node<T>(head, newEntry);
	}

	/**
	 * Removes and returns this stack's top entry.
	 * @return  The object at the top of the stack.
	 * @throws  EmptyStackException if the stack is empty before the operation.
	 */
	@Override
	public T pop() {
		T currentTop;
		
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		{
			currentTop = peek();
			head = head.getLink();
		}
		return currentTop;
	}

	/**
	 * Retrieves this stack's top entry.
	 * @return  The object at the top of the stack.
	 * @throws  EmptyStackException if the stack is empty.
	 */
	@Override
	public T peek() {
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		else
		return head.getData();
	}

	/**
	 * Detects whether this stack is empty.
	 * @return  True if the stack is empty.
	 */
	@Override
	public boolean isEmpty() {
		if( head == null)	//If head is set to null, there are no other nodes and stack is empty.
		{
			return true;
		}
		else return false;
	}

	/**
	 * Removes all entries from this stack.
	 */
	@Override
	public void clear() {
		head = null;	//set head address null and unlink rest of nodes.
	}

}
