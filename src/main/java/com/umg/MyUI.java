package com.umg;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.*;

import java.util.ArrayList;
import java.util.List;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

    @Override
    protected void init(VaadinRequest vaadinRequest) {
        final VerticalLayout layout = new VerticalLayout();
        final HorizontalLayout hlayout = new HorizontalLayout();
        
        final TextField name = new TextField();
        name.setCaption("Escribe tu nombre");

        final TextField age = new TextField();
        age.setCaption("Escribe tu edad");

        List<Estudiante> listaEstudiante = new ArrayList<>();

        //listaEstudiante.add(new Estudiante("Yoel", 15));

        Grid<Estudiante> gridEstudiante = new Grid<>();
        gridEstudiante.setWidth("100%");

        gridEstudiante.setItems(listaEstudiante);
        gridEstudiante.addColumn(Estudiante::getNombre).setCaption("Nombre");
        gridEstudiante.addColumn(Estudiante::getEdad).setCaption("Edad");


        Button button = new Button("Añadir");

        button.addClickListener( e -> {
            listaEstudiante.add(new Estudiante(name.getValue(),Integer.parseInt(age.getValue())));
            gridEstudiante.setItems(listaEstudiante);

            name.clear();
            age.clear();

            Notification.show("Estudiante añadido.");

            //layout.addComponent(new Label("Gracias " + name.getValue()
            //        + ", funciona!"));
        });
        
        hlayout.addComponents(name, age, button);
        hlayout.setComponentAlignment(button,Alignment.BOTTOM_RIGHT);
        layout.addComponents(hlayout,gridEstudiante);
        
        setContent(layout);
    }

    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
