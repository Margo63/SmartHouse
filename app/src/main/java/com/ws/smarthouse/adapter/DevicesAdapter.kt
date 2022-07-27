package com.ws.smarthouse

import android.content.Context
import android.content.res.Resources
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import androidx.recyclerview.widget.RecyclerView


interface RecyclerViewClickListener {
    fun recyclerViewListClicked(v: View?, position: Int)
}

class DevicesAdapter(
    private val devices: Array<String>,
    private val onClickListener: RecyclerViewClickListener,val context: Context
) : RecyclerView.Adapter<DevicesAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textView: TextView = view.findViewById<View>(R.id.textView2) as TextView
        val imageView: ImageView = view.findViewById<View>(R.id.imageView2) as ImageView

    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item_device, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.textView.text = devices.get(position)
        val resources = viewHolder.itemView.context.resources
        val resourceId = resources.getIdentifier(
            "device$position", "drawable",
            viewHolder.itemView.context.packageName
        )



        viewHolder.imageView.setImageResource(resourceId)
        viewHolder.itemView.setOnClickListener(View.OnClickListener { view ->
            onClickListener.recyclerViewListClicked(
                view,
                viewHolder.layoutPosition
            )
        })

//        val res: Resources = getResources()
 //       val src = BitmapFactory.decodeResource(context.resources, resourceId)
//        val dr = RoundedBitmapDrawableFactory.create(res, src)
//        dr.cornerRadius = Math.max(src.width, src.height) / 2.0f
//        imageView.setImageDrawable(dr)

//        val dr: RoundedBitmapDrawable = RoundedBitmapDrawableFactory.create(context.resources,src)
  //      dr.cornerRadius = 10F
    //    viewHolder.imageView.setImageDrawable(dr)


    }

    override fun getItemCount(): Int {
        return devices.size+1
    }
}