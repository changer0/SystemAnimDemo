package com.lulu.systemanimdemo.test

/**
 * @author zhanglulu on 2019/11/22.
 * for
 */

/**
 * object声明一个类时，该类自动成为一个简单的单例模式
 * object声明的类，无法在外部用new的方式重新实例化
 */
object Utils {
    /**
     * 获取资源Id
     */
    fun getResIdByString(idStr: String, c: Class<*>): Int{
        val idField = c.getDeclaredField(idStr)
        return idField.getInt(idField)
    }
}

