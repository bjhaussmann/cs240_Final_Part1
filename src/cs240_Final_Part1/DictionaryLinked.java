/**
 * 
 */
package cs240_Final_Part1;

import java.util.Iterator;

/**
 * @author Ben
 *
 */
public class DictionaryLinked<K extends Comparable<? super K>, V> implements DictionaryInterface<K, V> {

	private DictionaryNode<K, V> firstNode;
	private int numberOfEntries;
	private int counter;

	public DictionaryLinked() {
		firstNode = null;
		numberOfEntries = 0;
		counter = 0;
	}

	@Override
	public V add(K key, V value) {
		V result = null;

		DictionaryNode<K, V> currentNode = firstNode;
		DictionaryNode<K, V> nodeBefore = null;

		while ((currentNode != null) && key.compareTo(currentNode.getKey()) > 0) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}

		if ((currentNode != null) && key.equals(currentNode.getKey())) {
			result = currentNode.getValue();
			currentNode.setValue(value);
		} else {
			DictionaryNode<K, V> newNode = new DictionaryNode<K, V>(key, value);
			if (nodeBefore == null) {
				newNode.setNextNode(firstNode);
				firstNode = newNode;
			} else {
				newNode.setNextNode(currentNode);
				nodeBefore.setNextNode(newNode);
			}
			numberOfEntries++;
		}
		counter ++;
		return result;
	}

	@Override
	public V remove(K key) {
		V result = null;
		DictionaryNode<K, V> currentNode = firstNode;
		DictionaryNode<K, V> nodeBefore = null;

		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			nodeBefore = currentNode;
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			return null;
		} else {
			result = currentNode.getValue();
			nodeBefore.setNextNode(currentNode.getNextNode());
			currentNode.setKey(null);
			currentNode.setValue(null);
			currentNode.setNextNode(null);
			counter--;
		}
		return result;
	}

	@Override
	public V getValue(K key) {
		DictionaryNode<K, V> currentNode = firstNode;

		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			return null;
		} else {
			return currentNode.getValue();
		}
	}

	@Override
	public boolean contains(K key) {
		DictionaryNode<K, V> currentNode = firstNode;

		while ((currentNode != null) && !key.equals(currentNode.getKey())) {
			currentNode = currentNode.getNextNode();
		}
		if (currentNode == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Iterator<K> getKeyIterator() {
		Iterator <K> keyIt = new Iterator <K>()
				{
					private DictionaryNode <K,V> currentKNode = firstNode;
					@Override
					public boolean hasNext() {
						if (currentKNode.getNextNode() != null)
						{
							return true;
						}
						else
						{
							return false;
						}
					}

					@Override
					public K next() {
						return currentKNode.getNextNode().getKey();
					}
				};
		return keyIt;
	}

	@Override
	public Iterator<V> getValueIterator() {
		Iterator <V> valueIt = new Iterator <V>()
				{
					private DictionaryNode <K,V> currentVNode = new DictionaryNode <K, V>();
					
					@Override
					public boolean hasNext() {
						if (currentVNode.getNextNode() != null)
						{
							return true;
						}
						else
						{
							return false;
						}
					}

					@Override
					public V next() {
						return currentVNode.getNextNode().getValue();
					}
			
				};
		return valueIt;
	}

	@Override
	public boolean isEmpty() {
		if (firstNode.getNextNode() == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getSize() {
		return counter;
	}

	@Override
	public void clear() {
		DictionaryNode<K, V> currentNode = firstNode.getNextNode();
		DictionaryNode <K,V> beforeNode = firstNode;

		while (currentNode != null) {
			beforeNode.setNextNode(null);
			currentNode.setKey(null);
			currentNode.setValue(null);
			beforeNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		counter = 0;
	}

}
