package utils;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Set;

public class WebPage {

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("linksFromPage")
    @Expose
    private Set<String> linksFromPage;

    @SerializedName("title")
    @Expose
    private String title;

    public WebPage(String link, Set<String> linksFromPage, String title) {
        this.link = link;
        this.linksFromPage = linksFromPage;
        this.title = title;
    }

    public WebPage(String link) {
        this.link = link;
    }

    public WebPage(String link, String title) {
        this.link = link;
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Set<String> getLinksFromPage() {
        return linksFromPage;
    }

    public void setLinksFromPage(Set<String> linksFromPage) {
        this.linksFromPage = linksFromPage;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return JsonUtils.toJson(this);
    }
}
