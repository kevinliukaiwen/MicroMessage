package com.cims.servlet;

import com.cims.service.ListService;
import com.cims.service.MaintainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by kevin on 2017/12/31.
 */
@WebServlet(name = "DeleteOneServlet",urlPatterns = "/DeleteOneServlet")
public class DeleteOneServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //接受页面的值
        int id = Integer.parseInt(request.getParameter("id"));
        MaintainService maintainService = new MaintainService();
        maintainService.deleteOne(id);
       request.getRequestDispatcher("/ListServlet").forward(request, response);
    }
}
