package com.application.subscrimamalona.Controlador;

import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class Data {
    //Primera Versión: Guardamos solo el nombre, tipo de subscripción/pago y el monto
    private Set<String> datosCasilleros;
    private SharedPreferences preferences;

    public Data(SharedPreferences preferences){
        this.preferences=preferences;
        leerData();
    }
    public void leerData(){
        datosCasilleros = preferences.getStringSet("titulo", new HashSet<String>());
    }
    public void guardarData(String nombre, String monto, String tipo){
        datosCasilleros.add(nombre+":"+monto+":"+tipo);
    }
    public boolean validarData(String nombre, String monto, String tipo) {
        for (String datos:datosCasilleros) {
            if (datos.equals(nombre+":"+monto+":"+tipo)) {
                return true;
            }
        }
        return false;
    }
    public void escribirData(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putStringSet("titulo",datosCasilleros);
        editor.putStringSet("monto",datosCasilleros);
        editor.putStringSet("tipo",datosCasilleros);
        editor.commit();
    }
}