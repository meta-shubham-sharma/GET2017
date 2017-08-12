function toHome(){
	window.location.href="Assignment1.html";
}

function toContact(){
	window.location.href="Assignment2.html";
}

function removeLoc(){
	localStorage.clear();
}


function validateForm(){
	if(validateName() && validateEmail() && validateCity() && validateOrganization() && validateNumber() && validateMessage())
	{
		document.form.name.value="";
		document.form.email.value="";
		document.form.organization.value="";
		document.form.city.value="";
		document.getElementById("val").hidden = true;
		document.form.msg.value="";
		document.form.num.value="";
		return true;	
	}
	return false;
}

function validateName()
{
	var name = document.form.name;
	var len = name.value.length;
	var letters1 = /^[A-Za-z]+ +[A-Za-z]+$/;
	var letters2 = /^[A-Za-z]+$/;
	var letters3 = /^[A-Za-z]+ +[A-Za-z]+ +[A-Za-z]+$/;

	if( ( name.value.match(letters1) || name.value.match(letters2) || name.value.match(letters3) )  && len >1  && len<=20 ){
		localStorage.setItem("key1",name.value);
		return true;
	}	
	else
	{
		name.value="";
		name.style.outlineColor="red";
		alert("Name should have 1 to 20 charachters");
		name.focus();
		return false;
	}
}

function validateEmail()
{
	var email= document.form.email;
	var mailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/;  
	
	if(email.value.match(mailformat) )
	{
		localStorage.setItem("key2",email.value);
		return true;
	}
	else
	{
		email.value="";
		email.style.outlineColor="red";
		alert("Enter a valid email address");
		email.focus();
		return false;
	}
}

function validateOrganization()
{
	var organization = document.form.organization;
	var letters = /^[A-Za-z]+$/;
	if(organization.value.match(letters)){
		localStorage.setItem("key4",organization.value);
		return true;
	}	
	else{
		organization.value="";
		organization.style.outlineColor="red";
		alert("Organization name should have only charachters");
		organization.focus();
		return false;
	}
}

function validateNumber()
{
	var num = document.form.num;
	var numbers = /^[0-9]+$/;  
	var len = num.value.length;

	if(num.value.match(numbers) && len==10 )
	{
		localStorage.setItem("key5",num.value);
		return true;
	}
	else
	{
		num.value="";
		num.style.outlineColor="red";
		alert("Enter a valid number of 10 digits for contact numbers");
		num.focus();
		return false;
	}
}

function validateMessage()
{
	var msg = document.form.msg;

	if(msg.value.length > 250 || msg.value.length == 0)
	{
		msg.value="";
		msg.style.outlineColor="red";
		alert("Enter 1 to 250 charachters for message");
		msg.focus();
		return false;
	}
	localStorage.setItem("key6",msg.value);
	return true;
}

function validateCity()
{
	var city = document.form.city;
	localStorage.setItem("key3",city.value);
	if(city.value ==  "")
	{
		alert("Select a city from drop down list");
		return false;
	}
	fillField(city);
	return true;
}

function fillField(city)
{
	var name = city.value;
	document.form.cityname.hidden = false;   
	document.form.cityname.value = "Selected city is :" + name;
}

window.onload =function(){
	document.form.name.value=localStorage.getItem("key1");
	document.form.email.value=localStorage.getItem("key2");
	document.form.city.value=localStorage.getItem("key3");
	document.form.organization.value=localStorage.getItem("key4");
	document.form.num.value=localStorage.getItem("key5");
	document.form.msg.value=localStorage.getItem("key6");
}