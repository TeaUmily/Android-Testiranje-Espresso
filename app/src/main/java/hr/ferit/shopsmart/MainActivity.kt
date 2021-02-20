package hr.ferit.shopsmart

import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val itemList = mutableListOf<Item>()
    var total: Int = 0
    var limitAvailableAmount: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        populateList()
        setLimitInputListener()
        setItemsListeners()
    }

    private fun populateList() {
        itemList.addAll(listOf(
            Item(ItemTypes.BACKPACK, rlBackpack, cbBackPack),
            Item(ItemTypes.PANTS, rlPants, cbPants),
            Item(ItemTypes.SHIRT, rlShirt, cbShirt),
            Item(ItemTypes.BALL, rlBall, cbBall),
            Item(ItemTypes.PIANO, rlPiano, cbPiano),
            Item(ItemTypes.CAR, rlCar, cbCar)))
    }

    private fun setItemsListeners() {
        itemList.forEach { item ->
            item.checkBox.setOnClickListener {
                if(item.isChecked) {
                    limitAvailableAmount += item.type.price
                    total -= item.type.price
                    item.isChecked = false
                    setItemsTotal()
                    updateItems(item)
                } else {
                    limitAvailableAmount -= item.type.price
                    total += item.type.price
                    item.isChecked = true
                    setItemsTotal()
                    updateItems(item)
                }
            }
        }
    }

    private fun setItemsTotal() {
        tvTotal.text = total.toString()
    }

    private fun setLimitInputListener() {
        etLimit.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                hideKeyboard()
                etLimit.clearFocus()
                var limit = etLimit.text.toString()
                total = 0
                setItemsTotal()
                if(limit.isEmpty()) {
                    limit = 0.toString()
                }

                limitAvailableAmount = limit.toInt()
                resetItems(limit.toInt())

                return@OnEditorActionListener true
            }
            false
        })
    }

   private fun hideKeyboard() {
        val imm: InputMethodManager = this.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(content.windowToken, 0)
    }

    private fun resetItems(limit: Int) {
        itemList.forEach {
            if(limit >= it.type.price) {
                enableItem(it)
            } else {
              disableItem(it)
            }
        }
    }

    private fun enableItem(item: Item) {
        item.isEnabled = true
        item.viewContainer.alpha = 1F
        item.checkBox.isEnabled = true
        item.checkBox.isChecked = false
        item.isChecked = false
    }

    private fun disableItem(item: Item) {
        item.isEnabled = false
        item.viewContainer.alpha = 0.5F
        item.checkBox.isEnabled = false
        item.checkBox.isChecked = false
    }

    private fun updateItems(item: Item) {
        var filteredItems = listOf<Item>()
        filteredItems = if(item.isChecked) {
            itemList.filter { !it.isChecked && it.isEnabled }
        } else {
            itemList.filter { !it.isChecked && !it.isEnabled }
        }

        filteredItems.forEach {
            if(limitAvailableAmount >= it.type.price) {
                enableItem(it)
            } else {
                disableItem(it)
            }
        }
    }
}