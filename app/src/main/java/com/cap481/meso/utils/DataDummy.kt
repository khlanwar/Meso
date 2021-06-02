package com.cap481.meso.utils

import java.util.ArrayList

object DataDummy {

    fun generateDummyMental(): List<MentalEntity> {

        val mentals = ArrayList<MentalEntity>()

        mentals.add(MentalEntity("m1",
            "Gangguan Cemas",
            "Gangguan kecemasan berhubungan dengan rasa takut terhadap objek atau situasi. Mereka juga umumnya mengalami peningkatan detak jantung dan sering berkeringat.Penyakit kejiwaan ini terdeteksi jika respons seseorang tidak sesuai dengan situasi atau tidak dapat mengendalikan respons yang dikeluarkan.",
            "https://image-cdn.medkomtek.com/-KOg0ar2Pn8qrrQLnFUbpdoVhz4=/640x360/smart/filters:quality(75):strip_icc():format(jpeg)/klikdokter-media-buckets/medias/2317631/original/008945800_1596793292-PHK-Picu-Depresi-pada-Pria-shutterstock_735508921.jpg"))
        mentals.add(MentalEntity("m2",
            "Gangguan Mood",
            "Jenis gangguan jiwa ini berhubungan dengan sering merasa sedih, kelewat bahagia, atau gejolak dari kebahagiaan hingga kesedihan berlebih.Contoh dari gangguan mood (suasana hati) adalah depresi dan bipolar.Depresi umumnya dicirikan dengan kesedihan, kehilangan minat atau kesenangan, perasaan bersalah atau menghargai diri rendah, gangguan tidur atau nafsu makan, kelelahan, dan konsentrasi yang buruk.Sedangkan bipolar biasanya terdiri dari episode mania dan depresi, yang dipisahkan oleh periode suasana hati yang normal. Episode mania melibatkan suasana hati yang meningkat atau mudah tersinggung, aktivitas berlebihan, bicara cepat, harga diri meningkat, dan kebutuhan tidur yang sedikit.Orang yang mengalami serangan mania, tetapi tidak mengalami episode depresi juga diklasifikasikan sebagai gangguan bipolar.",
            "https://d1bpj0tv6vfxyp.cloudfront.net/gangguan-bipolar-dan-mood-swing-ini-perbedaannya2.jpg"))
        mentals.add(MentalEntity("m3",
            "Gangguan Psikotik",
            "Penyakit kejiwaan psikotik melibatkan kesadaran atau pola pikir yang terdistorsi. Dua gejala yang paling umum adalah halusinasi dan delusi.Skizofrenia merupakan salah satu contoh gangguan psikotik, yang ditandai dengan distorsi dalam berpikir, persepsi, emosi, bahasa, dan perilaku.",
            "https://image-cdn.medkomtek.com/7XwPZP0xxT7Qv_W01grpJqqJXD4=/640x360/smart/filters:quality(75):strip_icc():format(webp)/klikdokter-media-buckets/medias/2315622/original/099276200_1591931935-Ilustrasi-Gangguan-Cemas-dan-Depresi-shutterstock_613544588.jpg"))
        mentals.add(MentalEntity("m4",
            "Gangguan Makan",
            "Gangguan makan melibatkan emosi, sikap, dan perilaku ekstrem yang melibatkan berat badan serta makanan.Gangguan makan dapat berupa asupan makanan yang tidak mencukupi atau berlebihan, yang akhirnya dapat merusak kesejahteraan individu.Bentuk gangguan makan yang paling umum, yaitu Binge Eating Disorder, Anorexia Nervosa, dan Bulimia Nervosa.",
            "https://image-cdn.medkomtek.com/8tEn83INEi8oW0kiOiTdI-7GHS4=/673x379/smart/klikdokter-media-buckets/medias/2304789/original/071240100_1554197454-Pria-juga-Bisa-Kena-Gangguan-Pola-Makan-By-Tommaso79-Shutterstock.jpg"))
        mentals.add(MentalEntity("m5",
            "Kontrol Impuls ",
            "Gangguan kontrol impuls membuat penderitanya tidak dapat menahan keinginan atau dorongan untuk melakukan tindakan yang membahayakan diri atau orang lain.Sering kali, orang-orang dengan gangguan ini menjadi begitu terlibat dengan objek kecanduan sehingga cenderung mengabaikan tanggung jawab.Pyromania (menyalakan api) dan kleptomania (mencuri) adalah contoh gangguan kontrol impuls.",
            "https://d1bpj0tv6vfxyp.cloudfront.net/articles/382460_10-8-2020_17-6-5.jpeg"))

        return mentals
    }
}