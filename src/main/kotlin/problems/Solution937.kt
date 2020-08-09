package problems

fun reorderLogFiles(logs: Array<String>): Array<String> {
    return logs.map {
        val split = it.split(" ", limit = 2)
        Log(split[0], split[1])
    }.sorted().map { it.toString() }.toTypedArray()
}

data class Log(val id: String, val msg: String) : Comparable<Log> {

    private val isDigit = msg[0].isDigit()

    override fun toString(): String {
        return "$id $msg"
    }

    override fun compareTo(other: Log): Int {
        if (isDigit && other.isDigit) {
            return 0
        }
        if (isDigit) return 1
        if (other.isDigit) return -1
        val compareMsg = compareValues(msg, other.msg)
        if (compareMsg == 0) return compareValues(id, other.id)
        return compareMsg
    }
}
