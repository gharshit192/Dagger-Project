package userManager.Exception
import java.lang.IllegalArgumentException
import javax.ws.rs.core.Response
import javax.ws.rs.ext.ExceptionMapper
import javax.ws.rs.ext.Provider

@Provider
class ExceptionMapper : ExceptionMapper<IllegalException> {
    override fun toResponse(exception: IllegalException): Response {

    when (exception) {
        is IllegalTypeException -> return Response.ok(200).entity("Invalid id or id not found").build()
        is UserException -> return Response.ok(200).entity("User already entered").build()
    }
    return Response.ok(200).entity("EXCEPTION Not FOUND").build()
    }
}
