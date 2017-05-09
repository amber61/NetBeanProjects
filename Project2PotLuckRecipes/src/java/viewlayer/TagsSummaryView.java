/* Author: Qing Zhang
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslayer.TagsBusinessLogic;
import transferobjects.Tag;
import java.util.List;


public class TagsSummaryView extends HttpServlet {

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
            out.println("<title>Qing Zhang</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Tags Servlet by Qing Zhang</h1>");
//            out.println("<td>Tag Text</td>");
            out.println("</tr>");
            out.println("<table border=1;border-spacing:0;border-collapse:collapse;>");
          
            TagsBusinessLogic logic = new TagsBusinessLogic();
            List<Tag> tags = logic.getAllTags();
            out.println("<table border=\"1\">");
            out.println("<tr>");            
           out.println("<tr><td>TagId</td><td>TagText</td></tr>");
           
            for (Tag tag : tags) {
                out.println("<tr>");
                out.println("<td>"+tag.getTagID()+"</td>");
                out.println("<td>"+tag.getTagText()+"</td></tr>");
             }
            out.println("</table><br/>");
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
