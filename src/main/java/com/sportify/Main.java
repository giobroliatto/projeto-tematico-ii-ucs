package com.sportify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EquipeEventoController;
import com.sportify.controller.EventoController;
import com.sportify.util.HibernateUtil;
import com.sportify.view.MenuForm;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        
        Session session = sessionFactory.openSession();
        EquipeController equipeController = new EquipeController(session);
        EventoController eventoController = new EventoController(session);
        EquipeEventoController equipeEventoController = new EquipeEventoController(session);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuForm menuForm = new MenuForm(equipeController, eventoController, equipeEventoController);
                menuForm.setVisible(true);
            }
        });
    }
}

