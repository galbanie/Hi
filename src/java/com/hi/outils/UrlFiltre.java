/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.outils;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author galbanie
 */
public class UrlFiltre implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        
        String path = req.getRequestURI();
        
        //String[] controles = req.getRequestURI().split("/");
        
        if(path.endsWith(".css") || path.endsWith(".js") || path.endsWith(".jsp") || path.endsWith(".jpg") || path.endsWith(".png") || path.endsWith(".ico")){
            chain.doFilter(request, response);
        }
        else{
            String[] controles = req.getRequestURI().split("/");
            String cible = "";
            /*System.out.println("------"+controles.length+"-------");
            for(String controle : controles) System.out.println("("+controle+")");
            System.out.println("--------------");*/
            if(controles.length > 2){
                
                if(controles[2].equals("controle")){
                    if(controles.length > 3) cible = controles[3];
                }
                else cible = controles[2];
                
                request.setAttribute("cible", cible);
                
            }
            request.getRequestDispatcher("/controle").forward(request, response);
        }
        
    }

    @Override
    public void destroy() {
        
    }
    
}
