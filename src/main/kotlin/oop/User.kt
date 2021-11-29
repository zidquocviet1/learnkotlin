package oop

// Data class cannot be abstract, open, inner, sealed
data class User(var username: String, var password: String) {
    override fun hashCode(): Int {
        return 31 * username.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (username != other.username) return false
        if (password != other.password) return false

        return true
    }
}