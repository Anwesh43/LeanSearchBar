package com.anwesome.ui.searchbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by anweshmishra on 29/03/17.
 */
public class DataSource {
    private ConcurrentLinkedQueue<String> data = new ConcurrentLinkedQueue<>();
    public void setData(Set<String> data) {
        for(String text:data) {
            this.data.add(text);
        }
    }
    public void addToData(String text) {
        boolean present = false;
        for(String containedText:data) {
            if(text.toLowerCase() == containedText.toLowerCase()) {
                present = true;
                break;
            }
        }
        if(!present) {
            this.data.add(text);
        }
    }
    public List<String> matchForResults(String text) {
        List<String> results = new ArrayList<>();
        for(String containedText:data) {
            if(text.length()<= containedText.length() && text.toLowerCase().equals(containedText.toLowerCase().substring(0,text.length()))) {
                results.add(containedText);
            }
        }
        return  results;
    }
    public void removeFromData(String text) {
        for(String containedText:data) {
            if(text.toLowerCase() == containedText.toLowerCase()) {
                data.remove(text);
                break;
            }
        }
    }
}
