var arr = [];
var topVal=-1;
function pushItem(){
	var input = document.getElementById("push").value;
	document.getElementById("push").value="";
	arr[++topVal] = input;
	console.log(arr[topVal] + " " + topVal);
}

function popItem(){
	document.getElementById("spanPop").innerHTML = arr[topVal--];
	console.log(topVal);
}

function printStack(){
	document.getElementById("spanStack").innerHTML="";
	for(var index=0;index <= topVal ; index++){
		document.getElementById("spanStack").innerHTML += arr[index] + " ";
	}
}
