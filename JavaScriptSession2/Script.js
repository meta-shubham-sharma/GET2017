
function getResult(){
	var input = document.getElementById("string").value;
	var result=input;
	var index=0;
	document.getElementById("result").innerHTML = input;
	while(index < input.length-1){
		var string="";
		var count=index;
		while(input.charAt(index) == input.charAt(index+1)){
			index++;
		}
		if(index!=count)
		for(var jindex=count;jindex<=index;jindex++){
			string+=input.charAt(jindex);
		}
		if(string!=""){
		input=input.replace(string,"");
		document.getElementById("result").innerHTML += " -> " +input;
		index=0;
		}
		else{
			index++;
		}
	}
}