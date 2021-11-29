package oop.enum

// Anonymous classes with the abstract function
enum class ProtocolState {
    WAITING {
        override fun signal(): ProtocolState  = WAITING
    },

    TALKING {
        override fun signal(): ProtocolState = TALKING
    };

    abstract fun signal(): ProtocolState
}