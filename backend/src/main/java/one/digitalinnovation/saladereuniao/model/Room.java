package one.digitalinnovation.saladereuniao.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Table(name = "meeting_room")
@AllArgsConstructor(onConstructor = @__(@Autowired))
@NoArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false, name = "name")
    private String name;

    @Column(nullable = false, name = "date")
    private String date;

    @Column(nullable = false, name = "start_time")
    private String startHour;

    @Column(nullable = false, name = "end_time")
    private String endHour;

    @Override
    public String toString() {
        return "Room [id= " + id + ", name= " + name + ", start= " + startHour + ", end= " + endHour + "]";
    }

}
