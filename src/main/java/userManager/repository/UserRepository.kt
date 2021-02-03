package userManager.repository

import userManager.model.User
import java.lang.Exception
import javax.inject.Inject
import javax.ws.rs.NotFoundException

class UserRepository @Inject constructor() {

    companion object {
        var userList  : MutableList<User> = mutableListOf()
    }

    fun addUser(user : User): User {
        try {
            for (searchUser in userList)
                if (searchUser.email == user.email)
                   throw Exception("User email already exist")
            userList.add(user)
        }catch (e : Exception ){
            println(e)
        }
        return user
    }

    fun getUser(id: String): String {
        val indexOfUser = userList.indexOfFirst { it.id == id }
        try {
            if (indexOfUser == -1)
                throw  Exception("User not found with $id")
        }catch (e : Exception){
            println(e)
        }
        return id
    }

    fun updateUser(id: String,user: User): User {
        try {
            val indexOfUser = userList.indexOfFirst { it.id == id }
            if (indexOfUser == -1) {
                throw Exception("User not found at $id")
            }else {
                user.id = id
                userList.remove(id)
                userList.add(indexOfUser, user)
            }
        }catch (e:Exception){
            println(e)
        }
        return user
    }

    fun deleteUser(id: String): User {
        val indexOfUser = userList.indexOfFirst { it.id == id }
        try {
            if (indexOfUser == -1) {
                throw Exception("User not found at $id")
            } else
                userList.removeAt(indexOfUser)
        }catch (e : Exception){
            println(e)
        }
        return userList[indexOfUser]
    }

}