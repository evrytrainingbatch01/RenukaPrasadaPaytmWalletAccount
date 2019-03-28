<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign-up</title>
<script type="text/javascript">
	
	 function validate () {
		 var password1 = document.myform.password.value;
			var password2 = document.myform.password1.value;
		if(password1!=password2){
			alert("Passwords should be same..try again.");
			return false;
		}
	
	}
</script>
</head>
<body>

<h1>Evry Wallet Account</h1>
<br><br>

<form name="myform" action="../registration" method="post" onsubmit="return validate()">
User Name : <input type="text" name="username" required="required"><br>
Password  : <input type="password" name="password"  required="required"><br>
Re-enter Password : <input type="password" name="password1" placeholder="re-enter password" required="required"><br>
Mobile No : <input type="number" name="mobilenumber" required="required"><br>
E-mail id : <input type="email" name="email" required="required"><br>
<button onclick="validate()" type="submit">Sign-up</button>
<input type="reset" name="Reset">
</form>

</body>
</html>