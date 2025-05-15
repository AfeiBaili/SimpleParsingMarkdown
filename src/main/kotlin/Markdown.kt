class Markdown {
    private val title = Title()
    private val asterisk = Asterisk()
    private val splitLine = SplitLine()
    private val codeSnippet = CodeSnippet()
    private val code = Code()
    private val table = Table()

    fun parsing(line: String): String {
        val string = parsingLines(line)
        if (string.isEmpty()) return ""

        if (!code.isLines && !table.isLines) {
            var str = string
            str = table.matchHeads(str)
            str = title.matchReplace(str)
            str = asterisk.matchReplace(str)
            str = splitLine.matchReplace(str)
            str = codeSnippet.matchReplace(str)
            return str
        }
        return string
    }

    fun parsingText(text: String): String {
        val sb = StringBuilder()
        text.lines().forEach {
            val line: String = parsing(it)
            if (line != "" || it == "") sb.append(line).append('\n')
        }
        return sb.removeSuffix("\n").toString()
    }

    private fun parsingLines(text: String): String {
        if (!code.isLines && !table.isLines) {
            code.isLines = code.matchStart(text)
            table.isLines = table.matchStart(text)

            return if (code.isLines || table.isLines) ""
            else text
        } else {
            if (code.isLines) {
                val result: Result<Boolean, StringBuilder> = code.matchEnd(text)
                if (result.isEnds) {
                    code.isLines = false
                    return result.string.toString()
                }
            }
            if (table.isLines) {
                val result: Result<Boolean, StringBuilder> = table.matchEnd(text)
                if (result.isEnds) {
                    table.isLines = false
                    return result.string.toString()
                }
            }
        }
        return ""
    }
}