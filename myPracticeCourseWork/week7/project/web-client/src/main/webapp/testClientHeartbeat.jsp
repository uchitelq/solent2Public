<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>
<%@page import="org.solent.com504.project.impl.webclient.WebClientObjectFactory"%>
<%@page import="org.solent.com504.project.model.service.ServiceFacade"%>


<%
    // used to place error message at top of page 
    String errorMessage = "";
    String message = "";

    // used to set html header autoload time. This automatically refreshes the page
    // Set refresh, autoload time every 20 seconds
    response.setIntHeader("Refresh", 20);

    // accessing service 
    ServiceFacade serviceFacade = (ServiceFacade) WebClientObjectFactory.getServiceFacade();

    // accessing request parameters
    String actionStr = request.getParameter("action");
    String test_send = request.getParameter("Test_send");
    String name=request.getParameter("name");
    String site=request.getParameter("site");
    // basic error checking before making a call
    if (actionStr == null || actionStr.isEmpty()) {
        // do nothing

    } else if ("onSite".equals(actionStr)) {
        serviceFacade.personOnSite(name, site);
    }
    else if("leavingSite".equals(actionStr)){
        serviceFacade.personLeavingSite(name, site);
    }
    else {
        errorMessage = "ERROR: page called for unknown action";
    }

%>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Client Page for heart beat</title>
    </head>
    <body>
        <!-- works with http://localhost:8080/basicfacadeweb/testHeartbeat.jsp -->
        <H1>Client JSP Page for heart beat</H1>
        <!-- print error message if there is one -->
        <div style="color:red;"><%=errorMessage%></div>
        <div style="color:green;"><%=message%></div>


       <p>Getting heartbeat message: <%= serviceFacade.getHeartbeat()%> (note message is auto refreshed every 20 seconds)</p>

        <form action ="./testClientHeartbeat.jsp" method="post">
            <input type="hidden" name="action" value="onSite">
            <td>Site:<input type="textbox" name="site"></td>
            <td>Person id:<input type="textbox" name="name"></td>
            <input type="submit" value="On site">
        </form>
        <form action ="./testClientHeartbeat.jsp" method="get">
            <input type="hidden" name="action" value="leavingSite">
            <td>Site:<input type="textbox" name="site"></td>
            <td>Person id:<input type="textbox" name="name"></td>
            <input type="submit" value="Leaving site">
        </form>
        

    </body>
</html>
