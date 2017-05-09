/* File: SimpleSerlvet.java
 * Date: 2015
 * Author: Phillip Bridgham (2004).
 * Modified By: Stanley Pieda
 * Modified to update for HTML5 and to tinker with the number of loops + thread sleep time,
 * as well as lock on a private final class level object on the advice of: Fei He (2015)
 * References:

Phillip Bridgham. (2004). Write thread-safe servlets: Learn how to handle thread safety. Retrieved from
http://www.javaworld.com/article/2072798/java-web-development/write-thread-safe-servlets.html


Fei He., modified by Arthur Hicken. (Nov 3, 2015). LCK00-J. Use private final lock objects to synchronize classes that may interact with untrusted  * code. [web page]. Retrieved from
https://www.securecoding.cert.org/confluence/display/java/LCK00-J.+Use+private+final+lock+objects+to+synchronize+classes+that+may+interact+with+untrusted+code

 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// import javax.servlet.SingleThreadModel; // caution, deprecated

/**
 *
 * @author Stanley Pieda
 */
public class SimpleServlet extends HttpServlet { // implements SingleThreadModel 
    
    // used to hold lock on synchronized block below
    private final Object lock = new Object();
    
    // only used as a non-thread-safe resource
    private int counter = 0;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
//        int counter = 0;
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SimpleServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<p>"+this+"</p>");
            synchronized (lock){    
              for (int c = 0; c < 1000; c++){
                out.println("Counter = " + counter + "<br />");
                try{
                  Thread.currentThread().sleep((long) Math.random() * 100);
                  counter++;
                }
                catch (InterruptedException exc) { }
              } // end loop
            } // end synchronized
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
