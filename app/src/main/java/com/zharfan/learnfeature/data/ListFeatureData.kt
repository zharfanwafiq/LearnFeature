package com.zharfan.learnfeature.data

object ListFeatureData {

    private val listNames = arrayOf(
        "Lemari",
        "Meja",
        "Cermin",
        "Sepatu",
        "Baju",
        "Celana",
        "Kasur",
        "Kursi",
        "Buku",
        "Bantal",
        "Lampu",
        "Selimut",
        "Pintu"

    )

    private val listImages =  arrayOf(
        "https://images.tokopedia.net/img/cache/900/product-1/2016/8/13/7477924/7477924_de537686-f82f-48d3-bb23-8fff514f17c2.jpg",
        "https://d2xjmi1k71iy2m.cloudfront.net/dairyfarm/id/images/370/0737092_PE740877_S5.jpg",
        "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full/MTA-4601139/dekoruma_heim-studio-rine-cermin-badan---standing-mirror_full08.jpg",
        "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//97/MTA-10658544/no_brand_sepatu_sneaker_pria_import_-_air_venron_truedoo_cassual_shoes_-_sepatu_kasual_santai_full01_ld48p1pt.jpg",
        "https://images.tokopedia.net/img/cache/500-square/product-1/2020/2/18/42599313/42599313_f4a0842d-e957-4557-9a22-b5f9cff18fe3_700_700",
        "https://cf.shopee.co.id/file/af1d1483e3af909ca694e70c6f359eb3",
        "https://lirp.cdn-website.com/4c569d4c/dms3rep/multi/opt/dr+smart-fd976524-640w.png",
        "https://cf.shopee.co.id/file/406a5304f5cd2b99fa574d04bc6597d5",
        "https://asset.kompas.com/crops/mTnVdoYXCoN9ElxrsEDbdoY7y0s=/65x65:865x599/750x500/data/photo/2017/06/28/1265845835.jpg",
        "https://d2xjmi1k71iy2m.cloudfront.net/dairyfarm/id/images/117/0811758_PE771827_S5.jpg",
        "https://asset.kompas.com/crops/_kDdg4YiDGoTHlvdYmkD1_GdCyk=/562x687:5063x3687/750x500/data/photo/2021/04/05/606af412e464f.jpg",
        "https://ceklist.id/wp-content/uploads/2021/12/Merk-Selimut-Nyaman-Terbaik.jpg",
        "https://cf.shopee.co.id/file/d70d8e8e7ab3a2ced0c77d6dbac982ec"

    )

    private val listDescriptions = arrayOf(
        "Lemari atau almari merupakan salah satu produk mebel yang biasanya berukuran relatif besar yang dapat digunakan untuk menyimpan aneka barang dan dilengkapi sistem pengaman seperti kunci. Menurut KBBI V, lemari adalah peti besar tempat menyimpan",
        "Meja adalah sebuah mebel atau perabotan yang memiliki permukaan datar dan kaki-kaki sebagai penyangga, yang bentuk dan fungsinya bermacam-macam. Meja digunakan untuk menaruh barang atau makanan. Meja umumnya dipasangkan dengan kursi atau bangku",
        "Cermin adalah permukaan yang licin dan dapat menciptakan pantulan bayangan benda dengan sempurna",
        "Sepatu adalah salah satu jenis alas kaki yang biasanya terdiri atas bagian-bagian sol, hak, kap, tali, dan lidah",
        "Pakaian adalah bahan tekstil dan serat yang digunakan sebagai penutup tubuh. Pakaian adalah kebutuhan pokok manusia selain makanan dan tempat berteduh/tempat tinggal (rumah). Manusia membutuhkan pakaian untuk melindungi dan menutup dirinya.",
        "Celana adalah pakaian luar yang menutup pinggang sampai mata kaki, kadang-kadang hanya sampai lutut, yang membungkus batang kaki secara terpisah, terutama merupakan pakaian lelaki. Ada dua kategori umum dari Celana: Celana pendek Celana panjang",
        "Kasur adalah alas besar, biasanya berbentuk persegi panjang yang berfungsi sebagai alas orang tidur atau berbaring. Kasur dirancang untuk digunakan sebagai tempat tidur, atau ditaruh di atas dipan sebagai bagian dari tempat tidur. ",
        "Kursi adalah sebuah perabotan rumah tangga yang digunakan sebagai tempat duduk. Pada umumnya, kursi memiliki 4 kaki yang digunakan untuk menopang berat tubuh di atasnya. Beberapa jenis kursi, seperti barstool, hanya memiliki 1 kaki yang terletak di bagian tengah",
        "buku adalah kumpulan tulisan atau gambar/ilustrasi yang dijilid atau digabungkan menjadi satu.",
        "Bantal adalah penyangga kepala, biasanya digunakan untuk tidur di atas ranjang, atau untuk penyangga tubuh di sofa atau kursi. Bantal biasanya diisi oleh kapas, bulu unggas, kapuk dan sebagainya.",
        "Lampu adalah sebuah peranti yang menghasilkan cahaya. Kata lampu dapat juga berarti bola lampu. Lampu pertama kali ditemukan oleh Sir Joseph William Swan.",
        "Selimut adalah bagian dari peralatan tidur untuk memberikan rasa hangat terutama ketika sedang tidur. Selain selimut yang terbuat dari bahan kain, terdapat juga selimut listrik, yaitu selimut yang diberikan aliran listrik untuk diubah menjadi energi panas yang memberikan rasa hangat kepada pemakainya",
        "Selimut adalah bagian dari peralatan tidur untuk memberikan rasa hangat terutama ketika sedang tidur. Selain selimut yang terbuat dari bahan kain, terdapat juga selimut listrik, yaitu selimut yang diberikan aliran listrik untuk diubah menjadi energi panas yang memberikan rasa hangat kepada pemakainya"
    )

    val listData: ArrayList<ListFeature>
    get() {
        val list = arrayListOf<ListFeature>()
        for (position in listNames.indices){
            val listFeature = ListFeature()
            listFeature.listName = listNames[position]
            listFeature.listImage = listImages[position]
            listFeature.listDescription = listDescriptions [position]
            list.add(listFeature)
        }
        return list
    }
}