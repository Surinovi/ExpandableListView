package com.gyk2017.expandablelistview;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends Activity implements ExpandableListView.OnChildClickListener {
    private ExpandableListAdapter mExpandableListAdapter;
    private ExpandableListView mExpandableListView;

    // Group/parent data
    private List<String> listDataHeader;

    // HashMap is a a data structure, based on hashing, which allows one to
    // store object as key value pair, advantage of using HashMap is that, one
    // can retrieve object on constant time i.e. O(1), if one knows the key.
    private HashMap<String, List<String>> listDataChild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Hides the title bar (must be used before setContentView)
        // Requires import android.view.Window
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);

        mExpandableListView = (ExpandableListView) findViewById(R.id.explv1);

        // Preparing list data
        prepareListData();

        mExpandableListAdapter = new ExpandableListAdapter(this, listDataHeader, listDataChild);

        // Setting list adapter
        mExpandableListView.setAdapter(mExpandableListAdapter);
        mExpandableListView.setOnChildClickListener(this);
    }

    // Preparing the list data
    private void prepareListData() {
        listDataHeader = new ArrayList<String>();
        listDataChild = new HashMap<String, List<String>>();

        // Adding group/parent data
        listDataHeader.add("Top 250");
        listDataHeader.add("Now Showing");
        listDataHeader.add("Coming Soon..");

        // Adding child1 data
        List<String> top250 = new ArrayList<String>();
        top250.add("The Shawshank Redemption");
        top250.add("The Godfather");
        top250.add("The Godfather: Part II");
        top250.add("Pulp Fiction");
        top250.add("The Good, the Bad and the Ugly");
        top250.add("The Dark Knight");
        top250.add("12 Angry Men");

        // Adding child2 data
        List<String> nowShowing = new ArrayList<String>();
        nowShowing.add("The Conjuring");
        nowShowing.add("Despicable Me 2");
        nowShowing.add("Turbo");
        nowShowing.add("Grown Ups 2");
        nowShowing.add("Red 2");
        nowShowing.add("The Wolverine");

        // Adding child3 data
        List<String> comingSoon = new ArrayList<String>();
        comingSoon.add("2 Guns");
        comingSoon.add("The Smurfs 2");
        comingSoon.add("The Spectacular Now");
        comingSoon.add("The Canyons");
        comingSoon.add("Europa Report");

        // Header, Child data
        listDataChild.put(listDataHeader.get(0), top250);
        listDataChild.put(listDataHeader.get(1), nowShowing);
        listDataChild.put(listDataHeader.get(2), comingSoon);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View view,
                                int groupPosition, int childPosition, long id) {
        // TODO Auto-generated method stub
        TextView mTextView = (TextView) view.findViewById(R.id.tvListItem);

        Toast.makeText(getBaseContext(), mTextView.getText().toString(), Toast.LENGTH_SHORT).show();

        return false;
    }
}
