var doublylist = new DoublyLinkedList();

function Node(data){
	this.data = data;
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
	var data = document.getElementById("add").value;
	var node = new Node(data);
	var pattern = /^[A-Za-z0-9]+$/;
	if(data.match(pattern)) {
	if(this.head == null){
	this.head=node;
	document.getElementById("spanAdd").innerHTML = "Element added successfully";
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
		document.getElementById("spanAdd").innerHTML = "Element added succesfully";
	}	
	}
	else{
		document.getElementById("spanAdd").innerHTML = "Enter valid text to add";
	}
}

	this.deleteFromList = function (){
	var val = document.getElementById("delete").value;
	var pattern = /^[A-Za-z0-9]+$/;
	document.getElementById("delete").value="";
	var flag = true;
	this.temp=this.head;
	if(val.match(pattern)){	
	while(this.temp!= null){
		if(this.head.data == val){
			this.head = this.head.next;
			if(this.head)
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
		}
		this.temp=this.temp.next;
	}
	if(flag){
		document.getElementById("spanDelete").innerHTML = "Element is not present in the list";
	}
	else{
		document.getElementById("spanDelete").innerHTML = "Element is deleted from the list";
	}
	}
	else{
		document.getElementById("spanDelete").innerHTML = "Enter valid text to delete";
	}
}

	this.printList=function(){
	this.temp=this.head;
	document.getElementById("spanList").innerHTML="";
	if(!this.temp){
		document.getElementById("spanList").innerHTML ="List is empty"
	}
	else{
		while(this.temp!=null)
		{
			document.getElementById("spanList").innerHTML += this.temp.data + " ";
			this.temp = this.temp.next;
		}
	}
}

	this.searchFromList = function(){
	this.temp=this.head;
	var pattern = /^[A-Za-z0-9]+$/;
	var val = document.getElementById("search").value;
	document.getElementById("search").value="";
	var count=1,flag=true;
	if(val.match(pattern)){
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
	else{
		document.getElementById("spanSearch").innerHTML = "Enter valid text to search";
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
