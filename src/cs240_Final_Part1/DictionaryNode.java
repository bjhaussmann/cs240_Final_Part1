/**
 * 
 */
package cs240_Final_Part1;

/**
 * @author Ben
 *
 */
public class DictionaryNode <K, V> {
	private K key;
	private V value;
	private DictionaryNode <K, V> next;
	
	public DictionaryNode()
	{
		key = null;
		value = null;
		next = null;
	}
	
	public DictionaryNode(K key, V value)
	{
		this.key = key;
		this.value = value;
		next = null;
	}

	public void setNextNode(DictionaryNode <K, V> node)
	{
		next = node;
	}
	public DictionaryNode <K, V> getNextNode()
	{
		return next;
	}

	/**
	 * @return the key
	 */
	public K getKey() {
		return key;
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(K key) {
		this.key = key;
	}

	/**
	 * @return the value
	 */
	public V getValue() {
		return value;
	}

	/**
	 * @param value
	 *            the value to set
	 */
	public void setValue(V value) {
		this.value = value;
	}
}