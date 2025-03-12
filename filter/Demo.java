public class Demo
{
    public static void main(String[] args)
    {
        FirstProcessorChain chain = new FirstProcessorChain();
        StringBuilder s = new StringBuilder("yaopengshuai");
        StringBuilder s2 = new StringBuilder("return");
        chain.doExec(s, s2);
        System.out.println(s);
        System.out.println(s2);
    }
}
