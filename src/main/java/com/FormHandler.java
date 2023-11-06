package com;
import java.io.IOException;
import java.util.HashMap;
import java.util.*;
import java.util.Map;

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
		
		HttpSession session = request.getSession();
		
        String userName  = request.getParameter("userName");
		String eventName = request.getParameter("eventName");
        String eventDate = request.getParameter("eventDate");
        String eventTime = request.getParameter("eventTime");
        String eventLocation = request.getParameter("eventLocation");
        String eventDescription = request.getParameter("eventDescription");
//        String finalUser = request.getParameter("final_username");

        
        request.setAttribute("userName", userName);
        request.setAttribute("eventName", eventName);
        request.setAttribute("eventDate", eventDate);
        request.setAttribute("eventTime", eventTime);
        request.setAttribute("eventLocation", eventLocation);
        request.setAttribute("eventDescription", eventDescription);
//        request.setAttribute("final_username", finalUser);
        
        Map<String, String> eventInfo = new HashMap<>();
        eventInfo.put("userName", userName);
//        eventInfo.put("final_username", finalUser);
        eventInfo.put("eventName", eventName);
        eventInfo.put("eventDate", eventDate);
        eventInfo.put("eventTime", eventTime);
        eventInfo.put("eventLocation", eventLocation);
        eventInfo.put("eventDescription", eventDescription);
        
        
        @SuppressWarnings("unchecked")
		List<Map<String, String>> eventList = (List<Map<String, String>>) session.getAttribute("eventList");
        if (eventList == null) {
            eventList = new ArrayList<>();
        }

        // Add the current event to the list
        eventList.add(eventInfo);

        // Update the event list in the session
        session.setAttribute("eventList", eventList);
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("eventinformation.jsp");
        dispatcher.forward(request, response);

		}
	}
	



