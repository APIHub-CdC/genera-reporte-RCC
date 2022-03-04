package com.circulodecredito.generarreporte.mapper;

import javax.xml.bind.annotation.XmlElement;

public class Scores {
	
    private Score score;

    @XmlElement(name ="Score")
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }
}
