package com.juanguachi.webservice;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Emoji {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("group")
    @Expose
    private String group;
    @SerializedName("htmlCode")
    @Expose
    private List<String> htmlCode = null;
    @SerializedName("unicode")
    @Expose
    private List<String> unicode = null;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public List<String> getHtmlCode() {
        return htmlCode;
    }

    public void setHtmlCode(List<String> htmlCode) {
        this.htmlCode = htmlCode;
    }

    public List<String> getUnicode() {
        return unicode;
    }

    public void setUnicode(List<String> unicode) {
        this.unicode = unicode;
    }

    @Override
    public String toString() {
        return "Emoji{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", group='" + group + '\'' +
                ", htmlCode=" + htmlCode +
                ", unicode=" + unicode +
                '}';
    }
}