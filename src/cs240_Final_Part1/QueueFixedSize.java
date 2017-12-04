/**
 * 
 */
package cs240_Final_Part1;

/**
 * @author bjhau
 *
 */
public class QueueFixedSize<T> implements QueueInterface<T>{
	protected int front, back;
	protected static int defaultSize = 10;
	protected T queue[];
	
	public QueueFixedSize()
	{
		this(defaultSize);
	}
	
	public QueueFixedSize(int size) {
		@SuppressWarnings("unchecked")
		T temp[] = (T[])new Object[size];
		queue = temp;
		front = 0;
		back = 0;
	}
	
	/**
	 * Adds a new entry to the back of this queue.
	 * @param	newEntry	An Object to be added.
	 * @throws	ArrayIndexOutOfBoundsException	No room left in queue for new entry.
	 */
	@Override
	public void enqueue(T newEntry) {
		if (back < queue.length - 1)
		{
			if((back + 1) != front)	//if next index after current back is empty, then set next index to newEntry and back.
			{
				back++;
				queue[back] = newEntry;
			}
		}
		else if (front != 0)	//check if front is at the beginning of the array, if true, array full, if false, set [0] to newEntry and back.
		{
			back = 0;
			queue[back] = newEntry;
		}
		else	//array full. no room left in queue.
		{
			throw new ArrayIndexOutOfBoundsException();
		}
	}

	/**
	 * Removes and returns the entry at the front of this queue.
	 * @return	The object at the front of the queue.
	 * @throws	EmptyQueueException	if the queue is empty before the operation.
	 */
	@Override
	public T dequeue() throws EmptyQueueException {
		if(!isEmpty())
		{
		T next = queue[front];
		queue[front] = null;
		
		if (front < queue.length - 1)	//if front is not at the last index, set the next index to front.
		{
			front ++;
		}
		else	//if front is at the last index, set [0] to front.
		{
			front = 0;
		}
		return next;
		}
		else
		{
			throw new EmptyQueueException();
		}
	}

	/**
	 * Retrieves the entry at the front of this queue.
	 * @return	The object at the front of the queue.
	 * @throws	EmptyQueueException	if the queue is empty.
	 */
	@Override
	public T getFront() {
		return queue[front];
	}

	/**
	 * Detects whether this queue is empty.
	 * @return	True if the queue is empty, or false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (front == back)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}

	/**
	 * Removes all entries from this queue.
	 */
	@Override
	public void clear() {
		front = 0;
		back = 0;
		for (int i = 0; i < queue.length; i++)
		{
			queue[i] = null;
		}
	}

}

