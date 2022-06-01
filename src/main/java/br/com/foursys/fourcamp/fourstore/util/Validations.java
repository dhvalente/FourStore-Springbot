package br.com.foursys.fourcamp.fourstore.util;

public class Validations {
	
    public static boolean validaCep(String cep) {
        if (!cep.matches("\\d{8}")) {
            return false;
        }

        return true;
    }
}
