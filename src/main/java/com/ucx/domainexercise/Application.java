package com.ucx.domainexercise;

import com.ucx.domainexercise.domain.Costumer;
import com.ucx.domainexercise.repository.StorageService;
import com.ucx.domainexercise.repository.StorageServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {


        /*Costumer costumer = new Costumer(1, "Filani");

        ssi.save(costumer);
        System.out.println(ssi.find(1));

        costumer.setName("FIsteku");
        ssi.update(costumer);
        System.out.println(ssi.find(1));*/

//        try{
//            Costumer costumer1 = new Costumer(3, "qehrlqelk");
//            ssi.update(costumer1);
//        } catch (Exception ex){
//            System.err.println(ex.getMessage());
//        }

//        try{
//            ssi.save(costumer);
//        } catch (Exception ex){
//            System.err.println(ex.getMessage());
//        }

//        int x = 9;
//        System.out.println(Integer.toBinaryString(x));
//        System.out.println(Integer.toBinaryString(x).chars().filter(e -> e == '0').count());
//
//        List<String> lista = Arrays.asList("Filani", "Fisteku", "Filanja", "Fistekja", "Fisniki");
//        List<String> filteredList = lista.stream().filter(e -> e.endsWith("i")).collect(Collectors.toList());
//        System.out.println(lista);
//        System.out.println(filteredList);
    }
}
