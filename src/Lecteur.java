import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class Lecteur extends Thread{
	
	private String threadName;
	private String fileName;
	private MyBuffer buff;
	FileInputStream fis;
	int n=9;
	
	public Lecteur(String threadName,String fileName, MyBuffer buff) throws IOException {
		this.threadName=threadName;
		this.fileName=fileName;
		this.buff=buff;
		fis=new FileInputStream(new File("C:\\Users\\Mlle.Wiss\\eclipse-workspace-java\\DS1_Java\\src\\fichier1.txt"));
	}
	
	public String readWord() throws IOException {
		String str="";
		byte[] by=new byte[1];
		int i=0;
		while((i = fis.read(by)) != -1 && Character.toString((char) by[0]).matches("\\w")) {
			str+= Character.toString((char) by[0]);
		}
		n=i;
		return str;
	}
	
	public void run() {
		super.run();
		try {
			while(true) {
				this.buff.addWord(readWord());
				if(n== -1)
					break;
			}
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
