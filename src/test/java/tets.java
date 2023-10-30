public class tets {

            public static void main(String[] args) {
                String s = "Hello";
                String s1 = s;
                s = s+"FireFlink";
                System.out.println(s);
                System.out.println(s1);

                StringBuilder str = new StringBuilder("Ok");
                StringBuilder str1 = str;
                str.append("Google");
                System.out.println(str);
                System.out.println(str1);
            }

        }
