package com.example.designpatterns.Singleton;

/*
    We need to make this class singleton as multiple calls for database configuration should not return new class every time
 */

import javax.xml.crypto.Data;

public class DatabaseConfig {
    private static DatabaseConfig databaseConfig;
    private int c;
    private DatabaseConfig(){

    }
    public static DatabaseConfig getInstance(){
            if (databaseConfig == null) {
                synchronized(DatabaseConfig.class) {
                    if (databaseConfig == null)
                        databaseConfig = new DatabaseConfig();
            }
        }
        return databaseConfig;
    }
}
