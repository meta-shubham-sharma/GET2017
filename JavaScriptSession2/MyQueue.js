var arr= [];
var rear=-1;
var front=0;
function getQueue(){
	document.getElementById("queue").innerHTML = "";
		for(var index = front;index <= rear;index++){
			document.getElementById("queue").innerHTML += arr[index] + " "; 
		}
}

function enqueue(){
	var input = document.getElementById("enq").value;
	document.getElementById("enq").value="";
	arr[++rear]=input;
	console.log(arr[rear]);
}

function dequeue(){
	document.getElementById("spanDeque").innerHTML = arr[front++];
}
