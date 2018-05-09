package pl.org.sh.portalharcerza.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;
import pl.org.sh.portalharcerza.R;

import java.util.HashMap;
import java.util.List;

import pl.org.sh.portalharcerza.SprawnoscCzysta;

/**
 * Created by Adam on 2017-10-12.
 */

public class ExpListVievAdapter extends BaseExpandableListAdapter {

    private Context ctx;
    private HashMap<String, List<SprawnoscCzysta>> hash_map;
    private List<String> kategorie_list;

    public ExpListVievAdapter( Context ctx, HashMap<String, List<SprawnoscCzysta>> hm, List<String> sl )
    {
        this.ctx = ctx;
        this.hash_map = hm;
        this.kategorie_list = sl;
    }

    @Override
    public SprawnoscCzysta getChild(int parent, int child) {

        return hash_map.get(kategorie_list.get(parent)).get(child);
    }

    @Override
    public long getChildId(int parent, int child) {
        // TODO Auto-generated method stub
        return child;
    }

    @Override
    public View getChildView(int parent, int child, boolean lastChild, View convertview,
                             ViewGroup parentview)
    {
        String child_title = getChild(parent, child).getNazwa();
        int child_lvl = getChild(parent, child).getPoziom();
        String child_level;
        switch (child_lvl){
            case 1: child_level = "*";
                break;
            case 2: child_level = "**";
                    break;
            case 3: child_level = "***";
                    break;
            case 4: child_level = "M";
                    break;
            default:child_level = "?";
                    break;
        }
        String child_label = child_title + " " + child_level;
        if(convertview == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.child_layout, parentview,false);
        }
        TextView child_textview = (TextView) convertview.findViewById(R.id.child_txt);
        child_textview.setText(child_label);

        return convertview;
    }

    @Override
    public int getChildrenCount(int arg0) {

        return hash_map.get(kategorie_list.get(arg0)).size();
    }

    @Override
    public Object getGroup(int arg0) {
        // TODO Auto-generated method stub
        return kategorie_list.get(arg0);
    }

    @Override
    public int getGroupCount() {
        // TODO Auto-generated method stub
        return hash_map.size();
    }

    @Override
    public long getGroupId(int arg0) {
        // TODO Auto-generated method stub
        return arg0;
    }

    @Override
    public View getGroupView(int parent, boolean isExpanded, View convertview, ViewGroup parentview) {
        // TODO Auto-generated method stub
        String group_title = (String) getGroup(parent);
        if(convertview == null)
        {
            LayoutInflater inflator = (LayoutInflater) ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertview = inflator.inflate(R.layout.parent_layout, parentview,false);
        }
        TextView parent_textview = (TextView) convertview.findViewById(R.id.parent_txt);
        parent_textview.setTypeface(null, Typeface.BOLD);
        parent_textview.setText(group_title);
        return convertview;
    }

    @Override
    public boolean hasStableIds() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isChildSelectable(int arg0, int arg1) {
        // TODO Auto-generated method stub
        return true;
    }

}