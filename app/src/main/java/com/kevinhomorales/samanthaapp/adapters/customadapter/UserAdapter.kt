package com.kevinhomorales.samanthaapp.adapters.customadapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.kevinhomorales.samanthaapp.R
import com.kevinhomorales.samanthaapp.databinding.CustomItemRowBinding

class UserAdapter(private val context: Context, private val list: List<CustomUser>) : BaseAdapter() {

    override fun getCount(): Int = list.size

    override fun getItem(index: Int): Any = list[index]

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getView(positon: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View = convertView ?: LayoutInflater.from(context).inflate(R.layout.custom_item_row, parent, false)
        val binding = CustomItemRowBinding.bind(view)
        val user = list[positon]
        binding.nameId.text = user.name
        binding.lastNameId.text = user.lastName
        binding.ageId.text = "${user.age} años"
        binding.coursesId.text = user.courses.joinToString(", ") { it.name }
        binding.teachersId.text = user.courses.joinToString(", ") { it.teacher }
        return view
    }

}