package com.example.pay.roomdatabase;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Insert
    void registerUser(UserEntity userEntity);

    @Query("SELECT * from users where email=(:email) and password=(:password)")
    UserEntity login(String email, String password);

    @Query("SELECT * from users where email=(:email)")
    UserEntity recovery(String email);

    @Query("SELECT * from users where email=(:email)")
    UserEntity profile(String email);
}
