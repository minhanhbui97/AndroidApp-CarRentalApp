//package [your package name here];

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<RentalCar> {
    Context context;

    public CustomListViewAdapter(Context context, int resourceId, List<RentalCar> items){
        super(context, resourceId, items);
        this.context = context;
    }

    private class ViewHolder{
        ImageView imageCar;
        TextView txtCar;
    }

    public View getView(int position, View carView, ViewGroup parent){
        ViewHolder holder = null;
        RentalCar aCar = getItem(position);

        LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if (carView == null) {
            carView = mInflater.inflate(R.layout.activity_car_item, null);
            holder = new ViewHolder();
            holder.txtCar = (TextView) carView.findViewById(R.id.txtCarName);
            holder.imageCar = (ImageView) carView.findViewById(R.id.imgCar);
            carView.setTag(holder);
        } else
            holder = (ViewHolder) carView.getTag();

        holder.txtCar.setText(aCar.getName());
        holder.imageCar.setImageResource(aCar.getImage());

        return carView;
    }
}


