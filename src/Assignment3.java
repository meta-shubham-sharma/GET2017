/*
 * longest increasing sequence detected 
 * @author Shubham  
 */

public class Assignment3 {
	public int[] longestSequence(int a[]){		
		
		int maxNow=0,start1=0,end=0,maxPre=0,start2=0,i=0,k=0;
		
		for(i=0;i<a.length-1;i++){
			
			if(a[i]<a[i+1]){
				
				maxNow++;    ///// maximum length of current sequence
				
			}
			else{
				if(maxNow<maxPre){
					
				    start2=i+1;
				}
				else{
					start1=start2;
					maxPre=maxNow;     ///// comparison with the length of previous sequence
					end=i;
					start2=i+1;
				}
				
			
			maxNow=0;	
			}
		
		}
			if(maxNow<maxPre){
					
				    start2=i+1;
				}
				else{
					start1=start2;
					maxPre=maxNow;				
					end=i;
					start2=i+1;
				}
		int b[]=new int[end-start1+1];
		
		for(int j=start1;j<=end;j++){
			
			b[k++]=a[j];
		
		}
				return b;
}
}
