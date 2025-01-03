package com.zendot.otp.repository


import com.zendot.otp.model.OtpRequest
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OtpRequestRepository : MongoRepository<OtpRequest, String> {

    fun findByPhoneNumberAndActive(phoneNumber: String, active: Boolean): Optional<OtpRequest>
}