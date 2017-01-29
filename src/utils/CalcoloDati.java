/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Te4o
 */
public class CalcoloDati {
    
    public static float percentualeMassaGrassa (int plica1, int plica2, int plica3, int eta, String sesso){
        int sommaPliche = plica1 + plica2 + plica3;
        Double densitaCorporea = 0.0;
        
        if (sesso.equalsIgnoreCase("M")) {
            densitaCorporea = (Double) (1.10938 - (0.0008267 * sommaPliche) + (0.0000016 * (sommaPliche*sommaPliche)) - (0.0002574 * eta));
        }
        else{
            densitaCorporea = (Double) (1.0994921 - (0.0009929 * sommaPliche) + (0.0000023 * (sommaPliche*sommaPliche)) - (0.0000023 * eta));
        }

        float percentualeMassaGrassa  = (float) ((495/densitaCorporea) - 450);
        
        return percentualeMassaGrassa;
    }
    
}
