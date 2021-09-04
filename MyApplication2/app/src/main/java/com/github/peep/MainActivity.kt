package com.github.peep

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.navigation.NavOptions
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.github.peep.DB.UserDB
import com.github.peep.databinding.ActivityMainBinding

//메인 쓰레드에서 Romm DB에 접근하려고 하면 에러가 발생
//Cannot access database on the main thread since it may potentially lock the UI for a long period of time.
//따라서 Room과 관련된 액션은 Thread, AsyncTask 등을 이용해 백그라운드에서 작업해야 한다.

//CollectionActivity Room db와 RecyclerView를 성공적으로 연결하더라도, 아직 추가한 데이터가 없으므로
//RecyclerView에는 아무 정보도 표시되지 않는다. AddActivity를 만들어 데이터 추가가 가능하도록 해주자
class MainActivity : AppCompatActivity(){
    private lateinit var mBinding : ActivityMainBinding

    //나중에 값이 설정될거라고 lateinit으로 설정
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        mBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        //네비게이션을 담는 호스트
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.my_nav_host) as NavHostFragment

        // 네비게이션 컨트롤러
        val navController = navHostFragment.navController

        //바텀 네비게이션뷰와 네비게이션 뷰를 묶어준다.
        NavigationUI.setupWithNavController(mBinding.myBottomNav, navController)

//        supportFragmentManager.commit{
//            setCustomAnimations(R.anim.nav_default_enter_anim, R.anim.nav_default_exit_anim,
//                        R.anim.nav_default_pop_enter_anim, R.anim.nav_default_pop_exit_anim)
//            addToBackStack(null)
////            replace(R.id.nav_host_fragment_container, navHostFragment.onContextItemSelected)
////            addToBackStack(null)
//        }

//        val animationOptions = NavOptions.Builder().setEnterAnim(R.anim.nav_enter_anim)
//            .setExitAnim(R.anim.nav_exit_anim)
//            .setPopEnterAnim(R.anim.nav_pop_enter_anim)
//            .setPopExitAnim(R.anim.nav_pop_exit_anim).build()
//
//        findNavController().navigate(MyFragmentDirections.toMainActivity(), animationOptions)
    }

}