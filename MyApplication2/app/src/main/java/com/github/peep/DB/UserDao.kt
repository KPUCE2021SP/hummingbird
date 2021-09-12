package com.github.peep.DB

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE

import androidx.room.Query
import androidx.room.Update
import androidx.room.util.TableInfo

//DB에 접근해 질의를 수행할 DAO. Query를 메소드로 작성해주어야 한다.
//여기서 User는 UserResponse의 User가 아님
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

    //레벨업
    @Query("UPDATE user SET level = level + 1")
    fun updateLevel()

    //해삡 병아리 졸업 시킴
    @Query("UPDATE user SET happy_peep = happy_peep + 1")
    fun updateHappy()

    //슬픔 병아리 졸업
    @Query("UPDATE user SET sad_peep = sad_peep + 1")
    fun updateSad()


}