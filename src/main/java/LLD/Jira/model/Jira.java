package LLD.Jira.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class Jira {
    List<User> userList;
    List<Sprint> sprints;

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public void setSprints(List<Sprint> sprints) {
        this.sprints = sprints;
    }

    public static JiraBuilder getBuilder(){
        return new JiraBuilder();
    }

    public static class JiraBuilder{
        List<User> userList;
        List<Sprint> sprints;

        public JiraBuilder setUserList(List<User> userList) {
            this.userList = userList;
            return this;
        }

        public JiraBuilder setSprints(List<Sprint> sprints) {
            this.sprints = sprints;
            return this;
        }

        public Jira build(){
            Jira jira=new Jira();
            jira.setSprints(this.sprints);
            jira.setUserList(this.userList);
            return jira;
        }
    }
}
