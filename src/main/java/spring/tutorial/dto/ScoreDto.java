package spring.tutorial.dto;


import java.time.LocalDateTime;

/**
 * Created by Robert on 10/11/2015.
 */
public class ScoreDto implements Identifiable {
    private Long id;
    private String userName;
    private Long score;
    private LocalDateTime date;

    public ScoreDto(String userName, Long score, LocalDateTime date){
        this.userName = userName;
        this.score = score;
        this.date = date;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
