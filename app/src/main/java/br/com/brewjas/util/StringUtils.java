package br.com.brewjas.util;


/*
 * © Copyright 2016 Brewjas.
 * Autor : Paulo Sales - dev@paulovns.com.br
 * Empresa : Brewjas app.
 */

public class StringUtils {

    public static String setLabel(String base, String label){

        return base.replace("{var}", label);
    }

}
