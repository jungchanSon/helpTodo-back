package HelpTodo.helptodoBackend.Form.TodoListForm;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AddTDDForm {

    String teamName;
    String Content;
    Long TodoListId;

    int importance;
}
