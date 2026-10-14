<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="es">
<head>
<jsp:include page="sections/head.jsp" />
<script type="text/javascript">
	function changeDni(dni, dniHref) {
		document.getElementById("dni").innerHTML = "Are you sure you wish to delete student with dni=<strong>"
				+ dni + "</strong>?";
		document.getElementById("dniHref").href = dniHref;
	}
</script>
<style type="text/css">
</style>
</head>
<body>
	<div class="container my-4">
		<jsp:include page="sections/header.jsp" />
		TODO - Students view
	</div>
</body>
</html>