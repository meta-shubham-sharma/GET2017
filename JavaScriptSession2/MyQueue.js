var obj = new Queues();

var Node = function(data){
	this.data=data;
	this.next=null;
}

function Queues(){
	this.first = null;
    var pattern = /^[A-Za-z0-9]+$/;
	
Queues.prototype.getQueue = function(){
	document.getElementById("queue").innerHTML = "";
	temp=this.first;
	if(!temp){
		document.getElementById("queue").innerHTML = "Queue is empty";
	}
	else{
		while(temp!=null){
				document.getElementById("queue").innerHTML += temp.data + " "; 
				temp=temp.next;
		}
	}
}

Queues.prototype.enqueue = function(){
	var input = document.getElementById("enq").value;
	if(input.match(pattern)){
	var node= new Node(input);
	document.getElementById("enq").value="";
	if(!this.first){
		this.first=node;
		document.getElementById("spanEnqueue").innerHTML = "Element added to queue";
	}
	else{
		var temp=this.first; 
		while(temp.next){
			temp=temp.next;
		}
		temp.next=node;
		document.getElementById("spanEnqueue").innerHTML = "Element added to queue";
	}
	}
	else{
		document.getElementById("spanEnqueue").innerHTML = "Enter valid text to enqueue";
	}
}

Queues.prototype.dequeue = function(){
	if(this.first){
		document.getElementById("spanDeque").innerHTML = this.first.data;
		this.first=this.first.next;
	}
	else{
		document.getElementById("spanDeque").innerHTML = "There are no elements in the queue";	
	}
}

}
function enqueueVal(){
	obj.enqueue();
}

function dequeueVal(){
	obj.dequeue();
}
function getQueueVal(){
	obj.getQueue();
}
