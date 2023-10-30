package AssesmemntQuestions;
public class Pattern {
    public static void main(String[] args)
    {
        int i,j,n=5,k=1,l=2,m=1;
        for(i=1;i<=n;i++)
        {
            m=k;
            for(j=1;j<=i;j++)
            {
                System.out.print(m +" ");
                m--;
            }
            k=k+l;
            l++;
            System.out.println();
        }
    }
}
