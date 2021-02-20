package hr.ferit.shopsmart

import android.view.View
import android.widget.CheckBox

data class Item(val type: ItemTypes,
                val viewContainer: View,
                val checkBox: CheckBox,
                var isChecked: Boolean = false,
                var isEnabled: Boolean = false)