public class ScatterSystem
{
    double makeOperation(double[] input)
    {
       double value=1;

       for(double x : input)
       {
           value+=x;
       }

       return value;
    }
}
