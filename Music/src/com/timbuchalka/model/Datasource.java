package com.timbuchalka.model;
import sun.security.provider.PolicySpiFile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Datasource {

    public static final String DB_NAME = "music.db";
    public static final String CONNECTION_STRING = "jdbc:sqlite:C:\\databases\\"  + DB_NAME;

    public static final String TABLE_ALBUMS = "albums";
    public static final String COLUMN_ALBUM_ID = "_id";
    public static final String COLUMN_ALBUM_NAME = "name";
    public static final String COLUMN_ALBUM_ARTIST = "artist";


    public static final int INDEX_ALBUM_ID = 1;
    public static final int INDEX_NAME_ID = 2;
    public static final int INDEX_ARTIST = 3;


    public static final String TABLE_ARTISTS = "artists";
    public static final String COLUMN_ARTIST_ID = "_id";
    public static final String COLUMN_ARTIST_NAME = "name";

    public static final int INDEX_ARTIST_ID = 1;
    public static final int INDEX_ARTIST_NAME = 2;


    public static final String TABLE_SONGS = "songs";
    public static final String COLUMN_SONG_ID= "_id";
    public static final String COLUMN_SONG_TRACK = "track";
    public static final String COLUMN_SONG_TITLE = "title";
    public static final String COLUMN_SONG_ALBUM = "album";

    public static final int INDEX_SONG_ID = 1;
    public static final int INDEX_SONG_TRACK = 2;
    public static final int INDEX_SONG_TITLE = 3;
    public static final int INDEX_SONG_ALBUM = 4;


    public static final String INSERT_ARTIST = "INSERT INTO "+ TABLE_ARTISTS +'('+COLUMN_ARTIST_NAME+") VALUES (?)";
    public static final String INSERT_ALBUM = "INSERT INTO" +TABLE_ALBUMS +'('+COLUMN_ALBUM_NAME+", "+COLUMN_ALBUM_ARTIST+") VALUES (?, ?)";
    public static final String INSERT_SONG = "INSERT SONG" + TABLE_SONGS + '('+COLUMN_SONG_TRACK+", "+COLUMN_SONG_TITLE+", "+COLUMN_SONG_ALBUM+") VALUES (?, ?, ?)";
    private Connection conn;

    private PreparedStatement insertIntoArtists;
    private PreparedStatement insertIntoAlbums;
    private PreparedStatement insertIntoSongs;

    public boolean open() {
        try {
            conn = DriverManager.getConnection(CONNECTION_STRING);
            insertIntoArtists = conn.prepareStatement(INSERT_ARTIST, Statement.RETURN_GENERATED_KEYS );
            insertIntoAlbums = conn.prepareStatement(INSERT_ALBUM, Statement.RETURN_GENERATED_KEYS );
            insertIntoSongs = conn.prepareStatement(INSERT_SONG);

            return true;
        } catch(SQLException e) {
            System.out.println("Couldn't connect to database: " + e.getMessage());
            return false;
        }
    }

    public void close() {
        try {

            if (insertIntoArtists != null){
                insertIntoArtists.close();
            }
            if (insertIntoAlbums != null){
                insertIntoAlbums.close();
            }
            if (insertIntoSongs != null){
                insertIntoSongs.close();
            }
            if(conn != null) {
                conn.close();
            }

        } catch(SQLException e) {
            System.out.println("Couldn't close connection: " + e.getMessage());
        }
    }

    public static final String QUERY_ARTIST_FOR_SONG_START = "SELECT"+TABLE_ARTISTS+"."+COLUMN_ARTIST_NAME+", "+TABLE_ALBUMS+"."+COLUMN_ALBUM_NAME+", "+TABLE_SONGS+"."+COLUMN_SONG_TRACK+" FROM "+TABLE_SONGS+
            " INNER JOIN "+TABLE_ALBUMS+" ON "+
            TABLE_SONGS+ "."+COLUMN_SONG_ALBUM+" = "+TABLE_ALBUMS+"."+COLUMN_ALBUM_ID+
            "INNER JOIN "+ TABLE_ARTISTS + " ON "+
            TABLE_ALBUMS+"."+ COLUMN_ALBUM_ARTIST+ " = "+TABLE_ARTISTS + "."+COLUMN_ARTIST_ID+
            "WHERE "+TABLE_SONGS+"."+COLUMN_SONG_TITLE+ " = \"";


    public List<Artists> queryArtists () {

        try (Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM "+TABLE_ARTISTS)){


        List <Artists> artists = new ArrayList<>();
        while (result.next()){
           Artists artists1 = new Artists();
          artists1.setId(result.getInt(INDEX_ALBUM_ID));
          artists1.setName(result.getString(INDEX_ARTIST_NAME));
          artists.add(artists1);

        }
        return  artists;

        }catch (SQLException exception){
            System.out.println("query failed");
            return null;
        }
        }
    }
















