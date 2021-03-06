/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import restClient.ProfecoServiceRESTClient;

/**
 *
 * @author crist
 */
@WebServlet(name = "inicia", urlPatterns = {"/InicioSesion"})
public class InicioSesion extends HttpServlet {

    ProfecoServiceRESTClient clienteProfeco = new ProfecoServiceRESTClient();

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String email = request.getParameter("email");
        String psw = request.getParameter("psw");

        JSONObject jsonsolicitud = new JSONObject();
        jsonsolicitud.put("email", email);
        jsonsolicitud.put("contrasenia", psw);

        String usuario = clienteProfeco.login(jsonsolicitud.toString());
        if (!usuario.isEmpty()) {
            response.sendRedirect("indexProfeco.jsp");
        } else {
            response.sendRedirect("login.jsp");

        }

//        if (email.equals("grupooxxomexico@gmail.com") && psw.equals("oxxo123")) {
//            response.sendRedirect("indexMercado.jsp");
//        } else if (email.equals("carminamoreno29@gmail.com") && psw.equals("monita")) {
//            response.sendRedirect("indexConsumidor.jsp");
//        } else if (email.equals("profeco.gob.mexico@gmail.com") && psw.equals("admin")) {
//            response.sendRedirect("indexProfeco.jsp");
//        } else {
//            response.sendRedirect("index.jsp");
//        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
