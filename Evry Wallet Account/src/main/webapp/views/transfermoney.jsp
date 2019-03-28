<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Transfer money</title>
</head>
<body>
<br>
<h1>Evry Wallet Account</h1>
<br>
<form action="../transfer" method="post">
<br><br>
Enter your uid : <input type="number" name="uid" required="required">
<br>
Enter beneficiary uid : <input type="number" name="bid" required="required"/><br>
<br>
Enter the amount : <input type="number" name="amt" required="required"/><br>
<br>
<input type="submit" name="Submit"/>
</form>
</body>
</html>