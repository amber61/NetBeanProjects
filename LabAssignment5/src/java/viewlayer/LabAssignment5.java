/*
 * Updated by: Zhe Huang
 * Code in this file was based on materials provided by Stanley Pieda (2015) personal
 * communication.
 *
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transferobjects.Tuna;
import businesslayer.TunasBusinessLogic;
/**
 *
 * @author ZHE
 */
public class LabAssignment5 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Zhe Huang</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Zhe Huang</h1>");
            out.println("<p>Date: " + java.time.LocalDate.now().toString() + "<br/>Time: " + java.time.LocalTime.now().toString() + "</p>");
            
            TunasBusinessLogic logic = new TunasBusinessLogic();
            List<Tuna> tunas = logic.getAllTunas();
            out.println("<table border=\"1\">");
            out.println("<tr>");
            out.println("<td>Tuna Id</td>");
            out.println("<td>Genus Name</td>");
            out.println("<td>Species Name</td>");
            out.println("<td>Common Name</td>");
            out.println("<td>Max Weight</td>");
            out.println("<td>IUCN Status</td>");
            out.println("</tr>");       
            for(Tuna tuna : tunas){
                out.printf("<tr><td>%d</td><td>%s</td><td>%s</td><td>%s</td><td>%.1f</td><td>%s</td></tr>",
                    tuna.getTunaId(), tuna.getGenusName(), tuna.getSpeciesName(), tuna.getCommonName(), tuna.getMaxWeight(), tuna.getIucnStatus());
            }
            out.println("</table>");            
            out.println("</body>");
            out.println("</html>");
        }
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
        processRequest(request, response);
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
