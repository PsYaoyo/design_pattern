import java.util.List;

public class FirstProcessorChain extends AbstractProcessorChain<StringBuilder, StringBuilder>
{
    private static final List<Filter<StringBuilder, StringBuilder>> processors = List.of(
            new AddMobile(), new CheckMobile()
    );
    @Override
    protected List<? extends Filter<StringBuilder, StringBuilder>> getProcessors()
    {
        return processors;
    }
}
