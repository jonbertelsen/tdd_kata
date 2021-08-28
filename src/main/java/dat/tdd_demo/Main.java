package dat.tdd_demo;

public class Main
{

    // Requirement 1 + 2 + 3
    
    public static String greet(String name)
    {
        if (name != null)
        {
            if (isUpperCaseOnly(name))
            {
                return "HELLO " + name + "!";
            }
            return "Hi, " + name; 
        }   
        else
        {
            return "Hello, my friend";
        }
    }
    
    public static boolean isUpperCaseOnly(String name)
    {
        char[] charArray = name.toCharArray();
        
        for(int i = 0; i < charArray.length; i++){
            if( !Character.isUpperCase( charArray[i] ))
                return false;
        }
        return true;
    }

    // Requirement 4 + 5
    
    public static String greet(String[] names)
    {
       if (names.length == 1)
       {
           return Main.greet(names[0]);
       }
       if (names.length == 2)
       {
            return "Hello, " + names[0] + " and " + names[1] + ".";
       } 
       if (names.length > 2)
       {
           String greeting = "Hello, ";
           for (int i = 0; i < names.length - 1; i++)
           {
               greeting += names[i] + ", ";
           }
           greeting += "and " + names[names.length - 1] + ".";
           
           return greeting;
       }
       return "Hello, my friend";
    }

    
    // Requirement 6
    
    public static String greetMixedNames(String[] names)
    {
       int lowerCaseNameCount = 0, upperCaseNameCount = 0;
       
       for (int i = 0; i < names.length; i++)
       {
            if (isUpperCaseOnly(names[i]))
            {
               upperCaseNameCount++;
            } else {
                lowerCaseNameCount++;
            }       
       }

       String[] lowerCaseArray = new String[lowerCaseNameCount]; 
       String[] upperCaseArray = new String[upperCaseNameCount];
       
       int iLower = 0, iUpper = 0;
       
       for (int i = 0; i < names.length; i++)
       {
           if (isUpperCaseOnly(names[i]))
           {
               upperCaseArray[iUpper] = names[i];
               iUpper++;
           } else
           {
               lowerCaseArray[iLower] = names[i];
               iLower++;
           
           }
       }
       
       String greeting = null;
       
       if (iLower > 0)
       {
            greeting = greet(lowerCaseArray);   
       }
       
       if (iUpper > 0)
       {
            greeting += " AND " + greet(upperCaseArray);
       }
       
       return greeting;
    }
    
    // Requirement 7

    public static String greetMixedNamesWithCommas(String[] names)
    {
        int nameCount = getNumberOfNamesInArray(names);
        String[] allNamesArray = new String[nameCount];
        int counter = 0;
        
        for (int i = 0; i < names.length; i++)
        {
           if (containsCommaDelimeter(names[i]))  // ["Bob", "\"Charlie, Diane\""]
           {
                allNamesArray[counter] = stripCommaDelimiters(names[i]);
                counter++;
           }
           else
           {
                String[] nameArray = names[i].split(",");
                for (int j = 0; j < nameArray.length; j++)
                {
                    allNamesArray[counter] = nameArray[j].trim();
                    counter++;
                }
           }            
        }
        return greetMixedNames(allNamesArray);
    }
    
    private static int getNumberOfNamesInArray(String[] names)
    {
        int nameCount = 0;
                
        for (int i = 0; i < names.length; i++)
        {
            if (containsCommaDelimeter(names[i]))
            {
                nameCount += 1;
            }
            else
            {
                nameCount += 1 + occurences(',', names[i]);
            }
        }
        return nameCount;
    }
    
    public static int occurences(char c, String s)
    {
        int count = 0;
 
        for (int i = 0; i < s.length(); i++) 
        {
            if (s.charAt(i) == c) 
            {
                count++;
            }
        }
        return count;
    }
    
    public static boolean containsCommaDelimeter(String s)
    {
        int first = s.indexOf('\"');
        int last =  s.lastIndexOf('\"');
        
        return (first != -1 && last != -1);
    } 
    
    public static String stripCommaDelimiters(String s)
    {
        int first = s.indexOf('\"');
        int last =  s.lastIndexOf('\"');
        
        if (first != -1 && last != -1)
        {
            return s.substring(first + 1, last);
        }
        return s;
    }  
    
}
