internal interface Syntax {
    fun match(text: String): Boolean
    fun replace(string: String): String
}