/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.controleurs;

import com.gs.manager.Manager;
import com.gs.modele.entity.Article;
import com.gs.modele.entity.Categorie;
import com.gs.modele.entity.Membre;
import com.gs.modele.entity.Texte;
import com.gs.modele.entity.Usager;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author galbanie <galbanie at setrukmarcroger@gmail.com>
 */
public class ControleurTopic extends HttpServlet {

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
        
        Manager manager = (Manager) this.getServletContext().getAttribute("manager");
        
        HttpSession session = request.getSession();
        
        //Article article;
        
        Categorie categorie;
        
        if(session.getAttribute("usager") == null) this.getServletContext().getRequestDispatcher("/jsp/gabarit.jsp").forward(request, response);
        else if(request.getParameter("formulaire") != null){
            String form = (String) request.getParameter("formulaire");
            
            if(form.equals("addTopic")){
                Membre membre = (Membre) session.getAttribute("usager");
                categorie = (Categorie) manager.find(Categorie.class, (String)request.getParameter("categorie"));
                Article topic = new Article(request.getParameter("titre"));
                topic.setCategorie(categorie);
                topic.setContenu(new Texte((String)request.getParameter("contenu")));
                membre.setArticle(topic);
                manager.update(membre);
                request.setAttribute("section", "hi");
            }
        }
        else if(request.getParameter("action") != null){
            String action = (String) request.getParameter("action");
            
            if(action.equals("add")){
                request.setAttribute("section", "addTopic");
            }
        }
        else if(request.getParameter("cat") != null){
            /*manager.createNamedQuery("Categorie.findByNom");
            manager.setParametre("nom", (String)request.getParameter("cat"));
            categorie = (Categorie) manager.findSingleResult();*/
        }
        else if(request.getParameter("article") != null){
            
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
