package spring.tutorial.service.mapper;

import org.springframework.stereotype.Component;
import spring.tutorial.domain.Score;
import spring.tutorial.dto.ScoreDto;

/**
 * Created by Robert on 10/11/2015.
 */
@Component
public class ScoreMapper extends AbstractMapper<ScoreDto, Score>{

    @Override
    public ScoreDto map(Score score) {
        if (score == null){
            return null;
        }
        return new ScoreDto(score.getUserName(),score.getScore(), score.getDate());
    }

    @Override
    public void map(ScoreDto scoreDto, Score score) {
        if(scoreDto == null || score == null){
            return;
        }

        score.setId(scoreDto.getId());
        score.setDate(scoreDto.getDate());
        score.setScore(scoreDto.getScore());
        score.setUserName(scoreDto.getUserName());
    }
}
