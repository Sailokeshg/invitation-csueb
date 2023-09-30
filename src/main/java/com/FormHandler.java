package com;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/FormHandler")
public class FormHandler extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		       throws ServletException, IOException
		{
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        Integer attendCount = (Integer) session.getAttribute("attendCount");
        if (attendCount == null) {
            attendCount = 0;
        }

        Integer notAttendCount = (Integer) session.getAttribute("notAttendCount");
        if (notAttendCount == null) {
            notAttendCount = 0;
        }
		
		String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String eventLocation = request.getParameter("eventLocation");
        String eventDescription = request.getParameter("eventDescription");
        
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"en\">");
        out.println("<head>");
        out.println("    <title>Event Information</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<form method=\"post\" action=\"FormHandler\">");
        out.println("    <h1>Event Information</h1>");
        out.println("    <p>Event Name: " + eventName + "</p>");
        out.println("    <p>Event Date: " + eventDate + "</p>");
        out.println("    <p>Event Time: " + eventTime + "</p>");
        out.println("    <p>Event Location: " + eventLocation + "</p>");
        out.println("    <p>Event Description: " + eventDescription + "</p>");
        out.println("    <button type=\"submit\" name=\"attendance\" value=\"attend\">Attend</button>");
        out.println("    <button type=\"submit\" name=\"attendance\" value=\"not-attend\">Not Attend</button>");
        out.println("</form>");
        out.println("</br>");
        out.println("<form method=\"GET\" action=\"RestartHandler\">");
        out.println("    <button type=\"submit\">Restart</button>");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");

        String confirmationChoice = request.getParameter("attendance");
        
        if (confirmationChoice != null) {
            if (confirmationChoice.equals("attend")) {
                attendCount++;
            } else if (confirmationChoice.equals("not-attend")) {
                notAttendCount++;
            }
        
            session.setAttribute("attendCount", attendCount);
            session.setAttribute("notAttendCount", notAttendCount);

            RequestDispatcher dispatcher = request.getRequestDispatcher("confirmationscreen.jsp");
            dispatcher.forward(request, response);
        }
        
        out.close();
		}
	}
	



