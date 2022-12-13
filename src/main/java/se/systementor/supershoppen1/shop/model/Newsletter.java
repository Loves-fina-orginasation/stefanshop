package se.systementor.supershoppen1.shop.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "newsletter")
public class Newsletter {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String subject;

    @Column(length = 4000)
    private String message;

    @Column
    private Boolean sent;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date date;
    @PrePersist
    private void onCreate() {
        date = new Date();
    }

    @ManyToMany
    @JoinTable(
            name = "newsletter_subscribers",
            joinColumns = @JoinColumn(name = "newsletter_id"),
            inverseJoinColumns = @JoinColumn(name = "subscriber_id"))
    List<Subscriber> subscriber;
}