package com.mushroom.trial.questionaires

object Constants {


    // TODO (STEP 1: Create a constant variables which we required in the result screen.)
    // START

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"
    // END

    fun getQuestions() : ArrayList<Question> {


        val listQuestion = ArrayList<Question>()
        val que1 = Question(
            1, "what is Economics?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que1)
        val que2 = Question(
            2, "What attraction in Montreal is one of the largest in the world?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que2)
        val que3 = Question(
            3, "what is Economics?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que3)
        val que4 = Question(
            4, "what is consjfondodjo loperjss  dikrenmosn  kncndodpond kdhiosnkdojdponmdpsjolnodjksdnxodnkd  kdjojdslnmslfsjfosj kdosfnsfksnfosonsfo ksjfsofns kjshcis?",
            "sciudhfidhfohfosnce",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que4)
        val que5 = Question(
            5, "what is Economics?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que5)
        val que6 = Question(
            6, "what is Economics?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que6)
        val que7 = Question(
            7, "what is Economics?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que7)
        val que8 = Question(
            8, "what is Economics?",
            "scince",
            "mathematics",
            "niology",
            "greater",
            1
        )
        listQuestion.add(que8)







        return listQuestion

    }
}