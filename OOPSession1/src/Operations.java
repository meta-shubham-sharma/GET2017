/*
 * perform the various operations 
 */
public class Operations {

	/**
	 * 
	 * @param firstNum
	 * @param secondNum
	 * @param operator
	 * @return result for further calculation if any
	 */
	public int evaluate(int firstNum, int secondNum, char operator)
	{
		switch(operator)
		{
			case '+':
				return firstNum + secondNum;
			case '-':
				return firstNum - secondNum;
			case '*':
				return firstNum * secondNum;
			case '/':
				return firstNum / secondNum;
			/*
			 *  other operators 
			 *  logarithmic 
			 *  percentage etc. 
			 *  other functionalities can be extended
			 */
			default:	
				return firstNum;
		}
	}
}
