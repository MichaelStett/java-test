import static java.text.MessageFormat.format;

public class MenuDisplay {
    String Text;

    MenuDisplay() {
        StringBuilder sb = new StringBuilder();

        sb.append("-----------------\n");
        sb.append("Task Manager Menu:");
        for (var opt :
                MenuOptionsEnum.stream()
                        .sorted()
                        .map(MenuOptionsEnum::asPair)
                        .toList()){
            String result = format("\n{0}. {1}", opt.getValue0(), opt.getValue1());

            sb.append(result);
        }

        Text = sb.toString();
    }
}
