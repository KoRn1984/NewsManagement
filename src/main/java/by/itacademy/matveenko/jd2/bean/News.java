package by.itacademy.matveenko.jd2.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idNews = 0;
	private String title = "";
	private String briefNews = "";
	private String content = "";
	private String newsDate = "";
	
	public News(){}

	public News(Integer idNews, String title, String briefNews, String content, String newsDate) {
		super();
		this.idNews = idNews;
		this.title = title;
		this.briefNews = briefNews;
		this.content = content;
		this.newsDate = newsDate;
	}

	public Integer getIdNews() {
		return idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBriefNews() {
		return briefNews;
	}

	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
		
	}

	public String getNewsDate() {
		return newsDate;
	}

	public void setNewsDate(String newsDate) {
		this.newsDate = newsDate;
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News that = (News) obj;
        return Objects.equals(idNews, that.idNews) && Objects.equals(title, that.title) && Objects.equals(briefNews, that.briefNews) && Objects.equals(content, that.content) 
        		&& Objects.equals(newsDate, that.newsDate);
    }
	
	@Override
    public String toString() {
        return "News{" +
                "idNews='" + idNews + '\'' +
                ", title='" + title + '\'' +
                ", briefNews='" + briefNews + '\'' +
                ", content='" + content + '\'' +
                ", newsDate='" + newsDate + '\'' +
                '}';
    }	
}