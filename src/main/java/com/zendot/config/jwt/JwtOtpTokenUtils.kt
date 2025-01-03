package com.zendot.config.jwt

import com.zendot.otp.model.ZenOtpUser
import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jws
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.Instant
import java.util.*
import javax.crypto.spec.SecretKeySpec
import io.jsonwebtoken.Jwts



@Component
class JwtOtpTokenUtils(
    @Value("\${interkashi.jwt.lifetime}") val jwtLifeDuration: Long,
    @Value("\${interkashi.refreshToken.lifetime}") val refreshTokenLifeDuration: Long,
    @Value("\${interkashi.jwt.secret}") val secretKey: String,
    @Value("\${interkashi.refreshToken.secret}") val refreshTokenSecretKey: String

) {

    fun generateOtpToken(user: ZenOtpUser): String = Jwts.builder()
        .claim("phoneNo", user.phoneNo)
        .claim("authType","otp")
        .subject(user.id)
        .id(UUID.randomUUID().toString())
        .issuedAt(Date())
        .expiration(Date.from(Instant.now().plusSeconds(jwtLifeDuration)))
        .signWith(getOtpKey())
        .compact()

    fun generateRefreshOtpToken(user: ZenOtpUser): String = Jwts.builder()
        .claim("type", "Refresh Token")
        .subject(user.id)
        .id(UUID.randomUUID().toString())
        .issuedAt(Date())
        .expiration(Date.from(Instant.now().plusSeconds(refreshTokenLifeDuration)))
        .signWith(getRefreshOtpTokenKey())
        .compact()

    fun getOtpKey() = SecretKeySpec(
        Base64.getDecoder().decode(secretKey),
        "HmacSHA256"
    )

    fun parseOtpToken(jwtString: String): Jws<Claims> {
        return Jwts.parser()
            .verifyWith(getOtpKey())
            .build()
            .parseSignedClaims(jwtString)
    }

    fun parseRefreshOtpToken(jwtString: String): Jws<Claims> {
        return Jwts.parser()
            .verifyWith(getRefreshOtpTokenKey())
            .build()
            .parseSignedClaims(jwtString)
    }

    private fun getRefreshOtpTokenKey() = SecretKeySpec(
        Base64.getDecoder().decode(refreshTokenSecretKey),
        "HmacSHA256"
    )
}