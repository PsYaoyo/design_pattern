import java.util.List;

public abstract class AbstractProcessorChain<IN,OUT>
{
    private int index = 0;

    protected abstract List<? extends Filter<IN,OUT>> getProcessors() ;

    public final void doExec(IN in, OUT out){
        if (this.index < this.getProcessors().size()) {
            Filter<IN, OUT> processor = this.getProcessors().get(this.index++);
            try{
                processor.doInit(in, out);
                processor.doChain(in, out, this);
            }catch (Exception e) {
                processor.doException(in, out, this, e);
            }finally {
                processor.doFinal(in, out);
            }
        }
    }


}
