package LLD.Jira.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@ToString
@Getter
@Setter
public class Story extends SpecialEntity{
    public List<SubTask> subTaskList;
    public User user;
    Story() {
        super(Type.STORY);
    }
}
