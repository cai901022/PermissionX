package com.permissionx.caixiaojiadev

import androidx.fragment.app.FragmentActivity

/*************************************************************
 * @ProjectName:  PermissionX
 * @Desc:
 * @Author:  Caixiaojia
 * @Date:  2022/5/17
 **************************************************************/
object PermissionX {

    private const val TAG = "InvisibleFragment"

    //我们在Per missionX 中定义了一个request()方法，这个方法接收一个
    //FragmentActivity参数、一个可变长度的permissions参数列表，以及一个callback回
    //调。其中， FragmentActivity是AppCompatActivity的父类


    fun request(activity:FragmentActivity,vararg permissions:String,callback:PermissionCallback){
        val fragmentManager = activity.supportFragmentManager
        val existedFragment = fragmentManager.findFragmentByTag(TAG)
        val fragment = if(existedFragment !=null){
            existedFragment as InvisibleFragment
        } else {
            val invisibleFragment = InvisibleFragment()
            fragmentManager.beginTransaction().add(invisibleFragment,TAG).commitNow()
            invisibleFragment
        }
        fragment.requestNow(callback,*permissions)  //在permissions参数的前面加上了一个*，这个符号并不是指针的意思，而是表示将一个 数组转换成可变长度参数传递过去
    }
}