package com.ymIntnet.servlet;

import com.ymIntnet.entity.*;
import com.ymIntnet.service.*;
import com.ymIntnet.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "EasyBuyProductCategoryServlet")
public class EasyBuyProductCategoryServlet extends HttpServlet {
    EasyBuyProductCategoryService es = new EasyBuyProductCategoryServiceImpl();
    EasyBuyProductService ebs = new EasyBuyProductServiceImpl();
    browseService bs = new browseServiceImpl();
    ShopCarService scs = new ShopCarServiceImpl();
    EasyBuyOrderService ebos = new EasyBuyOrderServiceImpl();
    EasyBuyOrderDetailService ebods = new EasyBuyOrderDetailServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            request.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
            String method = request.getParameter("method");
            if ("productFind".equals(method)){
                productFind(request,response);
            }else if ("productFindId".equals(method)){
                productFindId(request,response);
            }else if ("browse".equals(method)){
                browse(request,response);
            }else if ("shopCar".equals(method)){
                shopCar(request,response);
            }else if ("countAdd".equals(method)){
                count(request,response);
            } else if ("shopCarFind".equals(method)){
                shopCarFind(request,response);
            }else if ("ddl".equals(method)){
                shopDelete(request,response);
            }else if ("order".equals(method)){
                orderFind(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void productFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EasyBuyProductCategory> eList = es.findAllParents();
        request.getSession().setAttribute("productList",eList);
        response.sendRedirect("EasyBuy/index.jsp");

    }
    protected void productFindId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<EasyBuyProduct> ebpList = ebs.shopFind(Integer.valueOf(id));
        request.getSession().setAttribute("list",ebpList);
        response.sendRedirect("EasyBuy/product-list.jsp");
    }
    protected void browse(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shopId = request.getParameter("eId");
        List<EasyBuyProduct> list = ebs.browseFind(Integer.valueOf(shopId));
        Browse bro = new Browse();
        bro.setBrowseName(list.get(0).getEpNam());
        bro.setImgAddress(list.get(0).getEpFileName());
        bs.browseInsert(bro);
        List<Browse> bList = bs.findAll();
        request.getSession().setAttribute("browseList",bList);
        request.getSession().setAttribute("ebpList",list);
        response.sendRedirect("EasyBuy/product-view.jsp");
    }
    protected void shopCarFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //scs
        PrintWriter out = response.getWriter();
        Object user = request.getSession().getAttribute("userList");
        if (user==null){
            out.write("<script language='javascript'>alert('请先登录');location.href='EasyBuy/login.jsp'</script>");

        }else {
            List<ShopCar> sList = scs.shopCarFindAll();
            request.getSession().setAttribute("shopCarList",sList);
            //request.getRequestDispatcher("EasyBuy/shopping.jsp").forward(request,response);
            response.sendRedirect("EasyBuy/shopping.jsp");
        }
    }
    protected void shopCar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //scs
        PrintWriter out = response.getWriter();
        Object user = request.getSession().getAttribute("userList");
        if (user==null){
            out.write("<script language='javascript'>alert('请先登录');location.href='EasyBuy/login.jsp'</script>");
        }else {
            String id = request.getParameter("id");
            List<ShopCar> sList = scs.shopCarFindAll();
            if (sList.size()==0){
                List<EasyBuyProduct> list = ebs.browseFind(Integer.valueOf(id));
                EasyBuyProduct eb = new EasyBuyProduct();
                eb.setEpFileName(list.get(0).getEpFileName());
                eb.setEpPrice(list.get(0).getEpPrice());
                eb.setEpNam(list.get(0).getEpNam());
                eb.setEpId(list.get(0).getEpId());
                ShopCar sc = new ShopCar();
                sc.setEbp(eb);
                sc.setShopCarTotalPrice(sc.getEbp().getEpPrice()*sc.getShopCount());
                scs.shopCarInsert(sc);
                shopCarFind(request,response);
            }else {
                for (int i = 0; i <sList.size();i++) {
                    if (sList.get(i).getEbp().getEpId()==Integer.valueOf(id)){
                        out.write("<script language='javascript'>alert('购物车已有该商品');location.href='EasyBuy/product-view.jsp'</script>");
                    }
                }
                List<EasyBuyProduct> list = ebs.browseFind(Integer.valueOf(id));
                EasyBuyProduct eb = new EasyBuyProduct();
                eb.setEpFileName(list.get(0).getEpFileName());
                eb.setEpPrice(list.get(0).getEpPrice());
                eb.setEpNam(list.get(0).getEpNam());
                eb.setEpId(list.get(0).getEpId());
                ShopCar sc = new ShopCar();
                sc.setEbp(eb);
                sc.setShopCarTotalPrice(sc.getEbp().getEpPrice()*sc.getShopCount());
                int num = scs.shopCarInsert(sc);
                boolean flag = false;
                if (num>0){
                    flag=true;
                }
                out.print(flag);
            }
        }
    }
    protected void count(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("sId");
        List<ShopCar> scList = scs.shopCarIdFindAll(Integer.valueOf(id));
        String num = request.getParameter("count");
        int count = Integer.valueOf(num);
        String name = request.getParameter("operation");
        if ("reduce".equals(name)){
            if (count==1){
                out.write("<script language='javascript'>alert('数量已经为1，不能再减了');location.href='EasyBuy/shopping.jsp'</script>");
            }else {
                count=count-1;
                ShopCar ss = new ShopCar();
                ss.setShopCount(count);
                ss.setShopCarId(Integer.valueOf(id));
                ss.setShopCarTotalPrice(scList.get(0).getEbp().getEpPrice()*ss.getShopCount());
                scs.shopCarModify(ss);
                shopCarFind(request,response);
            }

        }else if ("add".equals(name)){
            if (count>=scList.get(0).getEbp().getEpStock()){
                out.write("<script language='javascript'>alert('已为最大库存');location.href='EasyBuy/shopping.jsp'</script>");
            }else {
                count=count+1;
                ShopCar ss = new ShopCar();
                ss.setShopCount(count);
                ss.setShopCarId(Integer.valueOf(id));
                ss.setShopCarTotalPrice(scList.get(0).getEbp().getEpPrice()*ss.getShopCount());
                scs.shopCarModify(ss);
                shopCarFind(request,response);
            }
        }else if ("ss".equals(name)){
            if (count==0){
                out.write("<script language='javascript'>alert('数量不能为0');location.href='EasyBuy/shopping.jsp'</script>");
            }else if (count>=scList.get(0).getEbp().getEpStock()){
                out.write("<script language='javascript'>alert('数量已超过最大库存');location.href='EasyBuy/shopping.jsp'</script>");
            }else {
                ShopCar ss = new ShopCar();
                ss.setShopCount(count);
                ss.setShopCarId(Integer.valueOf(id));
                ss.setShopCarTotalPrice(scList.get(0).getEbp().getEpPrice()*ss.getShopCount());
                int num1 = scs.shopCarModify(ss);
                boolean flag = false;
                if (num1>0){
                    flag=true;
                }
                out.print(flag);
                //shopCarFind(request,response);
            }
        }
    }
    protected void shopDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String shopId = request.getParameter("sId");
        ShopCar sc = new ShopCar();
        sc.setShopCarId(Integer.valueOf(shopId));
        scs.shopCarDelete(sc);
        shopCarFind(request,response);
    }
    protected void orderFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //ebos订单类         ebods订单详情类
        List<EasyBuyUser> uList = (List<EasyBuyUser>)request.getSession().getAttribute("userList");
        List<ShopCar> scList = (List<ShopCar>)request.getSession().getAttribute("shopCarList");
        double totalPrice = 0;
        for (int i = 0; i <scList.size() ; i++) {
            totalPrice = totalPrice+scList.get(i).getShopCount()*scList.get(i).getShopCarTotalPrice();
        }
        EasyBuyOrder ee = new EasyBuyOrder();
        String id = UUID.randomUUID().toString().replace("-", "").toLowerCase();
        ee.setEo_id(id);
        ee.setEo_user_id(uList.get(0).getEuUserId());
        ee.setEo_user_name(uList.get(0).getEuUserName());
        ee.setEo_user_address(uList.get(0).getEuAddress());
        ee.setEo_create_time(new Date());
        ee.setEo_status(1);
        ee.setEo_cost(Double.valueOf(totalPrice));
        ee.setEo_type(1);
        int num = ebos.easyBuyOrderInsert(ee);
        List<EasyBuyOrder> easyBuyOrderList = ebos.easyBuyOrderIdFind(ee.getEo_id());
        ebods.OrderDetailInsert(id);
        List<EasyBuyOrderDetail> easyBuyOrderDetailList = ebods.OrderDetailDaoFindAll(scList,easyBuyOrderList);
        request.getSession().setAttribute("OrderDetail",easyBuyOrderDetailList);
        response.sendRedirect("EasyBuy/shopping-result.jsp");
    }
}
