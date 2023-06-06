package com.eee.teste.lala.exception;

import java.util.List;

import com.eee.teste.lala.model.Ingresso;

public class ExceptionHandler extends RuntimeException{

    public static String handleSalaCheia(List<Ingresso> ingressos, int capacidade) {
        if (ingressos.size() >= capacidade) {
            return "Sala cheia";
        }else{
            return null;
        }
    }
    
}
