package com.ymIntnet.servlet;

import com.ymIntnet.entity.EasyBuyUser;
import com.ymIntnet.service.EasyBuyUserService;
import com.ymIntnet.service.impl.EasyBuyUserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    EasyBuyUserService ebs = new EasyBuyUserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String method = request.getParameter("method");
        if ("loginFind".equals(method)){
            loginFind(request,response);
        }else if ("insert".equals(method)){
            try {
                addUser(request,response);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }else if ("loginYX".equals(method)){
            loginYx(request,response);
        }
        out.flush();
        out.close();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void loginFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        boolean flag = true;
        String name = request.getParameter("name");
        List<EasyBuyUser> uList = ebs.userFind();
        for (int i = 0; i <uList.size() ; i++) {
            if (name.equals(uList.get(i).getEuUserName())){
                flag = false;
            }
        }
        out.print(flag);
    }
    protected void addUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        PrintWriter out=response.getWriter();
        String uName = request.getParameter("userName");
        String uPassword = request.getParameter("passWord");
        String uSex = request.getParameter("sex");
        String birth = request.getParameter("time");
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date uBirth = format.parse(birth);
        String uPhone = request.getParameter("iPhone");
        String uAddress = request.getParameter("address");
        String uIdCard = request.getParameter("idCard");
        String uEmail = request.getParameter("email");
        EasyBuyUser ebu = new EasyBuyUser();
        ebu.setEuUserId(uName);
        ebu.setEuUserName(uName);
        ebu.setEuPassword(uPassword);
        ebu.setEuSex(uSex);
        ebu.setEuBirthday(uBirth);
        ebu.setEuIdentityCode(uIdCard);
        ebu.setEuEmail(uEmail);
        ebu.setEuAddress(uAddress);
        ebu.setEuStatus(1);
        int num = ebs.userRegister(ebu);
        if (num>0){
            request.getSession().setAttribute("EasyBuyUser",ebu);
            response.sendRedirect("EasyBuy/reg-result.jsp");
        }else {
            out.write("<script language='javascript'>");
            out.write("alert('注册失败,系统异常')");
            out.write("window.location.href='EasyBuy/register.jsp'");
            out.write("</script>");
        }
    }
    protected void loginYx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String uName  = request.getParameter("userName");
        String uPassword = request.getParameter("passWord");
        EasyBuyUser ebu = new EasyBuyUser();
        ebu.setEuUserId(uName);
        ebu.setEuUserName(uName);
        List<EasyBuyUser> uList = ebs.loginFind(uName,uPassword);
        request.getSession().setAttribute("userList",uList);
        if (uList.size()>0){
            request.getSession().setAttribute("loginUser",ebu);
            request.getSession().setAttribute("userList",uList);
            if (uList.get(0).getEuStatus()==2){
                response.sendRedirect("Manager/index.jsp");
            }else {
                response.sendRedirect("EasyBuy/log-result.jsp");
            }

        }else if (uList.size()==0){
            out.write("<script language='javascript'>alert('用户名或密码错误');location.href='EasyBuy/login.jsp'</script>");

        }
    }
}
