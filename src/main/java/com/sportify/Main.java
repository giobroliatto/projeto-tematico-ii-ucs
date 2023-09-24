package com.sportify;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.sportify.controller.EquipeController;
import com.sportify.controller.EventoController;
import com.sportify.view.MenuForm;

public class Main {
    public static void main(String[] args) {
        // Configurar o Hibernate a partir do arquivo hibernate.cfg.xml
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");

        // Criar a fábrica de sessões do Hibernate
        SessionFactory sessionFactory = configuration.buildSessionFactory();

        // Criar uma sessão do Hibernate
        Session session = sessionFactory.openSession();

        // Criar uma instância do EquipeController
        EquipeController equipeController = new EquipeController(session);

        // Criar uma instância do EventoController
        EventoController eventoController = new EventoController(session);

        // Iniciar o menu principal e passar os controladores
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MenuForm menuForm = new MenuForm(equipeController, eventoController);
                menuForm.setVisible(true);
            }
        });

        // Fechar a sessão e a fábrica de sessões quando não forem mais necessárias
        // session.close();
        // sessionFactory.close();
    }
}
