package pack;

public class StringUtil
{
    private static StringBuffer formater(StringBuffer sb, Object[] args)
    {
        char c;
        for (int i = sb.length() - 1; i >= 0; i--)
        {
            c = sb.charAt(i);
            if (c == '}')
            {
                int multiplier = 1, num = 0;
                boolean isNum = true;
                int startI = i;
                i--;
                c = sb.charAt(i);
                do
                {
                    if (c == '}')
                    {
                        isNum = false;
                        i++;
                        break;
                    }
                    switch (c)
                    {
                        case '0' -> num += 0 * multiplier;
                        case '1' -> num += 1 * multiplier;
                        case '2' -> num += 2 * multiplier;
                        case '3' -> num += 3 * multiplier;
                        case '4' -> num += 4 * multiplier;
                        case '5' -> num += 5 * multiplier;
                        case '6' -> num += 6 * multiplier;
                        case '7' -> num += 7 * multiplier;
                        case '8' -> num += 8 * multiplier;
                        case '9' -> num += 9 * multiplier;
                        default -> isNum = false;
                    }

                    multiplier *= 10;

                    i--;
                    c = sb.charAt(i);

                    if (c == '}')
                    {
                        i++;
                        isNum = false;
                    }

                } while (isNum && c != '{');

                if (isNum)
                {
                    String str = args[num].toString();
                    sb.replace(i, startI + 1, str);
                    i = startI - str.length() + 1;
                }

            }
        }

        return sb;
    }

    public static String format(String str, Object ...args)
    {
        return formater(new StringBuffer(str), args).toString();
    }

    public static StringBuffer format(StringBuffer sb, Object ...args)
    {
        return formater(sb, args);
    }

}
