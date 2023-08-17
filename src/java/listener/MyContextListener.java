/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // Este código se ejecuta cuando la aplicación se inicia
        System.out.println("Aplicación iniciada");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // Este código se ejecuta cuando la aplicación se detiene
        System.out.println("Aplicación detenida");
    }
}
