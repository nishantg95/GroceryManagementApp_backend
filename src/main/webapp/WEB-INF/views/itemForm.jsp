<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <style type="text/css">
#backdrop {
	background: #2193b0; /* fallback for old browsers */
	background: -webkit-linear-gradient(to bottom, #6dd5ed, #2193b0);
	/* Chrome 10-25, Safari 5.1-6 */
	background: linear-gradient(to bottom, #6dd5ed, #2193b0);
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
}</style>
    <body id = backdrop>
        <h3>Welcome, Enter The Employee Details</h3>
        <form:form method="POST"
          action="viewItem" modelAttribute="item">
             <table>
                <tr>
                    <td><form:label path="name">Name</form:label></td>
                    <td><form:input path="name"/></td>
                </tr>
                <tr>
                    <td><form:label path="id">Id</form:label></td>
                    <td><form:input path="id"/></td>
                </tr>
                <tr>
                    <td><form:label path="expiry">
                      Contact Number</form:label></td>
                    <td><form:input path="expiry"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                </tr>
            </table>
        </form:form>
    </body>
</html>