package Observer;

public interface Subject {// the subject interface
	public void registerOb(Observer o);
	public void removerOb(Observer o);
	public void notifyOb();
}
