package com.openkotlin.jqacoount.data.rsp

import java.util.*

/**
 *
 *  Current name : UserAccountRsp in `JQAcoount`
 *
 *  Created by Tanck on 2019-11-14 12:31.
 *
 *  Note : N/A
 *
 */
data class UserAccountRsp(

    /**
     * id : null
     * cardNumber : null
     * userName : null
     * expireTime : null
     * userPassword : null
     * bindNumber : null
     * tieBindNumber : 0
     * lastLoginTime : 2019-11-13T15:08:50.000+0000
     * gameName : 矫情工作室0x1
     * gameAccount : q422013
     * gamePassword : XXXX
     * gameTeamName : 专业代练俱乐部
     * expired : false
     * online : false
     */

    var id: Any? = null,
    var cardNumber: Any? = null,
    var userName: Any? = null,
    var expireTime: Any? = null,
    var userPassword: Any? = null,
    var bindNumber: Any? = null,
    var tieBindNumber: Int = 0,
    var lastLoginTime: Date? = null,
    var gameName: String? = null,
    var gameAccount: String? = null,
    var gamePassword: String? = null,
    var gameTeamName: String? = null,
    var isExpired: Boolean = false,
    var isOnline: Boolean = false,
    var gameAccountIsBlocked: Boolean = false
)
