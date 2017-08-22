package com.metacube.arrayList;

import java.util.Scanner;

import com.metacube.copyLists.JoinArrayLists;

/**
 * @author shubham
 *
 */
public class Main {
	/**
	 * @param args
	 */
	@SuppressWarnings("unchecked")
	public static <E> void main(String[] args) {
		MyArrayList<E> arrayList = new MyArrayList<E>();
		do{
		System.out.println("\n1. Add item to ArrayList");
		System.out.println("2. Add item to ArrayList at a location");
		System.out.println("3. Get item from ArrayList");
		System.out.println("4. Remove item from ArrayList");
		System.out.println("5. Remove item from ArrayList by location");
		System.out.println("6. Clear ArrayList");
		System.out.println("7. Reverse ArrayList");
		System.out.println("8. Sort ArrayList");
		System.out.println("9. Print ArrayList");
		System.out.println("10. Join two ArrayList");
		System.out.println("11. Exit\n");
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter your choice");
		int val = scan.nextInt();
		switch(val){
		case 1:
			System.out.println("Enter element you want to add");
			E element = (E)scan.next();
			arrayList.addElement(element);
			break;
		case 2:
			System.out.println("Enter location where you want to add the element");
			int location = scan.nextInt();
			System.out.println("Enter element you want to add");
			element = (E)scan.next();
			if(arrayList.setElement(location-1 , element)){
				System.out.println("Element is added to the ArrayList");
			}
			else{
				System.out.println("Invalid Location !!");
			}
			break;
		case 3:
			System.out.println("Enter element you want to get");
			element = (E)scan.next(); 
			int position = arrayList.getElement(element);
			if(position == -1){
				System.out.println("Element is not present in the ArrayList");
			}
			else{
			System.out.println("Element is at position : "+position);
			}
			break;
		case 4:
			System.out.println("Enter element you want to remove");
			element = (E)scan.next();
			if(arrayList.removeElement(element)){
				System.out.println("Element is removed from the ArrayList");
			}
			else{
				System.out.println("Element is not present in the ArrayList");
			}
			break;
		case 5:	
			System.out.println("Enter location of the element you want to remove");
			location = scan.nextInt();
			if(arrayList.removeElementFromPosition(location-1)){
				System.out.println("Element is removed from the ArrayList");
			}
			else{
				System.out.println("Element is not present in the ArrayList");
			}
			break;
		case 6:
			arrayList.clearArrayList();
			break;
		case 7:
			arrayList.reverseArrayList();
			Object result[] = arrayList.printArrayList();
			if(result[0]==null){
				System.out.println("ArrayList is empty");
			}
			for(int index =0;index< result.length ;index++){
				if(result[index] != null){
				System.out.print(result[index] + " ");
				}
				else{
					break;
				}
			}
			break;
		case 8:
			arrayList.sortArrayList();
			result= arrayList.printArrayList();
			if(result[0]==null){
				System.out.println("ArrayList is empty");
			}
			for(int index =0;index< result.length ;index++){
				if(result[index] != null){
				System.out.print(result[index] + " ");
				}
				else{
					break;
				}
			}
			break;
		case 9:
			result= arrayList.printArrayList();
			if(result[0]==null){
				System.out.println("ArrayList is empty");
			}
			for(int index =0;index< result.length ;index++){
				if(result[index] != null){
				System.out.print(result[index] + " ");
				}
				else{
					break;
				}
			}
			break;
		case 10:
			JoinArrayLists<E> joinList = new JoinArrayLists<E>();
			MyArrayList<E> arrayList2 = new MyArrayList<E>();
			System.out.println("Enter number of elements you want to add to this new list");
			int num = scan.nextInt();
			for(int index = 0 ; index < num;index++)
			{
				System.out.println("Enter element you want to add");
				element = (E)scan.next();
				arrayList2.addElement(element);
			}
			joinList.joinTwoArrayList(arrayList, arrayList2);
			break;
		case 11:
			scan.close();
			System.exit(0);
			break;
		}
		}while(true);
	}
}
 
