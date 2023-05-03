package com.example.myapplication.data

import com.example.myapplication.data.model.LoggedInUser
import java.io.IOException
import java.util.*

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 *
 * Attempts to authenticate the user with the given credentials and retrieve their information.
 *
 * @param username The user's username.
 * @param password The user's password.
 * @return A [Result] object containing a [LoggedInUser] object if authentication was successful,
 * or an [IOException] if there was an error communicating with the server.
*/

class LoginDataSource {
    /**
     * Logs the user out of the app by clearing their authentication state and updating the UI.
     *
     * This method should be called when the user manually logs out or when their authentication token
     * expires.
     */
    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            // TODO: handle loggedInUser authentication
            val fakeUser = LoggedInUser(java.util.UUID.randomUUID().toString(), "Jane Doe")
            return Result.Success(fakeUser)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }
    /**
     * Decodes a JWT (JSON Web Token) and returns the payload as a [JsonObject].
     *
     * @param jwt The JWT to decode.
     * @return The payload of the JWT as a [JsonObject].
     */
    fun logout() {
        // TODO: revoke authentication
        fun parseJwtClaims(jwt: String): JsonObject {
            val claims = jwt.split(".")[1]
            val decoded = Base64.decode(claims, Base64.URL_SAFE)
            val json = String(decoded, Charsets.UTF_8)
            return JsonParser.parseString(json).asJsonObject
        }
    }
}