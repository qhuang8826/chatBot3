package objects;

public class Term{
	double coefficient;
	String variable;
	int exponent;
	boolean constant;//this is true if a Term has no variable expression
	//TODO: Write getters for all of the above fields

	public Term(double coefficient, String var, int exp){
		//set the value of all the fields
		//if variable is non-empty, sets constant to 'false'
		this.coefficient=coefficient;
		variable = var;
		exponent = exp;
		if(var.equals("")){
			constant=true;
			exponent = 0;
		}else{
			constant=false;	
		}
		if(coefficient==0){
			variable="";
			exponent=0;
		}
	}

	public double getCoefficient() {
		return coefficient;
	}

	public String getVariable() {
		return variable;
	}

	public int getExponent() {
		return exponent;
	}

	public boolean isConstant() {
		return constant;
	}

	/**
	 *a constructor for constant: 
	 */
	Term(double constant){
		//sets coefficient to constant, variable to "", exponent to "0" and constant to 'true')
		coefficient=constant;
		variable = "";
		exponent =0;
		this.constant = true;
	}
	/**
	 *Write getters for each field
	 *Note that the getter for the boolean should be called 'isConstant'
	 */ 

	public Term getAddInverse(){
		//returns the additive inverse of this Term
		return new Term(-coefficient,variable,exponent);
	}

	public int getDegree(){
		//returns the exponent
		return exponent;
	}

	public boolean isPositive(){
		//returns true if the coefficient is positive (or zero), false otherwise
		if(coefficient>-1) return true;
		else return false;
	}	

	public String toString(){
		/**
		 *Some tips to consider:
		 *doubles always print with trailing zeros (i.e. 2.0) This is not desireable
		 *If a term has a coefficient of 1 or -1, the 1 should not be shown. 
		 *If a term has an exponent of 1, the 1 should not be shown
		 *For exponents, use '^'. The GUI will change it into superscript.
		 */
		String builder = "";
		if(constant!=true &&(coefficient==1||coefficient==-1)){
			if(coefficient==-1)builder+="-";
			else builder+=variable;
		}
		else{
			int replacement = (int)(coefficient);
			if(replacement == coefficient)builder += replacement;
			if(replacement < coefficient)builder += coefficient;
			builder += variable;
			
		}
		if(exponent !=1 && exponent!=0){
			builder += "^";
			builder+=exponent;
		}
		return builder;
	}
	/**
	 * @return 'true' if s and t are like terms (same variable and exponent)
	 */

	public static boolean areLikeTerms(Term s, Term t){
		boolean alike = true;
		if(!s.getVariable().equals(t.getVariable()))alike = false;
		if(s.getExponent()!=t.getExponent())alike=false;
		return alike;
	}

	/**
	 * returns a new Term with same variable and exponent as s and t but combined coefficient
	 */

	public static Term combine(Term s, Term t){
		double coe =s.getCoefficient()+t.getCoefficient();
		return new Term(coe,s.getVariable(),s.getExponent());
	}

	public void setCoefficient(double d) {
		coefficient = d;
	}

}