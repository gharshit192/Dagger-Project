package userManager.resource

import com.fasterxml.jackson.databind.ObjectMapper
import userManager.OccurException
import userManager.model.User
import userManager.service.UserService
import java.lang.Exception
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("user/v1")
class UserResources @Inject constructor(
    private val userService: UserService,
    private var objectMapper :  ObjectMapper
) {

    @GET
    @Path("/status")
    @Produces(MediaType.TEXT_PLAIN)
    fun status(): Response {
        return Response.status(Response.Status.OK).entity("Status of the User").build()
    }
    @POST
    @Path("/user")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun addUser(request : String): Response {
        val user = userService.addUser(objectMapper.readValue(request, User::class.java))
            return Response.ok(user).build()
    }
    @GET
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun getUser(@PathParam("id") id: String): Response{
        val user = userService.getUser(id)
        return Response.ok(user).build()

    }
    @PUT
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    fun updateUser(@PathParam("id") id : String,request: String) : Response{
        val user = userService.updateUser(id,objectMapper.readValue(request, User::class.java))
        return Response.ok(user.toString()).build()
    }
    @DELETE
    @Path("/user/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun deleteUser(@PathParam("id") id: String) : Response{
        val user = userService.deleteUser(id)
        return Response.ok(user.toString()).build()
    }
}