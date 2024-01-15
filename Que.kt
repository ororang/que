package com.study

class que{
    val queSize = 50
    var qued = arrayOfNulls<String>(queSize)
    var front = 0
    var rear = -1
    var itemcount = 0

    fun isfull(): Boolean{
        if(itemcount == queSize ){
            return true
        }else{
            return false
        }
    }
    fun isEmpty():Boolean{
        return itemcount == 0
    }
    fun delete(): String? {
        var data: String? = qued[front++]
        if(front == queSize){
            front = 0
        }
        itemcount --
        return data
    }

    fun insert(data:String){
        if(isfull() == false){
            if(rear == queSize-1){
                rear = -1
            }

            rear++
            qued[rear] = data
            itemcount++
        }

    }


    override fun toString(): String {
        val validElements = qued.sliceArray(front..rear)
        return validElements.contentToString()
    }

}

fun main(){
    var quee = que()
    with(quee){
        for (i in 1..80){
            quee.insert(i.toString())
        }
        delete()

        println(quee)
    }




}
