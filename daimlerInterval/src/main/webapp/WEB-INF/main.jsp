<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Interval merge</title>
</head>
<body>
<div><!-- first form to manually enter values for the intervals -->
	<form action="nextInterval">
		<div>
			<input type="text" name= "intervals" value="${intervals}" required="required" style="visibility:hidden">
			<label for="value1">Value 1: </label> <input type="text" name= "value1" required="required">
			<label for="value2">Value 2: </label> <input type="text" name= "value2" required="required">
			<input type="submit" value="Add Interval to list" formmethod="post">
		</div>
	</form>
</div><br><br>

<div><!-- second form to automatically read values for the intervals -->
	<form action="readInterval">
		<div>
			<label for="filePath">Path to Interval List: </label> <input type="text" name= "filePath" required="required">
			<input type="submit" value="Read intervals from file" formmethod="post">
		</div>
	</form>
</div><br><br>

<div><!-- third form to call merged method -->
	<form action="merge">
		<div>
			<input type="text" name= "intervals" value="${intervals}" required="required" style="visibility:hidden">
			<input type="submit" value="Merge intervals" formmethod="post">
		</div>
	</form>
</div><br><br>
<div><!-- displays pre-merged list and result-->
	The List of Intervals: 
	<c:forEach items="${intervals}" var="interval">
		<div>${interval.value1}  ${interval.value2}</div>
	</c:forEach>
</div><br>
<div>
	The List of merged Intervals: 
	<c:forEach items="${mergedIntervals}" var="interval">
		<div>${interval.value1}  ${interval.value2}</div>
	</c:forEach>
</div>

</body>
</html>