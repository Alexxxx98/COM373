
public class Errors extends RuntimeException
{
    public static class OverdraftException extends RuntimeException
    {
        public OverdraftException()
        {
            super("Overdraft limited reached\n");
        }
    }
    public static class NumOfWithdrawalsException extends RuntimeException
    {
        public NumOfWithdrawalsException()
        {
            super("Limit of withdrawals reached\n");
        }
    }
    public static class BalanceValueException extends RuntimeException
    {
        public BalanceValueException()
        {
            super("Balance cannot drop below 100\n");
        }
    }
  
}
