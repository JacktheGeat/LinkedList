package LinkedList;

/**
 *  An abstract array type that uses nodes to store data.
 * @author Jack Lynch
 * @version 2/13/2024
 */
public class LinkedList<T>
{
    private int length;
    private ListNode<T> firstNode;

    /**
     * default constructor
     */
    public LinkedList()
    {
        length=0;
        firstNode=null;
    }

    /**
     * return number of items in list
     * @return number of items (nodes) in the list
     */
    public int getLength()
    {
        return length;
    }

    /**
     * tells if this linked list is empty or not
     * @return true if this list has no nodes; else false
     */
    public boolean isEmpty() {
        return getLength()==0;
    }

    /**
     * inserts given string at the start of the list
     * @param data string to insert
     */
    public void insertAtHead(T data)
    {
    	ListNode<T> newnode = new ListNode<>(data);
        newnode.next=firstNode;
        firstNode=newnode;
        length++;
    }

    /**
     * inserts given string at the end of the list
     * @param data string to insert
     */
    public void insertAtTail(T data)
    {
    	ListNode<T> newnode = new ListNode<>(data);
        if (firstNode == null) firstNode = newnode;
        else {
            ListNode<T> runner = firstNode;
            while (runner.next != null) runner = runner.next;
            runner.next=newnode;
        }
        length++;
    }

    /**
     * inserts given string at a specified index of the list
     * @param index the index of where to insert. will insert at tail if too big.
     * @param data string to insert
     */
    public void insertAtIndex(int index, T data)
    {
        if (index < 0) throw new IllegalArgumentException("Index is negative: " + index);

    	ListNode<T> newnode = new ListNode<>(data);

        if (firstNode == null || index == 0) insertAtHead(data); 
        else{
            ListNode<T> runner = firstNode;
            int i = 0;
            while (runner.next != null && i < index-1) {
                runner = runner.next;
                i++;
            }
            ListNode<T> temp = runner.next;
            runner.next = newnode;
            newnode.next = temp;
        }
        length++;
    }

    /**
     * Removes the ListNode at specified index in the LinkedList.
     * @param index the index of the ListNode to be removed.
     * @return the string of the ListNode that was removed
     */
    public String removeAtIndex(int index){
        if (index < 0) throw new IllegalArgumentException("Index is negative: " + index);
        else if (index >= length) throw new IllegalArgumentException("Index is greater than list length: " + index);
        else if (length<=0) throw new IllegalArgumentException("Can't remove from an empty list!");
        String returnString;
        if (index == 0) {
            returnString = firstNode.toString();
            firstNode = firstNode.next;
        }
        else{
            ListNode<T> runner = firstNode;
            for (int i = 0; i<index-1; i++){
                runner = runner.next;
            }
            returnString = runner.next.toString();
            runner.next = runner.next.next;
        }
        return returnString;
    }

    /**
     * Removes the first Node from the LinkedList
     * @return the string value of the node
     */
    public String removeAtHead(){
        if (length<=0) throw new IllegalArgumentException("Can't remove from an empty list!");
        length--;
        return removeAtIndex(0);
    }

    /**
     * Removes the last Node from the LinkedList
     * @return the string value of the node
     */
    public String removeAtTail(){
        if (length<=0) throw new IllegalArgumentException("Can't remove from an empty list!");
        length--;
        return removeAtIndex(length);
    }

    /**
     * 
     * @param index
     * @return
     */
    public String getData(int index){
        if (index >= length) throw new IllegalArgumentException("Index is greater than the list length: " + index);
        else if (index < 0) throw new IllegalArgumentException("Index is negative: " + index);
        ListNode<T> runner =firstNode;
        for (int i = 0; i < index; i++){
            runner = runner.next;
        }
        return runner.toString();
    }

    /**
     * 
     * @param other
     * @return
     */
    public boolean equals(LinkedList<T> other){

        if (this.getLength() != other.getLength()) return false;
        System.out.println("lengths");
        ListNode<T> thisRunner = this.firstNode;
        ListNode<T> otherRunner = other.firstNode;
        for (int i = 0; i < this.getLength(); i++){
            System.out.println("thisRunner: " + thisRunner);
            System.out.println("otherRunner: " + otherRunner);
            if (!thisRunner.data.equals(otherRunner.data)) return false;
            thisRunner = thisRunner.next;
            otherRunner = otherRunner.next;
        }
        return true;

    }

    /**
     * returns printable version of this list
     * @return string version of the list
     */
	public String toString(){ 
		String toReturn = "(";
		ListNode<T> runner = firstNode;
		while(runner != null){
			toReturn += runner.toString();
			runner = runner.next;
			if(runner != null){
				toReturn = toReturn + ", ";
			}
		}
		toReturn = toReturn + ")";
		return toReturn;
	}

}


