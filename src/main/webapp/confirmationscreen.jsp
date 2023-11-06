<!DOCTYPE html>
<html lang="en">
<head>
    <title>Event Confirmation</title>
</head>
<body>
    <h1>Event Information Confirmation</h1>
    <p> User Name: ${requestScope.userName}</p>
    <p>Event Name: ${requestScope.eventName}</p>
    <p>Event Date: ${requestScope.eventDate}</p>
    <p>Event Time: ${requestScope.eventTime}</p>
    <p>Event Location: ${requestScope.eventLocation}</p>
    <p>Event Description: ${requestScope.eventDescription}</p>
    <p>Total Attending: ${sessionScope.attendCount}</p>
    <p>Total Not Attending: ${sessionScope.notAttendCount}</p>
    
     <form method="GET" action="RestartHandler">
        <button type="submit">Restart</button>
    </form>
</body>
</html>
