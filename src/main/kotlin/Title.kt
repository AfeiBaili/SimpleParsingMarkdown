internal class Title : AbstractSyntax() {
    override fun match(text: String): Boolean {
        return "^#{1,6}\\s*.*".toRegex().matches(text)
    }

    override fun replace(string: String): String {
        return "${string.replace("^#{1,6}\\s*(.*)".toRegex(), "$1").trim()}\n"
    }
}