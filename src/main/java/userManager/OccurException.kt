package userManager

import java.lang.NullPointerException
import java.rmi.AlreadyBoundException
import javax.inject.Singleton
import kotlin.Throws


class OccurException {
    @Singleton
    @Throws
    fun OccurException() : OccurException {
        NullPointerException("Null Value assign Exception")
        AlreadyBoundException("Already Enter user details")
        Exception("Exception Occur")
       return OccurException()
    }
}