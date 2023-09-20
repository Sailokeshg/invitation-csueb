package com;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/FormHandler")
public class FormHandler extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	int attendCount = 0;
	int notAttendCount = 0;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		       throws ServletException, IOException
		{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		
		String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String eventLocation = request.getParameter("eventLocation");
        String eventDescription = request.getParameter("eventDescription");
        String confirmationChoice = request.getParameter("attendance");
              
        if (confirmationChoice != null) {
            if (confirmationChoice.equals("attend")) {
                attendCount++;
            } else if (confirmationChoice.equals("not-attend")) {
                notAttendCount++;
            }
        }
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <title>Event Information</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <h1>Event Information</h1>");
        out.println("    <p>Event Name: " + eventName + "</p>");
        out.println("    <p>Event Date: " + eventDate + "</p>");
        out.println("    <p>Event Time: " + eventTime + "</p>");
        out.println("    <p>Event Location: " + eventLocation + "</p>");
        out.println("    <p>Event Description: " + eventDescription + "</p>");
        out.println("    <p>Total Attending: " + attendCount + "</p>");
        out.println("    <p>Total Not Attending: " + notAttendCount + "</p>");
        out.println("</body>");
        out.println("</html>");
        out.close();
        
		}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		
		response.setContentType("text/html");
		
		PrintWriter out  = response.getWriter();
		
		out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <title>Event Invitation Page</title>");
        out.println("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("    <link rel=\"stylesheet\" href=\"styles.css\">");
        out.println("    <script type=\"text/javascript\" src=\"/validator.js\"></script>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class=\"container\">");
        out.println("        <h1>Event Invitation</h1>");
        out.println("        <p>Kindly fill in the details below and let us know if you will be attending the event.</p>");
        out.println("        <form id=\"eventForm\" method=\"POST\" action=\"FormHandler\">");
        out.println("            <label for=\"eventName\">Event Name:</label>");
        out.println("            <input type=\"text\" id=\"eventName\" name=\"eventName\">");
        out.println("            <label for=\"eventDate\">Event Date:</label>");
        out.println("            <input type=\"text\" id=\"eventDate\" name=\"eventDate\" placeholder=\"MM/DD/YYYY\">");
        out.println("            <label for=\"eventTime\">Event Time:</label>");
        out.println("            <input type=\"text\" id=\"eventTime\" name=\"eventTime\">");
        out.println("            <label for=\"eventLocation\">Event Location:</label>");
        out.println("            <input type=\"text\" id=\"eventLocation\" name=\"eventLocation\">");
        out.println("            <label for=\"eventDescription\">Event Description:</label>");
        out.println("            <textarea id=\"eventDescription\" name=\"eventDescription\" rows=\"4\" wrap maxlength=\"50px\"></textarea>");
        out.println("            <div class=\"attendance-buttons\">");
        out.println("                <div class=\"attend-button\">");
        out.println("                    <label for=\"attendance\">");
        out.println("                        <input type=\"radio\" name=\"attendance\" value=\"attend\">Attend");
        out.println("                    </label>");
        out.println("                </div>");
        out.println("                <div class=\"notattend-button\">");
        out.println("                    <label for=\"attendance\">");
        out.println("                        <input type=\"radio\" name=\"attendance\" value=\"not-attend\">Not Attend");
        out.println("                    </label>");
        out.println("                </div>");
        out.println("            </div>");
        out.println("            <div class=\"submit-button\">");
        out.println("                <button type=\"submit\" style=\"margin-top: 10px; margin-right: 10%;\">Submit</button>");
        out.println("            </div>");
        out.println("        </form>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");
        out.close();
		
	}
}