import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;


public class TestAssignment4 {

	
	@Test
	public void testOnSampleInput() {
		int arival_time[] = {1, 5, 9, 25};
		int job_size[] = {12,7,2,5};
		int expected[][] = { {1,1,0,1,12},{2,5,8,13,19},{3,9,11,20,21},{4,25,0,25,29} };
		Assignment4 a4=new Assignment4();
		int actual[][] = a4.implemetFcfs(arival_time, job_size);
		Assert.assertArrayEquals(expected, actual);
	}
	
	@Test
	public void testOnOtherInput() {
		int arival_time[] = {0,1,2};
		int job_size[] = {3,2,1};
		int expected[][] = { {1,0,0,0,3},{2,1,3,4,5},{3,2,4,6,6}};
		Assignment4 a4=new Assignment4();
		int actual[][] = a4.implemetFcfs(arival_time, job_size);
		Assert.assertArrayEquals(expected, actual);
	}

}
