/**
 * 
 */
package cs240_Final_Part1;

/**
 * @author bjhau
 *
 */
public interface ListInterface<T> {

	/**
	 * Adds a new entry to the end of this list. Entries currently in the list are
	 * unaffected. List's size increased by 1;
	 * 
	 * @param newEntry
	 *            The object to be added as a new entry.
	 */
	public void add(T newEntry);

	/**
	 * Adds a new entry at a specified position within this list. Entries originally
	 * at and above the specified position are at the next higher position within
	 * the list. The list's size is increased by 1.
	 * 
	 * @param newPosition
	 *            An integer that specifies the desired position of the new entry.
	 * @param newEntry
	 *            The object to be added as a new entry.
	 * @throws IndexOutOfBoundsException
	 *             if newPosition <0 or >length.
	 */
	public void add(int newPosition, T newEntry);

	/**
	 * Removes the entry at a given position from this list. Entries originally at
	 * positions higher than the given position are at the next lower position
	 * within the list. List's size increased by 1.
	 * 
	 * @param givenPosition
	 *            An integer that indicates the position of the entry to be removed.
	 * @return A reference to the removed entry. Null if error is encountered.
	 */
	public T remove(int givenPosition);

	/**
	 * Removes all entries from this list.
	 */
	public void clear();

	/**
	 * Replaces the entry at a given position from this list.
	 * 
	 * @param givenPosition
	 *            An integer that indicates the position of the entry to be
	 *            replaced.
	 * @param newEntry
	 *            The object that will replace the entry at the position
	 *            givenPosition.
	 * @return The original entry that was replaced. Null if error is encountered.
	 */
	public T replace(int givenPosition, T newEntry);

	/**
	 * Retrieves the entry at a given position in this list.
	 * 
	 * @param givenPosition
	 *            An integer that indicates the position of the desired entry.
	 * @return A reference to the indicated entry. Null if error is encountered.
	 */
	public T getEntry(int givenPosition);

	/**
	 * Retrieves all entries that are in this list in the order in which they occur
	 * in the list.
	 * 
	 * @return A newly allocated array of all the entries in the list. Null if list
	 *         is empty.
	 */
	public T[] toArray();

	/**
	 * Sees whether this list contains a given entry.
	 * 
	 * @param anEntry
	 *            The object that is the desired entry.
	 * @return True if the list contains anEntry. False otherwise.
	 */
	public boolean contains(T anEntry);

	/**
	 * Gets the length of this list.
	 * 
	 * @return The integer number of entries currently in the list.
	 */
	public int getLength();

	/**
	 * Sees whether this list is empty.
	 * 
	 * @return True if the list is empty. False otherwise.
	 */
	public boolean isEmpty();
}
