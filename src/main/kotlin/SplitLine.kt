internal class SplitLine : AbstractSyntax() {
    override fun match(text: String): Boolean {
        return "^---\\s*".toRegex().matches(text)
    }

    override fun replace(string: String): String {
        return string.replace("^---(\\s*)".toRegex(), "$1")
    }
}