package com.metacube.assignment1;

public class HeapSort<T extends Comparable<T>> {
	
	private static int length;
	/* Sort Function */
    public void sort(T[] jobQueue)
    {       
        heapify(jobQueue);        
        for (int index = length; index > 0; index--)
        {
            swap(jobQueue,0, index);
            length = length-1;
            minheap(jobQueue, 0);
        }
    }     
    /* Function to build a heap */   
    public void heapify(T[] jobQueue)
    {
        length = jobQueue.length-1;
        for (int index = length/2; index >= 0; index--)
            minheap(jobQueue, index);        
    }
    /* Function to swap largest element in heap */        
    public void minheap(T jobQueue[], int index)
    { 
        int left = 2*index ;
        int right = 2*index + 1;
        int min = index;
        if (left <= length &&  (jobQueue[left].compareTo(jobQueue[index]) < 0) )
            min = left;
        if (right <= length && (jobQueue[right].compareTo(jobQueue[min]) <= 0))        
            min = right;
 
        if (min != index)
        {
            swap(jobQueue, index, min);
            minheap(jobQueue, min);
        }
    }    
    /* Function to swap two numbers in an array */
    public void swap(T jobQueue[], int index, int jindex)
    {
        T temp = jobQueue[index];
        jobQueue[index] = jobQueue[jindex];
        jobQueue[jindex] = temp; 
    }    
}
