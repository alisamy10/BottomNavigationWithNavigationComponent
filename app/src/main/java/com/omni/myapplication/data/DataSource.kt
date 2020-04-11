package com.omni.myapplication.data

class DataSource {

    companion object {
        fun getdata(): ArrayList<Model> {

            var list = ArrayList<Model>()
           for(i in 1..1000)
            list.add(Model(title = "aaa $i"))


            return list
        }
    }
}