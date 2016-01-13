package Introduction;

public class GetPermutations {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ok = {"a","b","c","d","e","f","g","h","i","j","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		printPermutations(ok);
	}

	public static String[] printPermutations(String[] s1){
		int rows = s1.length;
		int noDupes = rows;
		
		for(int i=0; i<rows; i++){
			for(int j=i+1; j<rows; j++){
				if(s1[i].equals("")){
					
				}else if(s1[j].equals(s1[i])){
					s1[j] = "";
					noDupes--;
				}
			}
		}
		
		String[] noDupeArray = new String[noDupes];
		
		int factorial = noDupes * (noDupes);
		
		String[] tmp = new String[factorial];
		
		int x = 0;
		for(int i=0; i<rows; i++){
			if(!s1[i].equals("")){
				noDupeArray[x] = s1[i];
				x++;
			}
		}
		
		int y=0;
		for(int i=0; i<noDupeArray.length; i++){
			for(int j=0; j<noDupeArray.length; j++){
				tmp[y]=noDupeArray[i] + noDupeArray[j];
				y++;
			}
		}
		printArray(tmp);
		
       return tmp;
    }
    
    public static void printArray(String[] s){
       String all = "[";
       for(int i=0; i<s.length-1; i++){
           all+=s[i]+", ";
       }
       all+=s[s.length-1]+"]";
       System.out.println(all);
   }
}
