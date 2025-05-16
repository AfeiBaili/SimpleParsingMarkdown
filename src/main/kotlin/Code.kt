internal class Code : SyntaxLines {
    lateinit var language: String
    private val sb = StringBuilder()
    val result = Result(false, sb)

    /**
     * @param isLines 是否在处理代码行
     */
    var isLines = false


    override fun matchStart(text: String): Boolean {
        val matches: Boolean = "^\\s*```[^`]*$".toRegex().matches(text)
        if (!matches) return false
        language = "[^`]*$".toRegex().find(text)?.value ?: "文本"
        sb.clear()
        result.isEnds = false
        sb.append('『').append(language).append('\n')
        return true
    }

    override fun matchEnd(text: String): Result<Boolean, StringBuilder> {
        val matches: Boolean = "^\\s*```.*$".toRegex().matches(text)
        if (!matches) sb.append(text).append('\n')
        else {
            sb.append(language).append('』')
            result.isEnds = true
        }
        return result
    }
}