import java.util.LinkedList;

public class MyBuffer {
    private int size=0;
	private LinkedList<String> data;
	private int MaxSize;
	private boolean value=false;
	
	public MyBuffer(int size) {
		this.MaxSize=size;
		this.data=new LinkedList<String>();
	}
	
	public synchronized void addWord(String mot) throws InterruptedException {
		if(value||size>=MaxSize)
			wait();
		System.out.println("Ajouter un mot: "+mot);
		data.add(mot);
		size++;
		value=true;
		notify();
	}
	public synchronized String getWord() throws InterruptedException {
		if(!value|| size<=0) {
			wait();
		}
		String string =data.get(size-1);
		System.out.println("Prendre un mot: "+string);
		
		data.remove(size-1);
		size--;
		value=false;
		notify();
		return string;
	}
	public LinkedList<String> getWords(){
		return this.data;
	}
}
