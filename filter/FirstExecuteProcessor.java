public abstract class FirstExecuteProcessor extends StringMobileProcessor implements Filter<StringBuilder, StringBuilder>
{
    @Override
    public <CHAIN extends AbstractProcessorChain<StringBuilder, StringBuilder>> void doChain(StringBuilder s, StringBuilder s2, CHAIN chain)
            throws Exception
    {
        //业务处理
        executeStringMobile(s,s2);
        chain.doExec(s, s2);
    }
}
