<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Event Information</title>
</head>
<body>
	<% List<Map<String, String>> eventList = (List<Map<String, String>>) request.getSession().getAttribute("eventList");
   if (eventList != null) {
       for (Map<String, String> eventInfo : eventList) { %>
	<p>
		User Name:
		<%= eventInfo.get("userName") %></p>
	<p>
		Event Name:
		<%= eventInfo.get("eventName") %></p>
	<p>
		Event Date:
		<%= eventInfo.get("eventDate") %></p>
	<p>
		Event Time:
		<%= eventInfo.get("eventTime") %></p>
	<p>
		Event Location:
		<%= eventInfo.get("eventLocation") %></p>
	<p>
		Event Description:
		<%= eventInfo.get("eventDescription") %></p>
	<form method="post" action="FormHandler">
		<input type="hidden" name="eventName"
			value="<%= eventInfo.get("eventName") %>"> <input
			type="hidden" name="eventDate"
			value="<%= eventInfo.get("eventDate") %>"> <input
			type="hidden" name="eventTime"
			value="<%= eventInfo.get("eventTime") %>"> <input
			type="hidden" name="eventLocation"
			value="<%= eventInfo.get("eventLocation") %>"> <input
			type="hidden" name="eventDescription"
			value="<%= eventInfo.get("eventDescription") %>"> <label
			for="userName">Please enter you username for confirmation:</label> <input
			type="text" id="userName" name="userName" required>
		<button type="submit" name="attendance" value="attend">Attend</button>
		<button type="submit" name="attendance" value="not-attend">Not
			Attend</button>
	</form>
	<% }
   } else { %>
	<p>No events added yet.</p>
	<% } %>


	<%
        String confirmationChoice = request.getParameter("attendance");
           
        
        if (confirmationChoice != null) {
            int attendCount = 0;
            int notAttendCount = 0;

            Object attendCountObj = session.getAttribute("attendCount");
            if (attendCountObj != null) {
                attendCount = (Integer) attendCountObj;
            }

            Object notAttendCountObj = session.getAttribute("notAttendCount");
            if (notAttendCountObj != null) {
                notAttendCount = (Integer) notAttendCountObj;
            }

            if (confirmationChoice.equals("attend")) {
                attendCount++;
            } else if (confirmationChoice.equals("not-attend")) {
                notAttendCount++;
            }

            session.setAttribute("attendCount", attendCount);
            session.setAttribute("notAttendCount", notAttendCount);

            RequestDispatcher dispatch = request.getRequestDispatcher("confirmationscreen.jsp");
            dispatch.forward(request, response);
        }
    %>
</body>
</html>
