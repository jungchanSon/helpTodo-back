package HelpTodo.helptodoBackend.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="members")
@Getter @Setter
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    private String loginId;
    private String loginPw;


    @OneToMany(mappedBy = "member", cascade= CascadeType.ALL)
    private List<MemberTeam> memberTeam = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "new_entity_ID")
    private NewEntity newEntity;

}
