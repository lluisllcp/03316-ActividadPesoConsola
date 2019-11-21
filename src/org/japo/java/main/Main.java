/* 
 * Copyright 2019 Lluís CP - aw.lluiscerda@gmail.com.
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
package org.japo.java.main;

import java.util.Locale;
import java.util.Scanner;

/**
 *
 * @author Lluís CP - aw.lluiscerda@gmail.com
 */
public final class Main {

    public static final Scanner SCN
            = new Scanner(System.in, "Windows-1252")
                    .useLocale(Locale.ENGLISH).useDelimiter("\\s+");

    public static void main(String[] args) {

        //Constantes
        final int DIAS_MAX = 7;
        final int PESO_MIN = 0;
        final int PESO_MAX = 250;

        //Variables
        int dia = 1;
        double pesoDia;
        double sumaPeso = 0;
        double media;

        boolean testOk = true;

        //Bucle
        do {
            //Entrada datos
            try {
                System.out.printf("Introduzca el peso del dia %d ....: ", dia);
                pesoDia = SCN.nextDouble();

                if (pesoDia <= PESO_MAX && pesoDia >= PESO_MIN) {
                    testOk = false;
                    dia++;
                    sumaPeso += pesoDia;

                } else {
                    System.out.println("ERROR: Peso incorrecto.");
                }
                //Error
            } catch (Exception e) {
                System.out.println("ERROR: Entrada incorrecta");
                //Borrar bufer           
            } finally {
                SCN.nextLine();
            }
            //Media        
        } while (testOk || (dia <= DIAS_MAX));
        media = sumaPeso / DIAS_MAX;
        //Salida
        System.out.printf(Locale.ENGLISH, "El peso medio de los 7 dias es...: %.2f Kg.%n", media);
    }
}
