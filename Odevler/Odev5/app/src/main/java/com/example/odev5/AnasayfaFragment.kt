package com.example.odev5

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.odev5.databinding.FragmentAnasayfaBinding

class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private var currentInput = "0"
    private var firstNumber = ""
    private var secondNumber = ""
    private var currentOperator: String? = null
    private var isResultDisplayed = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        setupNumberButtons()

        binding.buttonToplama.setOnClickListener { setOperator("+") }
        binding.buttonEsittir.setOnClickListener { calculate() }
        binding.buttonSifirla.setOnClickListener { clearAll() }
        binding.imageButton.setOnClickListener { handleBackspace() } // Backspace butonu eklendi
        binding.imageButton.setOnLongClickListener {
            clearAll()
            true
        }

        return binding.root
    }

    // Backspace işlevi
    private fun handleBackspace() {
        if (isResultDisplayed) {
            clearAll()
            return
        }

        if (currentOperator == null) {
            if (firstNumber.isNotEmpty()) {
                firstNumber = firstNumber.dropLast(1)
                currentInput = if (firstNumber.isEmpty()) "0" else firstNumber
            }
        } else {
            if (secondNumber.isNotEmpty()) {
                secondNumber = secondNumber.dropLast(1)
                currentInput = "$firstNumber $currentOperator $secondNumber"
            } else {
                // Operatörü silmek istiyorsa
                currentOperator = null
                currentInput = firstNumber
            }
        }
        updateDisplay()
    }

    private fun setupNumberButtons() {
        val numberButtons = listOf(
            binding.buttonRakam1 to "1",
            binding.buttonRakam2 to "2",
            binding.buttonRakam3 to "3",
            binding.buttonRakam4 to "4",
            binding.buttonRakam5 to "5",
            binding.buttonRakam6 to "6",
            binding.buttonRakam7 to "7",
            binding.buttonRakam8 to "8",
            binding.buttonRakam9 to "9",
            binding.buttonSifir to "0"
        )

        numberButtons.forEach { (button, number) ->
            button?.setOnClickListener { appendNumber(number) }
        }
    }

    private fun appendNumber(number: String) {
        if (isResultDisplayed) {
            clearAll()
            isResultDisplayed = false
        }

        if (currentOperator == null) {
            if (firstNumber == "0") {
                firstNumber = number
            } else {
                firstNumber += number
            }
            currentInput = firstNumber
        } else {
            if (secondNumber == "0") {
                secondNumber = number
            } else {
                secondNumber += number
            }
            currentInput = "$firstNumber $currentOperator $secondNumber"
        }
        updateDisplay()
    }

    private fun setOperator(operator: String) {
        if (firstNumber.isNotEmpty()) {
            currentOperator = operator
            currentInput = "$firstNumber $currentOperator"
            updateDisplay()
        }
    }

    private fun calculate() {
        if (firstNumber.isNotEmpty() && secondNumber.isNotEmpty() && currentOperator != null) {
            val result = when (currentOperator) {
                "+" -> firstNumber.toDouble() + secondNumber.toDouble()
                else -> 0.0
            }

            currentInput = result.toString()
            firstNumber = result.toString()
            secondNumber = ""
            currentOperator = null
            isResultDisplayed = true
            updateDisplay()
        }
    }

    private fun clearAll() {
        currentInput = "0"
        firstNumber = ""
        secondNumber = ""
        currentOperator = null
        isResultDisplayed = false
        updateDisplay()
    }

    private fun updateDisplay() {
        binding.textViewIslem.text = currentInput
    }
}