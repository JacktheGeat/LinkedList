package LinkedList;

/**
 * individual Node used by LinkedList 
 * @author Jack Lynch
 * @version 2/13/2024
 */

public class ListNode<T>
{
    public T data;
    public ListNode<T> next;

    public ListNode(T newData) {
        data = newData;
        next = null;
    }
    
    public String toString(){
    	return data.toString();
    }

    /**
     * Sets the Data.
     * @param newData new Data to be set
     */
    public void setData(T newData){
    	data = newData;
    }

    /**
     * gets the Data (same as toString)
     * @return the String stored.
     */
    public String getData(){
    	return toString();
    }

    public void setNext(ListNode<T> newNext){
    	next = newNext;
    }

    public boolean equals(ListNode<T> other){
        if (this.data.equals(other.data)) return true;
        else return false;
    }

}
