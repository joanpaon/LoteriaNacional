/* 
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.controllers;

import java.util.Properties;
import org.japo.java.interfaces.IDataAccessController;
import org.japo.java.models.Model;
import org.japo.java.libraries.UtilesApp;
import org.japo.java.libraries.UtilesFecha;
import org.japo.java.libraries.UtilesValidacion;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DataAccessControllerPRP implements IDataAccessController {
    // Nombres Propiedades
    public static final String PRP_NUMERO = "loteria.numero";
    public static final String PRP_SERIE = "loteria.serie";
    public static final String PRP_FRACCION = "loteria.fraccion";
    public static final String PRP_FECHA = "loteria.fecha";
    public static final String PRP_PRECIO = "loteria.precio";

    // Fichero Propiedades > Modelo
    @Override
    public void importarModelo(Model model, String fichero) throws Exception {
        // Fichero Propiedades > Propiedades
        Properties prp = UtilesApp.cargarPropiedades(fichero);

        // Propiedades > Modelo
        convertirPropiedadesModelo(prp, model);
    }

    // Modelo > Fichero Propiedades
    @Override
    public void exportarModelo(Model model, String fichero) throws Exception {
        // Propiedades
        Properties prp = new Properties();

        // Modelo > Propiedades
        convertirModeloPropiedades(model, prp);

        // Propiedades > Fichero Propiedades
        UtilesApp.guardarPropiedades(prp, fichero);
    }

    // Modelo > Propiedades
    void convertirModeloPropiedades(Model model, Properties prp) {
        prp.setProperty(PRP_NUMERO, model.getNumero());
        prp.setProperty(PRP_SERIE, model.getSerie());
        prp.setProperty(PRP_FRACCION, model.getFraccion());
        prp.setProperty(PRP_FECHA, model.getFecha());
        prp.setProperty(PRP_PRECIO, model.getPrecio());
    }

    // Propiedades > Modelo
    void convertirPropiedadesModelo(Properties prp, Model model) throws Exception {
        // Número
        if (UtilesValidacion.validarDato(prp.getProperty(PRP_NUMERO), Model.ER_NUMERO)) {
            model.setNumero(prp.getProperty(PRP_NUMERO));
        } else {
            throw new Exception("Datos corruptos");
        }

        // Serie
        if (UtilesValidacion.validarDato(prp.getProperty(PRP_SERIE), Model.ER_SERIE)) {
            model.setSerie(prp.getProperty(PRP_SERIE));
        } else {
            throw new Exception("Datos corruptos");
        }

        // Fracción
        if (UtilesValidacion.validarDato(prp.getProperty(PRP_FRACCION), Model.ER_FRACCION)) {
            model.setFraccion(prp.getProperty(PRP_FRACCION));
        } else {
            throw new Exception("Datos corruptos");
        }

        // Fecha
        if (UtilesFecha.validarFecha(prp.getProperty(PRP_FECHA))) {
            model.setFecha(prp.getProperty(PRP_FECHA));
        } else {
            throw new Exception("Datos corruptos");
        }

        // Precio
        if (UtilesValidacion.validarDato(prp.getProperty(PRP_PRECIO), Model.ER_PRECIO)) {
            model.setPrecio(prp.getProperty(PRP_PRECIO));
        } else {
            throw new Exception("Datos corruptos");
        }
    }
}
