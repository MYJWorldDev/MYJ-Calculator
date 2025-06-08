package com.yousufjamil.calculator.accessories

import com.notkamui.keval.Keval

class CustomMath () {
    fun evaluate(expression: String): Double {
        val expression2 = expression.replace("÷", "/").replace("×", "*").replace("%", "/100")
        return Keval.eval(expression2)
    }

    fun sqrt(expression: String): Double {
        val expression2 = expression.replace("÷", "/").replace("×", "*").replace("%", "/100")
        val number = Keval.eval(expression2)
        return kotlin.math.sqrt(number)
    }
}