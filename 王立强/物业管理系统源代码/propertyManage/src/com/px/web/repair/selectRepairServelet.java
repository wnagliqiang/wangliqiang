package com.px.web.repair;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.px.bean.Repair;
import com.px.service.RepairService;
import com.px.service.Impl.RepairServiceImpl;

/**
 * Servlet implementation class selectRepairServelet
 */
@WebServlet("/selectRepairServlet")
public class selectRepairServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public selectRepairServelet() {
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
		request.setCharacterEncoding("UTF-8");
		int rpno = Integer.parseInt(request.getParameter("rpno"));
		RepairService repairService = new RepairServiceImpl();
		List<Repair> repairs = repairService.selectRepairByRpno(rpno);
		if(repairs!=null){
			request.setAttribute("repairs", repairs);
			request.getRequestDispatcher("Repairtab.jsp").forward(request, response);
		}else{
			request.setAttribute("error", "该维修记录不存在");
			request.getRequestDispatcher("listRepairServlet").forward(request, response);
		}
	}

}
