<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="org.solent.com504.project.impl.web.WebObjectFactory"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>
<%@page import="org.solent.com504.project.model.dto.Person"%> 



<%
    // used to place error message at top of page 
    String errorMessage = "";
    String message = "";

    // used to set html header autoload time. This automatically refreshes the page
    // Set refresh, autoload time every 20 seconds
    response.setIntHeader("Refresh", 20);

    // accessing service 
    ServiceFacade serviceFacade = (ServiceFacade) WebObjectFactory.getServiceFacade();

    // accessing request parameters
    String actionStr = request.getParameter("action");
    List<Person> personList= new ArrayList<Person>();
    Person tempPerson=new Person();
    tempPerson.setAddress("Address");
    tempPerson.setFirstName("FirstName");
    Long a=new Long(15);
    tempPerson.setId(a);
    tempPerson.setSecondName("SecondName");
    
    // basic error checking before making a call
    if (actionStr == null || actionStr.isEmpty()) {
        // do nothing

    } else if ("XXX".equals(actionStr)) {
        // put your actions here
    } else {
    }    
        personList.add(tempPerson);
    

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <link rel="stylesheet" type="text/css" href="../css/style.css">

        <title>JSP Server Page for heart beat</title>
    </head>
    <body>
        <!-- works with http://localhost:8080/basicfacadeweb/testHeartbeat.jsp -->
        <H1>JSP Server Page for heart beat</H1>
        <!-- print error message if there is one -->
        <div style="color:red;"><%=errorMessage%></div>
        <div style="color:green;"><%=message%></div>

        <p>The time is: <%= new Date().toString()%> (note page is auto refreshed every 20 seconds)</p>

        <p>Getting heartbeat message: <%= serviceFacade.getHeartbeat()%> (note message is auto refreshed every 20 seconds)</p>
        <table>
        <tr>
			<th>id</th>
			<th>title</th>
			<th>author</th>
			<th>isbn</th>
			<th></th>
		</tr>
		<%
			for (Person person : personList) {
		%>
		<tr>
			<td><%=person.getId()%></td>
			<td><%=((person.getFirstName()==null) ? "":person.getFirstName()) %></td>
			<td><%=((person.getSecondName()==null) ? "":person.getSecondName()) %></td>
                        <td><%=((person.getAddress()==null) ? "":person.getAddress()) %></td>
                            <!--GETROLE-->
			<td>
			
			</td>
		</tr>
		<%
			}
		%>
                </table>

    </body>
</html>
