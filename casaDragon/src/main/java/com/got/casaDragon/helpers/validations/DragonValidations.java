package com.got.casaDragon.helpers.validations;

import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class DragonValidations {

    public boolean validarNombreDragon(String nombreDragon){
        if (nombreDragon.length()>20){
            return false;
        }

        String expresionRegular = "^[a-zA-Z\\s]+$";

        Pattern pattern = Pattern.compile(expresionRegular);
        Matcher matcher = pattern.matcher(nombreDragon);

        return matcher.matches();
    }

    public boolean validarEdad(Integer edad){
        return edad > 0 && edad <= 2000;
    }

    public boolean validarAltura(Double altura){
        return altura > 0;
    }

    public boolean validarNumeroVictorias(Integer victorias){
        return victorias > 0;
    }

}
