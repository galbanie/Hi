/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.controleurs;

import com.gs.manager.Manager;
import com.gs.modele.entity.Usager;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author galbanie
 */
public class FrontControler extends HttpServlet {

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
        /*response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();*/
        
        HttpSession session = request.getSession();
        
        Manager manager = (Manager) this.getServletContext().getAttribute("manager");
        
        Usager user = (Usager) session.getAttribute("usager");
        
        /*String[] controles = request.getRequestURI().split("/");
        System.out.println("------"+controles.length+"-------");
        for(String controle : controles) System.out.println("("+controle+")");
        System.out.println("--------------");
        
        System.out.println(request.getAttribute("cible"));
        System.out.println(request.getParameter("test"));*/
        
        manager.createNamedQuery("Article.findAll");
        this.getServletContext().setAttribute("articles",manager.findResultList());
        
        String cible = (String) request.getAttribute("cible");
        
        if(user == null){
            if(request.getParameter("guess") != null && request.getParameter("guess").equals("true")){
                request.getSession(true).setAttribute("guess", true);
            }
            else if(request.getParameter("guess") != null && request.getParameter("guess").equals("false")){
                request.getSession(true).setAttribute("guess", false);
            }
        }
        
        if(cible != null){
            if(cible.equals("register")){
                this.getServletContext().getRequestDispatcher("/users").forward(request, response);
            }
            else if(cible.equals("sujet")) this.getServletContext().getRequestDispatcher("/topic").forward(request, response);
            else this.getServletContext().getRequestDispatcher("/jsp/gabarit.jsp").forward(request, response);
        }
        else this.getServletContext().getRequestDispatcher("/jsp/gabarit.jsp").forward(request, response);
        
        
        //out.close();
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
