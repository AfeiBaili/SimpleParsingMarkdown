internal class Asterisk : AbstractSyntax() {
    override fun match(text: String): Boolean {
        return "(\\*{1,3})([^*]+?)\\1".toRegex().containsMatchIn(text)
    }

    override fun replace(string: String): String {
        return string.replace("(\\*{1,3})([^*]+?)\\1".toRegex(), "「$2」")
    }
}