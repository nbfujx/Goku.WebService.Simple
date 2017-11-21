package com.goku.webapi.util.dataview;

import org.omg.CORBA.PRIVATE_MEMBER;

/**
 * Created by nbfujx on 2017/11/21.
 */
public class TreeInfo {

    private String id;
    private String title;
    private boolean expand;
    private boolean selected;
    private boolean checked;
    private TreeInfo children;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isExpand() {
        return expand;
    }

    public void setExpand(boolean expand) {
        this.expand = expand;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public TreeInfo getChildren() {
        return children;
    }

    public void setChildren(TreeInfo children) {
        this.children = children;
    }
}
