public interface Filter<IN, OUT>
{
    //这里<CHAIN extends AbstractProcessorChain<IN, OUT>> 直接确定了外层链的类型
    <CHAIN extends AbstractProcessorChain<IN, OUT>> void doChain(IN in, OUT out, CHAIN chain) throws Exception;
    default void doInit(IN in, OUT out){}

    default <CHAIN extends AbstractProcessorChain<IN, OUT>> void doException(IN in, OUT out, CHAIN chain, Throwable e){}

    default void doFinal(IN in, OUT out){}
}
