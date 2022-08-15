package by.itacademy.matveenko.jd2.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer idNews = 0;
	private String titleNews = "";
	private String briefNews = "";
	private String contentNews = "";
	private String dateNews = "";
	//private Integer idReporter = 0;
	
	public News(){}

	public News(Integer idNews, String titleNews, String briefNews, String contentNews, String dateNews) {
		super();
		this.idNews = idNews;
		this.titleNews = titleNews;
		this.briefNews = briefNews;
		this.contentNews = contentNews;
		this.dateNews = dateNews;
		//this.idReporter = idReporter;
	}

	public Integer getIdNews() {
		return idNews;
	}

	public void setIdNews(Integer idNews) {
		this.idNews = idNews;
	}

	public String getTitleNews() {
		return titleNews;
	}

	public void setTitleNews(String titleNews) {
		this.titleNews = titleNews;
	}

	public String getBriefNews() {
		return briefNews;
	}

	public void setBriefNews(String briefNews) {
		this.briefNews = briefNews;
	}

	public String getContentNews() {
		return contentNews;
	}

	public void setContentNews(String contentNews) {
		this.contentNews = contentNews;
		
	}

	public String getDateNews() {
		return dateNews;
	}

	public void setDateNews(String dateNews) {
		this.dateNews = dateNews;
	}
	
	//public Integer getIdReporter() {
	//	return idReporter;
	//}

	//public void setIdReporter(Integer idReporter) {
	//	this.idReporter = idReporter;
	//}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        News that = (News) obj;
        return Objects.equals(idNews, that.idNews) && Objects.equals(titleNews, that.titleNews) && Objects.equals(briefNews, that.briefNews) && Objects.equals(contentNews, that.contentNews) 
        		&& Objects.equals(dateNews, that.dateNews);
    }
	
	@Override
    public String toString() {
        return "News{" +
                "idNews='" + idNews + '\'' +
                ", titleNews='" + titleNews + '\'' +
                ", briefNews='" + briefNews + '\'' +
                ", contentNews='" + contentNews + '\'' +
                ", dateNews='" + dateNews + '\'' +                
                '}';
    }	
}