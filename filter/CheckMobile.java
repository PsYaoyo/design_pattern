import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CheckMobile extends FirstExecuteProcessor
{

    @Override
    protected void executeStringMobile(StringBuilder s, StringBuilder s2)
    {
        System.out.println("CheckMobile");
        Pattern pattern = Pattern.compile("(\\d+])");
        Matcher matcher = pattern.matcher(s);
        if(matcher.find()){
            String tmp = matcher.group();
            System.out.println(tmp);
            if(tmp.length() > 11){
                System.out.println("mobile number is too long");
                s2.delete(0,s.length());
                s2.append("return mobile false");
            }
        }
    }
}
