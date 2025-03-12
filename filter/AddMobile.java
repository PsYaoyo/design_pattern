public class AddMobile extends FirstExecuteProcessor
{

    @Override
    protected void executeStringMobile(StringBuilder s, StringBuilder s2)
    {
        System.out.println("Add Mobile");
        s.append("132312121210000");
        s2.append("132312121210000");
        System.out.println(s);
        System.out.println(s2);
    }
}
