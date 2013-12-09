/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.listerners;

import com.gs.classes.State;
import com.gs.manager.Manager;
import com.gs.modele.entity.Article;
import com.hi.outils.EntityManagerSingleton;
import java.util.LinkedList;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Web application lifecycle listener.
 *
 * @author galbanie <galbanie at setrukmarcroger@gmail.com>
 */
public class ContextSessionListerner implements ServletContextListener, HttpSessionListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("manager", new Manager(EntityManagerSingleton.getInstance()));
        sce.getServletContext().setAttribute("states", new LinkedList<State>());
        sce.getServletContext().setAttribute("articles", new LinkedList<Article>());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        se.getSession().setAttribute("guess",false);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        se.getSession().setAttribute("guess",false);
    }
}
