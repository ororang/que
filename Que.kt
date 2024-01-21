package com.study

class Queue {
    val queSize = 50
    var qued = arrayOfNulls<String>(queSize)
    var front = 0
    var rear = -1
    var itemCount = 0

    fun isFull() = itemCount == queSize
    fun isEmpty() = itemCount == 0

    fun poll(): String? =
        if (isEmpty()) {
            null
        } else {
            var data: String? = qued[front++]
            if (front == queSize) {
                front = 0
            }
            itemCount--
            data
        }

    fun offer(data: String): Boolean =
        if (isFull()) {
            false
        } else {
            if (rear == queSize - 1) {
                rear = 0
            } else {
                rear++
            }
            qued[rear] = data
            itemCount++
            true
        }

    override fun toString(): String {
        if (itemCount == 0) {
            return ""
        }
        val validElements = if (front <= rear) {
            qued.sliceArray(front..rear)
        } else {
            qued.sliceArray(front until queSize) + qued.sliceArray(0..rear)
        }
        return validElements.joinToString(",")
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val quee = Queue()
            with(quee) {
                for (i in 1..80) {
                    quee.offer(i.toString())
                }
                val polledValue = quee.poll()
                println("Polled value: $polledValue")
                println(quee)
            }
        }
    }
}
