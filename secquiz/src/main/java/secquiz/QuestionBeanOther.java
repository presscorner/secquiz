package secquiz;

public class QuestionBeanOther {
	private Integer id_question, typeQuest;
	private String question, sousQuestion1, sousQuestion2, a, b, c, d, e, reponse, explication, sujets_traites;
	
	public QuestionBeanOther() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId_question() {
		return id_question;
	}

	public void setId_question(Integer id_question) {
		this.id_question = id_question;
	}

	public Integer getTypeQuest() {
		return typeQuest;
	}

	public void setTypeQuest(Integer typeQuest) {
		this.typeQuest = typeQuest;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getSousQuestion1() {
		return sousQuestion1;
	}

	public void setSousQuestion1(String sousQuestion1) {
		this.sousQuestion1 = sousQuestion1;
	}

	public String getSousQuestion2() {
		return sousQuestion2;
	}

	public void setSousQuestion2(String sousQuestion2) {
		this.sousQuestion2 = sousQuestion2;
	}

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public String getB() {
		return b;
	}

	public void setB(String b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	public String getReponse() {
		return reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	public String getExplication() {
		return explication;
	}

	public void setExplication(String explication) {
		this.explication = explication;
	}

	public String getSujets_traites() {
		return sujets_traites;
	}

	public void setSujets_traites(String sujets_traites) {
		this.sujets_traites = sujets_traites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((a == null) ? 0 : a.hashCode());
		result = prime * result + ((b == null) ? 0 : b.hashCode());
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		result = prime * result + ((e == null) ? 0 : e.hashCode());
		result = prime * result + ((explication == null) ? 0 : explication.hashCode());
		result = prime * result + ((id_question == null) ? 0 : id_question.hashCode());
		result = prime * result + ((question == null) ? 0 : question.hashCode());
		result = prime * result + ((reponse == null) ? 0 : reponse.hashCode());
		result = prime * result + ((sousQuestion1 == null) ? 0 : sousQuestion1.hashCode());
		result = prime * result + ((sousQuestion2 == null) ? 0 : sousQuestion2.hashCode());
		result = prime * result + ((sujets_traites == null) ? 0 : sujets_traites.hashCode());
		result = prime * result + ((typeQuest == null) ? 0 : typeQuest.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuestionBeanOther other = (QuestionBeanOther) obj;
		if (a == null) {
			if (other.a != null)
				return false;
		} else if (!a.equals(other.a))
			return false;
		if (b == null) {
			if (other.b != null)
				return false;
		} else if (!b.equals(other.b))
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		if (e == null) {
			if (other.e != null)
				return false;
		} else if (!e.equals(other.e))
			return false;
		if (explication == null) {
			if (other.explication != null)
				return false;
		} else if (!explication.equals(other.explication))
			return false;
		if (id_question == null) {
			if (other.id_question != null)
				return false;
		} else if (!id_question.equals(other.id_question))
			return false;
		if (question == null) {
			if (other.question != null)
				return false;
		} else if (!question.equals(other.question))
			return false;
		if (reponse == null) {
			if (other.reponse != null)
				return false;
		} else if (!reponse.equals(other.reponse))
			return false;
		if (sousQuestion1 == null) {
			if (other.sousQuestion1 != null)
				return false;
		} else if (!sousQuestion1.equals(other.sousQuestion1))
			return false;
		if (sousQuestion2 == null) {
			if (other.sousQuestion2 != null)
				return false;
		} else if (!sousQuestion2.equals(other.sousQuestion2))
			return false;
		if (sujets_traites == null) {
			if (other.sujets_traites != null)
				return false;
		} else if (!sujets_traites.equals(other.sujets_traites))
			return false;
		if (typeQuest == null) {
			if (other.typeQuest != null)
				return false;
		} else if (!typeQuest.equals(other.typeQuest))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "QuestionBeanOther [id_question=" + id_question + ", typeQuest=" + typeQuest + ", question=" + question
				+ ", sousQuestion1=" + sousQuestion1 + ", sousQuestion2=" + sousQuestion2 + ", a=" + a + ", b=" + b
				+ ", c=" + c + ", d=" + d + ", e=" + e + ", reponse=" + reponse + ", explication=" + explication
				+ ", sujets_traites=" + sujets_traites + "]";
	}
	
	
}
