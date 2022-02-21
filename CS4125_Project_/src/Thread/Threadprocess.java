package Thread;

//This will process the detailed logic when mulitple threads are processing, and it will report errors if some exception is handled such as race condition.
public class Threadprocess {

	private int wait_time_ms;
	private long s_time, e_time, duration;
	private String message;
	
	private static final int framerate = 30;
	public static final int DEFAULT_FRAMERATE = (int)(1000 / framerate);
	
	//two constructor function in order to cope with different conditions
	public Threadprocess () 
	{
		this.wait_time_ms = 0;
	}
	
	public Threadprocess(int milliseconds) 
	{
		this.wait_time_ms = milliseconds;
	}
	
	
	public void setMessage(String _message) 
	{
		this.message = _message;
	}
	
	
	public void start() //set the s_time
	{
		this.s_time = System.nanoTime();
		
	}	
	
	
	public void end() //set the s_time and compute the duration
	{
		this.e_time = System.nanoTime();
		this.duration = (this.e_time - this.s_time) / 1000000;
		this.sleep();// when one thread complete one atomic task, it will start sleeping to let other thread start working
	}
	
	
	private boolean message_empty() //this function will be used to check whether the message is empty
	{
		return (this.message == null || this.message.isEmpty());
	}
	
	
	private void sleep()
	{
		try {
			Thread.sleep(Math.max(this.wait_time_ms - this.duration, 0));
		} 
		catch (InterruptedException ex) {
			if (!this.message_empty()) {
				System.out.printf("Thread errors!!!\n");// if one of threads is interrupted, it will report error
			}
		}
	}
	
}
