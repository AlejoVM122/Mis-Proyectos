package com.timbuchalka;

import com.timbuchalka.model.Artists;
import com.timbuchalka.model.Datasource;

import java.sql.Statement;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Datasource datasource = new Datasource();
        datasource.open();

        if(!datasource.open()) {
            System.out.println("Can't open datasource");
            return;
        }

        List <Artists> artists = datasource.queryArtists();
        if (artists == null){
            System.out.println("NO Artists;");
            return;
        }
        for (Artists s : artists){
            System.out.println("ID = " +s.getId() +" NAME = "+ s.getName());

        }

        datasource.close();
    }

}
