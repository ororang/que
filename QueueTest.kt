package com.study

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class QueueTest {

    val queue = Queue()

    @Test
    fun poll() {
        offer()
        assertEquals("1",queue.poll())
        for(i in 2 ..50){
            queue.poll()
        }
        assertNull(queue.poll())
        assertEquals("",queue.toString())
    }

    @Test
    fun offer() {
        queue.offer("1")
        queue.offer("2")
        queue.offer("3")
        assertEquals("1,2,3",queue.toString())
        for(i in 4..50){
            queue.offer(i.toString())
        }
        assertFalse(queue.offer("51"))
    }

    @Test
    fun offerAndPoll(){
        offer()
        queue.poll()
        queue.poll()
        queue.poll()
        queue.poll()
        queue.poll()
        queue.offer("51")
        queue.offer("52")
        queue.offer("53")
        assertEquals((6..53).toList().joinToString(","),queue.toString())
    }
}