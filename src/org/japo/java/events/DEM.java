package org.japo.java.events;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.japo.java.controllers.Controller;

public class DEM implements DocumentListener {

    // Referencia al Controller
    private final Controller control;

    // Constructor
    public DEM(Controller control) {
        this.control = control;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
//        control.procesarCambioTexto(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
//        control.procesarCambioTexto(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
//        control.procesarCambioTexto(e);
    }
}
