/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.hi.modeles.entites;

import com.gs.modele.entity.Article;
import com.gs.modele.entity.Usager;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author galbanie <galbanie at setrukmarcroger@gmail.com>
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Membre extends Usager{
    @OneToMany
    @JoinColumn(name = "ID_USAGER")
    private List<Article> articles;

    public Membre() {
        articles = new LinkedList<Article>();
    }

    public List<Article> getArticles() {
        return articles;
    }

    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
    public void setArticle(Article article) {
        if(!this.articles.contains(article))this.articles.add(article);
    }

    @Override
    public boolean equals(Object object) {
        return super.equals(object);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (this.articles != null ? this.articles.hashCode() : 0);
        return hash;
    }
    
    
}
