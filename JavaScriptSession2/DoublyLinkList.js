var doublylist = new DoublyLinkedList();

function Node(){
	this.data = document.getElementById("add").value;
	document.getElementById("add").value = "";
	this.prev=null;
	this.next=null;
}

	function DoublyLinkedList(){
	this.head=null;
	this.prev=null;
	this.next=null;
	var data,temp;

	this.addToList = function(){
	var node = new Node();
	if(this.head == null){
	this.head=node;
	}
	else
	{
		this.temp=this.head;
		while(this.temp.next!=null)
		{
			this.temp=this.temp.next;
		}
		node.prev=this.temp;
		this.temp.next=node;
	}	
}

	this.deleteFromList = function (){
	var val = document.getElementById("delete").value;
	document.getElementById("delete").value="";
	var flag = true;
	this.temp=this.head;
	while(this.temp!= null){
		if(this.head.data == val){
			this.head = this.head.next;
			this.head.prev=null;
			flag = false;
			break;
		}
		else
		{
			if(this.temp.data == val){
				this.temp.prev.next=this.temp.next;
				if(this.temp.next!=null)
				this.temp.next.prev=this.temp.prev;
				flag = false;
				break;
			}
			this.temp=this.temp.next;
		}
	}
	if(flag){
		document.getElementById("spanDelete").innerHTML = "Element is not present in the list";
	}
	else{
		document.getElementById("spanDelete").innerHTML = "Element is deleted from the list";
	}
}

	this.printList=function(){
	this.temp=this.head;
	document.getElementById("spanList").innerHTML="";
	while(this.temp!=null)
	{
		document.getElementById("spanList").innerHTML += this.temp.data + " ";
		this.temp = this.temp.next;
	}
}

	this.searchFromList = function(){
	this.temp=this.head;
	var val = document.getElementById("search").value;
	document.getElementById("search").value="";
	var count=1,flag=true;
	while(this.temp!=null){
		if(this.temp.data == val){
			document.getElementById("spanSearch").innerHTML = "Element is present at index " + count; 
			flag=false;
			break;
		}
		count++;
		this.temp = this.temp.next;
	}
	if(flag){
		document.getElementById("spanSearch").innerHTML = "Element is not present in the list";
	}
}
}


function deleteVal(){
	doublylist.deleteFromList();
}

function addVal(){
	doublylist.addToList();
}

function printVal(){
	doublylist.printList();
}

function searchVal(){
	doublylist.searchFromList();
}
