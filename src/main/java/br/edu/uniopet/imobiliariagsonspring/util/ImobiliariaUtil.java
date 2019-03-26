package br.edu.uniopet.imobiliariagsonspring.util;

import br.edu.uniopet.imobiliariagsonspring.domain.Imobiliaria;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ImobiliariaUtil {

    public static List<Imobiliaria> convertGson(){
        List<Imobiliaria> list = new ArrayList<>();

        Gson gson = new Gson();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\imobiliaria.json"));

            Type type = new TypeToken<List<Imobiliaria>>(){
            }.getType();

            list = gson.fromJson(br, type);

            System.out.println(list);

//            //Converte String JSON para objeto Java
//            objectParse = gson.fromJson(String.valueOf(br), Imobiliaria.class);

        } catch (Exception e){
            e.printStackTrace();
        }

        return list;
    }
}
