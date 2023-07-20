package LLD.Jira.model;

import LLD.Jira.controller.JiraController;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        User user=new User();
        user.setAddress("address");
        user.setEmail("test@gmai.com");
        user.setName("tester");
        List<Sprint> sprints=new ArrayList<>();
        List<User> userList=new ArrayList<>();
        userList.add(user);

        JiraController jiraController=new JiraController();

        Jira jira=jiraController.create(sprints,userList);

        Sprint sprint=new Sprint();
        sprint.id=1;
        sprint.setSpecialEntityList(new ArrayList<>());
        jiraController.createSprint(jira,sprint);


        Story story=new Story();
        story.setSubTaskList(new ArrayList<>());
        story.setUser(user);

        jiraController.assignTaskTo(jira, 1, story);

        System.out.println(jira.toString());

    }
}
