package com.zendot.otp.service

import com.zendot.auth.model.ZenUser
import com.zendot.auth.service.TokenProvider
import com.zendot.otp.model.ZenOtpUser
import football.interkashi.dashboard.config.auth.jwt.JwtOtpTokenUtils

class OtpTokenProvider(private val jwtOtpTokenUtils: JwtOtpTokenUtils) : TokenProvider {
    override fun generateToken(user: ZenUser): String {
        val us=user as ZenOtpUser
        return jwtOtpTokenUtils.generateOtpToken(us)
    }
}