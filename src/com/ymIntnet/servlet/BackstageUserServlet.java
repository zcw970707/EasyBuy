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

@WebServlet(name = "BackstageUserServlet")
public class BackstageUserServlet extends HttpServlet {
    EasyBuyUserService ebus = new EasyBuyUserServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String method = request.getParameter("method");
            if ("add".equals(method)){
                try {
                    userAdd(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else if ("find".equals(method)){
                userFind(request,response);
            }else if ("modify".equals(method)){
                try {
                    userModify(request,response);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else if ("delete".equals(method)){
                userDelete(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void userAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        PrintWriter out = response.getWriter();
        String uName = request.getParameter("userName");
        String uPwd = request.getParameter("passWord");
        String uSex = request.getParameter("sex");
        String uBirthyear = request.getParameter("birthyear");
        String uBirthmonth = request.getParameter("birthmonth");
        String uBirthday = request.getParameter("birthday");
        String born = new StringBuffer().append(uBirthyear).append(uBirthmonth).append(uBirthday).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date uBorn = sdf.parse(born);
        String uMobile = request.getParameter("mobile");
        String uAddress = request.getParameter("address");
        String uIdcode = request.getParameter("idcode");
        String uEmail = request.getParameter("email");
        EasyBuyUser ebu = new EasyBuyUser();
        ebu.setEuUserId(uName);
        ebu.setEuUserName(uName);
        ebu.setEuStatus(1);
        ebu.setEuAddress(uAddress);
        ebu.setEuEmail(uEmail);
        ebu.setEuIdentityCode(uIdcode);
        ebu.setEuBirthday(uBorn);
        ebu.setEuSex(uSex);
        ebu.setEuPassword(uPwd);
        ebu.setEuMobile(uMobile);
        int num = ebus.userRegister(ebu);
        if (num>0){
            out.write("<script language='javascript'>alert('添加成功');location.href='Manager/manage-result.jsp'</script>");
        }else {
            out.write("<script language='javascript'>alert('后台数据出错，请稍后再试');location.href='Manager/manage-result.jsp'</script>");
        }
    }
    protected void userFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EasyBuyUser> ebUserList = ebus.userFind();
        request.getSession().setAttribute("ebUserList",ebUserList);
        response.sendRedirect("Manager/user.jsp");

    }
    protected void userModify(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ParseException {
        //manage-result.jsp
        PrintWriter out = response.getWriter();
        String uId = request.getParameter("userId");
        String uName = request.getParameter("userName");
        String uPwd = request.getParameter("passWord");
        String uSex = request.getParameter("sex");
        String uBirthyear = request.getParameter("birthyear");
        String uBirthmonth = request.getParameter("birthmonth");
        String uBirthday = request.getParameter("birthday");
        String born = uBirthyear+uBirthmonth+uBirthday;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date uBorn = sdf.parse(born);
        String uMobile = request.getParameter("mobile");
        String uAddress = request.getParameter("address");
        String uIdcode = request.getParameter("idcode");
        String uEmail = request.getParameter("email");
        EasyBuyUser ebu = new EasyBuyUser();
        ebu.setEuUserId(uId);
        ebu.setEuUserName(uName);
        ebu.setEuStatus(1);
        ebu.setEuAddress(uAddress);
        ebu.setEuEmail(uEmail);
        ebu.setEuIdentityCode(uIdcode);
        ebu.setEuBirthday(uBorn);
        ebu.setEuSex(uSex);
        ebu.setEuPassword(uPwd);
        ebu.setEuMobile(uMobile);
        int num = ebus.userModify(ebu);
        if (num>0){
            out.write("<script language='javascript'>alert('修改成功');location.href='Manager/manage-result.jsp'</script>");
        }else {
            out.write("<script language='javascript'>alert('后台数据出错，请稍后再试');location.href='Manager/manage-result.jsp'</script>");
        }
    }
    protected void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String userId = request.getParameter("id");
        EasyBuyUser ebu = new EasyBuyUser();
        ebu.setEuUserId(userId);
        int num = ebus.userDelete(ebu);
        if (num>0){
            out.write("<script language='javascript'>alert('删除成功')");
            userFind(request,response);
        }else {
            out.write("<script language='javascript'>alert('后台数据出错，请稍后再试');location.href='Manager/manage-result.jsp'</script>");
        }
    }
}
