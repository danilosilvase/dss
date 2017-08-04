package ufs.core;

public abstract class  Algorithm {
	
	protected Operator operator;	
	protected Function funcaoObjetivo;

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Function getFuncaoObjetivo() {
		return funcaoObjetivo;
	}

	public void setFuncaoObjetivo(Function funcaoObjetivo) {
		this.funcaoObjetivo = funcaoObjetivo;
	}
	
	public abstract Solution execute() throws CloneNotSupportedException;
		
}
