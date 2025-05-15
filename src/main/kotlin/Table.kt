internal class Table : SyntaxLines {
    private val sb = StringBuilder()
    val result = Result(false, sb)
    val heads = ArrayList<String>()
    var lastLine = ""

    /**
     * @param isLines 是否在处理表格行
     */
    var isLines = false

    fun matchHeads(text: String): String {
        if ("(?<!.)\\|(\\s*(.*)\\s*\\|)+(?!.)".toRegex().matches(text)) return ""
        return text
    }

    override fun matchStart(text: String): Boolean {
        val matches: Boolean = "\\|(:?-+:?\\|)+".toRegex().matches(text)
        if (!matches) {
            lastLine = text
            return false
        }
        sb.clear()

        "(?<=\\|)\\s*([^|]*?)\\s*(?=\\|)"
            .toRegex()
            .findAll(lastLine)
            .forEach { heads.add(it.groupValues[1]) }

        result.isEnds = false
        return true
    }

    override fun matchEnd(text: String): Result<Boolean, StringBuilder> {
        val findAll: Sequence<MatchResult> = "(?<=\\|)\\s*([^|]*?)\\s*(?=\\|)"
            .toRegex()
            .findAll(text)
        val findAllList = findAll.toList()
        if (findAllList.size != heads.size) return result.also { it.isEnds = true }

        for (index in 0 until heads.size) {
            sb.append(heads[index]).append(": ").append(findAllList[index].groupValues[1]).append("  ")
        }
        sb.append('\n')

        return result
    }
}