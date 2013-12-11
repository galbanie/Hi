/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.controleurs;


import com.gs.manager.Manager;
import com.gs.modele.entity.Usager;
import com.gs.modele.entity.Membre;
import com.hi.outils.EntityManagerSingleton;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author galbanie <galbanie at setrukmarcroger@gmail.com>
 */
public class ControleurUsers extends HttpServlet {

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
        
        //Manager manager = (Manager) this.getServletContext().getAttribute("manager");
        Manager manager = new Manager(EntityManagerSingleton.getInstance());
        HttpSession session = request.getSession();
        Usager user;
        
        
        if(request.getParameter("formulaire") != null){
            String form = (String) request.getParameter("formulaire");
            /*if(form.equals("connexion") || form.equals("inscription") || form.equals("pwdforget")){
                System.out.println("form : " + form);
            }*/
            
            if(form.equals("connexion")){
                manager.createNamedQuery("Usager.findByIdentifiant");
                manager.setParametre("identifiant", request.getParameter("username"));
                user = (Usager) manager.findSingleResult();
                if(user != null){
                    if(user.getPassword().equals(request.getParameter("password"))){
                        session.setAttribute("usager", user);
                    }
                }
            }
            else if(form.equals("inscription")){
                user = new Membre(request.getParameter("username"), request.getParameter("email"), request.getParameter("password"));
                System.out.println(user);
                manager.create(user);
            }
            else if(form.equals("pwdforget")){
                
            }
        }
        else{
            if(request.getParameter("user") != null){
                String action = (String) request.getParameter("user");
                
                if(action.equals("deconnexion")){
                    if(session.getAttribute("usager") != null){
                        session.removeAttribute("usager");
                        session.setAttribute("guess", true);
                    }
                }
            }
        }
        
        
        this.getServletContext().getRequestDispatcher("/jsp/gabarit.jsp").forward(request, response);
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
