internal abstract class AbstractSyntax : Syntax {
    fun matchReplace(text: String): String {
        return if (match(text)) replace(text) else text
    }
}