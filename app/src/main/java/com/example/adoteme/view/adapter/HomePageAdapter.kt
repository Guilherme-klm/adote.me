package com.example.adoteme.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.adoteme.R
import com.example.adoteme.model.Publication
import com.squareup.picasso.Picasso


class HomePageAdapter(private var publication: List<Publication>) : RecyclerView.Adapter<HomePageAdapter.ViewHolder>() {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userPublication: TextView = view.findViewById(R.id.userNamePublication)
        val nameAnimal: TextView = view.findViewById(R.id.nameAnimalValueTV)
        val breedAnimal: TextView = view.findViewById(R.id.breedValueTV)
        val descriptionValueTV: TextView = view.findViewById(R.id.descriptionValueTV)
        val addressTV: TextView = view.findViewById(R.id.addressValueTV)
        val iconVaccine: ImageView = view.findViewById(R.id.vaccineIcon)
        val vaccineName: TextView = view.findViewById(R.id.vaccineNameValueTV)
        val vaccineDate: TextView = view.findViewById(R.id.vaccineDateValueTV)
        val vaccineValidity: TextView = view.findViewById(R.id.vaccineValidityValueTV)
        val remedyIcon: ImageView = view.findViewById(R.id.remedyIcon)
        val remedyName: TextView = view.findViewById(R.id.remedyNameValueTV)
        val remedyDate: TextView = view.findViewById(R.id.remedyDateValueTV)
        val remedyValidity: TextView = view.findViewById(R.id.remedyValidityValueTV)
        val diseaseIcon: ImageView = view.findViewById(R.id.diseaseIcon)
        val diseaseName: TextView = view.findViewById(R.id.diseaseNameValueTV)
        val imagePublication: ImageView = view.findViewById(R.id.imagePublication)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val createTransactions = LayoutInflater.from(parent.context).inflate(
                R.layout.item_publication,
                parent,
                false
        )
        return ViewHolder(createTransactions)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(publication[position].imageLink != null) {
            var url = "http://10.0.2.2:8080/image/" + publication[position].id
            Picasso.get().load(url).fit().into(holder.imagePublication)
        } else holder.imagePublication.visibility = View.GONE

        holder.userPublication.text = publication[position].publicationUser.name

        holder.nameAnimal.text = publication[position].animal.name
        holder.breedAnimal.text = publication[position].animal.breed

        holder.addressTV.text = "${publication[position].neighborhood}, ${publication[position].city} - ${publication[position].state} "
        holder.descriptionValueTV.text = publication[position].description

        if(publication[position].animal.vaccine.name.isNotEmpty()) {
            holder.vaccineName.text = "Nome: ${publication[position].animal.vaccine.name}"
            holder.vaccineDate.text = "Data: ${publication[position].animal.vaccine.date}"
            holder.vaccineValidity.text = "Validade: ${publication[position].animal.vaccine.validity}"
        } else {
            holder.iconVaccine.visibility = View.GONE
            holder.vaccineName.visibility = View.GONE
            holder.vaccineDate.visibility = View.GONE
            holder.vaccineValidity.visibility = View.GONE
        }

        if(publication[position].animal.remedy.name.isNotEmpty()) {
            holder.remedyName.text = "Nome: ${publication[position].animal.remedy.name}"
            holder.remedyDate.text = "Data: ${publication[position].animal.remedy.date}"
            holder.remedyValidity.text = "Validade: ${publication[position].animal.remedy.validity}"
        } else {
            holder.remedyIcon.visibility = View.GONE
            holder.remedyName.visibility = View.GONE
            holder.remedyDate.visibility = View.GONE
            holder.remedyValidity.visibility = View.GONE
        }

        if(publication[position].animal.disease.name.isNotEmpty())
            holder.diseaseName.text = "Nome: ${publication[position].animal.disease.name}"
        else {
            holder.diseaseName.visibility = View.GONE
            holder.diseaseIcon.visibility = View.GONE
        }
    }

    override fun getItemCount(): Int {
        return publication.size
    }
}

