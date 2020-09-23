package com.omaressam.a2oleh.Data.RoomDb
val gender_male = "male"
val gender_female = "female"
val gender_all = "all"
val type_funeral="funeral"
val type_congrats="congrats"
val type_newpic = "newpic"
val type_birthday = "birthday"

val gridListTypes = arrayOf( "تهنئة\nCongrats","عيد ميلاد\nBirthday" ,"صورة جديدة\nNew Picture","تعزية\nFuneral")
fun DbStaticData() :ArrayList<RepliesTableModel> {



     //emojis
    val flameEmoji  = String(Character.toChars(0x1F525))
    val heartEmoji = String(Character.toChars(0x2764))

    val confettiEmoji =String(Character.toChars(0x1F389))
    val eyeheartEmoji =String(Character.toChars(0x1F60D))


    var i =0
    var dbList : ArrayList<RepliesTableModel> = ArrayList()

    //setting data
    //cermony
     dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_male , replies = "البقاء الله ربنا يغفرله ويرحمه يارب"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_male , replies = "ربنا يرحمه ويغفر له"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_male , replies = "البقاء لله يحبيبى ربنا يرحمه ويغفر له ويسكنه فسيح جناته"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_male , replies = "البقاء و الدوام لله ربنا يرحمه و يغفر له و يسكنه فسيح جناته و يصبركم"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_male , replies = "ان لله و ان إليه راجعون .. الله يرحمه و يسكنه فسيح جناتة"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender =gender_female , replies = "البقاء الله ربنا يغفرلها ويرحمها يارب"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_female , replies = "البقاء و الدوام لله ربنا يرحمها و يغفر لها و يسكنها فسيح جناته و يصبركم"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_female , replies = "ربنا يرحمها ويغفر لها"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_female , replies = "البقاء لله يحبيبى ربنا يرحمها ويغفر لها ويسكنها فسيح جناته"))
    i++
    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_female , replies = "ان لله و ان إليه راجعون .. الله يرحمها و يسكنها فسيح جناتة"))
    i++

    dbList.add(RepliesTableModel(i,type = type_funeral , gender = gender_all , replies = "شكر الله سعيكم وجزاكم الله خيراً"))
    i++

    //congrats
    val congratsList = listOf("Alf mabrouk ya akhoya $flameEmoji $heartEmoji","الف مبروك ي حبيبي   $heartEmoji","وربنا يسعدك ف حياتك الي جايه   $heartEmoji $heartEmoji ","الف مليون مبروك ي رجوووله  $flameEmoji $heartEmoji","7obe  $heartEmoji Allah ybark fek   $heartEmoji","الف مبروك يا صاحبي ربنا يوفقك في حياتك ان شاء الله $heartEmoji","Albe $heartEmoji Allah ybark feke yarab $heartEmoji","Allah ybark feke yarab $heartEmoji","الله يبارك فيكي يارب  $heartEmoji","الف مبروك يا صاحبتي ربنا يوفقك في حياتك ان شاء الله $flameEmoji  $heartEmoji","الف مبرووووووووك ياقمر $heartEmoji","الف الف مبروك يروح قلبى $flameEmoji  $heartEmoji","الف مبروك  و ربنا يوفقك فى اللى جاى ان شاء الله ","مبروك ربنا يوفقك لكل خير","الف مبروك يا حبيب قلبي  $heartEmoji $heartEmoji","الف مبروك يا صاحبى $flameEmoji $flameEmoji  $heartEmoji","Mabroook ya sa7by   $heartEmoji","الف الف مبروك يا قلبي","الف مبروووك $flameEmoji  ","الف مبروك يا حبيب قلبي وربنا يوفقك فاللي جاي $heartEmoji $heartEmoji $heartEmoji","اخويا الله يبارك فيك  $heartEmoji","Allah ybark fek ya 7ob  $heartEmoji $heartEmoji","الله يبارك في حضرتك  ","Congratulations $flameEmoji ")

    for ((index, replyList) in congratsList.withIndex()) {
        var gender: String?
        if (index in 0..5) {
            gender = gender_male
            dbList.add(
                RepliesTableModel(
                    i,
                    type = type_congrats,
                    gender = gender,
                    replies = replyList
                )
            )
            i++
        }
        if (index in 6..10) {
            gender = gender_female
            dbList.add(
                RepliesTableModel(
                    i,
                    type = type_congrats,
                    gender = gender,
                    replies = replyList
                )
            )
            i++
        }
        if (index in 11..23) {
            gender = gender_all
            dbList.add(
                RepliesTableModel(
                    i,
                    type = type_congrats,
                    gender = gender,
                    replies = replyList
                )
            )
            i++
        }
    }
        //birthday
        val birthdayList = listOf("اخويا اللي مني أطيب وأجدع خلق الله  $heartEmoji  $confettiEmoji كل سنة وانت طيب وبخير يا حبيبي ويارب دايماً مبسوط وتحقق كل الي نفسك فيه  $heartEmoji","وانت طيب يا عم الناس ويخليك يارب  $heartEmoji $eyeheartEmoji","$confettiEmoji كل سنة وانت طيب يا صاحبي وعقبال $heartEmoji سنة في سعادة وفرح","$heartEmoji اخويا اللي من زمان بلاقيه في ظهري في اي حاجه $heartEmoji  كل سنة و انتا طيب يا أخويا ","كل سنه وانت طيب ي صاحبي $heartEmoji $heartEmoji $flameEmoji ","وسنه سعيده عليك ي قلبي$flameEmoji $heartEmoji  $confettiEmoji  $eyeheartEmoji وعقبال سنين كتيره كده ف نجاح وخير دايما كده  ","Sadeky El saddook  $heartEmoji   $eyeheartEmoji Happy Birthday ya A5oia  $heartEmoji  ","Sadeky El saddook  $heartEmoji   $eyeheartEmoji Happy Birthday my Sweet Girl $heartEmoji  ","كل سنه وانتي طيبه يا حبيبتي   $heartEmoji  $confettiEmoji $heartEmoji","كل سنة وانتي طيبة يا صاحبتي وعقبال $heartEmoji سنة في سعادة وفرح","كل سنه وانت طيب يا صديقي $heartEmoji  $confettiEmoji ","kol sana w enya tayeb ya 7bebeeee $heartEmoji","Happy birthday ya Bro $flameEmoji $heartEmoji  $confettiEmoji  ","كل سنة وانت طيب وبخير يا حبيبي ويارب دايماً مبسوط وتحقق كل الي نفسك فيه $heartEmoji","Happy birthday! I hope all your birthday wishes and dreams come true $flameEmoji $heartEmoji","Wishing you a day filled with happiness and a year filled with joy. Happy birthday $confettiEmoji ","On this wonderful day, I wish you the best that life has to offer! Happy birthday! ","Bon anniversaire mon ami  $heartEmoji  $confettiEmoji $eyeheartEmoji")

        for ((index, replyList) in birthdayList.withIndex()) {
            var gender: String?
            if (index in 0..6) {
                gender = gender_male
                dbList.add(
                    RepliesTableModel(
                        i,
                        type = type_birthday,
                        gender = gender,
                        replies = replyList
                    )
                )
                i++
            }
            if (index in 7..9) {
                gender = gender_female
                dbList.add(
                    RepliesTableModel(
                        i,
                        type = type_birthday,
                        gender = gender,
                        replies = replyList
                    )
                )
                i++

            }
            if (index in 10..18) {
                gender = gender_all
                dbList.add(
                    RepliesTableModel(
                        i,
                        type = type_birthday,
                        gender = gender,
                        replies = replyList
                    )
                )
                i++
            }
              }
            //newpic
            val newpicList = listOf("حبيب قلبي $flameEmoji $flameEmoji","اخويا العظمه $heartEmoji $heartEmoji","اخويااا $heartEmoji $flameEmoji","روح قلب اخووك $heartEmoji  $flameEmoji","حبيبي الي واحشني ","الغالي ابن الغالى الرجولة الأخلاق ","اخوياا القمر $heartEmoji $flameEmoji  $eyeheartEmoji","اخويه لي بتشرف بي $heartEmoji $heartEmoji","الصاحب الي مال قارون ميكفهوش $flameEmoji  ",
                "عم العيال وابو الرجوله والجدعنه $heartEmoji $flameEmoji","اخويا اللي بحبه $heartEmoji  ","العاظمة عايزة منك ايه ياجدع $heartEmoji $heartEmoji $flameEmoji","ايه القمر ده $eyeheartEmoji $heartEmoji",
                "My Beautiful Girl $heartEmoji $flameEmoji","Amaar masha’allah $eyeheartEmoji ","S7bti al amr $eyeheartEmoji ","Ya 7yati $eyeheartEmoji $heartEmoji","Msh mmkn kol sora arwa3 mn l ablha kdaaa $heartEmoji ","Sahbty $eyeheartEmoji $flameEmoji ","Yaraabii 3l gmaaall daaa $eyeheartEmoji $heartEmoji",
                "Msh mommmknn $heartEmoji $heartEmoji $heartEmoji","خربت خااالص   خالص $heartEmoji $flameEmoji","حياتي $heartEmoji $eyeheartEmoji ","Ro7 alpii $heartEmoji $eyeheartEmoji")

            for ((index, replyList) in newpicList.withIndex())
            {   var gender:String?
                if(index in 0..11 )
                { gender = gender_male
                    dbList.add(RepliesTableModel(i,type = type_newpic , gender = gender , replies = replyList))
                    i++}
                if(index in 12..20 ) {
                    gender = gender_female
                    dbList.add(RepliesTableModel(i,type = type_newpic, gender = gender , replies =replyList))
                    i++
                }
                if(index in 21..26 ) {
                    gender = gender_all
                    dbList.add(RepliesTableModel(i,type = type_newpic, gender = gender , replies = replyList))
                    i++
                }
                 }
     return dbList
}