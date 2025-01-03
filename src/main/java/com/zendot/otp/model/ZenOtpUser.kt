package com.zendot.otp.model

import com.zendot.auth.model.ZenUser


data class ZenOtpUser(
    override val id: String,
    val phoneNo: String,
    val appHash: String,
    val username: String
) : ZenUser