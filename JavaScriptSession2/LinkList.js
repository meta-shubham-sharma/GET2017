//var data,next=null,head=null,temp;

var singlylist = new SinglyLinkList();

function Node(){
	this.data = document.getElementById("add").value;
	document.getElementById("add").value = "";
	this.next=null;
}

 function SinglyLinkList(){
	 this.head=null;
	 this.next=null;
	 var temp,data;

this.addToList= function(){
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
		this.temp.next=node; 
	}	
}

this.deleteFromList = function(){
	this.temp=this.head;
	pre=this.head;
	var val = document.getElementById("delete").value;
	document.getElementById("delete").value="";
	while(this.temp!= null){
		if(this.head.data == val){
			this.head = this.head.next;
			console.log("value deleted");
			break;
		}
		else
		{
			if(this.temp.data == val){
			pre.next = this.temp.next;
			break;
			}
			var pre=this.temp;
			this.temp=this.temp.next;
		}
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

function addVal(){
	singlylist.addToList();
}

function deleteVal(){
	singlylist.deleteFromList();
}

function printVal(){
	singlylist.printList();
}

function searchVal(){
	singlylist.searchFromList();
}