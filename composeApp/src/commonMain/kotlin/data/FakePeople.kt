package data

import model.People
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.category1
import travelbuddy.composeapp.generated.resources.category2
import travelbuddy.composeapp.generated.resources.category3
import travelbuddy.composeapp.generated.resources.category4
import travelbuddy.composeapp.generated.resources.star

object FakePeople {

    val peoples = arrayListOf<People>().apply {
        add(People(0, "Всі", Res.drawable.star))
        add(People(1, "На одного", Res.drawable.category1))
        add(People(2, "На двох", Res.drawable.category2))
        add(People(3, "На трьох", Res.drawable.category3))
        add(People(4, "На чотирьох", Res.drawable.category4))
    }

}
