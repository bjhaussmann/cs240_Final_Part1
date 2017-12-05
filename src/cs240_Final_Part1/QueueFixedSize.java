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
		front = -1;
		back = 0;
	}
	
	/**
	 * Adds a new entry to the back of this queue.
	 * @param	newEntry	An Object to be added.
	 * @throws	ArrayIndexOutOfBoundsException	No room left in queue for new entry.
	 */
	@Override
	public void enqueue(T newEntry) {
		if (front < queue.length)
		{
			front ++;
			queue[front] = newEntry;
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
			front --;
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
	public T getFront() throws EmptyQueueException {
		if (!isEmpty())
			return queue[front];
		else
			throw new EmptyQueueException();
	}

	/**
	 * Detects whether this queue is empty.
	 * @return	True if the queue is empty, or false otherwise.
	 */
	@Override
	public boolean isEmpty() {
		if (front == -1)
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
		front = -1;
		for (int i = 0; i < queue.length; i++)
		{
			queue[i] = null;
		}
	}

}

