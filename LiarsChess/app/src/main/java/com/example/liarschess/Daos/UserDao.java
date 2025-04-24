package com.example.liarschess.Daos;

import com.example.liarschess.Entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserDao {

    private static UserDao instance; = null;
    private List<User> users = new ArrayList<>();

    public static UserDao getInstance() {
        if(instance==null)
            instance = new UserDao();
        return instance;

    }



}
