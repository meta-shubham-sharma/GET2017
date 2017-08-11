var sum=function(a){
	if(arguments.length == 2){
		document.getElementById("sum").innerHTML = arguments[0] + arguments[1];
	}
	else if(arguments.length ==1)
	{return function(b){
		document.getElementById("sum2").innerHTML = a+b;
		}
	}
}

