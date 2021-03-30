package org.codespeedy;

import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Description;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button mIncrementButton;
    private PieChart pieChart;

    int count = 0;
    int target = 100;

    @Override
    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        setContentView(R.layout.activity_main);

        mIncrementButton = findViewById(R.id.increment_button);
        pieChart = findViewById(R.id.progressChart);

        setupPiechart();

        mIncrementButton.setOnClickListener(v->{
            if(count<target)
            {
                count++;
                RefreshDataSet(count,target);
            }
        });
        RefreshDataSet(count,target);
    }

    private void setupPiechart() {
        Description description = new Description();
        description.setText("");
        pieChart.setDescription(description);
        pieChart.setRotationEnabled(true);
        pieChart.setHoleRadius(35f);
        pieChart.setTransparentCircleAlpha(0);
        pieChart.setCenterText("Step Tracker");
        pieChart.setCenterTextSize(13);

    }

    private void RefreshDataSet(long steps, long target) {

        ArrayList<PieEntry> yEntrys = new ArrayList<>();

        yEntrys.add(new PieEntry(steps, "Total Steps Taken"));
        yEntrys.add(new PieEntry((target - steps > 0 ? target - steps : 0f), "Remaining Steps"));

        //create the data set
        PieDataSet pieDataSet = new PieDataSet(yEntrys, "");
        pieDataSet.setSliceSpace(1);
        pieDataSet.setValueTextSize(20);
        pieDataSet.setValueTextColor(Color.rgb(255, 255, 255));

        //add colors to dataset
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(ColorTemplate.getHoloBlue());
        colors.add(Color.BLUE);
        pieDataSet.setColors(colors);

        //add legend to chart
        Legend legend = pieChart.getLegend();
        legend.setForm(Legend.LegendForm.CIRCLE);
        legend.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        legend.setHorizontalAlignment(Legend.LegendHorizontalAlignment.CENTER);
        legend.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        legend.setDrawInside(false);

        //create pie data object
        PieData pieData = new PieData(pieDataSet);
        pieChart.setData(pieData);
        pieChart.invalidate();
    }

}

