//package ro.procont.jspringjstree.controller;
//
//import java.io.IOException;
//import java.io.PrintWriter;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import ro.procont.jspringjstree.repos.Data;
//import ro.procont.jspringjstree.repos.LocalDataImpl;
//import ro.procont.jspringjstree.util.ConverterJSON;
//
//
//@WebServlet(urlPatterns = {"/ajax"})
//public class AjaxTree extends HttpServlet {
//	
//	
//    private Data data;
//
//    @Override
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        response.setContentType("application/json; charset=utf-8");
//        String nodeId = request.getParameter("id");
//        PrintWriter out = response.getWriter();
//        try {
//            if (nodeId.equals("root")) {
//                out.println(ConverterJSON.toJsonToString(data.getRoot()));
//            } else {
//                out.println(ConverterJSON.toJsonToString(data.getById(nodeId)));
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        } finally {
//            out.close();
//        }
//    }
//
//    @Override
//    public void init() throws ServletException {
//        super.init();
//        data = LocalDataImpl.getInstance();
//    }
//}