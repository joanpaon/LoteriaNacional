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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import org.japo.java.interfaces.IDataAccessController;
import org.japo.java.models.Model;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DataAccessControllerJSON implements IDataAccessController {

    // Fichero JSON > Modelo
    @Override
    public void importarModelo(Model modeloFin, String fichero) throws Exception {
        try (JsonReader entrada = new JsonReader(new FileReader(fichero))) {
            // Crea Objeto Gson
            Gson gson = new Gson();

            // Fichero JSON > Modelo (Importado)
            Model modeloIni = gson.fromJson(entrada, Model.class);

            // Modelo (Importado) > Modelo
            convertirModeloModelo(modeloIni, modeloFin);
        }
    }

    // Modelo > Fichero JSON
    @Override
    public void exportarModelo(Model model, String fichero) throws Exception {
        try (Writer salida = new FileWriter(fichero)) {
            // Instancia Objeto Gson
            Gson gson = new GsonBuilder().create();

            // Escribe los datos en el fichero
            gson.toJson(model, salida);
        }
    }

    // Modelo > Modelo
    public void convertirModeloModelo(Model modeloIni, Model modeloFin) {

    }
}
