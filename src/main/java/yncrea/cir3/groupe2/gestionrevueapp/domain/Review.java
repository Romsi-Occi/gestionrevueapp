package yncrea.cir3.groupe2.gestionrevueapp.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Review extends Review_template {

    @Id @Column
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "review")
    @SequenceGenerator(name="review", sequenceName = "seq_review")
    private Long id;

    //@Column
    //private String title;

    @Column
    private int highest_CVSS;

    @Column
    private int noncompliances;

    @OneToMany(mappedBy = "parent", cascade = CascadeType.REMOVE)
    private List<ControlPoint> points;

    @ManyToOne
    private Projet parent_review;
    
    public void computeControlPoints()
    {
        setNoncompliances(0);
        setHighest_CVSS(0);

        for (ControlPoint point : points)
        {
            if(point.getCVSS() > getHighest_CVSS())
            {
                setHighest_CVSS(point.getCVSS());
            }

            if(point.getConform())
            {
                setNoncompliances(1 + getNoncompliances());
            }

        }
    }
}
