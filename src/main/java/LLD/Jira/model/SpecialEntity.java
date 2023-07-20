package LLD.Jira.model;

public abstract class SpecialEntity {
    Type type;
    User assignedTo;
    SpecialEntity(Type type){
        this.type=type;
    }
}
