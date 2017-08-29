package com.metacube.assignment1;

public class PriorityQueue <T extends Comparable<T>> {

	private Jobs[] heap; 
    private int heapSize, capacity;
 
    /** Constructor **/
    public PriorityQueue(int capacity)
    {    
        this.capacity = capacity + 1;
        heap = new Jobs[this.capacity];
        heapSize = 0;
    }
    /** function to clear **/
    public void clear()
    {
        heap = new Jobs[capacity];
        heapSize = 0;
    }
    /** function to check if empty **/
    public boolean isEmpty()
    {
        return heapSize == 0;
    }
    /** function to check if full **/
    public boolean isFull()
    {
        return heapSize == capacity - 1;
    }
    /** function to get Size **/
    public int size()
    {
        return heapSize;
    }
    /** function to insert task **/
    public void insert(String designation,String message, int priority)
    {
        Jobs newJob = new Jobs();
        newJob.setDesignation(designation);
        newJob.setMessage(message);
        newJob.setPriority(priority);
        
        heap[++heapSize] = newJob;
        int pos = heapSize;
        while (pos != 1 && (newJob.compareTo(heap[pos/2]) > 0) )
        {
            heap[pos] = heap[pos/2];
            pos /=2;
        }
        heap[pos] = newJob;    
    }
    /** function to remove task **/
    public Jobs remove()
    {
        int parent, child;
        Jobs item, temp;
        if (isEmpty() )
        {
            System.out.println("Heap is empty");
            return null;
        }
 
        item = heap[1];
        temp = heap[heapSize--];
 
        parent = 1;
        child = 2;
        while (child <= heapSize)
        {
            if (child < heapSize &&  (heap[child].compareTo(heap[child + 1]) < 0) )
                child++;
            if ( temp.compareTo(heap[child] ) >0 )
                break;
 
            heap[parent] = heap[child];
            parent = child;
            child *= 2;
        }
        heap[parent] = temp;
 
        return item;
    }
}
