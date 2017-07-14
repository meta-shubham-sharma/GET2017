/*
 *  remove duplicate elements
 *  @author Shubham
 */
public class Assignment2 {
	
		int[] removeDuplicate(int input[])
		{
	
			int end=input.length;    
			for(int i=0;i<end;i++){
				for(int j=i+1;j<end;j++){
					if(input[i]==input[j]){
						int shl =j;                // shl is used for shifting left
						for(int k=j+1;k<end;k++){
							input[shl++]=input[k];       
						}
						end--;
						j--;
					}
					
				}
			}
			
			int result[]=new int[end];
			for(int i = 0; i < end; i++){
		        result[i] = input[i];
		    }
		    return result;
		
			
		}
}


