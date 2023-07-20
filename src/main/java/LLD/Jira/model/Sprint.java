package LLD.Jira.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Sprint extends BaseModel {
    List<SpecialEntity> specialEntityList;
}
