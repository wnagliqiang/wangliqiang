package com.px.web.train;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px.service.TrainService;
import com.px.service.Impl.TrainServiceImpl;

/**
 * Servlet implementation class deleteTrainServlet
 */
@WebServlet("/deleteTrainServlet")
public class deleteTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public deleteTrainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		int tno = Integer.parseInt(request.getParameter("tno"));
		TrainService trainService = new TrainServiceImpl();
		int num = trainService.deleteByTno(tno);
		if(num!=0){
			request.getRequestDispatcher("listTrainServlet").forward(request, response);
		}
		else{
			request.setAttribute("error", "该培训记录不存在");
			request.getRequestDispatcher("listTrainServlet").forward(request, response);
			
		}
	}

}
