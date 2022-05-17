package com.permissionx.caixiaojiadev

import android.content.pm.PackageManager
import androidx.fragment.app.Fragment

/*************************************************************
 * @ProjectName:  PermissionX
 * @Desc:
 * @Author:  Caixiaojia
 * @Date:  2022/5/17
 **************************************************************/

//typealias关键字可以用于给任意类型指定一个别名，比
//如我们将(Boolean, List<String>) -> Unit的别名指定成了PermissionCallback，
//这样就可以使用PermissionCallback来替代之前所有使用(Boolean, List<String>) -
//> Unit的地方，从而让代码变得更加简洁易懂。
typealias PermissionCallback = (Boolean,List<String>) -> Unit

class InvisibleFragment : Fragment() {

    /*
    //定义一个callback变量作为运行时权限申请结果的回调通知方式
    private var callback:((Boolean,List<String>) -> Unit)? = null

    //定义了一个requestNow()方法，该方法接收一个与callback变量类型相同的函数类型
    //参数，同时还使用vararg关键字接收了一个可变长度的permissions参数列表。在
    //requestNow()方法中，我们将传递进来的函数类型参数赋值给callback变量，然后调用
    //Fragment 中提供的requestPermissions()方法去立即申请运行时权限，并将
    //permissions参数列表传递进去，这样就可以实现由外部调用方自主指定要申请哪些权限的功
    //能了。
    fun requestNow(cb:(Boolean,List<String>) -> Unit, vararg permissions:String){
        callback = cb
        requestPermissions(permissions,1)
    }

    //重写onRequestPermissionsResult()方法，并在这里处理运行时权限的申请
    //结果。可以看到，我们使用了一个deniedList列表来记录所有被用户拒绝的权限，然后遍历
    //grantResults数组，如果发现某个权限未被用户授权，就将它添加到deniedList中。遍历
    //结束后使用一个allGranted变量来标识是否所有申请的权限均已被授权，判断的依据就是
    //deniedList列表是否为空。最后使用callback变量对运行时权限的申请结果进行回调
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 1){
            val deniedList = ArrayList<String>()
            for((index,result) in grantResults.withIndex()){
                if(result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val allGranted = deniedList.isEmpty()
            callback?.let { it(allGranted,deniedList) }
        }
    }
    */

    //优化代码
    //定义一个callback变量作为运行时权限申请结果的回调通知方式
    private var callback:(PermissionCallback)? = null

    //定义了一个requestNow()方法，该方法接收一个与callback变量类型相同的函数类型
    //参数，同时还使用vararg关键字接收了一个可变长度的permissions参数列表。在
    //requestNow()方法中，我们将传递进来的函数类型参数赋值给callback变量，然后调用
    //Fragment 中提供的requestPermissions()方法去立即申请运行时权限，并将
    //permissions参数列表传递进去，这样就可以实现由外部调用方自主指定要申请哪些权限的功
    //能了。
    fun requestNow(cb:PermissionCallback, vararg permissions:String){
        callback = cb
        requestPermissions(permissions,1)
    }

    //重写onRequestPermissionsResult()方法，并在这里处理运行时权限的申请
    //结果。可以看到，我们使用了一个deniedList列表来记录所有被用户拒绝的权限，然后遍历
    //grantResults数组，如果发现某个权限未被用户授权，就将它添加到deniedList中。遍历
    //结束后使用一个allGranted变量来标识是否所有申请的权限均已被授权，判断的依据就是
    //deniedList列表是否为空。最后使用callback变量对运行时权限的申请结果进行回调
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(requestCode == 1){
            val deniedList = ArrayList<String>()
            for((index,result) in grantResults.withIndex()){
                if(result != PackageManager.PERMISSION_GRANTED){
                    deniedList.add(permissions[index])
                }
            }
            val allGranted = deniedList.isEmpty()
            callback?.let { it(allGranted,deniedList) }
        }
    }
}


