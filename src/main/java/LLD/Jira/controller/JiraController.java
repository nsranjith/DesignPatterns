package LLD.Jira.controller;

import LLD.Jira.model.Jira;
import LLD.Jira.model.SpecialEntity;
import LLD.Jira.model.Sprint;
import LLD.Jira.model.User;

import java.util.List;

public class JiraController {

    public Jira create(List<Sprint> sprints, List<User> userList){
        return Jira.getBuilder()
                .setSprints(sprints)
                .setUserList(userList)
                .build();
    }
    public Jira createSprint(Jira jira, Sprint sprint){
        jira.getSprints().add(sprint);
        return jira;
    }
    public Sprint assignTaskTo(Jira jira, Integer sprintId, SpecialEntity specialEntity){
        Sprint toDoSprint=null;
        for(Sprint s: jira.getSprints()){
              if(s.getId().intValue()==sprintId){
                  s.getSpecialEntityList().add(specialEntity);
                  return s;
              }
          }
        return null;
    }

}
