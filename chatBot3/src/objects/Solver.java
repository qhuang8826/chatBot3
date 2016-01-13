package objects;

import java.util.ArrayList;

import javax.swing.JFrame;

public class Solver{

	static SolverGUI gui;
	public static void main(String[] args){
		//TODO: for now, you may use this method for testing
		//your other methods
		//Here is something to try:
		//System.out.println("The terms in the equation \"3x^2 -12x +13 = 2x^2 -17x +7\" are:");
		Equation parsedEquation = interpretInput("3x-21=0");//3x^2 -12x +13 = 2x^2 -17x +7");
		//		for(Term t: parsedEquation.getLeftSide()){
		//			System.out.println(t.toString());
		//		}
		//		System.out.println("...on the left, and on the right:");
		//		for(Term t: parsedEquation.getRightSide()){
		//			System.out.println(t.toString());
		//		}
		//		parsedEquation.cancelRight();
//		parsedEquation.solveLinear(parsedEquation.getLeftSide());
//		System.out.println(parsedEquation.toString());
		//Once your methods are all working, you can use the following to initiate the GUI
				gui = new SolverGUI();
				gui.setVisible(true);
				gui.setSize(600, 300);
				gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static Equation interpretInput(String s){
		//parse s into two ArrayList<Term>
		//expect user input to appear like this:
		//3x^2 -12x +13 = 2x^2 -17x +7
		//A few things to note:
		//Assume the user will always include exactly one '=',
		//    (Invalid input will be handled by the GUI)
		//Terms are always separated by a '+','-' or '='
		//Do not consider subtraction. Rather, subtraction is ADDING a Term with a NEGATIVE coefficient
		//Recall that a term like "x" has a coefficient of '1' and an exponent of '1'
		//Recall that there is a specific constructor for constant terms
		String str = s.replaceAll("\\s", "");
		//str=3x^2-12x+13=2x^2-17x+7
		String[] leftAndRight = str.split("=");
		//left and right = [3x^2-12x+13,2x^2-17x+7]
		ArrayList<Term> leftSide= createAndAddTerms(leftAndRight[0]);
		ArrayList<Term> rightSide =createAndAddTerms(leftAndRight[1]);
		return new Equation(leftSide,rightSide);
	}

	//'private' since we are only using it HERE
	/**
	 * 
	 * @param termString String of user input
	 * @return equivalent mathematical Terms to what user entered
	 */
	private static ArrayList<Term> createAndAddTerms(String termString){
		ArrayList<Term> terms = new ArrayList<Term>();
		int i =0;//index of first digit (in case the String starts with '-')
		boolean positiveTerm = true;//assume term is positive
		if(termString.startsWith("-")){
			positiveTerm = false;
			i++;//start at index 1 if character at 0 is '-'
		}
		while(termString.length()>0){//delete one term at a time as it gets deleted
			int endOfTerm = termString.length();
			int indexOfPlus = termString.indexOf("+");
			//if there is no '+', above value is -1
			if(indexOfPlus<0)indexOfPlus=endOfTerm;
			int indexOfMinus = termString.indexOf("-");
			if(indexOfMinus<0)indexOfMinus =endOfTerm;
			if(indexOfMinus<indexOfPlus)endOfTerm =indexOfMinus;
			else endOfTerm=indexOfPlus; //guarantees what comes first, end, '+', or '-'
			try{
				Term a = parseTerm(termString.substring(i,endOfTerm));
				if(!positiveTerm)a=a.getAddInverse();

				if(a!=null)terms.add(a);

				//check if next term is + or -
				if(indexOfMinus<indexOfPlus)positiveTerm=false;
				else positiveTerm =true;
				//cut out the term added, including the NEXT +/- symbol
				termString = termString.substring(endOfTerm+1, termString.length());
			}catch(Exception e){
				//if the user is trying to do something that throws an error, skip this term
				termString = termString.substring(endOfTerm, termString.length());
				//cuts out the term
			}

		}
		return terms;

	}

	/**

	 * @param sample string from user: 34a^3

	 * @return new Term representing input from user

	 * Use this method for writing interpretInput

	 */

	private static Term parseTerm(String s) {

		if(s.matches("\\d*\\w\\^\\d+" +

 				"|" +

 				"\\d*\\w" +

 				"|" +

				"\\d+")){//regex identifies anything like 23x^2 or y^11 or 12b or z or 13

			double coef;

			String variable;

			Term t;

			if(s.matches("\\d+")){

				coef = Double.parseDouble(s);

				t = new Term(coef);

			}

			else if(s.matches("\\d*\\w+(\\^\\d+)?")){

				String noDigits = s.replaceAll("\\d", "");

				int indOfVar = s.indexOf(noDigits);

				if(s.substring(0,indOfVar).length()==0){

					coef = 1.0;

				}

				else coef = Double.parseDouble(s.substring(0, indOfVar));

				variable=s.substring(indOfVar, indOfVar+1);

				if(s.indexOf("^")>-1){

					int exponent = Integer.parseInt(s.substring(s.indexOf("^")+1));

					t =new Term(coef,variable,exponent); 

				}else{

					t =new Term(coef,variable,1); 

				}

			}else{

				t=null;

			}

			return t;

		}

		else return null;

	}


	public static String getConfirm(Equation eq) {

		return "Your input was interpreted as " + eq.toString();
		//returns a message confirming the input given by the user, such as "Your input was interpreted as "+eq.toString();

	}



	public static String getNoTricks(String usersInput) {

		return "Your input " + usersInput.toString() + " is invalid.";
		//returns a message for when the user types input that cannot be interpreted by your Solver

	}

	public static void solve(Equation eq) {
		//		gui.addStep(quadraticform(String nonRadical, String underRadical, String denominator), s);
		//		gui.addStep(s);
		//		gui.addStep(eq,s);
		//gui.clearSteps();
		ArrayList<Term> side =eq.getLeftSide();
		if(eq.cancelRight())side=eq.getRightSide();
		if(side.get(0).getCoefficient()!=0){
			eq.toZeroOnOneSide(side);
			gui.addStep(eq,"Cancel all terms on one side");
		}
		eq.simplify(eq.getLeftSide());
		eq.simplify(eq.getRightSide());
		gui.addStep(eq, "Simplify.");
		if(eq.isLinear()){
			eq.solveLinear(side);
			gui.addStep(eq, "answer is:");
		}
		if(eq.isQuadratic()){
			if(eq.isCancelRight()){
				solveQuadratic(eq.getLeftSide());
			}else{
				solveQuadratic(eq.getRightSide());
			}
		}
		
	}

	public static void solveQuadratic(ArrayList<Term> side){
		double a=0;
		double b=0;
		double c=0;
		for(Term t:side){
			if(t.getExponent()==2)a=t.getCoefficient();
			if(t.getExponent()==1)b=t.getCoefficient();
			if(t.getExponent()==0)c=t.getCoefficient();
		}
		double dis = calcDiscriminant(a,b,c);
		if(Math.sqrt(dis)==dis/(Math.sqrt(dis)) ||dis ==0){
			factor(side,a,b,c);
		}else{
			if(dis<0){
				quadraticFormula(true,a,b,c,dis);
			}else{
				quadraticFormula(false,a,b,c,dis);
			}
		}
	}
	
	public static void quadraticFormula(boolean imaginary, double a, double b, double c, double dis){
		if(imaginary){
			int outside = 1;
			for(int i=1;i<Math.sqrt((-1)*dis)+1;i++){
				if(((-1)*dis) % (i*i)==0){
					outside = i;
				}
			}
			int inRad = (int)(dis*(-1)/(outside*outside));
			boolean no2=false;
			boolean noA=false;
			if(outside%2==0 && b%2==0){
				outside /=2;
				b/=2;
				no2 =true;
			}
			if(outside%a==0 && b%a==0){
				outside /=a;
				b/=a;
				noA=true;
			}
			if(no2 && noA){
				gui.addStep(new QuadraticForm(Integer.toString(outside)+"i", Integer.toString(inRad), ""), 
						"This equation has no real solutions. However, the imaginary roots are:");
			}else{
				if(no2){
					gui.addStep(new QuadraticForm(Integer.toString(outside)+"i", Integer.toString(inRad),Integer.toString((int)(a))),
							"This equation has no real solutions. However, the imaginary roots are:");
				}
				if(noA){
					if(outside!=1) gui.addStep(new QuadraticForm(Integer.toString(outside)+"i", Integer.toString(inRad), "2"), 
							"This equation has no real solutions. However, the imaginary roots are:");
					else gui.addStep(new QuadraticForm("i", Integer.toString(inRad), "2"), 
							"This equation has no real solutions. However, the imaginary roots are:");
				}
			}
		}else{
			int outside = 1;
			for(int i=1;i<Math.sqrt(dis)+1;i++){
				if((dis) % (i*i)==0){
					outside = i;
				}
			}
			int inRad = (int)(dis/(outside*outside));
			boolean no2=false;
			boolean noA=false;
			if(outside%2==0 && b%2==0){
				outside /=2;
				b/=2;
				no2 =true;
			}
			if(outside%a==0 && b%a==0){
				outside /=a;
				b/=a;
				noA=true;
			}
			if(no2 && noA){
				gui.addStep(new QuadraticForm(Integer.toString(outside), Integer.toString(inRad), ""), 
						"This equation has irrational roots. They are:");
			}else{
				if(no2){
					gui.addStep(new QuadraticForm(Integer.toString(outside), Integer.toString(inRad),Integer.toString((int)(a))),
							"This equation has irrational roots. They are:");
				}
				if(noA){
					if(outside!=1) gui.addStep(new QuadraticForm(Integer.toString(outside), Integer.toString(inRad), "2"), 
							"This equation has irrational roots. They are:");
					else gui.addStep(new QuadraticForm("", Integer.toString(inRad), "2"), 
							"This equation has irrational roots. They are:");
				}
			}
		}
	}

	public static double calcDiscriminant(double a, double b, double c){
		double ans = (b*b)-(4*a*c);
		return ans;
	}

	public static void factor(ArrayList<Term> side,double a,double b, double c){
		int product = (int)(a*c);
		int[] factors = new int[2*(int) Math.sqrt(product)];
		int x=0;
		for(int i=0;i<Math.sqrt(product);i++){
			if(product%i==0){
				factors[x]=i;
				x++;
			}
		}
		int length=factors.length;
		for(int i=0;i<length;i++){
			factors[x]=product/factors[i];
			x++;
		}
		int y=x+1;
		for(int i:factors){
			factors[y]=i*(-1);
			y++;
		}
		int root1 =0;
		int root2 =0;
		for(int i=0;i<factors.length;i++){
			for(int j=0;j<factors.length;j++){
				if(i!=j){
					if(factors[i]+factors[j]==(-1)*b/a && factors[i]*factors[j]==(c/a)){
						root1=factors[i];
						root2=factors[j];
					}
				}
			}
		}
		int[] roots = {root1,root2};
		String printRoot ="";
		String printRoot1 ="";
		String var=side.get(0).getVariable();
		if(roots[0]>0){
			printRoot ="+"+Integer.toString(roots[0]);
		}else{
			printRoot = Integer.toString(roots[0]);
		}
		if(roots[1]>0){
			printRoot1 ="+"+Integer.toString(roots[1]);
		}else{
			printRoot1 = Integer.toString(roots[1]);
		}
		gui.addStep("You can factor the equation into "+"("+var+printRoot+")("+var+printRoot1+").");
		if(roots[0]==roots[1])gui.addStep("The root is "+ roots[0]+".");
		else gui.addStep("The roots are "+ roots[0] +" and "+roots[1]+".");
	}

}
