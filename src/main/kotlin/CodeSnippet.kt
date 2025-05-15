internal class CodeSnippet : AbstractSyntax() {
    override fun match(text: String): Boolean {
        return "`([^`]+?)`".toRegex().containsMatchIn(text)
    }

    override fun replace(string: String): String {
        return string.replace("`([^`]+?)`".toRegex(), "$1")
    }
}