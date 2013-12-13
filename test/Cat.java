
import com.gs.manager.Manager;
import com.gs.modele.entity.Categorie;
import com.hi.outils.EntityManagerSingleton;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author galbanie <galbanie at setrukmarcroger@gmail.com>
 */
public class Cat {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Manager manager = new Manager(EntityManagerSingleton.getInstance());
        manager.create(new Categorie("hi", "ancetre", null));
        manager.create(new Categorie("Programmation", "Tous ce qui touche à la prog.", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("Photographie", "clic clac la pose, clash la prise.", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("Videographie", "Action", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("Windows", "Pas optimal", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("Mac OS", "Trop chère", (Categorie)manager.find(Categorie.class, "hi")));
        
        manager.create(new Categorie("Java", "Java", (Categorie)manager.find(Categorie.class, "Programmation")));
        manager.create(new Categorie("C#", "C shap", (Categorie)manager.find(Categorie.class, "Programmation")));
        manager.create(new Categorie("C++", "plus plus", (Categorie)manager.find(Categorie.class, "Programmation")));
        
        manager.create(new Categorie("HDR", "on braquete pas un peu.", (Categorie)manager.find(Categorie.class, "Photographie")));
        manager.create(new Categorie("Magic Lantern", "Ma canon ...", (Categorie)manager.find(Categorie.class, "Photographie")));
        manager.create(new Categorie("Bonnes Pratiques", "Et oui", (Categorie)manager.find(Categorie.class, "Photographie")));
        
        /*manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));
        manager.create(new Categorie("hi", "ancetre", (Categorie)manager.find(Categorie.class, "hi")));*/
        
    }
    
}
