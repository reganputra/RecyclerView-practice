package com.example.myrecyclerview


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class ListHeroAdapter(private val listHero: ArrayList<Hero>) : RecyclerView.Adapter<ListHeroAdapter.ListViewHolder>() {

    //Implementasi onClick pada MainActivity agar dapat di trigger (Callback pada adapter)
    interface OnItemClickCallback {
        fun onItemClicked(data: Hero)
    }

    private lateinit var onItemClickCallback: OnItemClickCallback

    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }
    //Implementasi onClick pada MainActivity agar dapat di trigger (Callback pada adapter)

    /* onCreateViewHolder, digunakan untuk membuat ViewHolder baru yang berisi layout item yang digunakan,
       dalam hal ini yaitu R.layout.item_row_hero
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder { //
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_hero, parent, false)
        return ListViewHolder(view)
    }

    /*
     onBindViewHolder digunakan untuk menetapkan data yang ada ke dalam ViewHolder sesuai dengan posisinya,
      dengan menggunakan listHero[position]
     */
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listHero[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = name
        holder.tvDescription.text = description

        // how to add onClick()
//        holder.itemView.setOnClickListener{
              // mendapatkan context pada Adapter
//            Toast.makeText(holder.itemView.context, "Kamu memilih" + listHero[holder.adapterPosition].name, Toast.LENGTH_SHORT).show()
//        }

        //Implementasi onClick pada MainActivity agar dapat di trigger
        holder.itemView.setOnClickListener{onItemClickCallback.onItemClicked(listHero[holder.adapterPosition])}
    }

    /*
      getItemCount, digunakan untuk menetapkan ukuran dari list data yang ingin ditampilkan.
      dalam hal ini ingin menampilkan semua data maka menggunakan lisrHer.size
     */
    override fun getItemCount(): Int = listHero.size


    /*
      ListViewHolder, digunakan sebagai ViewHolder dalam RecyclerView. ViewHolder,
      yaitu wrapper seperti View yang berisi layout untuk setiap item dalam daftar RecyclerView.
      disini tempat untuk menginisialisasi setiap komponen pada layout item dengan menggunakan itemView.findViewById
     */
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
    }
    /*
      Adapter akan membuat objek ViewHolder seperlunya dan
     menetapkan data untuk tampilan tersebut. Proses mengatribusikan tampilan ke datanya disebut binding.
     */

}