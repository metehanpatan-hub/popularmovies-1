package patan.popularmovies.stage1;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String title, overview, poster_path, release_date;
    private Double vote_average;

    private final String POSTER_BASE_URL = "https://image.tmdb.org/t/p/w185";

    public Movie() {
    }

    //Getters and Setters
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }
    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPoster_path() {
        return POSTER_BASE_URL + poster_path;
    }
    public void setPoster_path(String poster_path) {
        this.poster_path = poster_path;
    }

    public String getRelease_date() {
        return release_date;
    }
    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Double getVote_average() {
        return vote_average;
    }
    public void setVote_average(Double vote_average) {
        this.vote_average = vote_average;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(poster_path);
        dest.writeString(overview);
        dest.writeString(release_date);
        dest.writeDouble(vote_average);
    }

    public Movie(Parcel parcel) {
        title = parcel.readString();
        poster_path = parcel.readString();
        overview = parcel.readString();
        release_date = parcel.readString();
        vote_average = parcel.readDouble();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        public Movie createFromParcel(Parcel src) {
            return new Movie(src);
        }

        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
