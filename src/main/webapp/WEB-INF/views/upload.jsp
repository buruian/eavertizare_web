<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
<title>Upload File Request Page</title>
</head>
<body>

	<form method="POST" action="uploadFile?${_csrf.parameterName}=${_csrf.token}" enctype="multipart/form-data">
		File to upload: <input type="file" name="file"><br /> 
		Name: <input type="text" name="name"><br /> <br /> 
		<input type="submit" value="Upload"> Press here to upload the file!
		<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
	</form>
	
</body>
</html>