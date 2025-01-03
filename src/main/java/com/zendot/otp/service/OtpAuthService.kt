package com.zendot.otp.service

import com.zendot.auth.model.ZenUser
import com.zendot.auth.service.AuthService
import com.zendot.otp.model.ZenOtpUser

class OtpAuthService(private val otpServiceV2: OtpServiceV2) : AuthService {
    override fun findUserOrCreate(credentials: Map<String, Any>): ZenUser {
        val phoneNo = credentials["phoneNo"] as? String
        requireNotNull(phoneNo) { "Phone number must be provided" }  // Optional: Ensure it's not null
        return otpServiceV2.findOrCreate(phoneNo) as ZenOtpUser
    }
}