package com.zendot.otp.model

import com.zendot.auth.model.ZenUser


open class ZenOtpUser(
    override val id: String?=null,
    open val phoneNo: String?=null,
) : ZenUser
