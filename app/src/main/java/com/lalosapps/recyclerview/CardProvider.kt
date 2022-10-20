package com.lalosapps.recyclerview

object CardProvider {

    val cards = mutableListOf(
        CardItem(
            1,
            "Title 1",
            "Description 1",
            false
        ),
        CardItem(
            2,
            "Title 2",
            "Description 2",
            false
        ),
        CardItem(
            3,
            "Title 3",
            "Description 3",
            false
        ),
        CardItem(
            4,
            "Title 4",
            "Description 4",
            false
        ),
        CardItem(
            5,
            "Title 5",
            "Description 5",
            false
        ),
        CardItem(
            6,
            "Title 6",
            "Description 6",
            false
        ),
        CardItem(
            7,
            "Title 7",
            "Description 7",
            false
        ),
        CardItem(
            8,
            "Title 8",
            "Description 8",
            false
        ),
        CardItem(
            9,
            "Title 9",
            "Description 9",
            false
        ),
        CardItem(
            10,
            "Title 10",
            "Description 10",
            false
        )
    )

    fun toggleFavorite(card: CardItem): Pair<Int, CardItem> {
        val index = cards.indexOf(card)
        val updatedCard = card.copy(favorite = !card.favorite)
        cards[index] = updatedCard
        return index to updatedCard
    }

    fun deleteCard(card: CardItem): Int {
        val index = cards.indexOf(card)
        cards.remove(card)
        return index
    }
}