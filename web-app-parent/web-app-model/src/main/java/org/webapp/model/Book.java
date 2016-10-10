package org.webapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "repository.Book")
public class Book implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -3476936475623063326L;

    @Id
    private long id;

    private String title;
    private String subtitle;

    @Column(length = 1000)
    private String description;
    private String author;
    private long isbn;
    private int page;
    private int year;
    private String publisher;
    private String image;
    private String download;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getSubtitle() {
        return subtitle;
    }
    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public long getIsbn() {
        return isbn;
    }
    public void setIsbn(long isbn) {
        this.isbn = isbn;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }
    public String getPublisher() {
        return publisher;
    }
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getDownload() {
        return download;
    }
    public void setDownload(String download) {
        this.download = download;
    }

    @Override
    public String toString() {
        return "Book [id=" + id + ", title=" + title + ", subtitle=" + subtitle
                + ", description=" + description + ", author=" + author
                + ", isbn=" + isbn + ", page=" + page + ", year=" + year
                + ", publisher=" + publisher + ", image=" + image
                + ", download=" + download + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((author == null) ? 0 : author.hashCode());
        result = prime * result
                + ((description == null) ? 0 : description.hashCode());
        result = prime * result
                + ((download == null) ? 0 : download.hashCode());
        result = prime * result + (int) (id ^ (id >>> 32));
        result = prime * result + ((image == null) ? 0 : image.hashCode());
        result = prime * result + (int) (isbn ^ (isbn >>> 32));
        result = prime * result + page;
        result = prime * result
                + ((subtitle == null) ? 0 : subtitle.hashCode());
        result = prime * result + ((title == null) ? 0 : title.hashCode());
        result = prime * result + year;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        if (author == null) {
            if (other.author != null)
                return false;
        } else if (!author.equals(other.author))
            return false;
        if (description == null) {
            if (other.description != null)
                return false;
        } else if (!description.equals(other.description))
            return false;
        if (download == null) {
            if (other.download != null)
                return false;
        } else if (!download.equals(other.download))
            return false;
        if (id != other.id)
            return false;
        if (image == null) {
            if (other.image != null)
                return false;
        } else if (!image.equals(other.image))
            return false;
        if (isbn != other.isbn)
            return false;
        if (page != other.page)
            return false;
        if (publisher != other.publisher)
            return false;
        if (subtitle == null) {
            if (other.subtitle != null)
                return false;
        } else if (!subtitle.equals(other.subtitle))
            return false;
        if (title == null) {
            if (other.title != null)
                return false;
        } else if (!title.equals(other.title))
            return false;
        if (year != other.year)
            return false;
        return true;
    }

}

