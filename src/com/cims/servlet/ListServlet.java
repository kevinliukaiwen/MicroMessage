package com.cims.servlet;


import com.cims.bean.Message;
import com.cims.dao.MessageDao;
import com.cims.service.ListService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kevin on 2017/12/29.
 */
@WebServlet(name = "ListServlet",urlPatterns = "/ListServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("UTF-8");
        //得到页面的值
        String command = request.getParameter("command");
        String description = request.getParameter("description");
        //调用service的方法
        ListService listService = new ListService();
        List<Message> messagelist = listService.query(command,description);
        //向页面传值
        request.setAttribute("messagelist",messagelist);
        request.setAttribute("command",command);
        request.setAttribute("description",description);
        //转发
        request.getRequestDispatcher("/WEB-INF/jsps/backward/list.jsp").forward(request, response);
    }
}
