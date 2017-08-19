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

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.japo.java.interfaces.IDataAccessController;
import org.japo.java.models.Model;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DataAccessControllerSXML implements IDataAccessController {

    // Fichero SXML > Modelo
    @Override
    public void importarModelo(Model model, String fichero) throws Exception {
        try (XMLDecoder entrada = new XMLDecoder(new FileInputStream(fichero))) {
            // Fichero SXML > Modelo (Importado)
            Model modelClon = (Model) entrada.readObject();

            // Modelo (Importado) > Modelo
            convertirModeloModelo(modelClon, model);
        }
    }

    // Modelo > Fichero SXML
    @Override
    public void exportarModelo(Model model, String fichero) throws Exception {
        try (XMLEncoder salida = new XMLEncoder(new FileOutputStream(fichero))) {
            // Escribe el modelo
            salida.writeObject(model);
        }
    }

    // Modelo > Modelo
    public void convertirModeloModelo(Model modeloIni, Model modeloFin) {

    }
}
