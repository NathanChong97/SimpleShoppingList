package com.example.simpleshoppinglist

import com.example.simpleshoppinglist.data.database.entity.ShoppingItem

interface ShoppingItemDialogListener {

    fun onAddButtonClicked(item: ShoppingItem)
}