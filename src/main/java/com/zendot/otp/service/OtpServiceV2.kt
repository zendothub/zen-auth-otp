package com.zendot.otp.service

import com.zendot.otp.model.ZenOtpUser

interface OtpServiceV2 {
    fun findOrCreate(phoneNo:String): ZenOtpUser?
}