package com.example.kotlinPro.member

data class MemberReqDto(
    val username: String,
    val password: String,
    val role: Role?,
    val name: String,
    val email: String,
    val gender: String,
    val age: String,
    val selfIntro: String? = null
) {
    fun toMemberEntity(password: String, role: Role): Member {
        return Member(
            username = username,
            password = password,
            role = role,
            name = name,
            email = email,
            gender = gender,
            age = age,
            selfIntro = selfIntro
        )
    }
}