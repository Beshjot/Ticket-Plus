package com.besh.ticketplus.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class News
{
    @Id
    private long newsId;
    @Column
    private String title;
    @Column
    private String details;
    public News()
    {

    }

    public News(long newsId, String title, String details) {
        this.newsId = newsId;
        this.title = title;
        this.details = details;
    }

    public long getNewsId() {
        return newsId;
    }

    public void setNewsId(long newsId) {
        this.newsId = newsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof News)) return false;
        News news = (News) o;
        return newsId == news.newsId &&
                Objects.equals(title, news.title) &&
                Objects.equals(details, news.details);
    }

    @Override
    public int hashCode() {
        return Objects.hash(newsId, title, details);
    }

    @Override
    public String toString() {
        return "News{" +
                "newsId=" + newsId +
                ", title='" + title + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
