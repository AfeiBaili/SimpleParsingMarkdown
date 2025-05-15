internal interface SyntaxLines {
    fun matchStart(text: String): Boolean
    fun matchEnd(text: String): Result<Boolean, StringBuilder>
}