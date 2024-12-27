package data

import model.Category
import travelbuddy.composeapp.generated.resources.Res
import travelbuddy.composeapp.generated.resources.category1
import travelbuddy.composeapp.generated.resources.category2
import travelbuddy.composeapp.generated.resources.category3
import travelbuddy.composeapp.generated.resources.category4
import travelbuddy.composeapp.generated.resources.star

object FakeCategories {

    val categories = arrayListOf<Category>().apply {
        add(Category(0, "Всі", Res.drawable.star))
        add(Category(1, "Гори", Res.drawable.category1))
        add(Category(2, "Водоспад", Res.drawable.category2))
        add(Category(3, "Ріки", Res.drawable.category3))
        add(Category(4, "Озера", Res.drawable.category4))
    }

}
