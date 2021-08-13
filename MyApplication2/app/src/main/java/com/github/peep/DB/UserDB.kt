package com.github.peep.DB

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.github.peep.CollectionActicity

//database holder를 포함하여, 앱의 영구 저장되는 데이터와 기본 연결을 위한 주 엑세스 지점이다.
//RoomDatabase를 extend 하는 추상 클래스여야 하며, 테이블과 버전을 정의하는 곳이다.

//Entity 모델을 기반으로 하고, dao의 메소드를 가지고 있는 데이터베이스를 생성하자. RoomDatabase()를 상속한다.
//MainActivity에서 호출하며 database 객체를 반환하거나 삭제할 수 있도록 getInstance()와 destroyInstance()메소드를 생성

@Database(entities = [User::class], version = 1)
abstract class UserDB : RoomDatabase() {
    abstract fun userDao() : UserDao

    companion object{
        private var INSTANCE : UserDB? = null

        fun getInstance(context: Context) : UserDB? {
            if (INSTANCE == null){
                synchronized(UserDB::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                    UserDB::class.java,"user.db")
                        .fallbackToDestructiveMigration()
                        .build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}