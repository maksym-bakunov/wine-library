package mate.team2.winelibrary.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.Date;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@MappedSuperclass
@Data
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity {
    @JsonIgnore
    @CreatedDate
    private Date created;
    @JsonIgnore
    @LastModifiedDate
    private Date updated;
    @JsonIgnore
    private Byte status = 1;
}
