package com.example.smartwindowsapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.NumberPicker
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_smart.*

class SmartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_smart, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var temp = 0
        val unit = arrayOf("°C", "°F")
        var cOrF = "°C"
        // Temperature Selection
        temp_input.minValue = 15
        temp_input.maxValue = 30
        temp_unit.displayedValues = unit
        temp_unit.minValue = 0
        temp_unit.maxValue = unit.size-1
        temp_input.setOnValueChangedListener { numberPicker, oldVal, newVal ->
            temp = newVal
            desired_temp_text.text = temp.toString()
            desired_temp_text.append(cOrF)
        }

        temp_unit.setOnValueChangedListener { numberPicker, oldVal, newVal ->
            if (temp_unit.value == 0)
            {
                temp_input.minValue = 15
                temp_input.maxValue = 30
            }
            if (temp_unit.value == 1)
            {
                temp_input.minValue = 59
                temp_input.maxValue = 86
            }
            cOrF = unit[newVal]
            desired_temp_text.text = temp.toString()
            desired_temp_text.append(cOrF)
        }
    }
}