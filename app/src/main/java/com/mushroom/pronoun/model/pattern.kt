package com.mushroom.pronoun.model

import java.util.regex.Pattern

data class pat(



    val passPattern: Pattern = Pattern.compile(
        "^" +
                "(?=.*[0-9])" +    // at least 1 digit
                "(?=.*[a-zA-Z])" +    // atleast one letter
                "(?=.*[@$#%^&+=])" +  // atleast one
                "(?=\\s+$)" +        // no white spaces
                ".{6,}" +
                "$"
    )


)

