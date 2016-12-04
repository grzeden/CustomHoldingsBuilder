package edu.grzegorzewski.customholdingsbuilder;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        String test = "KJR MSO NDI GKR ISN LFO KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM " +
                "KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI " +
                "GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE " +
                "CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO " +
                "DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OWQ " +
                "IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH " +
                "PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN " +
                "MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF " +
                "EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR " +
                "NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM " +
                "ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF " +
                "KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 " +
                "PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO " +
                "NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD " +
                "AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN " +
                "LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN " +
                "OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DEI KFH " +
                "SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF " +
                "JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ " +
                "CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD " +
                "SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF " +
                "OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE " +
                "OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU " +
                "AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR " +
                "MSO NDI GKR ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN " +
                "OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR " +
                "ISN LFO DFKEI KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ " +
                "KDN OWQ IFN KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI " +
                "KFH SWH PYI LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN " +
                "KEF JSN MTF PGD SHR NFH SNE OCF KEN KJR MSO NDI GKR ISN LFO DFKEI KFH SWH PYI " +
                "LSJ CJF EKV WJF OGM ISJ JGU AK6 PFM KAN OMD AJE CFQ KDN OFJWQ IFN KEF JSN MTF ";

        TextView holdingsList = (TextView) findViewById(R.id.textView_holdings_list);
        holdingsList.setText(test);
    }
}