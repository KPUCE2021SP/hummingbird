package com.github.peep.DB

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

//database 안에 있는 테이블을 java나 kotlin 클래스로 나타낸 것이다. 데이터 모델 클래스 라고 볼 수 있다.
//Entity를 import해서 Entity로 선언된 클래스를 만들 수 있다. 데이터 모델인 'user'에 무엇이 들어갈지 정의
//각각의 entity는 고유 식별자인 기본키가 필요. 큰 의미가 없다면 autoGenerate를 이용해 자동으로 생성되게 하는 것도 가능

//@Entity
//class cat(@PrimaryKey(autoGenerate = true) var id: Long?,
//...
//)

//prymarykey id -> auto (long)
//token -> github_token (string)
//name -> github_nickname (string)
//happyPeep_count (Int)
//sadPeep_count (Int)

@Entity(tableName = "user")
class User (
    @PrimaryKey(autoGenerate = true) var id : Long?,
    @ColumnInfo(name ="git_token") var git_Token : String?,
    @ColumnInfo(name ="git_name") var git_Name : String?,
    @ColumnInfo(name ="happy_peep") var happy_Peep : Int,
    @ColumnInfo(name ="sad_peep") var sad_Peep : Int
){
    constructor() : this(null,"","",0,0)
}