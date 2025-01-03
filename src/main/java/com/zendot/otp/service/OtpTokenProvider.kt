package com.zendot.otp.service

import com.zendot.auth.model.ZenUser
import com.zendot.auth.service.TokenProvider
import com.zendot.config.jwt.JwtOtpTokenUtils
import com.zendot.otp.model.ZenOtpUser
import org.springframework.stereotype.Component

@Component
class OtpTokenProvider(private val jwtOtpTokenUtils: JwtOtpTokenUtils) : TokenProvider {
    override fun generateToken(user: ZenUser): String {
        val us=user as ZenOtpUser
        return jwtOtpTokenUtils.generateOtpToken(us)
    }
}