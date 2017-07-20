import org.junit.Assert;
import org.junit.Test;


public class TestMatrix {

	// this test will check the multiplication of two square matrices 
	@Test
	public void testMultiply() {
		Matrix object = new Matrix(3,3);
		int k=0;
		for(int index = 0;index < 3;index++ )
		{
			for(int jindex = 0;jindex < 3;jindex++ )
			{
				object.addElements(index,jindex,++k);
			}
		}
		Matrix obj = new Matrix(3,3);k=0;
		for(int index = 0;index < 3;index++ )
		{
			for(int jindex = 0;jindex < 3;jindex++ )
			{
				obj.addElements(index,jindex,++k);
			}
		}
		Matrix result = object.multiply(obj);
		int expected[][] = { {30,36,42} , {66,81,96} , {102,126,150} };
		Assert.assertArrayEquals(expected,result.matrix);
	}

	// this test will check multiplication of two matrices with different rows and columns 
	@Test
	public void testMultiply2() {
		Matrix object = new Matrix(3,3);
		int k=0;
		for(int index = 0;index < 3;index++ )
		{
			for(int jindex = 0;jindex < 3;jindex++ )
			{
				object.addElements(index,jindex,++k);
			}
		}
		Matrix obj = new Matrix(2,3);
		k=0;
		for(int index = 0;index < 2;index++ )
		{
			for(int jindex = 0;jindex < 3;jindex++ )
			{
				obj.addElements(index,jindex,++k);
			}
		}
		Matrix result = object.multiply(obj);
		int expected[][] = { {0,0,0} , {0,0,0} , {0,0,0} };
		Assert.assertArrayEquals(expected, result.matrix);
	}
	
	// this test will check the transpose of a matrix
	@Test
	public void testTranspose() {
		Matrix object = new Matrix(2,3);
		int k = 0;
		for(int index = 0;index < 2;index++ )
		{
			for(int jindex = 0;jindex < 3;jindex++ )
			{
				object.addElements(index,jindex,++k);
			}
		}
		Matrix obj = object.transpose();
		int expected[][] = {{1,4}, {2,5},{3,6} };
		Assert.assertArrayEquals(expected,obj.matrix);
	}
}
