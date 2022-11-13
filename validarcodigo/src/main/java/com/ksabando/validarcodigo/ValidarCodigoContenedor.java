package com.ksabando.validarcodigo;
import java.util.HashMap;

public class ValidarCodigoContenedor {

    static private ValidarCodigoContenedor singleton = null;

    HashMap<String, Integer> TablaAsignacion;

    private ValidarCodigoContenedor() {
        initTabla();
    }

    public static ValidarCodigoContenedor getSingleton() {
        if (singleton == null) {
            singleton = new ValidarCodigoContenedor();
        }
        return singleton;
    }

    public String ComprobacionCodigo(String codigo){
        String pattern = "[A-Z]{4}\\d{7}";
        Integer suma = 0;
        Integer resultado = 0;
        if (codigo.matches(pattern)) {
            char[] arrayCodigo = codigo.toCharArray();
            for (int i = 0; i < arrayCodigo.length-1; i++) {
                if(i<4){
                    suma = TablaAsignacion.get(String.valueOf(arrayCodigo[i])) * (int) Math.pow(2,i) +suma;
                }else {
                    suma = Character.getNumericValue(arrayCodigo[i]) * (int) Math.pow(2,i) +suma;
                }
            }
            resultado = (int) suma /11;
            resultado = resultado * 11;
            resultado = suma - resultado;
            if(resultado == Character.getNumericValue(arrayCodigo[10])){
                return "Codigo Correcto";
            }else{
                return "Codigo Incorrecto";
            }

        }else{
            return "Error Formato Codigo";
        }
    }

    public void initTabla() {
        TablaAsignacion = new HashMap<>();
        char abecedario[] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        int valores[]     = {10 ,12 ,13 ,14 ,15 ,16 ,17 ,18 ,19 ,20 ,21 ,23 ,24 ,25 ,26 ,27 ,28 ,29 ,30 ,31 ,32 ,34 ,35 ,36 ,37 ,38 };
        for (int i = 0; i < abecedario.length; i++) {
            TablaAsignacion.put(String.valueOf(abecedario[i]), Integer.valueOf(valores[i]));
        }
    }
}
