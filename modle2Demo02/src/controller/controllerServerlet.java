package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;

@WebServlet("*.bit")
@MultipartConfig(fileSizeThreshold=1024*1024*2,
maxFileSize = 1024*1024*10,
maxRequestSize = 1024*1024*50)
public class controllerServerlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public controllerServerlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doService(request, response);
	}
	protected void doService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		
		String cmd = request.getParameter("cmd");
		
		if(cmd != null) {
			ActionFactory factory = ActionFactory.getFactory();
			Action action = factory.getAction(cmd);
			ActionForward af = action.execute(request, response);
			
			if(af.isMethod()) {
				response.sendRedirect(af.getUrl());
				
			}else {
				String path = "/WEB-INF/jsp/"+af.getUrl();
				RequestDispatcher rd = request.getRequestDispatcher(path);
				rd.forward(request, response);
			}
		}else {
			//요청이 있다면 처리할 로직
		}
		
	}
}
