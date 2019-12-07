import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		MyBuffer buff= new MyBuffer(100);
		Lecteur lecteur=new Lecteur("Thread1", "Lecteur", buff);
		Processor process=new Processor("Processor", buff);
		
		lecteur.start();
		process.start();
		while(lecteur.isAlive()||process.isAlive()) {
			
		}
		System.out.println("-----------Processor WordsCounts---------");
		HashMap<Integer, String> hashMap=process.getWordsCounts();
		Set<Integer> set= hashMap.keySet();
		Iterator<Integer> it=set.iterator();
		while(it.hasNext()) {
			int i=it.next();
			System.out.println(hashMap.get(i));
		}
	}

}
