/* Author: Jian Liu
 */
package viewlayer;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import businesslayer.RecipesBusinessLogic;
import java.util.List;
import transferobjects.Recipe;
import transferobjects.Tag;
import transferobjects.Category;
import transferobjects.Ingredient;

/**
 * Implementation of view of displaying all recipes.
 * 
 * @author Chunyan Wang, Jian Liu, Qing Zhang, Zhe Huang
 * @version 1.0.0 Date April 11, 2016
 * @since 1.8.0_73
 * 
 * @see java.io.IOException;
 * @see java.io.PrintWriter;
 * @see javax.servlet.ServletException;
 * @see javax.servlet.http.HttpServlet;
 * @see javax.servlet.http.HttpServletRequest;
 * @see javax.servlet.http.HttpServletResponse;
 * @see businesslayer.RecipesBusinessLogic;
 * @see java.util.List;
 * @see transferobjects.Recipe;
 * @see transferobjects.Tag;
 * @see transferobjects.Category;
 * @see transferobjects.Ingredient;
 */

public class RecipesSummaryView extends HttpServlet {

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
            out.println("<title>Jian Liu</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Recipes Servlet by Jian Liu</h1>");
//            out.println("<p>recipes</p>");
            RecipesBusinessLogic logic = new RecipesBusinessLogic();
            List<Recipe> recipes = logic.getAllRecipes();
            out.println("<table border='1'>");
            out.println("<tr>");
            out.println("<th>Recipe Id</th>");
            out.println("<th>Member Id</th>");
            out.println("<th>Name</th>");
            out.println("<th>Directions</th>");
            out.println("<th>Attributions</th>");
            out.println("<th>Tag</th>");
            out.println("<th>Category</th>");
            out.println("<th>Ingredients</th>");
            out.println("</tr>");
            // put all recipes in the table
            for(Recipe recipe : recipes){
                out.printf("<tr><td>%d</td><td>%d</td><td>%s</td><td>%s</td><td>%s</td>",
                           recipe.getRecipeId(), recipe.getMemberId(), recipe.getRecipeName(),
                           recipe.getDirection(), recipe.getAttribution());
                out.println("<td>");
                // set all tags in the table
                for (Tag tag: recipe.getTagList()){
                    out.println("[" + tag.getTagText() + "] ");
                }
                out.println("</td>");
                out.println("<td>");
                //set all categories in the table
                for (Category category: recipe.getCategoryList()){
                    out.println("[" + category.getCategoryName() + "] ");
                }
                out.println("</td>");
                out.println("<td>");
                //set all ingredients in the table
                for (Ingredient ingredient: recipe.getIngredientList()){
                    out.println("[" + ingredient.getName() + ": " + ingredient.getMeasurement() + "] ");
                }
                out.println("</td>");
                out.println("</tr>");
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
