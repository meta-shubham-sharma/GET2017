/*
 * class to implement tower of hanoi
 */
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class TowerOfHanoi {
	List<String> list = new ArrayList<String>();
	/**
	 * 
	 * @param source
	 * @param dest
	 * @param aux
	 * @param numOfDisk
	 */
	public List<String> towerOfHanoi(String source,String dest,String aux,int numOfDisk)
	{
		if(numOfDisk == 1)
		{
			list.add("Move disk " + numOfDisk + " from "+source+" to "+dest );
		}
		else
		{
			towerOfHanoi(source,aux,dest,numOfDisk-1);		// move n-1 disks to auxillary rod
			list.add("Move disk "+ numOfDisk + " from "+source+" to "+dest );  // move the nth disk to destination disk
			towerOfHanoi(aux,dest,source,numOfDisk-1);		// move n-1 disks to destination
		}
		return list;
	}
	public static void main(String args[])
	{
		TowerOfHanoi obj = new TowerOfHanoi();
		Scanner scan = new Scanner(System.in);
		String source = scan.next();
		String dest = scan.next();
		String aux = scan.next();
		int diskNum = scan.nextInt();
		List<String> result = obj.towerOfHanoi(source , dest, aux , diskNum);
		Iterator<String> itr = result.iterator();
		while(itr.hasNext())
		{
			System.out.println(itr.next());
		}
	}
}
