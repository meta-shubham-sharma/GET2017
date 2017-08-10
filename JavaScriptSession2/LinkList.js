var singlylist = new SinglyLinkList();

function Node(data){
	this.data = data;
	document.getElementById("add").value = "";
	this.next=null;
}

 function SinglyLinkList(){
	 this.head=null;
	 this.next=null;
	 var temp,data;

this.addToList= function(){
	var data =document.getElementById("add").value;
	var pattern = /^[A-Za-z0-9]+$/;
	if(data.match(pattern)) {
		var node = new Node(data);
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
			this.temp.next=node; 
			document.getElementById("spanAdd").innerHTML = "Element added successfully";
		}
	}	
	else{
		document.getElementById("spanAdd").innerHTML = "Enter valid text to add";
	}
}

this.deleteFromList = function(){
	this.temp=this.head;
	pre=this.head;
	var pattern = /^[A-Za-z0-9]+$/;
	var flag=true;
	var val = document.getElementById("delete").value;
	document.getElementById("delete").value="";
	if(val.match(pattern)){
		while(this.temp!= null){
			if(this.head.data == val){
				this.head = this.head.next;
				flag=false;
				break;
			}
			else
			{
				if(this.temp.data == val){
				pre.next = this.temp.next;
				flag=false;
				break;
				}
				var pre=this.temp;
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
	if(val==""){
		document.getElementById("spanSearch").innerHTML = "Enter an element to search";
	}
	else if(flag){
		document.getElementById("spanSearch").innerHTML = "Element is not present in the list";
	}
	}
	else{
		document.getElementById("spanSearch").innerHTML = "Element valid text to search";
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
