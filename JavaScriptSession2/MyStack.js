function Node(data){
	this.data = data;
	this.prev=null;
}

var stack = new MyStack();

 function MyStack(){
		this.top=null;
		var temp,data;
		var pattern = /^[A-Za-z0-9]+$/;
	
	MyStack.prototype.pushItem = function(){
		data = document.getElementById("push").value;
		document.getElementById("push").value = "";
		if(data.match(pattern)){
		var node = new Node(data);
		node.prev = this.top;
		this.top=node;
		document.getElementById("spanPush").innerHTML = "Element pushed to stack";
		}
		else{
			document.getElementById("spanPush").innerHTML = "Enter valid text to push";
		}
	}	
	
	MyStack.prototype.popItem = function(){
		document.getElementById("spanPop").innerHTML = "";
		if(this.top){
			document.getElementById("spanPop").innerHTML = this.top.data;
			this.top=this.top.prev;
		}
		else{
			document.getElementById("spanPop").innerHTML = "There are no elements in stack";
		}
	}
 
	MyStack.prototype.printStack = function(){
		temp = this.top;
		document.getElementById("spanStack").innerHTML="";
		if(!temp){
			document.getElementById("spanStack").innerHTML = "Stack is empty"
		}
		else{
			while(temp!=null){
				document.getElementById("spanStack").innerHTML += temp.data + " ";
				temp=temp.prev;
			}
		}
	}
 }
 
 function pushVal(){
	stack.pushItem();
 }
 
 function popVal(){
	stack.popItem();
 }
 
 function printVal(){
	stack.printStack();
 }
