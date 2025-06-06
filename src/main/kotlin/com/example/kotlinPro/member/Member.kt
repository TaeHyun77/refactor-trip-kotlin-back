package com.example.kotlinPro.member

import com.example.kotlinPro.BaseTime
import com.example.kotlinPro.follow.Follow
import com.example.kotlinPro.message.Message
import com.example.kotlinPro.post.Post
import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EntityListeners
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import org.springframework.data.jpa.domain.support.AuditingEntityListener

@EntityListeners(AuditingEntityListener::class)
@Entity
class Member (

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column
    var username: String,

    @Column
    val password: String,

    @Enumerated(EnumType.STRING)
    @Column
    var role: Role,

    @Column(nullable = false, unique = true)
    var name: String,

    @Column(nullable = false, unique = true)
    var email: String,

    @Column
    var gender: String,

    @Column
    var age: String,

    @Column
    var selfIntro: String?,

    @Column
    var profileImage: String? = null,

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val posts: MutableList<Post>? = null,

    @OneToMany(mappedBy = "following", cascade = [CascadeType.ALL], orphanRemoval = true)
    val followers: MutableList<Follow> = mutableListOf(),

    @OneToMany(mappedBy = "follower", cascade = [CascadeType.ALL], orphanRemoval = true)
    val followings: MutableList<Follow> = mutableListOf(),

    @OneToMany(mappedBy = "member", cascade = [CascadeType.ALL], orphanRemoval = true)
    val messageList: List<Message> = ArrayList()

    ): BaseTime() {

    fun updateMember(name: String, email: String, gender: String, age: String, selfIntro: String) {
        this.name = name
        this.email = email
        this.gender = gender
        this.age = age
        this.selfIntro = selfIntro
    }
}