package objects;

import java.util.ArrayList;

public class Equation{

	private ArrayList<Term> leftSide;
	private ArrayList<Term> rightSide;
	private boolean cancelRight;
	private ArrayList<Double> solution;
	//TODO: Make getters for all of the above

	public Equation(ArrayList<Term> leftSide, ArrayList<Term> rightSide){
		//sets values of leftSide and rightSide only
		this.leftSide = leftSide;
		this.rightSide = rightSide;
	}

	public ArrayList<Term> getLeftSide() {
		return leftSide;
	}

	public ArrayList<Term> getRightSide() {
		return rightSide;
	}

	public boolean isCancelRight() {
		return cancelRight;
	}

	public ArrayList<Double> getSolution() {
		return solution;
	}

	public boolean isLinear(){
		//returns 'true' if this equation is linear
		//and every term is either constant or has the same variable
		
//		String leftVar = "";
//		String rightVar = "";
//		boolean lin = true;
//		for(int i=0;i<leftSide.size();i++){
//			if(!leftSide.get(i).getVariable().equals("")){
//				leftVar = leftSide.get(i).getVariable();
//			}
//		}
//		for(int i=0;i<rightSide.size();i++){
//			if(!rightSide.get(i).getVariable().equals("")){
//				rightVar = rightSide.get(i).getVariable();
//			}
//		}
//		for(int l =0;l<leftSide.size();l++){
//			if(leftSide.get(l).getExponent() != 0 && leftSide.get(l).getExponent() != 1){
//			//if(leftSide.get(l).getExponent() <2){
//				lin = false;  
//				return lin;
//			}
//			if(!leftSide.get(l).getVariable().equals("") && !leftSide.get(l).getVariable().equals(leftVar)){
//				lin = false;
//				return lin;
//			}
//		}
//		for(int r =0;r<rightSide.size();r++){
//			if(rightSide.get(r).getExponent() != 0 && rightSide.get(r).getExponent() != 1){
//				//if(rightSide.get(r).getExponent() <2){
//				lin = false;  
//				return lin;
//			}
//			if(!rightSide.get(r).getVariable().equals("") && !rightSide.get(r).getVariable().equals(rightVar)){
//				lin = false;
//				return lin;
//			}
//		}
//		return lin;

		int maxDegree=0;
		int minDegree=0;
		String variable ="";
		for(Term t:leftSide){
			if(t.getDegree()>maxDegree)maxDegree=t.getDegree();
			if(t.getDegree()<minDegree)return false;
			if(!t.isConstant())variable=t.getVariable();
		}
		for(Term t:rightSide){
			if(t.getDegree()>maxDegree)maxDegree=t.getDegree();
			if(t.getDegree()<minDegree)return false;
			if(!t.isConstant())variable=t.getVariable();
		}
		if(maxDegree==1 && variablesMatch(variable))return true;
		else return false;
	}
	
	private boolean variablesMatch(String s){
		boolean match=true;
		for(Term t:leftSide){
			if(!t.isConstant()&&!t.getVariable().equals(s)){
				match= false;
			}
		}
		for(Term t:rightSide){
			if(!t.isConstant()&&!t.getVariable().equals(s)){
				match= false;
			}
		}
		return match;
	}

	public boolean isQuadratic(){
		//returns 'true' if this equation is quadratic
		//and every term is either constant or has the same variable
		String leftVar = "";
		String rightVar = "";
		boolean quad = true;
		for(int i=0;i<leftSide.size();i++){
			if(!leftSide.get(i).getVariable().equals("")){
				leftVar = leftSide.get(i).getVariable();
			}
		}
		for(int i=0;i<rightSide.size();i++){
			if(!rightSide.get(i).getVariable().equals("")){
				rightVar = rightSide.get(i).getVariable();
			}
		}
		for(int l =0;l<leftSide.size();l++){
			if(leftSide.get(l).getExponent() != 2 && leftSide.get(l).getExponent() != 1 && leftSide.get(l).getExponent() != 0){
				quad = false;  
				return quad;
			}
			if(!leftSide.get(l).getVariable().equals("") && !leftSide.get(l).getVariable().equals(leftVar)){
				quad = false;
				return quad;
			}
		}
		for(int r =0;r<rightSide.size();r++){
			if(rightSide.get(r).getExponent() != 0 && rightSide.get(r).getExponent() != 1 && rightSide.get(r).getExponent() != 2){
				quad = false;  
				return quad;
			}
			if(!rightSide.get(r).getVariable().equals("") && !rightSide.get(r).getVariable().equals(rightVar)){
				quad = false;
				return quad;
			}
		}
		return quad;
	}

	public boolean isSolveable(){
		//returns 'true' if this equation is linear or quadratic, 'false' otherwise 
		//(because in this project we are not programming a means of solving anything other than linear and quadratic equations)
		if(isLinear() || isQuadratic())return true;
		else return false;
	}

	public boolean cancelRight(){
		//sets the value of cancelRight and
		//returns 'true' if the equation should be solved by subtracting terms from the right side, 
		//false if it is better to subtract terms on the left side
		cancelRight = false;
		boolean move = true;
		int moveRight = 0;
		int lsize = leftSide.size();
		int lmaxE = 0;
		int lIndex =0;
		int rsize = rightSide.size();
		int rmaxE =0;
		int rIndex = 0;
		for(int i =0;i<lsize;i++){
			if(!leftSide.get(i).isConstant()){
				if(leftSide.get(i).getExponent()>lmaxE){
					lmaxE = leftSide.get(i).getExponent();
					lIndex=i;
				}
			}
		}
		for(int i =0;i<rsize;i++){
			if(!rightSide.get(i).isConstant()){
				if(rightSide.get(i).getExponent()>rmaxE){
					rmaxE = rightSide.get(i).getExponent();
					rIndex=i;
				}
			}
		}
		if(lmaxE == rmaxE){
			if(leftSide.get(lIndex).getCoefficient() > rightSide.get(rIndex).getCoefficient()){
				moveRight++;
			}
		}else{
			if(lmaxE>rmaxE){
				if(leftSide.get(lIndex).getCoefficient()<0){
					cancelRight=false;
					return false;
				}else{
					cancelRight=true;
					return true;
				}
			}else{
				if(rightSide.get(rIndex).getCoefficient()<0){
					cancelRight=true;
					return true;
				}else{
					cancelRight=false;
					return false;
				}
			}
		}
		for(int i =0;i<lsize;i++){
			if(!leftSide.get(i).isConstant()){
				if(leftSide.get(i).getExponent()==lmaxE-1){
					lmaxE = leftSide.get(i).getExponent();
					lIndex=i;
				}
			}
		}
		for(int i =0;i<rsize;i++){
			if(!rightSide.get(i).isConstant()){
				if(rightSide.get(i).getExponent()==rmaxE-1){
					rmaxE = rightSide.get(i).getExponent();
					rIndex=i;
				}
			}
		}
		if(lmaxE == rmaxE){
			if(leftSide.get(lIndex).getCoefficient() > rightSide.get(rIndex).getCoefficient()){
				moveRight++;
			}
		}else{
			if(lmaxE>rmaxE){
				if(leftSide.get(lIndex).getCoefficient()<0){
					cancelRight=false;
					return false;
				}else{
					cancelRight=true;
					return true;
				}
			}else{
				if(rightSide.get(rIndex).getCoefficient()<0){
					cancelRight=true;
					return true;
				}else{
					cancelRight=false;
					return false;
				}
			}
		}
		for(int i =0;i<lsize;i++){
				if(leftSide.get(i).getExponent()==lmaxE-1){
					lmaxE = leftSide.get(i).getExponent();
					lIndex=i;
				}
		}
		for(int i =0;i<rsize;i++){
				if(rightSide.get(i).getExponent()==rmaxE-1){
					rmaxE = rightSide.get(i).getExponent();
					rIndex=i;
				}
		}
		if(lmaxE == rmaxE){
			if(leftSide.get(lIndex).getCoefficient() > rightSide.get(rIndex).getCoefficient()){
				moveRight++;
			}
		}else{
			if(lmaxE>rmaxE){
				if(leftSide.get(lIndex).getCoefficient()<0){
					cancelRight=false;
					return false;
				}else{
					cancelRight=true;
					return true;
				}
			}else{
				if(rightSide.get(rIndex).getCoefficient()<0){
					cancelRight=true;
					return true;
				}else{
					cancelRight=false;
					return false;
				}
			}
		}
		if(moveRight>1){
			move=true;
			cancelRight=true;
		}
		return move;
	}

	public String toString(){
		/**
		 *Take your time on this method!
		 *There are many things to consider:
		 *Every terms should be separated by a '+' UNLESS it has a negative coefficient. 
		 *When a term is negative, the negative sign will appear as a minus.
		 */
		String builder = "";

			for(int i =0;i<leftSide.size();i++){
				if(leftSide.get(i).getCoefficient()<0){
					builder+=leftSide.get(i).toString();
				}else{
					if(i!=0)builder+= "+" + leftSide.get(i).toString();
					else builder+=leftSide.get(i).toString();
				}
			}
			
			builder+="=";
			for(int i =0;i<rightSide.size();i++){
				if(rightSide.get(i).getCoefficient()<0){
					builder+=rightSide.get(i).toString();
				}else{
					if(i!=0)builder+= "+" + rightSide.get(i).toString();
					else builder+=rightSide.get(i).toString();
				}
			}
		return builder;
	}


	public static Term getHighestDegreeTerm(ArrayList<Term> side){
		//returns the term in the ArrayList that is the highest degree.
		//example
		//3x^2 + 4x^3 - 12x + x^2
		//will return 4x^3
		int index = 0;
		for(Term t:side){
			if(t.getExponent()>index)index=t.getExponent();
		}
		return side.get(index);
	}
	
	/**
	* adds the additiveInverse of everything on the sideBeingCancelled
	* to both sides of the Equation
	* @param sideBeingCanceled
	*/

	public void toZeroOnOneSide(ArrayList<Term> sideBeingCanceled){
		ArrayList<Term> addIn = new ArrayList<Term>();
		for(Term t:sideBeingCanceled){
			if(t.getCoefficient()!=0){
				addIn.add(t.getAddInverse());
			}
		}
		for(Term t:addIn){
			leftSide.add(t);
			rightSide.add(new Term(t.getCoefficient(),t.getVariable(),t.getExponent()));
		}
	}

	/**

	 * @param side - simplifies the specified side of the equation

	 * Notes: This method should check every Term on the specified side of the equation 

	 * with every other Term to check if they are like terms (use Term.areLikeTerms(Term s, Term t)

	 * If they are, it should reassign the current Term to the combined result (use Term.combine(Term s, Term t)

	 * and remove the one with which it combined.

	 * Finally, if the resulting term has a coefficient of zero should be removed.

	 * 

	 * For example, Suppose side contains 5x + 3 -5x. Call the three terms a, b and c, respectively

	 * 1. It checks to see if 5x and 3 (a and b) are like terms, they are not

	 * 2. It checks to see if 5x and -5x (a and c) are like terms, they are

	 * 3. Since 5x and -5x are like terms, a = Term.cobine(a, c) then leftSide.remove(c)

	 * 4. Now side contains 0x + 3. Since term a has a coefficient of zero, remove it.

	 * 5. Now side contains 3. 

	 * 

	 * ONE MORE NOTE: Since you will be removing items from side, use a standard for loop

	 * and remember that when something is moved, everything "slides over"

	 */

	public void simplify(ArrayList<Term> side){
//		for(int i =0;i<side.size();i++){
//			for(int j=0;j<side.size();j++){
//				Term a = side.get(i);
//				Term b = side.get(j);
//				if(Term.areLikeTerms(a,b)&&i!=j){
//					a = Term.combine(a,b);
//					b.setCoefficient(0);
//					
//				}
//			}
//		}
		for(Term t:side){
			for(Term s:side){
				if(t!=s&&t.getCoefficient()!=0){
					if(Term.areLikeTerms(s, t)){
						Term result = Term.combine(s, t);
						t.setCoefficient(result.getCoefficient());
						s.setCoefficient(0);
					}
				}
			}
		}
		for(Term t:side){
			while(t.getCoefficient()==0){
				side.remove(t);
			}
		}
	}


	/**

	 * @param sideWithVariable - we can assume the side with a variable is of the form ax + b

	 * @return the solution

	 * 

	 * Example: 3x + 21 = 0

	 * 1. Identify the constant term in the sideWithVariable (21)

	 * 2. Identify the variable term in the sideWithVariable (3x)

	 * 3. Add the additive inverse of the constant Term to both sides of the equation (3x = -21)

	 * 4. Multiple both sides by the additive inverse of the coefficient of the variable term (.33333333)

	 */

	public void solveLinear(ArrayList<Term> sideWithVariable){
		double reciprocal =1;
		Term inverse = new Term(0);
		for(Term t:sideWithVariable){
			if(!t.getVariable().equals("")){
				reciprocal = 1/t.getCoefficient(); 
			}
		}
		Solver.gui.addStep("reciprocal is "+Double.toString(reciprocal));
	//System.out.println(reciprocal);
		for(Term t:sideWithVariable){
			if(t.isConstant()){
				inverse=t.getAddInverse();
			}
		}
		Solver.gui.addStep("inverse is "+inverse.toString());
//	System.out.println(inverse.toString());
		sideWithVariable.add(inverse);
		simplify(sideWithVariable);
	//System.out.println(sideWithVariable.toString());
		Solver.gui.addStep("equation now looks like "+sideWithVariable.toString());
		if(cancelRight){
			rightSide.add(inverse);
			simplify(rightSide);
		}else{
			leftSide.add(inverse);
			simplify(leftSide);
		}
	//System.out.println(sideWithVariable.toString());
		multiplyScalar(rightSide,reciprocal);
		multiplyScalar(leftSide,reciprocal);
		
	}


	/**

	 * multiplies all Terms on the given side by the given scalar

	 * (Hint: use setCoefficient(double))

	 */

	public void multiplyScalar(ArrayList<Term> side, double scalar){
		for(Term t:side){
			t.setCoefficient(scalar*t.getCoefficient());
		}
	}
}
