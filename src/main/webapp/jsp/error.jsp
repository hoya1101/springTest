<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<body>
	<h2>Spring MVC @ExceptionHandler Example</h2>

	<c:if test="${not empty msg}">
		<h2>${msg}</h2>
	</c:if>
	
	<c:if test="${not empty msgText}">
		<h2>${msgText}</h2>
	</c:if>


</body>
</html>