package userManager.service

import userManager.model.User
import userManager.repository.UserRepository
//import userManager.repository.UserRepository
import java.util.HashSet
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserService @Inject constructor(private val userRepository: UserRepository)
{


    fun addUser(user: User): User {
        if (user.name == null || user.email == null)
            throw NullPointerException("Please Enter Name")
        return userRepository.addUser(user)
    }

    fun getUser(id : String): String {
        if (id.isBlank())
            throw NullPointerException("Please Enter valid id")
        return userRepository.getUser(id)
    }

    fun updateUser(id: String,user: User): User {
        if (id.isBlank())
            throw NullPointerException("Please Enter valid id")
        return userRepository.updateUser(id,user)
    }

    fun deleteUser(id: String): User {
        if (id.isBlank())
            throw NullPointerException("Please Enter valid id")
        return userRepository.deleteUser(id)
    }


}