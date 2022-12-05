package se.systementor.supershoppen1.shop.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Column
    private String message;

    @Column
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm a z")
    private Date date;
}