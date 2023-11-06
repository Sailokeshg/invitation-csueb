<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Event Invitation Page</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles.css">
    <script type="text/javascript" src="validator.js"></script>
</head>
<body>
    <div class="container">
        <h1>Event Invitation</h1>
        <p>Kindly fill in the details below and let us know if you will be attending the event.</p>
       
        <form id="eventForm" action="FormHandler" method="POST">
        
        	<label for="userName">User Name:</label>
            <input type="text" id="userName" name="userName">
            
            <label for="eventName">Event Name:</label>
            <input type="text" id="eventName" name="eventName">
            
            <label for="eventDate">Event Date:</label>
            <input type="text" id="eventDate" name="eventDate" placeholder="MM/DD/YYYY">
            
            <label for="eventTime">Event Time:</label>
            <input type="text" id="eventTime" name="eventTime">
            
            <label for="eventLocation">Event Location:</label>
            <input type="text" id="eventLocation" name="eventLocation">
            
            <label for="eventDescription">Event Description:</label>
            <textarea id="eventDescription" name="eventDescription" rows="4"></textarea>

            <div class="submit-button">
                <button type="submit" style="margin-top: 10px; margin-right: 10%;">Submit</button>
            </div>
        </form>
    </div>
</body>
</html>
