package txstate.edu.amb309.rentalcarapp;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends Activity implements AdapterView.OnItemClickListener {

    int[] intCarIDs = {1, 2, 3, 4, 5};
    String[] strNames = {"Nissan Versa", "Hyundai Elantra", "Volkswagen Jetta", "Ford Eco Ford", "Chrysler 300"};
    String[] strBrands = {"Nissan", "Hyundai", "Volkswagen", "Ford", "Chrysler"};
    double[] dblCostPerDays = {36.99, 38.99, 40.99, 59.99, 89.99};
    String[] strUrls = {"https://www.nissanusa.com/vehicles/cars/versa-sedan.html",
            "https://www.hyundaiusa.com/elantra/index.aspx",
            "https://www.vw.com/models/jetta/section/masthead/",
            "https://www.ford.com/suvs-crossovers/ecosport/",
            "https://www.chrysler.com/300.html"};
    int[] intCarImages = {R.drawable.car1, R.drawable.car2, R.drawable.car3, R.drawable.car4, R.drawable.car5};

    ListView listView;
    List<RentalCar> cars;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        cars = new ArrayList<RentalCar>();
        for (int i = 0; i < strNames.length; i++) {
            RentalCar aCar = new RentalCar(intCarIDs[i], strNames[i], strBrands[i], dblCostPerDays[i], strUrls[i], intCarImages[i]);
            cars.add(aCar);
        }
        listView = (ListView) findViewById(R.id.listCars);
        CustomListViewAdapter adapter = new CustomListViewAdapter(this, R.layout.activity_car_item, cars);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            RentalCar selectedCar = cars.get(position);
            SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(ListViewActivity.this);
            SharedPreferences.Editor editor = sp.edit();
            editor.putInt("id", selectedCar.getId());
            editor.putString("name", selectedCar.getName());
            editor.putString("brand", selectedCar.getBrand());
            editor.putFloat("cost", (float)selectedCar.getCostPerDay()); //since costperday is double, need to casr to flost
            editor.putString("url", selectedCar.getUrl());
            editor.commit();

            startActivity(new Intent(ListViewActivity.this, CalculateCostActivity.class));
    }
}

