package com.example.hw2.DataBaseCreation;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.hw2.Dao.UserDao;
import com.example.hw2.User;

@Database(entities = {User.class}, version = 1)
public abstract class UsersDatabase extends RoomDatabase {
    private static UsersDatabase instance;
    public static synchronized UsersDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(
                            context.getApplicationContext(),
                            UsersDatabase.class,
                            "users_db")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }
    public abstract UserDao userDao();
}