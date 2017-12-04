/**
 * 
 */
package cs240_Final_Part1;

/**
 * @author bjhau
 *
 */
public class Node<T> {
	private Node<T> frontLink;
	private Node<T> backLink;
	private T data;

	public Node(Node<T> fAddress, T data) {
		this.frontLink = fAddress;
		this.data = data;
	}

	public Node(Node<T> fAddress, T data, Node<T> bAddress) {
		this.frontLink = fAddress;
		this.data = data;
		this.backLink = bAddress;
	}

	public T getData() {
		return data;
	}

	public Node<T> getFLink() {
		return frontLink;
	}

	public Node<T> getLink() {
		return frontLink;
	}

	public Node<T> getBLink() {
		return backLink;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setLink(Node<T> FAddress) {
		this.frontLink = FAddress;
	}

	public void setFLink(Node<T> FAddress) {
		this.frontLink = FAddress;
	}

	public void setBLink(Node<T> BAddress) {
		this.backLink = BAddress;
	}
}

