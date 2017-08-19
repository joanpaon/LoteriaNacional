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
package org.japo.java.models;

import java.io.Serializable;
import org.japo.java.libraries.UtilesFecha;
import org.japo.java.libraries.UtilesValidacion;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class Model implements Serializable {

    // Número de items
    public static final int NUM_ITEMS = 5;

    // Constantes de acceso
    public static final int POS_NUMERO = 0;
    public static final int POS_SERIE = 1;
    public static final int POS_FRACCION = 2;
    public static final int POS_FECHA = 3;
    public static final int POS_PRECIO = 4;

    // Expresiones regulares
    public static final String ER_NUMERO = "[0-9]{5}";                  // 00000 - 99999
    public static final String ER_SERIE = "0|[1-9]\\d?|1[0-5]\\d|160";  // 0 - 160
    public static final String ER_FRACCION = "[0-9]";                   // 0 - 9
    public static final String ER_PRECIO = "0|[1-9]\\d?";               // 0 - 99

    // Valores por defecto
    public static final String DEF_NUMERO = "00000";
    public static final String DEF_SERIE = "0";
    public static final String DEF_FRACCION = "0";
    public static final String DEF_FECHA = UtilesFecha.obtenerFechaHoy();
    public static final String DEF_PRECIO = "0";

    // Campos de la entidad
    private String numero;
    private String serie;
    private String fraccion;
    private String fecha;
    private String precio;

    public Model() {
        numero = DEF_NUMERO;
        serie = DEF_SERIE;
        fraccion = DEF_FRACCION;
        fecha = DEF_FECHA;
        precio = DEF_PRECIO;
    }

    // Constructor Parametrizado
    public Model(String numero, String serie, String fraccion,
            String fecha, String precio) {
        // Número
        if (UtilesValidacion.validarDato(numero, ER_NUMERO)) {
            this.numero = numero;
        } else {
            this.numero = DEF_NUMERO;
        }

        // Serie
        if (UtilesValidacion.validarDato(serie, ER_SERIE)) {
            this.serie = serie;
        } else {
            this.serie = DEF_SERIE;
        }

        // Fracción
        if (UtilesValidacion.validarDato(fraccion, ER_FRACCION)) {
            this.fraccion = fraccion;
        } else {
            this.fraccion = DEF_FRACCION;
        }

        // Fecha
        if (UtilesFecha.validarFecha(fecha)) {
            this.fecha = fecha;
        } else {
            this.fecha = DEF_FECHA;
        }

        // Precio
        if (UtilesValidacion.validarDato(precio, ER_PRECIO)) {
            this.precio = precio;
        } else {
            this.precio = DEF_PRECIO;
        }
    }

    // --- INICIO SETTERS / GETTERS
    //
    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (UtilesValidacion.validarDato(numero, ER_NUMERO)) {
            this.numero = numero;
        }
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        if (UtilesValidacion.validarDato(serie, ER_SERIE)) {
            this.serie = serie;
        }
    }

    public String getFraccion() {
        return fraccion;
    }

    public void setFraccion(String fraccion) {
        if (UtilesValidacion.validarDato(fraccion, ER_FRACCION)) {
            this.fraccion = fraccion;
        }
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        if (UtilesFecha.validarFecha(fecha)) {
            this.fecha = fecha;
        }
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        if (UtilesValidacion.validarDato(precio, ER_PRECIO)) {
            this.precio = precio;
        }
    }

    // --- FIN SETTERS / GETTERS
}
