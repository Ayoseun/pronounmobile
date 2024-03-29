package com.mushroom.pronoun.model

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

object Constants {
    // START
    var fore: Array<String> = arrayOf(

        "#E57373",
        "#D81B60",
        "#673AB7",
        "#0288D1",
        "#FBC02D",
        "#795548",
        "#546E7A",
        "#66BB6A",
        "#009106",
        "#67E7C1",
        "#673AB7",
        "#0288D1",
        "#FBC02D",
        "#FF3700B3",
        "#546E7A",
        "#526474"
    )


    var backGrnd = arrayOf(

        "#FFEBEE", "#FCE4EC", "#EDE7F6", "#E1F5FE", "#FFFDE7", "#EFEBE9", "#ECEFF1", "#E8F5E9"

    )

    var mColors = arrayOf(
        "FFEBEE", "FFCDD2", "EF9A9A", "E57373", "EF5350", "F44336", "E53935",  //reds
        "D32F2F", "C62828", "B71C1C", "FF8A80", "FF5252", "FF1744", "D50000",
        "FCE4EC", "F8BBD0", "F48FB1", "F06292", "EC407A", "E91E63", "D81B60",  //pinks
        "C2185B", "AD1457", "880E4F", "FF80AB", "FF4081", "F50057", "C51162",
        "F3E5F5", "E1BEE7", "CE93D8", "BA68C8", "AB47BC", "9C27B0", "8E24AA",  //purples
        "7B1FA2", "6A1B9A", "4A148C", "EA80FC", "E040FB", "D500F9", "AA00FF",
        "EDE7F6", "D1C4E9", "B39DDB", "9575CD", "7E57C2", "673AB7", "5E35B1",  //deep purples
        "512DA8", "4527A0", "311B92", "B388FF", "7C4DFF", "651FFF", "6200EA",
        "E8EAF6", "C5CAE9", "9FA8DA", "7986CB", "5C6BC0", "3F51B5", "3949AB",  //indigo
        "303F9F", "283593", "1A237E", "8C9EFF", "536DFE", "3D5AFE", "304FFE",
        "E3F2FD", "BBDEFB", "90CAF9", "64B5F6", "42A5F5", "2196F3", "1E88E5",  //blue
        "1976D2", "1565C0", "0D47A1", "82B1FF", "448AFF", "2979FF", "2962FF",
        "E1F5FE", "B3E5FC", "81D4fA", "4fC3F7", "29B6FC", "03A9F4", "039BE5",  //light blue
        "0288D1", "0277BD", "01579B", "80D8FF", "40C4FF", "00B0FF", "0091EA",
        "E0F7FA", "B2EBF2", "80DEEA", "4DD0E1", "26C6DA", "00BCD4", "00ACC1",  //cyan
        "0097A7", "00838F", "006064", "84FFFF", "18FFFF", "00E5FF", "00B8D4",
        "E0F2F1", "B2DFDB", "80CBC4", "4DB6AC", "26A69A", "009688", "00897B",  //teal
        "00796B", "00695C", "004D40", "A7FFEB", "64FFDA", "1DE9B6", "00BFA5",
        "E8F5E9", "C8E6C9", "A5D6A7", "81C784", "66BB6A", "4CAF50", "43A047",  //green
        "388E3C", "2E7D32", "1B5E20", "B9F6CA", "69F0AE", "00E676", "00C853",
        "F1F8E9", "DCEDC8", "C5E1A5", "AED581", "9CCC65", "8BC34A", "7CB342",  //light green
        "689F38", "558B2F", "33691E", "CCFF90", "B2FF59", "76FF03", "64DD17",
        "F9FBE7", "F0F4C3", "E6EE9C", "DCE775", "D4E157", "CDDC39", "C0CA33",  //lime
        "A4B42B", "9E9D24", "827717", "F4FF81", "EEFF41", "C6FF00", "AEEA00",
        "FFFDE7", "FFF9C4", "FFF590", "FFF176", "FFEE58", "FFEB3B", "FDD835",  //yellow
        "FBC02D", "F9A825", "F57F17", "FFFF82", "FFFF00", "FFEA00", "FFD600",
        "FFF8E1", "FFECB3", "FFE082", "FFD54F", "FFCA28", "FFC107", "FFB300",  //amber
        "FFA000", "FF8F00", "FF6F00", "FFE57F", "FFD740", "FFC400", "FFAB00",
        "FFF3E0", "FFE0B2", "FFCC80", "FFB74D", "FFA726", "FF9800", "FB8C00",  //orange
        "F57C00", "EF6C00", "E65100", "FFD180", "FFAB40", "FF9100", "FF6D00",
        "FBE9A7", "FFCCBC", "FFAB91", "FF8A65", "FF7043", "FF5722", "F4511E",  //deep orange
        "E64A19", "D84315", "BF360C", "FF9E80", "FF6E40", "FF3D00", "DD2600",
        "EFEBE9", "D7CCC8", "BCAAA4", "A1887F", "8D6E63", "795548", "6D4C41",  //brown
        "5D4037", "4E342E", "3E2723",
        "FAFAFA", "F5F5F5", "EEEEEE", "E0E0E0", "BDBDBD", "9E9E9E", "757575",  //grey
        "616161", "424242", "212121",
        "ECEFF1", "CFD8DC", "B0BBC5", "90A4AE", "78909C", "607D8B", "546E7A",  //blue grey
        "455A64", "37474F", "263238"
    )
    val spell = arrayOf(
        "AGRICULTURAL EXTENSION AND MANAGEMENT",
        "AGRICULTURAL EXTENSION AND RURAL DEVELOPMENT OPTION",
        "CROP PRODUCTION AND PROTECTION SCIENCES",
        "SOIL AND LAND RESOURCES MANAGEMENT",
        "AGRICULTURAL ECONOMICS AND AGRO BUSINESS",
        "AQUACULTURE AND FISHERIES MANAGEMENT",
        "ANIMAL SCIENCE",
        "HOTEL AND CATERING MANAGEMENT","YORUBA","HAUSA","IGBO","ARABIC LANGUAGE AND LITERATURE",
        "ISLAMIC STUDIES",
        "CHRISTIAN RELIGIOUS STUDIES",
        "FRENCH","ENGLISH","HUMAN KINETICS","LIBRARY AND INFORMATION SCIENCE",
        "HEALTH EDUCATION",
        "(ED) BUSINESS EDUCATION","(ED) PRIMARY EDUCATION","(ED) FRENCH	EDUCATION",
        "(ED) ENGLISH","(ED) EARLY CHILDHOOD EDUCATION","(ED) PHYSICS",
        "(ED) MATHEMATICS","(ED) COMPUTER SCIENCE","(ED) INTEGRATED SCIENCE",
        "(ED) CHEMISTRY","(ED) BIOLOGY","(ED) AGRICULTURAL SCIENCE","ENVIRONMENTAL HEALTH SCIENCE","NURSING SCIENCE(BNSC)",
        "PUBLIC HEALTH","LLB LAW","BANKING AND FINANCE","MARKETING","PUBLIC ADMINISTRATION",
        "BUSINESS ADMINISTRATION","ACCOUNTING","ENTREPRENEURSHIP","COOPERATIVE AND RURAL DEVELOPMENT","DATA MANAGEMENT",
        "PHYSICS","CHEMISTRY","BIOLOGY","MATHEMATICS","COMPUTER SCIENCE","INFORMATION TECHNOLOGY","MATHEMATICS AND COMPUTER",
        "ENVIRONMENTAL MANAGEMENT AND TOXICOLOGY","DEVELOPMENT STUDIES","BROADCASTING","FILM PRODUCTION","INTERNATIONAL AND DIPLOMATIC STUDIES",
        "TOURISM STUDIES","ECONOMICS","POLITICAL SCIENCE","MASS COMMUNICATION","PEACE STUDIES AND CONFLICT RESOLUTION",
        "CRIMINOLOGY AND SECURITY STUDIES")

    val USER_NAME: String = "user_name"
    val TOTAL_QUESTIONS: String = "total_questions"
    val CORRECT_ANSWERS: String = "correct_answers"
    var name: String = "total_questions"
    var surname: String = "correct_answers"
    var dept: String = "total_questions"
    var level: String = "correct_answers"
    var sems: String = "total_questions"

    // END
    val onee: String = "level"
    const val tw: String = "level"
    const val three: String = "level"
    const val fr: String = "level"
    const val fv: String = "level"
    const val six: String = "level"


}

object SavedPreference {

    const val EMAIL = "email"
    const val USERNAME = "username"

    private fun getSharedPreference(ctx: Context?): SharedPreferences? {
        return PreferenceManager.getDefaultSharedPreferences(ctx)
    }

    private fun editor(context: Context, const: String, string: String) {
        getSharedPreference(
            context
        )?.edit()?.putString(const, string)?.apply()
    }

    fun getEmail(context: Context) = getSharedPreference(
        context
    )?.getString(EMAIL, "")

    fun setEmail(context: Context, email: String) {
        editor(
            context,
            EMAIL,
            email
        )
    }

    fun setUsername(context: Context, username: String) {
        editor(
            context,
            USERNAME,
            username
        )
    }

    fun getUsername(context: Context) = getSharedPreference(
        context
    )?.getString(USERNAME, "")

}