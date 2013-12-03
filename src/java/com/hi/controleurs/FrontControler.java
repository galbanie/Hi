/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.controleurs;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        /*String[] controles = request.getRequestURI().split("/");
        System.out.println("------"+controles.length+"-------");
        for(String controle : controles) System.out.println("("+controle+")");
        System.out.println("--------------");
        
        System.out.println(request.getAttribute("cible"));
        System.out.println(request.getParameter("test"));*/
        
        if(request.getParameter("guess") != null && request.getParameter("guess").equals("true")){
            request.getSession(true).setAttribute("guess", true);
        }
        else if(request.getParameter("formulaire") != null){
            String form = (String) request.getParameter("formulaire");
            if(form.equals("connexion") || form.equals("inscription") || form.equals("pwdforget")){
                this.getServletContext().getRequestDispatcher("/users").forward(request, response);
            }
            // d'autres formulaires
            
        }
        else{
            String cible = (String) request.getAttribute("cible");
            
        }
        
        this.getServletContext().getRequestDispatcher("/jsp/gabarit.jsp").forward(request, response);
        out.close();
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
