package com.practiceavinash.app3;
import java.io.Serializable;

public class Movie implements Serializable
    {
        private int id;
        private String title ;
        private String description;
        private double ratings ;
        private int image;

        public Movie() {
        }

        public Movie(int id, String title, String description, double ratings, int image) {
            this.id = id;
            this.title = title;
            this.description = description;
            this.ratings = ratings;
            this.image = image;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public double getRatings() {
            return ratings;
        }

        public void setRatings(double ratings) {
            this.ratings = ratings;
        }

        public int getImage() {
            return image;
        }

        public void setImage(int image) {
            this.image = image;
        }
    }
