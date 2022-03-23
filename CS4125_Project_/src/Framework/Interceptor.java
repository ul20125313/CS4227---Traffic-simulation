package Framework;

public interface Interceptor {
	public void prepay(PrePayContext context);
	public void postpay(Context context);

}
