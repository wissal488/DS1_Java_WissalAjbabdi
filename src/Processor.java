import java.util.HashMap;

public class Processor extends Thread {
	private String PName;
	private MyBuffer buff;
	private HashMap<Integer, String> wordsCounts;
	int a=0;
	
	public HashMap<Integer, String> getWordsCounts(){
		return wordsCounts;
	}
	
	public Processor(String PName, MyBuffer buff) {
		super();
		this.PName=PName;
		this.buff=buff;
		this.wordsCounts=new HashMap<Integer, String>();
	}


	public void run() {
		super.run();
		try {
			while(true) {
				processe();
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void processe() throws InterruptedException {
		wordsCounts.put(++a, buff.getWord());
	}
}
