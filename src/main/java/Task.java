import static java.text.MessageFormat.format;

public class Task {
    Integer Id;
    String Description;
    StatusEnum Status;

    public Task(Integer ID, String description, StatusEnum status) {
        Id = ID;
        Description = description;
        Status = status;
    }

    @Override
    public String toString() {
        return format("ID: {0}, Description: {1}, Status: {2}", Id, Description, Status);
    }
}
