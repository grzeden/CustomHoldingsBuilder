package edu.grzegorzewski.customholdingsbuilder;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import edu.grzegorzewski.customholdingsbuilder.dao.OclcDao;
import edu.grzegorzewski.customholdingsbuilder.domain.Institution;

public class ProcessListActivity extends AppCompatActivity {

    private OclcDao oclcDao = new OclcDao(this);

    private static ProcessListActivity processListActivityInstance;

    public static ProcessListActivity getInstance() {
        return processListActivityInstance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        processListActivityInstance = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process_list);

        //Intent passed in
        Intent thisIntent = this.getIntent();

        final String state = thisIntent.getStringExtra("state");

        StateZoneList stateZone = new StateZoneList(state);

        // TODO descripton.
        List<Pair> stateZoneList = stateZone.getStateZones();

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setAdapter(createArrayAdapter(state));

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = parent.getItemAtPosition(position).toString();
                String splitValue[] = value.split(" ");
                ListView listView = (ListView) findViewById(R.id.list_view_holdings);

                ArrayAdapter adapter = new ArrayAdapter(ProcessListActivity.getInstance(), R.layout.simple_spinner_layout, getSymbolsList(state, splitValue[0]));
                listView.setAdapter(adapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private List<String> getSymbolsList(String sourceState, String spinnerSelectedValue) {

        List<String> symbols = new ArrayList<>();
        List<Institution> institutions = new ArrayList<>();

        String pattern = "([a-zA-Z]+)([0-9]+)";
        Pattern patternObject = Pattern.compile(pattern);

        Matcher matcher = patternObject.matcher(spinnerSelectedValue);

        String categoryName;
        Integer zone;

        if (matcher.find()) {
            categoryName = matcher.group(1);
            zone = Integer.valueOf(matcher.group(2));
        } else {
            return symbols;
        }

        switch (categoryName) {
            case "BKFREE":
                institutions = oclcDao.getBookFreeInstitutionsBySourceStateAndZone(sourceState, zone);
                break;
            case "BKPAY":
                institutions = oclcDao.getBookPayInstitutionsBySourceStateAndZone(sourceState, zone);
                break;
            case "ARFREE":
                institutions = oclcDao.getARFreeInstitutionsBySourceStateAndZone(sourceState, zone);
                break;
            case "ARPAY":
                institutions = oclcDao.getARPayInstitutionsBySourceStateAndZone(sourceState, zone);
                break;
        }

        for (Institution institution : institutions) {
            symbols.add(institution.getSymbol());
        }
        return symbols;
    }

    private ArrayAdapter createArrayAdapter(String sourceState) {
        List<String> stateZoneSummaries = new ArrayList<>();

        stateZoneSummaries.addAll(getBookFreeZoneSummaries(sourceState));
        stateZoneSummaries.addAll(getBookPayZoneSummaries(sourceState));
        stateZoneSummaries.addAll(getARFreeZoneSummaries(sourceState));
        stateZoneSummaries.addAll(getARPayZoneSummaries(sourceState));

        return new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, stateZoneSummaries);
    }

    private List<String> getBookFreeZoneSummaries(String sourceState) {
        List<String> stateZoneSummary = new ArrayList<>();
        for (int i = 0; i <=11; i++) {
            String paddedCount = StringUtils.leftPad(String.valueOf(i),2,'0');
            stateZoneSummary.add("BKFREE" + paddedCount + " (" + oclcDao.getBookFreeCount(sourceState, i) + ")");
        }
        return stateZoneSummary;
    }

    private List<String> getBookPayZoneSummaries(String sourceState) {
        List<String> stateZoneSummary = new ArrayList<>();
        for (int i = 0; i <=11; i++) {
            String paddedCount = StringUtils.leftPad(String.valueOf(i),2,'0');
            stateZoneSummary.add("BKPAY" + paddedCount + " (" + oclcDao.getBookPayCount(sourceState, i) + ")");
        }
        return stateZoneSummary;
    }

    private List<String> getARFreeZoneSummaries(String sourceState) {
        List<String> stateZoneSummary = new ArrayList<>();
        for (int i = 0; i <=11; i++) {
            String paddedCount = StringUtils.leftPad(String.valueOf(i),2,'0');
            stateZoneSummary.add("ARFREE" + paddedCount + " (" + oclcDao.getARFreeCount(sourceState, i) + ")");
        }
        return stateZoneSummary;
    }

    private List<String> getARPayZoneSummaries(String sourceState) {
        List<String> stateZoneSummary = new ArrayList<>();
        for (int i = 0; i <=11; i++) {
            String paddedCount = StringUtils.leftPad(String.valueOf(i),2,'0');
            stateZoneSummary.add("ARPAY" + paddedCount + " (" + oclcDao.getARPayCount(sourceState, i) + ")");
        }
        return stateZoneSummary;
    }
}