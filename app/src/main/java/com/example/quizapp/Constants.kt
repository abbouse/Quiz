package com.example.quizapp
object Constants {

    const val USER_NAME: String = "user_name"
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val TOTAL_QUESTIONS: String = "total_question"

    fun getQuestions(): ArrayList<Question>{
        val questionList = ArrayList<Question>()
        //1
        val que1 = Question(1,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_spain,
                "Argentina",
                "Avstraliya",
                "Ispaniya",
                "Turkiya",
                3
        )
        questionList.add(que1)
        //2
        val que2 = Question(2,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_afghanistan,
                "Latviya",
                "Afg'oniston",
                "Avstraliya",
                "Turkiya",
                2
        )
        questionList.add(que2)
        //3
        val que3 = Question(3,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_angola,
                "Lesoto",
                "Angola",
                "Livan",
                "Kosta-rika",
                2
        )
        questionList.add(que3)
        //4
        val que4 = Question(4,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_argentina,
                "Argentina",
                "Yamayka",
                "Polsha",
                "Ispaniya",
                1
        )
        questionList.add(que4)
        //5
        val que5 = Question(5,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_austria,
                "Avstriya",
                "Avstraliya",
                "Angola",
                "B.A.A.",
                1
        )
        questionList.add(que5)
        //6
        val que6 = Question(6,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_australia,
                "Lyuksemburg",
                "Fransiya",
                "Livan",
                "Avstraliya",
                4
        )
        questionList.add(que6)
        //7
        val que7 = Question(7,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_barbados,
                "Gvatemala",
                "Barbados",
                "Boliviya",
                "Turkiya",
                1
        )
        questionList.add(que7)
        //8
        val que8 = Question(8,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_beliz,
                "Vatikan",
                "Beliz",
                "Lixtenshteyn",
                "Bolgariya",
                2
        )
        questionList.add(que8)
        //9
        val que9 = Question(9,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_comoros,
                "Komora",
                "Kosta-Rika",
                "Quvayt",
                "Armaniston",
                1
        )
        questionList.add(que9)
        //10
        val que10 = Question(10,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_hungary,
                "Albaniya",
                "Avstraliya",
                "Vengriya",
                "Vatikan",
                3
        )
        questionList.add(que10)
        //11
        val que11 = Question(11,
                "Bu qaysi davlatning bayrog'i?",
                R.drawable.ic_vietnam,
                "Mavritaniya",
                "Nigeriya",
                "Vengriya",
                "Vetnam",
                4
        )
        questionList.add(que11)
        return questionList

    }
}
