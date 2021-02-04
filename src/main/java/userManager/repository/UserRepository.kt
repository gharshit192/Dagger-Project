package userManager.repository

import userManager.Exception.IllegalTypeException
import userManager.Exception.UserException
import userManager.model.User
import javax.inject.Inject

class UserRepository @Inject constructor() {
   private val userList  : MutableList<User> = mutableListOf()

    fun addUser(user : User): User {
        for (searchUser in userList)
            if (searchUser.email == user.email)
               throw UserException()
        userList.add(user)
    return user
    }

    fun getUser(id: String): User{
        val indexOfUser = userList.indexOfFirst { it.id == id }
            if (indexOfUser == -1)
                throw IllegalTypeException()
        return userList[indexOfUser]
    }

    fun updateUser(id: String,user: User): User {
            val indexOfUser = userList.indexOfFirst { it.id == id }
            if (indexOfUser == -1) {
                throw IllegalTypeException()
            }else {
                user.id = id
                userList.add(indexOfUser, user)
                }
        return user
    }

    fun deleteUser(id: String): User {
        val indexOfUser = userList.indexOfFirst { it.id == id }
        if (indexOfUser == -1) {
                throw IllegalTypeException()
            } else{
                userList.removeAt(indexOfUser)
        }
        return userList[indexOfUser]

    }

}