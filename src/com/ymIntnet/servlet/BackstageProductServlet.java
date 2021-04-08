package com.ymIntnet.servlet;

import com.ymIntnet.entity.EasyBuyOrder;
import com.ymIntnet.entity.EasyBuyProduct;
import com.ymIntnet.entity.EasyBuyProductCategory;
import com.ymIntnet.service.EasyBuyOrderService;
import com.ymIntnet.service.EasyBuyProductService;
import com.ymIntnet.service.impl.EasyBuyOrderServiceImpl;
import com.ymIntnet.service.impl.EasyBuyProductServiceImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "BackstageProductServlet")
public class BackstageProductServlet extends HttpServlet {
    EasyBuyProductService ebps = new EasyBuyProductServiceImpl();
    EasyBuyOrderService ebo = new EasyBuyOrderServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        String method = request.getParameter("method");
        if ("add".equals(method)){
            try {
                addProduct(request,response);
            } catch (FileUploadException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if ("find".equals(method)){
            findProduct(request,response);
        }else if ("order".equals(method)){
            orderFind(request,response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
    protected void addProduct(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter out = response.getWriter();
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        List<FileItem> items = upload.parseRequest(request);
        EasyBuyProduct ebp = new EasyBuyProduct();
        for (FileItem item:items){
            if (item.isFormField()==true){
                String key = item.getFieldName();
                String value = item.getString("utf-8");
                if ("productName".equals(key)){
                    ebp.setEpNam(value);
                }else if ("parentId".equals(key)){
                    EasyBuyProductCategory ebpc = new EasyBuyProductCategory();
                    ebpc.setEpcId(542);
                    ebp.setEpcId(ebpc);
                    ebp.setEpId(542);
                }else if ("photo".equals(key)){
                    ebp.setEpFileName(value);
                }else if ("productPrice".equals(key)){
                    ebp.setEpPrice(Integer.valueOf(value));
                }else if ("productStock".equals(key)){
                    ebp.setEpStock(Integer.valueOf(value));
                }else if ("description".equals(key)){
                    ebp.setEpDescription(value);
                }
            }else {
                File file = new File("D:\\tomcat\\apache-tomcat-7.0.106\\picture\\"+item.getName());
                item.write(file);
                ebp.setEpFileName("images/product/"+item.getName());
            }
        }
        int num = ebps.productInsert(ebp);
        if (num>0){
            out.write("<script language='javascript'>alert('添加成功')");
            findProduct(request,response);
        }else {
            out.write("<script language='javascript'>alert('添加失败，请稍后再试')");
            findProduct(request,response);
        }
    }
    protected void findProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<EasyBuyProduct> ebpList = ebps.hotSellFind();
        request.getSession().setAttribute("easyBuyProductList",ebpList);
        response.sendRedirect("Manager/product.jsp");
    }
    protected void orderFind(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("orderId");
        String name =request.getParameter("userName");
        List<EasyBuyOrder>eoList = ebo.allFind(id,name);
        request.getSession().setAttribute("easyBuyOrderList",eoList);
        response.sendRedirect("Manager/order.jsp");
    }
}
