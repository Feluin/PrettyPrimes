import java.lang.reflect.Method;
import java.math.BigInteger;
import java.util.ArrayList;

public class PrettyPrimes
{

    private PrettyPrimes instance = new PrettyPrimes();
    public Port port;

    public PrettyPrimes getInstance()
    {
        return instance;
    }

    private PrettyPrimes()
    {
        port = new Port();
    }

    public class Port implements IPrettyPrimes
    {
        private Method[] methods = getClass().getMethods();

        public void listMethods()
        {
            System.out.println("--- public methods for " + getClass().getName());
            for (int i = 0; i < methods.length; i++)
            {

                System.out.println(methods[i]);
                System.out.println("---");
            }

        }

        public ArrayList<BigInteger> execute(BigInteger rangeFrom,
            BigInteger rangeTo)
        {
            return findprimes(rangeFrom, rangeTo);
        }
    }

    public ArrayList<BigInteger> findprimes(BigInteger rangeFrom,
        BigInteger rangeTo)
    {

        ArrayList<BigInteger> primes = new ArrayList<>();
        while (rangeTo.subtract(rangeFrom).signum() == 1)
        {
            if (BigMath.returnPrime(rangeFrom) && BigMath.returnPrime(rangeFrom.add(BigInteger.valueOf(6))) &&
                BigMath.returnPrime(rangeFrom.add(BigInteger.valueOf(12))))
            {
                primes.add(rangeFrom);
            }
            rangeFrom = rangeFrom.add(BigInteger.ONE);

        }
        return primes;
    }

}
