package data

import model.Destination

object FakeDestinations {
    val destinations = arrayListOf<Destination>().apply {
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Індонезійська гора",
                description = "Велична гора Рінжані на острові Ломбок — це великий вулкан, що піднімається над островом Ломбок. Підйом на вершину — це один з найзахоплюючих досвідів, які ви можете отримати в Індонезії. Висота гори Рінжані становить 3,726 метрів, що робить її другою за висотою горою в Індонезії...",
                rating = 4.3f,
                location = "Ломбок, Індонезія",
                price = "$48",
                type = "Людина",
                category = FakeCategories.categories[0],
                image = FakeImages.randomImageUrls(6),
                dates = arrayListOf(
                    "20 грудня - 24 грудня 2024"
                ),
                meetingPoints = arrayListOf("Серанг", "Баранг", "Манчестер", "Фоліо"),
                facilities = arrayListOf(
                    "Транспорт",
                    "Сімаксі",
                    "Кава-брейк",
                    "Їжа під час трекінгу",
                    "Намет для кемпінгу",
                    "П3К",
                    "Офіційно визнаний гірський гід",
                    "Гід під час трекінгу",
                    "Фоліо"
                ),
                via = "На одного",
                estimation = "1 тиждень",
                people = FakePeople.peoples[0],
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Гора Бромо",
                description = "Велична гора Рінжані на острові Ломбок — це великий вулкан, що піднімається над островом Ломбок. Підйом на вершину — це один з найзахоплюючих досвідів, які ви можете отримати в Індонезії. Висота гори Рінжані становить 3,726 метрів, що робить її другою за висотою горою в Індонезії...",
                rating = 4.0f,
                location = "Бромо, Індонезія",
                price = "$30",
                type = "Людина",
                category = FakeCategories.categories[1],
                image = FakeImages.randomImageUrls(5),
                dates = arrayListOf(
                    "20 грудня - 24 грудня 2024",
                    "25 грудня - 26 грудня 2024",
                    "27 грудня - 30 грудня 2024"
                ),
                meetingPoints = arrayListOf("Серанг", "Баранг", "Манчестер", "Фоліо"),
                facilities = arrayListOf(
                    "Транспорт",
                    "Сімаксі",
                    "Кава-брейк",
                    "Їжа під час трекінгу",
                    "Намет для кемпінгу",
                    "П3К",
                    "Офіційно визнаний гірський гід",
                    "Гід під час трекінгу",
                    "Фоліо"
                ),
                via = "На двох",
                estimation = "1 тиждень",
                people = FakePeople.peoples[0],
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Гора Ломбок",
                description = "Велична гора Рінжані на острові Ломбок — це великий вулкан, що піднімається над островом Ломбок. Підйом на вершину — це один з найзахоплюючих досвідів, які ви можете отримати в Індонезії. Висота гори Рінжані становить 3,726 метрів, що робить її другою за висотою горою в Індонезії...",
                rating = 3.7f,
                location = "Ломбок, Індонезія",
                price = "$30",
                type = "Людина",
                category = FakeCategories.categories[2],
                image = FakeImages.randomImageUrls(3),
                dates = arrayListOf(
                    "20 грудня - 24 грудня 2024",
                    "25 грудня - 26 грудня 2024",
                    "27 грудня - 30 грудня 2024"
                ),
                meetingPoints = arrayListOf("Серанг", "Баранг", "Манчестер", "Фоліо"),
                facilities = arrayListOf(
                    "Транспорт",
                    "Сімаксі",
                    "Кава-брейк",
                    "Їжа під час трекінгу",
                    "Намет для кемпінгу",
                    "П3К",
                    "Офіційно визнаний гірський гід",
                    "Гід під час трекінгу",
                    "Фоліо"
                ),
                via = "На трьох",
                estimation = "1 тиждень",
                people = FakePeople.peoples[1],
            )
        )
        add(
            Destination(
                id = 1,
                thumbnail = FakeImages.randomThumbnailUrl(),
                title = "Гора Рінжані",
                description = "Велична гора Рінжані на острові Ломбок — це великий вулкан, що піднімається над островом Ломбок. Підйом на вершину — це один з найзахоплюючих досвідів, які ви можете отримати в Індонезії. Висота гори Рінжані становить 3,726 метрів, що робить її другою за висотою горою в Індонезії...",
                rating = 2.7f,
                location = "Рінжані, Індонезія",
                price = "$18",
                type = "Людина",
                category = FakeCategories.categories[3],
                image = FakeImages.randomImageUrls(),
                dates = arrayListOf(
                    "20 грудня - 24 грудня 2024",
                    "25 грудня - 26 грудня 2024",
                    "27 грудня - 30 грудня 2024"
                ),
                meetingPoints = arrayListOf("Серанг", "Баранг", "Манчестер", "Фоліо"),
                facilities = arrayListOf(
                    "Транспорт",
                    "Сімаксі",
                    "Кава-брейк",
                    "Їжа під час трекінгу",
                    "Намет для кемпінгу",
                    "П3К",
                    "Офіційно визнаний гірський гід",
                    "Гід під час трекінгу",
                    "Фоліо"
                ),
                via = "На чотирьох",
                estimation = "1 день",
                people = FakePeople.peoples[2],
            )
        )

    }
}