package ufs.core;

public abstract class Operator {
	
	private int avaliacao = 0;

	public int getAvaliacao() {
		return avaliacao;
	}

	public void contAvaliacao() {
		avaliacao++;
	}
	
	public abstract Solution tweak (Solution s) throws CloneNotSupportedException;

}
