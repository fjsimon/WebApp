package org.webapp.model;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Objects;

//@Indexed
@Entity
@Table(name = "repository.Book")
public class Book extends Identity {

//    @Field
    private String title;

//    @Field
    private String subtitle;

//    @Field
    @Column(length = 1000)
    private String description;

    private String author;
    private long isbn;
    private int page;
    private int year;
    private String publisher;
    private String image;
    private String download;

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
        return "Book [id=" + getId() + ", title=" + title + ", subtitle=" + subtitle
                + ", description=" + description + ", author=" + author
                + ", isbn=" + isbn + ", page=" + page + ", year=" + year
                + ", publisher=" + publisher + ", image=" + image
                + ", download=" + download + "]";
    }

    @Override
    public int hashCode() {

//        return Objects.hashCode(this);

        return new HashCodeBuilder()
                .append(author)
                .append(description)
                .append(download)
                .append(getId())
                .append(image)
                .append(isbn)
                .append(page)
                .append(subtitle)
                .append(title)
                .append(year)
                .toHashCode();
    }

    @Override
    public boolean equals(Object obj) {

//        return Objects.equals(this, obj);

        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() == obj.getClass()) {
            Book other = (Book) obj;
            return new EqualsBuilder()
                    .append(author, other.author)
                    .append(description, other.description)
                    .append(download, other.download)
                    .append(getId(), other.getId())
                    .append(image, other.image)
                    .append(isbn, other.isbn)
                    .append(page, other.page)
                    .append(publisher, other.publisher)
                    .append(subtitle, other.subtitle)
                    .append(title, other.title)
                    .append(year, other.year)
                    .isEquals();

        } else {
            return false;
        }
    }

}

