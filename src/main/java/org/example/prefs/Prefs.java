package org.example.prefs;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Prefs {
    public static final String DB_URL = "dbUrl";
    public static final String DB_USER = "dbUser";
    public static final String DB_PASSWORD = "dbPassword";

    public static final String INIT_DB_SQL_FILE_PATH = "initDbSql";
    public static final String POPULATE_DB_SQL_FILE_PATH = "populateDbSql";

    public static final String DEFAULT_PREFS_FILENAME = "prefs.json";


    private Map<String, Object> prefs = new HashMap<>();

    public Prefs(){
        this(DEFAULT_PREFS_FILENAME);
    }

    public Prefs(String fileName) {
        try {
            String json = String.join(
                    "\n",
                    Files.readAllLines(Paths.get(fileName))
            );

            TypeToken<?> typeToken = TypeToken.getParameterized(Map.class, String.class, Object.class);
            prefs = new Gson().fromJson(json, typeToken.getType());

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public String getString(String key){
        return getPref(key).toString();
    }

    public Object getPref(String key){
        return prefs.get(key);
    }

}

