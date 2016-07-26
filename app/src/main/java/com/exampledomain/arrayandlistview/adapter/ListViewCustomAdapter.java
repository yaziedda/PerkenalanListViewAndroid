package com.exampledomain.arrayandlistview.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.exampledomain.arrayandlistview.R;
import com.exampledomain.arrayandlistview.model.ItemModel;

import java.util.List;

/**
 * Created by Dizzay-PC on 7/27/2016.
 */
public class ListViewCustomAdapter extends BaseAdapter {

    // Deklarasi context dan listItem menjadi variable global
    Context context;
    List<ItemModel> listItem;

    // Contructor untuk class ListViewCustomAdapter
    // Fungsinya untuk mengimplementasi kan class dengan parameter
    // parameternya adalah contextParameter dan listItemParameter
    public ListViewCustomAdapter(Context contextParameter, List<ItemModel> listItemParameter) {
        this.context = contextParameter;
        this.listItem = listItemParameter;
    }

    // Membuat class ViewHolder untuk item listView nya
    private class ViewHolder{
        ImageView imageView;
        TextView textViewJudul;
        TextView textViewDeskripsi;
    }

    @Override
    public int getCount() {
        // set count dengan size / jumlah listItem
        return listItem.size();
    }

    @Override
    public Object getItem(int position) {
        // set Object dengan list sesuai posisi itemnya
        return listItem.get(position);
    }

    @Override
    public long getItemId(int position) {
        // set item id berdasarkan posisi item
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Memanggil class ViewHolder
        ViewHolder viewHolder = null;

        // Menggunakan layoutInflater untuk mengimplemantasikan ListView dengan Custom Item ListView
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView == null){

            // Memanggil layout_item_listview.xml dan di implementasikan ke adapter untuk Custom Item ListView
            convertView = layoutInflater.inflate(R.layout.layout_item_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.textViewJudul = (TextView) convertView.findViewById(R.id.textJudul);
            viewHolder.textViewDeskripsi = (TextView) convertView.findViewById(R.id.textDeskripsi);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }

        // set textView dengan ItemModel
        ItemModel itemModel = (ItemModel) getItem(position);
        viewHolder.textViewJudul.setText(itemModel.getJudul());
        viewHolder.textViewDeskripsi.setText(itemModel.getDeskripsi());
        return convertView;
    }
}
