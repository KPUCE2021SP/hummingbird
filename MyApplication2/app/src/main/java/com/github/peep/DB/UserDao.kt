package com.github.peep.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

import androidx.room.Query

//DB에 접근해 질의를 수행할 DAO. Query를 메소드로 작성해주어야 한다.

@Dao
interface UserDao {
    @Query("SELECT * FROM user")
    fun getAll(): List<User>

    //import androidx.room.OnConflictStrategy.REPLACE
    //User -> DB 패키지내 User 클래스를 사용할것. githubapi user 아님
    @Insert(onConflict = REPLACE)
    fun insert(user : User)

    @Query("DELETE FROM user")
    fun deleteAll()

}