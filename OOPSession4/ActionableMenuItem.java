/**
 * trigger the operation of the class that implements Action interface 
 * @author Shubham
 *
 */
public class ActionableMenuItem extends MenuItem{
	
	Action action;

	/**
	 * trigger an action
	 */
	public void triggerAction(){
		this.action.performAction();
	}

	public ActionableMenuItem(Action action) {
		
		this.action = action;
	}


}
