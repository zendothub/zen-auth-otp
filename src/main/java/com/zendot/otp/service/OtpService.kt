package com.zendot.otp.service

import com.zendot.otp.model.OtpRequest
import com.zendot.otp.model.ZenOtpUser

interface OtpService {
    fun sendOtp(phoneNumber: String, apphash: String)

    fun resendOtp(phoneNumber: String)

    fun verifyOtp(phoneNumber: String, otp: String): ZenOtpUser?

    fun save(otpRequest: OtpRequest): OtpRequest
}